package com.jessebrault.fsm.integration.predicate

import com.jessebrault.fsm.FiniteStateMachine
import com.jessebrault.fsm.greeting.GreetingFsmFactory
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.predicate.PredicateFsmBuilder

import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

class GroovyGreetingPredicateFsmFactory implements GreetingFsmFactory {

    @Override
    FiniteStateMachine<GreetingInputs, GreetingStates, GreetingInputs> get() {
        PredicateFsmBuilder.<GreetingInputs, GreetingStates>get().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { it.ordinal() == 1 } shiftTo GOODBYE
            }
            whileIn(GOODBYE) {
                on { it.ordinal() == 0 } shiftTo HELLO
            }
            build()
        }
    }

    @Override
    String toString() {
        this.class.simpleName
    }

}
