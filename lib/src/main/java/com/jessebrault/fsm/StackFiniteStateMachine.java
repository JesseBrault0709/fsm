package com.jessebrault.fsm;

import java.util.Deque;

/**
 * @param <I> Input type
 * @param <S> State type
 * @param <O> Output type
 * @implSpec Implementations are required to obey the following order of
 * operations with regard to changing state:
 * <ol>
 *     <li>pop the number of specified states</li>
 *     <li>push the specified states</li>
 *     <li>pop the current state and push the "shiftTo" state</li>
 * </ol>
 */
public interface StackFiniteStateMachine<I, S, O> extends FiniteStateMachine<I, S, O> {

    Deque<S> getStateStack();

}
