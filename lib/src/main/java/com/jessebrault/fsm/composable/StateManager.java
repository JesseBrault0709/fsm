package com.jessebrault.fsm.composable;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.Transition;

public interface StateManager<I, S, O, C, T extends Transition<S, O, C>, NMT extends NoMatchTransition<I, S>> {

    S getCurrentState();

    void shiftTo(S state);

    default void onMatch(T matchedTransition) {}

    default void onNoMatch(NMT noMatchTransition) {}

}
