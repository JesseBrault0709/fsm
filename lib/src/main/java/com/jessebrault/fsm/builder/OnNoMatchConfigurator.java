package com.jessebrault.fsm.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public interface OnNoMatchConfigurator<I, S, O, ONM extends OnNoMatchConfigurator<I, S, O, ONM>> {

    ONM shiftTo(@NotNull S state);

    ONM exec(@NotNull Consumer<I> inputConsumer);

    /**
     * @since 0.2.0
     */
    ONM instead(@NotNull Function<I, O> instead);

    @Nullable S getShiftTo();

    Collection<Consumer<I>> getInputConsumers();

    /**
     * @since 0.2.0
     */
    @Nullable Function<I, O> getInstead();

}
