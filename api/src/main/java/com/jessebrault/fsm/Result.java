package com.jessebrault.fsm;

/**
 * <p>An interface representing a result from an Fsm's
 * {@link FiniteStateMachine#accept(I input) accept} method.</p>
 *
 * @param <I>
 * @param <S>
 */
public interface Result<I, S> {
    boolean isMatch();
    I getInput();
    S getState();
}
