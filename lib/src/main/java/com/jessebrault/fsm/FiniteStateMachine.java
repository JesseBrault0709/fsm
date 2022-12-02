package com.jessebrault.fsm;

import org.jetbrains.annotations.Nullable;

/**
 * <p>A Finite State Machine that accepts an input and possibly transitions
 * to a new state based upon that input.</p>
 *
 * <p>Certain types of machines may also cause external side effects based
 * on the given inputs.</p>
 *
 * @param <I> Input: the type of input given to the {@link #apply(I input)}
 *           method.
 * @param <S> State: the type of the states that the machine can be in.
 *           Enums are recommended, though any type is possible.
 * @param <O> Output: the type of the output of the {@link #apply(I input)}
 *           method.
 * @implSpec Implementing classes are not required to accept null inputs.
 */
public interface FiniteStateMachine<I, S, O> {

    /**
     * <p>Accepts the given input; depending on how the particular machine
     * handles input, possibly may transition to a new state. Returns a
     * Result object describing the operation.</p>
     *
     * @param input the input
     * @return the Result
     * @implSpec Implementing classes are not required to accept null
     * inputs.</p>
     */
    @Nullable O apply(I input);

    S getCurrentState();

}
