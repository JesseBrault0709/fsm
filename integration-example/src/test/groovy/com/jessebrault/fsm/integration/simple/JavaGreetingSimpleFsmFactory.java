package com.jessebrault.fsm.integration.simple;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.greeting.GreetingFsmFactory;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.simple.SimpleFsmBuilder;

import static com.jessebrault.fsm.greeting.GreetingInputs.*;
import static com.jessebrault.fsm.greeting.GreetingStates.*;

public class JavaGreetingSimpleFsmFactory implements GreetingFsmFactory {

    @Override
    public FiniteStateMachine<GreetingInputs, GreetingStates, GreetingInputs> get() {
        return SimpleFsmBuilder.<GreetingInputs, GreetingStates>get()
                .setInitialState(HELLO)
                .whileIn(HELLO, tsb -> tsb.on(SAY_GOODBYE).shiftTo(GOODBYE))
                .whileIn(GOODBYE, tsb -> tsb.on(SAY_HELLO).shiftTo(HELLO))
                .build();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
