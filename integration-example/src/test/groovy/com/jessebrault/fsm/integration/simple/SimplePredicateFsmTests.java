package com.jessebrault.fsm.integration.simple;

import com.jessebrault.fsm.greeting.SimpleGreetingFsmFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class SimplePredicateFsmTests {

    private static Stream<SimpleGreetingFsmFactory> getFactories() {
        return Stream.of(new JavaGreetingSimpleFsmFactory(), new GroovyGreetingSimpleFsmFactory());
    }

    @ParameterizedTest
    @MethodSource("getFactories")
    public void dslsOutputEquivalentFsms(SimpleGreetingFsmFactory factory) {
        final var fsm = factory.get();

        // HELLO -> GOODBYE
        final var r0 = fsm.accept(SAY_GOODBYE);
        Assertions.assertEquals(SAY_GOODBYE, r0.getInput());
        Assertions.assertEquals(GOODBYE, r0.getState());

        // GOODBYE -> HELLO
        final var r1 = fsm.accept(SAY_HELLO);
        Assertions.assertEquals(SAY_HELLO, r1.getInput());
        Assertions.assertEquals(HELLO, r1.getState());
    }

}
