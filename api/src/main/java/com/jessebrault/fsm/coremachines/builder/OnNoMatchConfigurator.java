package com.jessebrault.fsm.coremachines.builder;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * @param <I> Input type
 * @param <S> State type
 */
public interface OnNoMatchConfigurator<I, S> {

    /**
     * When no conditions are met, shift to the given state.
     *
     * @param state the state to which the fsm will shift
     * @return this configurator
     */
    OnNoMatchConfigurator<I, S> shiftTo(@NotNull S state);

    /**
     * When no conditions are met, perform the given action receiving the
     * input.
     *
     * @param action the action to be performed
     * @return this configurator
     */
    OnNoMatchConfigurator<I, S> exec(@NotNull Consumer<I> action);

}
