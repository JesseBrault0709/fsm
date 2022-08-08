package com.jessebrault.fsm.integration.predicate;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.greeting.GreetingFsmFactory;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.predicate.PredicateFsmBuilder;

import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class JavaGreetingPredicateFsmFactory implements GreetingFsmFactory {

    @Override
    public FiniteStateMachine<GreetingInputs, GreetingStates, GreetingInputs> get() {
        return PredicateFsmBuilder.<GreetingInputs, GreetingStates>get()
                .setInitialState(HELLO)
                .whileIn(HELLO, tsb -> tsb.on(input -> input.ordinal() == 1).shiftTo(GOODBYE))
                .whileIn(GOODBYE, tsb -> tsb.on(input -> input.ordinal() == 0).shiftTo(HELLO))
                .build();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
