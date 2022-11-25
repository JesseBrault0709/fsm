package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.FiniteStateMachine;

import java.util.Deque;

public interface StackFunctionFsm<I, S, O> extends FiniteStateMachine<I, S, StackFunctionResult<I, O>> {

    Deque<S> getStateStack();

}
