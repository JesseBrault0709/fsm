package com.jessebrault.fsm.groovy.stackfunction

import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.stackfunction.StackFunctionFsmBuilder
import com.jessebrault.fsm.stackfunction.StackFunctionFsmBuilderImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import java.util.function.Consumer

import static org.mockito.Mockito.verify
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

@ExtendWith(MockitoExtension)
class GroovyStackFunctionFsmTests {

    static StackFunctionFsmBuilder<GreetingInputs, GreetingStates, Integer> getBuilder() {
        new StackFunctionFsmBuilderImpl<>()
    }

    @Test
    void stackFunctionStateConfiguratorWorks(@Mock Consumer consumer) {
        def fsm = getBuilder().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { it == SAY_HELLO ? it.toString().length() : null } exec consumer
            }
            build()
        }

        fsm.apply SAY_HELLO
        verify consumer accept(SAY_HELLO.toString().length())
    }

}
