package com.jessebrault.fsm.integration.simple;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.greeting.SimpleGreetingFsmFactory;
import com.jessebrault.fsm.simple.SimpleFsm;
import com.jessebrault.fsm.simple.SimpleFsmBuilderImpl;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public final class JavaGreetingSimpleFsmFactory implements SimpleGreetingFsmFactory {

    @Override
    public SimpleFsm<GreetingInputs, GreetingStates> get() {
        return new SimpleFsmBuilderImpl<GreetingInputs, GreetingStates>()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> sc.on(SAY_GOODBYE).shiftTo(GOODBYE))
                .whileIn(GOODBYE, sc -> sc.on(SAY_HELLO).shiftTo(HELLO))
                .build();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
