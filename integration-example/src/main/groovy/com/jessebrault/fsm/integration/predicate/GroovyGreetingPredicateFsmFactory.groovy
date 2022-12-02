package com.jessebrault.fsm.integration.predicate

import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.greeting.PredicateGreetingFsmFactory
import com.jessebrault.fsm.predicate.PredicateFsm
import com.jessebrault.fsm.predicate.PredicateFsmBuilderImpl

import java.util.function.Predicate

import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

class GroovyGreetingPredicateFsmFactory implements PredicateGreetingFsmFactory {

    @Override
    PredicateFsm<GreetingInputs, GreetingStates> get() {
        new PredicateFsmBuilderImpl<GreetingInputs, GreetingStates>().with {
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
