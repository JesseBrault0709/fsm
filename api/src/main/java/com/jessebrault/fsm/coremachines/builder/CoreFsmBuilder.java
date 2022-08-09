package com.jessebrault.fsm.coremachines.builder;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.FsmBuilder;
import com.jessebrault.fsm.Result;

import java.util.function.Consumer;

/**
 * The builder interface for building a Finite State Machine.
 * All provided builders in this library extend this interface.
 * The input type is what is given to the fsm during use, and the state type
 * represents the various states that the machine may be in.
 * States may either be of any type, but Strings, or better yet,
 * Enums, are recommended. See also the TransitionSetBuilder.
 *
 * @param <I> Input type
 * @param <S> State type
 * @param <C> Condition type
 * @param <O> Result type
 */
public interface CoreFsmBuilder<
        I, S, C, O,
        R extends Result<I, S>,
        M extends FiniteStateMachine<I, S, R>,
        B extends CoreFsmBuilder<I, S, C, O, R, M, B, SC>,
        SC extends StateConfigurator<I, S, C, O>
        > extends FsmBuilder<I, S, R, M> {

    S getInitialState();
    B setInitialState(S state);

    B whileIn(S state, Consumer<SC> configureState);

}
