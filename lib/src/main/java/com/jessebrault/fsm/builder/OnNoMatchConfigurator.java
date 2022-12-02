package com.jessebrault.fsm.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public interface OnNoMatchConfigurator<I, S, ONM extends OnNoMatchConfigurator<I, S, ONM>> {

    ONM shiftTo(@NotNull S state);

    ONM exec(@NotNull Consumer<I> inputConsumer);

    @Nullable S getShiftTo();

    Collection<Consumer<I>> getInputConsumers();

}
