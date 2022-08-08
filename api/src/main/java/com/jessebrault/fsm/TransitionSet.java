package com.jessebrault.fsm;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

public interface TransitionSet<I, S, C, R> {
    Set<Transition<S, C, R>> getTransitions();
    S getNoMatchShiftTo();
    Collection<Consumer<I>> getNoMatchActions();
}
