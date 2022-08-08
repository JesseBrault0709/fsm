package com.jessebrault.fsm;

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
 * @param <R> Result type
 */
public interface FsmBuilder<I, S, C, R, B extends FsmBuilder<I, S, C, R, B>> {

    S getInitialState();
    B setInitialState(S state);

    B whileIn(S state, Consumer<TransitionSetBuilder<I, S, C, R>> configureState);

    FiniteStateMachine<I, S, R> build();

}
