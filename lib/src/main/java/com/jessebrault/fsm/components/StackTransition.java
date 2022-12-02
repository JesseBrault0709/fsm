package com.jessebrault.fsm.components;

import java.util.List;

public interface StackTransition<S, O, C> extends Transition<S, O, C> {
    List<S> pushStates();
    int popStates();
}
