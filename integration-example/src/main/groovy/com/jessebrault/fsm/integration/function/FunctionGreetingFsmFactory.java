package com.jessebrault.fsm.integration.function;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;

public interface FunctionGreetingFsmFactory {
    FiniteStateMachine<GreetingInputs, GreetingStates, Integer> get();
}
