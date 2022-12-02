package com.jessebrault.fsm.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractOnNoMatchConfigurator<I, S, ONM extends OnNoMatchConfigurator<I, S, ONM>>
        implements OnNoMatchConfigurator<I, S, ONM> {

    private final Collection<Consumer<I>> inputConsumers = new ArrayList<>();
    private S shiftTo;

    protected abstract ONM getThis();

    @Override
    public final ONM shiftTo(@NotNull S state) {
        Objects.requireNonNull(state);
        this.shiftTo = state;
        return this.getThis();
    }

    @Override
    public final ONM exec(@NotNull Consumer<I> inputConsumer) {
        Objects.requireNonNull(inputConsumer);
        this.inputConsumers.add(inputConsumer);
        return this.getThis();
    }

    @Override
    public final @Nullable S getShiftTo() {
        return this.shiftTo;
    }

    @Override
    public final Collection<Consumer<I>> getInputConsumers() {
        return this.inputConsumers;
    }

}
