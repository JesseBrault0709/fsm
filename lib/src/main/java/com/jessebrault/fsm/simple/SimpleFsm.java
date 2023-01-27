package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.FiniteStateMachine;

/**
 * @implSpec This type of Fsm does <b>not</b> accept null inputs.</p>
 *
 * @param <I> Input type
 * @param <S> State type
 */
public interface SimpleFsm<I, S> extends FiniteStateMachine<I, S, I> {}
