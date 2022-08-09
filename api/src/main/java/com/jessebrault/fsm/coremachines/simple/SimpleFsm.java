package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.FiniteStateMachine;

public interface SimpleFsm<I, S> extends FiniteStateMachine<I, S, SimpleResult<I, S>> {}
