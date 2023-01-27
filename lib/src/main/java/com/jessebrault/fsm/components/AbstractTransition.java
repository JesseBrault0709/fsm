package com.jessebrault.fsm.components;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public abstract class AbstractTransition<S, O, C> implements Transition<S, O, C> {

    private final C on;
    private final S shiftTo;
    private final Collection<Consumer<O>> outputConsumers;

    public AbstractTransition(C on, S shiftTo, Collection<Consumer<O>> outputConsumers) {
        this.on = on;
        this.shiftTo = shiftTo;
        this.outputConsumers = outputConsumers;
    }

    @Override
    public C on() {
        return this.on;
    }

    @Override
    public @Nullable S shiftTo() {
        return this.shiftTo;
    }

    @Override
    public Collection<Consumer<O>> outputConsumers() {
        return this.outputConsumers;
    }

}
