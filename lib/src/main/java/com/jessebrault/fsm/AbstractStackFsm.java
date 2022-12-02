package com.jessebrault.fsm;

import com.jessebrault.fsm.components.StackNoMatchTransition;
import com.jessebrault.fsm.components.StackStateGrammar;
import com.jessebrault.fsm.components.StackTransition;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractStackFsm<
        I, S, O, C,
        SG extends StackStateGrammar<I, S, O, C, T, NMT>,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S>
        > extends AbstractFiniteStateMachine<I, S, O, C, SG, T, NMT>
        implements StackFiniteStateMachine<I, S, O> {

    private final Logger logger = LoggerFactory.getLogger(AbstractStackFsm.class);

    private final Deque<S> stateStack = new LinkedList<>();

    public AbstractStackFsm(Map<S, SG> grammar, S initialState) {
        super(grammar);
        Objects.requireNonNull(initialState);
        this.stateStack.push(initialState);
    }

    @Override
    protected final void shiftTo(@Nullable S state) {
        if (state != null) {
            final var popped = this.stateStack.pop();
            this.stateStack.push(state);
            logger.debug("shifted from {} to {}", popped, state);
            logger.debug("after shifting, stateStack: {}", this.stateStack);
        }
    }

    @Override
    public final S getCurrentState() {
        logger.debug("current stateStack: {}", this.stateStack);
        final var currentState = this.stateStack.peek();
        if (currentState == null) {
            throw new IllegalStateException("currentState is null");
        }
        return currentState;
    }

    @Override
    protected final void onMatch(T transition, O output) {
        for (var i = 0; i < transition.popStates(); i++) {
            logger.debug("popped {}", this.stateStack.pop());
        }
        if (transition.popStates() > 0) {
            logger.debug("after popping, stateStack: {}", this.stateStack);
        }
        for (final var state : transition.pushStates()) {
            this.stateStack.push(state);
            logger.debug("pushed {}", state);
        }
        if (!transition.pushStates().isEmpty()) {
            logger.debug("after pushing, stateStack: {}", this.stateStack);
        }
        super.onMatch(transition, output);
    }

    @Override
    protected final void onNoMatch(NMT noMatchTransition, I input) {
        for (var i = 0; i < noMatchTransition.popStates(); i++) {
            logger.debug("popped {}", this.stateStack.pop());
        }
        for (final var state : noMatchTransition.pushStates()) {
            this.stateStack.push(state);
            logger.debug("pushed {}", state);
        }
        super.onNoMatch(noMatchTransition, input);
    }

    @Override
    public final Deque<S> getStateStack() {
        return new LinkedList<>(this.stateStack);
    }

}
