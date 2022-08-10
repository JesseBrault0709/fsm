package com.jessebrault.fsm.integration.simple

import com.jessebrault.fsm.coremachines.simple.SimpleFsm
import com.jessebrault.fsm.coremachines.simple.SimpleFsmBuilder
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.greeting.SimpleGreetingFsmFactory

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

class GroovyGreetingSimpleFsmFactory implements SimpleGreetingFsmFactory {

    @Override
    SimpleFsm<GreetingInputs, GreetingStates> get() {
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
