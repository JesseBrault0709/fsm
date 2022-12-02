package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionFsm;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionResult;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

final class StackFunctionFsmImpl<I, S, O> implements StackFunctionFsm<I, S, O> {

    private static final Logger logger = LoggerFactory.getLogger(StackFunctionFsmImpl.class);
    private static final Marker enter = MarkerFactory.getMarker("ENTER");
    private static final Marker exit = MarkerFactory.getMarker("EXIT");

    private final Map<S, StackFunctionStateGrammar<I, S, O>> statesAndGrammars;
    private final Deque<S> stateStack = new LinkedList<>();

    StackFunctionFsmImpl(
            Map<S, StackFunctionStateGrammar<I, S, O>> statesAndGrammars,
            S initialState
    ) {
        this.statesAndGrammars = statesAndGrammars;
        this.stateStack.push(initialState);
    }

    private void pushState(@Nullable S state) {
        if (state != null) {
            logger.debug("pushing {}", state);
            this.stateStack.push(state);
        }
    }

    private void popState() {
        final var oldState = this.stateStack.pop();
        final var nextState = this.stateStack.peek();
        if (nextState == null) {
            throw new IllegalStateException();
        }
        logger.debug("popping from {} to {}", oldState, nextState);
    }

    private void shiftTo(@Nullable S state) {
        if (state != null) {
            final var oldState = this.stateStack.pop();
            logger.debug("shifting from {} to {}", oldState, state);
            this.stateStack.push(state);
        }
    }

    @Override
    public StackFunctionResult<I, O> apply(@Nullable I input) {
        logger.trace(enter, "input: {}", input);
        final var currentState = this.stateStack.peek();
        if (currentState == null) {
            throw new IllegalStateException();
        }
        logger.debug("currentState: {}", currentState);
        final var stateGrammar = this.statesAndGrammars.get(currentState);
        Objects.requireNonNull(stateGrammar);
        for (final var transition : stateGrammar.transitions()) {
            final var on = transition.on();
            final var output = on.apply(input);
            if (output != null) {
                logger.debug("matched {}; output: {}", on, output);

                this.shiftTo(transition.shiftTo());
                this.pushState(transition.pushState());
                if (transition.popState()) {
                    this.popState();
                }
                transition.outputConsumers().forEach(outputConsumer -> outputConsumer.accept(output));

                final var result = new StackFunctionResultImpl<>(true, on, output);
                logger.trace(exit, "result: {}", result);
                return result;
            }
        }
        logger.debug("no match");
        final var onNoMatchTransition = stateGrammar.onNoMatchTransition();

        this.shiftTo(onNoMatchTransition.shiftTo());
        this.pushState(onNoMatchTransition.pushState());
        if (onNoMatchTransition.popState()) {
            this.popState();
        }
        onNoMatchTransition.inputConsumers().forEach(inputConsumer -> inputConsumer.accept(input));

        final StackFunctionResult<I, O> result = new StackFunctionResultImpl<>(false, null, null);
        logger.trace(exit, "result: {}", result);
        return result;
    }

    @Override
    public S getCurrentState() {
        return this.stateStack.peek();
    }

    @Override
    public Deque<S> getStateStack() {
        return new LinkedList<>(this.stateStack);
    }

}
