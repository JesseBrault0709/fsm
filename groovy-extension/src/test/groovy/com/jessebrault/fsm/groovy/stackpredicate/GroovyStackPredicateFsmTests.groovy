package com.jessebrault.fsm.groovy.stackpredicate

import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.stackpredicate.StackPredicateFsmBuilder
import com.jessebrault.fsm.stackpredicate.StackPredicateFsmBuilderImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import java.util.function.Consumer

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.spy
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

@ExtendWith(MockitoExtension)
class GroovyStackPredicateFsmTests {

    static StackPredicateFsmBuilder<GreetingInputs, GreetingStates> getBuilder() {
        new StackPredicateFsmBuilderImpl<GreetingInputs, GreetingStates>()
    }

    @Test
    void stateConfiguratorOnExtensionWorks(@Mock Consumer consumer) {
        def fsm = getBuilder().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { true } exec consumer
            }
            build()
        }

        fsm.apply(SAY_HELLO) // or any input
        verify consumer accept SAY_HELLO
    }

}
