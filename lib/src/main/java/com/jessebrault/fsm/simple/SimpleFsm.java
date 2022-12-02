package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.builder.annotations.SingleStateBuilder;

/**
 * @implSpec This type of Fsm does <b>not</b> accept null inputs.</p>
 *
 * @param <I> Input type
 * @param <S> State type
 */
@SingleStateBuilder(input = "I", state = "S", output = "I", condition = "I")
public interface SimpleFsm<I, S> extends FiniteStateMachine<I, S, I> {}
