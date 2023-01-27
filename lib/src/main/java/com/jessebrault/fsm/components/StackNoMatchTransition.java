package com.jessebrault.fsm.components;

import java.util.List;

public interface StackNoMatchTransition<I, S, O> extends NoMatchTransition<I, S, O> {
    List<S> pushStates();
    int popStates();
}
