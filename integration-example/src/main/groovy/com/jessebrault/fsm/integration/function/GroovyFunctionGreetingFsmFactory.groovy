package com.jessebrault.fsm.integration.function

import com.jessebrault.fsm.FiniteStateMachine
import com.jessebrault.fsm.function.FunctionFsmBuilder
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates

import static com.jessebrault.fsm.greeting.GreetingInputs.*;
import static com.jessebrault.fsm.greeting.GreetingStates.*;

class GroovyFunctionGreetingFsmFactory implements FunctionGreetingFsmFactory {

    @Override
    FiniteStateMachine<GreetingInputs, GreetingStates, Integer> get() {
        FunctionFsmBuilder.<GreetingInputs, GreetingStates, Integer>get().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { it == SAY_GOODBYE ? it.name().length() : null } shiftTo GOODBYE
            }
            whileIn(GOODBYE) {
                on { it == SAY_HELLO ? it.name().length() : null } shiftTo HELLO
            }
            build()
        }
    }

    @Override
    String toString() {
        this.class.simpleName
    }

}
