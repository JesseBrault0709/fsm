package com.jessebrault.fsm.integration.simple;

import com.jessebrault.fsm.greeting.GreetingFsmFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class SimpleFsmTests {

    private static Stream<GreetingFsmFactory> getFactories() {
        return Stream.of(new JavaGreetingSimpleFsmFactory(), new GroovyGreetingSimpleFsmFactory());
    }

    @ParameterizedTest
    @MethodSource("getFactories")
    public void dslsOutputEquivalentFsms(GreetingFsmFactory factory) {
        final var fsm = factory.get();

        // HELLO -> GOODBYE
        final var r0 = fsm.accept(SAY_GOODBYE);
        Assertions.assertEquals(SAY_GOODBYE, r0);
        Assertions.assertEquals(GOODBYE, fsm.getCurrentState());

        // GOODBYE -> HELLO
        final var r1 = fsm.accept(SAY_HELLO);
        Assertions.assertEquals(SAY_HELLO, r1);
        Assertions.assertEquals(HELLO, fsm.getCurrentState());
    }

}
