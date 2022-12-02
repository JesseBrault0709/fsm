package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.StackFiniteStateMachine;

/**
 * @implSpec Implementations do <b>not</b> accept null inputs.
 *
 * @param <I>
 * @param <S>
 */
public interface StackSimpleFsm<I, S> extends StackFiniteStateMachine<I, S, I> {}
