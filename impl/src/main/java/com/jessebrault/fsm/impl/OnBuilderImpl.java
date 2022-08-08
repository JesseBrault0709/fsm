package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.OnBuilder;
import groovy.lang.Closure;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public final class OnBuilderImpl<S, R> implements OnBuilder<S, R> {

    private static void checkAction(Object action) {
        Objects.requireNonNull(action, "action must not be null");
    }

    private final Collection<Consumer<R>> actions = new LinkedList<>();
    private S shiftTo;

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<R>> getActions() {
        return this.actions;
    }

    @Override
    public OnBuilder<S, R> shiftTo(S state) {
        // state may be null
        this.shiftTo = state;
        return this;
    }

    @Override
    public OnBuilder<S, R> exec(Consumer<R> action) {
        checkAction(action);
        this.actions.add(action);
        return this;
    }

    @Override
    public OnBuilder<S, R> exec(Runnable action) {
        checkAction(action);
        // Groovy support: Closure implements Runnable, so we need to differentiate
        if (action instanceof Closure<?> cl) {
            this.actions.add(cl::call);
        } else {
            this.actions.add(input -> action.run());
        }
        return this;
    }

}
