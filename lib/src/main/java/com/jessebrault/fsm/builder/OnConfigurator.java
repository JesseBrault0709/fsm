package com.jessebrault.fsm.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public interface OnConfigurator<S, O, ON extends OnConfigurator<S, O, ON>> {

    ON shiftTo(@NotNull S state);

    ON exec(@NotNull Consumer<O> outputConsumer);

    @Nullable S getShiftTo();

    Collection<Consumer<O>> getOutputConsumers();

}
