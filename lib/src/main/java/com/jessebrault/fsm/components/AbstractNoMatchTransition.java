package com.jessebrault.fsm.components;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractNoMatchTransition<I, S, O> implements NoMatchTransition<I, S, O> {

    private final S shiftTo;
    private final Collection<Consumer<I>> inputConsumers;
    private final Function<I, O> instead;

    public AbstractNoMatchTransition(S shiftTo, Collection<Consumer<I>> inputConsumers, Function<I, O> instead) {
        this.shiftTo = shiftTo;
        this.inputConsumers = inputConsumers;
        this.instead = instead;
    }

    @Override
    public @Nullable S shiftTo() {
        return this.shiftTo;
    }

    @Override
    public Collection<Consumer<I>> inputConsumers() {
        return this.inputConsumers;
    }

    @Override
    public @Nullable Function<I, O> instead() {
        return this.instead;
    }

    @Override
    public String toString() {
        return "NoMatchTransitionImpl(" + this.shiftTo + ", " + this.inputConsumers + ", " + this.instead + ")";
    }

}
