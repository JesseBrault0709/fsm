package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.function.FunctionFsm;

public interface FunctionGreetingFsmFactory<O> {
    FunctionFsm<GreetingInputs, GreetingStates, O> get();
}
