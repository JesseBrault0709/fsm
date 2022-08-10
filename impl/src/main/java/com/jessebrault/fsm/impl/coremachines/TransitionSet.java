package com.jessebrault.fsm.impl.coremachines;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

public record TransitionSet<I, S, C, O>(
        Set<Transition<S, C, O>> transitions,
        S onNoMatchShiftTo,
        Collection<Consumer<I>> onNoMatchActions
) {}
