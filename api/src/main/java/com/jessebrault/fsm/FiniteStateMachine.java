package com.jessebrault.fsm;

/**
 * <p>A Finite State Machine that accepts an input
 * and possibly transitions to a new state based upon
 * that input.</p>
 *
 * <p>If built using one of the provided builders, may also
 * cause external side effects based on the given inputs.</p>
 *
 * @param <I> Input type
 * @param <S> State type
 * @param <R> Result type
 */
public interface FiniteStateMachine<I, S, R> {

    S getCurrentState();

    /**
     * Accepts the input and via side effects modifies
     * the internal state of the machine to the next state.
     * If built using one of the provided builders, may also
     * cause external side effects based on the given inputs.
     *
     * @param input the input
     * @return the next state (possibly the same as before)
     */
    R accept(I input);

}
