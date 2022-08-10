package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.coremachines.function.FunctionFsm;

public interface FunctionGreetingFsmFactory<O> {
    FunctionFsm<GreetingInputs, GreetingStates, O> get();
}
