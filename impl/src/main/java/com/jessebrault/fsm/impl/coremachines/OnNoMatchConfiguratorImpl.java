package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public final class OnNoMatchConfiguratorImpl<I, S> implements OnNoMatchConfigurator<I, S> {

    private S shiftTo;
    private final Collection<Consumer<I>> actions = new LinkedList<>();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<I>> getActions() {
        return this.actions;
    }
    
    @Override
    public OnNoMatchConfigurator<I, S> shiftTo(@NotNull S state) {
        this.shiftTo = state;
        return this;
    }

    @Override
    public OnNoMatchConfigurator<I, S> exec(@NotNull Consumer<I> action) {
        Objects.requireNonNull(action, "exec: action must not be null");
        this.actions.add(action);
        return this;
    }

}
