package com.jessebrault.fsm.integration.function;

import com.jessebrault.fsm.greeting.FunctionGreetingFsmFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionGreetingFsmTests {

    private static Stream<FunctionGreetingFsmFactory<Integer>> getFactories() {
        return Stream.of(new JavaFunctionGreetingFsmFactory(), new GroovyFunctionGreetingFsmFactory());
    }

    @ParameterizedTest
    @MethodSource("getFactories")
    public void dslsOutputEquivalentFsms(FunctionGreetingFsmFactory<Integer> factory) {
        final var fsm = factory.get();

        final var r0 = fsm.apply(SAY_GOODBYE);
        assertEquals(SAY_GOODBYE.name().length(), r0);
        assertEquals(GOODBYE, fsm.getCurrentState());

        final var r1 = fsm.apply(SAY_HELLO);
        assertEquals(SAY_HELLO.name().length(), r1);
        assertEquals(HELLO, fsm.getCurrentState());
    }

}
