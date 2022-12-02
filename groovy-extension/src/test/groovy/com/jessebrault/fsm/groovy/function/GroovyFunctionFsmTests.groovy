package com.jessebrault.fsm.groovy.function

import com.jessebrault.fsm.function.FunctionFsmBuilderImpl
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import org.junit.jupiter.api.Test

import java.util.function.Consumer

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.verify

class GroovyFunctionFsmTests {

    @Test
    void onExecClosureCalled() {
        def consumer = mock Consumer
        def fsm = new FunctionFsmBuilderImpl<GreetingInputs, GreetingStates, Integer>().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { it == SAY_GOODBYE ? it.name().length() : null } shiftTo GOODBYE exec {
                    consumer.accept it
                }
            }
            build()
        }
        fsm.apply SAY_GOODBYE
        verify consumer accept(SAY_GOODBYE.name().length())
    }

}
