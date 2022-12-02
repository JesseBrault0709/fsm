package com.jessebrault.fsm.integration.predicate;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.greeting.PredicateGreetingFsmFactory;
import com.jessebrault.fsm.predicate.PredicateFsm;
import com.jessebrault.fsm.predicate.PredicateFsmBuilderImpl;

import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class JavaGreetingPredicateFsmFactory implements PredicateGreetingFsmFactory {

    @Override
    public PredicateFsm<GreetingInputs, GreetingStates> get() {
        return new PredicateFsmBuilderImpl<GreetingInputs, GreetingStates>()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> sc.on(input -> input.ordinal() == 1).shiftTo(GOODBYE))
                .whileIn(GOODBYE, sc -> sc.on(input -> input.ordinal() == 0).shiftTo(HELLO))
                .build();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
