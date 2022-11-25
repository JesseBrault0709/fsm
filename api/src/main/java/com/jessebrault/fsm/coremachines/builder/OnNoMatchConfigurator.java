package com.jessebrault.fsm.coremachines.builder;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * @param <I> Input type
 * @param <S> State type
 */
public interface OnNoMatchConfigurator<I, S, ONM extends OnNoMatchConfigurator<I, S, ONM>> {

    /**
     * When no conditions are met, shift to the given state.
     *
     * @param state the state to which the fsm will shift
     * @return this configurator
     */
    ONM shiftTo(@NotNull S state);

    /**
     * When no conditions are met, perform the given action receiving the
     * input.
     *
     * @param action the action to be performed
     * @return this configurator
     */
    ONM exec(@NotNull Consumer<I> action);

}
