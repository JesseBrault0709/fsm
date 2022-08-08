package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.Transition;
import com.jessebrault.fsm.TransitionSet;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

public class TransitionSetImpl<I, S, C, R> implements TransitionSet<I, S, C, R> {

    private final Set<Transition<S, C, R>> transitions;
    private final S noMatchShiftTo;
    private final Collection<Consumer<I>> noMatchActions;

    public TransitionSetImpl(
            Set<Transition<S, C, R>> transitions,
            S noMatchShiftTo,
            Collection<Consumer<I>> noMatchActions
    ) {
        this.transitions = transitions;
        this.noMatchShiftTo = noMatchShiftTo;
        this.noMatchActions = noMatchActions;
    }

    @Override
    public Set<Transition<S, C, R>> getTransitions() {
        return this.transitions;
    }

    @Override
    public S getNoMatchShiftTo() {
        return this.noMatchShiftTo;
    }

    @Override
    public Collection<Consumer<I>> getNoMatchActions() {
        return this.noMatchActions;
    }

}
