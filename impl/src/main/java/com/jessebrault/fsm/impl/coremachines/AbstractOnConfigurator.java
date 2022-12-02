package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractOnConfigurator<S, O, ON extends OnConfigurator<S, O, ON>>
        implements OnConfigurator<S, O, ON> {

    private S shiftTo;
    private final Collection<Consumer<O>> actions = new ArrayList<>();

    protected abstract ON getThis();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<O>> getActions() {
        return this.actions;
    }

    @Override
    public ON shiftTo(@NotNull S state) {
        Objects.requireNonNull(state);
        this.shiftTo = state;
        return this.getThis();
    }

    @Override
    public ON exec(@NotNull Consumer<O> action) {
        Objects.requireNonNull(action);
        this.actions.add(action);
        return this.getThis();
    }

}
