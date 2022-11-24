package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public final class OnConfiguratorImpl<S, O> implements OnConfigurator<S, O> {

    private S shiftTo;
    private final Collection<Consumer<O>> actions = new LinkedList<>();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<O>> getActions() {
        return this.actions;
    }

    @Override
    public OnConfigurator<S, O> shiftTo(@NotNull S state) {
        this.shiftTo = state;
        return this;
    }

    @Override
    public OnConfigurator<S, O> exec(@NotNull Consumer<O> action) {
        Objects.requireNonNull(action, "exec: action must not be null");
        this.actions.add(action);
        return this;
    }

}
