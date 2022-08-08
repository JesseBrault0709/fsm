package com.jessebrault.fsm.integration.predicate;

import com.jessebrault.fsm.greeting.GreetingFsmFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateFsmTests {

    private static Stream<GreetingFsmFactory> getDslFactories() {
        return Stream.of(new JavaGreetingPredicateFsmFactory(), new GroovyGreetingPredicateFsmFactory());
    }

    @ParameterizedTest
    @MethodSource("getDslFactories")
    public void dslsOutputEquivalentFsms(GreetingFsmFactory factory) {
        final var fsm = factory.get();

        // HELLO -> GOODBYE
        final var r0 = fsm.accept(SAY_GOODBYE);
        assertEquals(SAY_GOODBYE, r0);
        assertEquals(GOODBYE, fsm.getCurrentState());

        // GOODBYE -> HELLO
        final var r1 = fsm.accept(SAY_HELLO);
        assertEquals(SAY_HELLO, r1);
        assertEquals(HELLO, fsm.getCurrentState());
    }
    
}
