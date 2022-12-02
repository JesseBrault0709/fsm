package com.jessebrault.fsm.composable;

import com.jessebrault.fsm.components.StackNoMatchTransition;
import com.jessebrault.fsm.components.StackTransition;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class StackStackManager<
        I, S, O, C,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S>
        > implements StateManager<I, S, O, C, T, NMT> {

    private final Deque<S> stateStack = new LinkedList<>();

    public StackStackManager(S initialState) {
        this.stateStack.push(initialState);
    }

    @Override
    public S getCurrentState() {
        return this.stateStack.peek();
    }

    @Override
    public void shiftTo(S state) {
        this.stateStack.pop();
        this.stateStack.push(state);
    }

    private void popAndPush(int popStates, List<S> pushStates) {
        for (var i = 0; i < popStates; i++) {
            this.stateStack.pop();
        }
        for (final var state : pushStates) {
            this.stateStack.push(state);
        }
    }

    @Override
    public void onMatch(T matchedTransition) {
        this.popAndPush(matchedTransition.popStates(), matchedTransition.pushStates());
    }

    @Override
    public void onNoMatch(NMT noMatchTransition) {
        this.popAndPush(noMatchTransition.popStates(), noMatchTransition.pushStates());
    }

}
