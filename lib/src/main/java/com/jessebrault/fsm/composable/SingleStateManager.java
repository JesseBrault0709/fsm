package com.jessebrault.fsm.composable;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.Transition;

public final class SingleStateManager<
        I, S, O, C,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > implements StateManager<I, S, O, C, T, NMT> {

    private S currentState;

    public SingleStateManager(S initialState) {
        this.currentState = initialState;
    }

    @Override
    public S getCurrentState() {
        return this.currentState;
    }

    @Override
    public void shiftTo(S state) {
        this.currentState = state;
    }

}
