package com.jessebrault.fsm.groovy.function

import com.jessebrault.fsm.function.FunctionFsmBuilder
import com.jessebrault.fsm.function.FunctionFsmBuilderImpl
import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import java.util.function.Consumer

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO
import static org.mockito.Mockito.verify

@ExtendWith(MockitoExtension)
class GroovyFunctionFsmTests {

    static FunctionFsmBuilder<GreetingInputs, GreetingStates, Integer> getBuilder() {
        new FunctionFsmBuilderImpl<>()
    }

    @Test
    void onExecClosureCalled(@Mock Consumer consumer) {
        def fsm = getBuilder().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { it == SAY_GOODBYE ? it.name().length() : null } exec consumer
            }
            build()
        }
        fsm.apply SAY_GOODBYE
        verify consumer accept(SAY_GOODBYE.name().length())
    }

}
