package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.OnNoMatchBuilder;
import groovy.lang.Closure;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public final class OnNoMatchBuilderImpl<I, S> implements OnNoMatchBuilder<I, S> {

    private static void checkAction(Object action) {
        Objects.requireNonNull(action, "action must not be null");
    }

    private final Collection<Consumer<I>> actions = new LinkedList<>();
    private S shiftTo;

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<I>> getActions() {
        return this.actions;
    }

    @Override
    public OnNoMatchBuilder<I, S> shiftTo(S state) {
        // state may be null
        this.shiftTo = state;
        return this;
    }

    @Override
    public OnNoMatchBuilder<I, S> exec(Consumer<I> action) {
        checkAction(action);
        this.actions.add(action);
        return this;
    }

    @Override
    public OnNoMatchBuilder<I, S> exec(Runnable action) {
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
