package com.jessebrault.fsm.integration.function

import com.jessebrault.fsm.coremachines.function.FunctionFsm
import com.jessebrault.fsm.coremachines.function.FunctionFsmBuilder
import com.jessebrault.fsm.greeting.FunctionGreetingFsmFactory
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

class GroovyFunctionGreetingFsmFactory implements FunctionGreetingFsmFactory<Integer> {

    @Override
    FunctionFsm<GreetingInputs, GreetingStates, Integer> get() {
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
