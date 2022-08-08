package com.jessebrault.fsm.integration.function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static com.jessebrault.fsm.greeting.GreetingInputs.*;
import static com.jessebrault.fsm.greeting.GreetingStates.*;

public class FunctionGreetingFsmTests {

    private static Stream<FunctionGreetingFsmFactory> getFactories() {
        return Stream.of(new JavaFunctionGreetingFsmFactory(), new GroovyFunctionGreetingFsmFactory());
    }

    @ParameterizedTest
    @MethodSource("getFactories")
    public void dslsOutputEquivalentFsms(FunctionGreetingFsmFactory factory) {
        final var fsm = factory.get();

        final var r0 = fsm.accept(SAY_GOODBYE);
        assertEquals(SAY_GOODBYE.name().length(), r0);
        assertEquals(GOODBYE, fsm.getCurrentState());

        final var r1 = fsm.accept(SAY_HELLO);
        assertEquals(SAY_HELLO.name().length(), r1);
        assertEquals(HELLO, fsm.getCurrentState());
    }

}
