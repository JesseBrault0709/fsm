package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractOnNoMatchConfigurator<I, S, ONM extends OnNoMatchConfigurator<I, S, ONM>>
        implements OnNoMatchConfigurator<I, S, ONM> {

    private S shiftTo;
    private final Collection<Consumer<I>> actions = new ArrayList<>();

    protected abstract ONM getThis();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public Collection<Consumer<I>> getActions() {
        return this.actions;
    }

    @Override
    public ONM shiftTo(@NotNull S state) {
        Objects.requireNonNull(state);
        this.shiftTo = state;
        return this.getThis();
    }

    @Override
    public ONM exec(@NotNull Consumer<I> action) {
        Objects.requireNonNull(action);
        this.actions.add(action);
        return this.getThis();
    }

}
