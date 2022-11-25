package com.jessebrault.fsm;

/**
 * <p>A Finite State Machine that accepts an input and possibly transitions to
 * a new state based upon that input.</p>
 *
 * <p>Certain types of machines may also cause external side effects based on
 * the given inputs.</p>
 *
 * @param <I> Input: the type of input given to the
 *            {@link #accept(I input) accept} method.
 * @param <R> Result: the result returned by the {@link #accept(I input) accept}
 *            method.
 */
public interface FiniteStateMachine<I, S, R> {

    /**
     * <p>Accepts the given input; depending on how the particular machine
     * handles input, possibly may transition to a new state. Returns a Result
     * object describing the operation.</p>
     *
     * @param input the input
     * @return the Result
     */
    R accept(I input);

    S getCurrentState();

}
