package com.jessebrault.fsm.components;

import java.util.List;

public interface StackNoMatchTransition<I, S> extends NoMatchTransition<I, S> {
    List<S> pushStates();
    int popStates();
}
