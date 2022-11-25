package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.FiniteStateMachine;

public interface StackFunctionFsm<I, S, O> extends FiniteStateMachine<I, S, StackFunctionResult<I, S, O>> {}
