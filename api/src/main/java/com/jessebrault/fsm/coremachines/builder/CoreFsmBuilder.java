package com.jessebrault.fsm.coremachines.builder;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.FsmBuilder;
import com.jessebrault.fsm.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * <p>The builder interface for building a Finite State Machine. All provided
 * builders in this library extend this interface.</p>
 *
 * @param <I>  Input type
 * @param <S>  State type
 * @param <C>  Condition type
 * @param <O>  Output type
 * @param <R>  Result type
 * @param <M>  Machine type
 * @param <B>  Builder type
 * @param <SC> StateConfigurator type
 */
public interface CoreFsmBuilder<
        I, S, C, O,
        R extends Result<I, S>,
        M extends FiniteStateMachine<I, S, R>,
        B extends CoreFsmBuilder<I, S, C, O, R, M, B, SC>,
        SC extends StateConfigurator<I, S, C, O>
        > extends FsmBuilder<I, S, R, M> {

    /**
     * Returns the initial currently set initial state for the machine to be
     * built, possibly null.
     *
     * @return the initial state
     */
    @Nullable S getInitialState();

    /**
     * Sets the initial state of the machine to be built.
     *
     * @param state the initial state, not null
     * @return this builder
     */
    B setInitialState(@NotNull S state);

    /**
     * <p>A method for describing the grammar of a given state. Should be called
     * once per configured state.</p>
     *
     * @param state          the state to configure, not null
     * @param configureState a Consumer of a StateConfigurator, not null
     * @return this builder
     */
    B whileIn(@NotNull S state, @NotNull Consumer<SC> configureState);

}
