package com.jessebrault.fsm.integration.simple

import com.jessebrault.fsm.FiniteStateMachine
import com.jessebrault.fsm.greeting.GreetingFsmFactory
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.simple.SimpleFsmBuilder

import static com.jessebrault.fsm.greeting.GreetingInputs.*
import static com.jessebrault.fsm.greeting.GreetingStates.*

class GroovyGreetingSimpleFsmFactory implements GreetingFsmFactory {

    @Override
    FiniteStateMachine<GreetingInputs, GreetingStates, GreetingInputs> get() {
        SimpleFsmBuilder.<GreetingInputs, GreetingStates>get().with {
            initialState = HELLO
            whileIn(HELLO) {
                on SAY_GOODBYE shiftTo GOODBYE
            }
            whileIn(GOODBYE) {
                on SAY_HELLO shiftTo HELLO
            }
            build()
        }
    }

    @Override
    String toString() {
        this.class.simpleName
    }

}
