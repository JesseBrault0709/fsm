package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.Transition;

import java.util.Collection;
import java.util.function.Consumer;

public final class TransitionImpl<S, C, R> implements Transition<S, C, R> {

    private final C on;
    private final S shiftTo;
    private final Collection<Consumer<R>> actions;

    public TransitionImpl(
            C on,
            S shiftTo,
            Collection<Consumer<R>> actions
    ) {
        this.on = on;
        this.shiftTo = shiftTo;
        this.actions = actions;
    }

    @Override
    public C getOn() {
        return this.on;
    }

    @Override
    public S getShiftTo() {
        return this.shiftTo;
    }

    @Override
    public Collection<Consumer<R>> getActions() {
        return this.actions;
    }
    
}
