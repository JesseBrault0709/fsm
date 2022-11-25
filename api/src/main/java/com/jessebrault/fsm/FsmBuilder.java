package com.jessebrault.fsm;

/**
 * <p>A generic interface representing a builder of a FiniteStateMachine.</p>
 *
 * <p>For the sub-interface that all builders in this library extend, see
 * {@link com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder
 * CoreFsmBuilder}.</p>
 *
 * @param <I> The machine Input type
 * @param <S> The machine State type
 * @param <R> The machine Result type
 * @param <M> The Machine type, extending {@link FiniteStateMachine}
 */
public interface FsmBuilder<
        I, S, R,
        M extends FiniteStateMachine<I, S, R>,
        B extends FsmBuilder<I, S, R, M, B>
        > {

    B setInitialState(S initialState);

    S getInitialState();

    M build();

}
