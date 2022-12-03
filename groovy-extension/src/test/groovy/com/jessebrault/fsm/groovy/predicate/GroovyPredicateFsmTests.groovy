package com.jessebrault.fsm.groovy.predicate

import com.jessebrault.fsm.greeting.GreetingInputs
import com.jessebrault.fsm.greeting.GreetingStates
import com.jessebrault.fsm.predicate.PredicateFsmBuilder
import com.jessebrault.fsm.predicate.PredicateFsmBuilderImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import java.util.function.Consumer

import static org.mockito.Mockito.verify
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO

@ExtendWith(MockitoExtension)
class GroovyPredicateFsmTests {

    static PredicateFsmBuilder<GreetingInputs, GreetingStates> getBuilder() {
        new PredicateFsmBuilderImpl<>()
    }

    @Test
    void stateConfiguratorOnWorks(@Mock Consumer consumer) {
        def fsm = getBuilder().with {
            initialState = HELLO
            whileIn(HELLO) {
                on { true } exec consumer
            }
            build()
        }

        fsm.apply SAY_HELLO
        verify consumer accept SAY_HELLO
    }

}
