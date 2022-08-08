package com.jessebrault.fsm.impl;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

public record TransitionSet<I, S, C, R>(
        Set<Transition<S, C, R>> transitions,
        S noMatchShiftTo,
        Collection<Consumer<I>> noMatchActions
) {}
