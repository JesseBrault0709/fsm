package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.FiniteStateMachine;

public interface FunctionFsm<I, S, O> extends FiniteStateMachine<I, S, FunctionResult<I, S, O>> {}
