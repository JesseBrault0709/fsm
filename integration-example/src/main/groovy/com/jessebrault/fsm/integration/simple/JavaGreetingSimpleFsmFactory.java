package com.jessebrault.fsm.integration.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;
import com.jessebrault.fsm.coremachines.simple.SimpleFsmBuilder;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.greeting.SimpleGreetingFsmFactory;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class JavaGreetingSimpleFsmFactory implements SimpleGreetingFsmFactory {

    @Override
    public SimpleFsm<GreetingInputs, GreetingStates> get() {
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
