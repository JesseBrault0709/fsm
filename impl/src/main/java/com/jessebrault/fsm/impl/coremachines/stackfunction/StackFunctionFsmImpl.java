package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionFsm;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

final class StackFunctionFsmImpl<I, S, O> implements StackFunctionFsm<I, S, O> {

    private static final Logger logger = LoggerFactory.getLogger(StackFunctionFsmImpl.class);

    private final Map<S, StackFunctionStateGrammar<I, S, O>> statesAndGrammars;
    private final Deque<S> stateStack = new LinkedList<>();

    public StackFunctionFsmImpl(
            Map<S, StackFunctionStateGrammar<I, S, O>> statesAndGrammars,
            S initialState
    ) {
        this.statesAndGrammars = statesAndGrammars;
        this.stateStack.push(initialState);
    }

    @Override
    public StackFunctionResult<I, O> accept(I input) {
        // TODO: logger trace entry
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
                final var shiftTo = transition.shiftTo();
                if (shiftTo != null) {
                    final var oldState = this.stateStack.pop();
                    logger.debug("shifting from {} to {}", oldState, shiftTo);
                    this.stateStack.push(shiftTo);
                }
                final var pushState = transition.pushState();
                if (pushState != null) {
                    logger.debug("pushing state {}", pushState);
                    this.stateStack.push(pushState);
                }
                final var popState = transition.popState();
                if (popState) {
                    final var oldState = this.stateStack.pop();
                    final var nextState = this.stateStack.peek();
                    if (nextState == null) {
                        throw new IllegalStateException();
                    }
                    logger.debug("popping from {} to {}", oldState, nextState);
                }
                transition.outputConsumers().forEach(outputConsumer -> outputConsumer.accept(output));
                // TODO: logger trace exit
                return new StackFunctionResultImpl<>(true, on, output);
            }
        }
        logger.debug("no match");
        final var onNoMatchTransition = stateGrammar.onNoMatchTransition();
        final var shiftTo = onNoMatchTransition.shiftTo();
        if (shiftTo != null) {
            // TODO: shiftTo as a private method
        }
        final var pushState = onNoMatchTransition.pushState();
        if (pushState != null) {
            // TODO: pushState as a private method
        }
        final var popState = onNoMatchTransition.popState();
        if (popState) {
            // TODO: popState as a private method
        }

        onNoMatchTransition.inputConsumers().forEach(inputConsumer -> inputConsumer.accept(input));

        // TODO: logger trace exit
        return new StackFunctionResultImpl<>(false, null, null);
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
