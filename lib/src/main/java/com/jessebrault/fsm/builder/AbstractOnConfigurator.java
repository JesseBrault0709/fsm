package com.jessebrault.fsm.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractOnConfigurator<S, O, ON extends OnConfigurator<S, O, ON>>
        implements OnConfigurator<S, O, ON> {

    private final Collection<Consumer<O>> outputConsumers = new ArrayList<>();

    private S shiftTo;

    protected abstract ON getThis();

    @Override
    public final ON shiftTo(@NotNull S state) {
        Objects.requireNonNull(state);
        this.shiftTo = state;
        return this.getThis();
    }

    @Override
    public final ON exec(@NotNull Consumer<O> outputConsumer) {
        Objects.requireNonNull(outputConsumer);
        this.outputConsumers.add(outputConsumer);
        return this.getThis();
    }

    @Override
    public final @Nullable S getShiftTo() {
        return this.shiftTo;
    }

    @Override
    public final Collection<Consumer<O>> getOutputConsumers() {
        return this.outputConsumers;
    }


}
