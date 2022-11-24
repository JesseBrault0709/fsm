package com.jessebrault.fsm.coremachines.builder;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * @param <S> State type
 * @param <O> Output type
 */
public interface OnConfigurator<S, O> {

    /**
     * When the associated condition is met, shift to the given state after all
     * actions are performed.
     *
     * @param state the state to which the fsm will shift
     * @return this configurator
     */
    OnConfigurator<S, O> shiftTo(@NotNull S state);

    /**
     * When the associated condition is met, perform the given action receiving
     * the output of the condition (the type of the output depends on the given
     * Fsm/Builder).
     *
     * @param action the action to be performed
     * @return this configurator
     */
    OnConfigurator<S, O> exec(@NotNull Consumer<O> action);

}
