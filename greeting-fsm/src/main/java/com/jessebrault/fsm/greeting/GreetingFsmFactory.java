package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.FiniteStateMachine;

public interface GreetingFsmFactory {
    FiniteStateMachine<GreetingInputs, GreetingStates, GreetingInputs> get();
}

