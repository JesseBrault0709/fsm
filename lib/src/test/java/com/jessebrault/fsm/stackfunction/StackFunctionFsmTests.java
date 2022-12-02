package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.jessebrault.fsm.greeting.GreetingInputs.*;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StackFunctionFsmTests {

    private static final Function<GreetingInputs, Integer> sayHelloFunction = input ->
            input == SAY_HELLO ? input.toString().length() : null;

    private static final Function<GreetingInputs, Integer> sayGoodbyeFunction = input ->
            input == SAY_GOODBYE ? input.toString().length() : null;

    private static final Function<GreetingInputs, Integer> isNull = input ->
            input == null ? 0 : null;

    private static StackFunctionFsmBuilder<GreetingInputs, GreetingStates, Integer> getBuilder() {
        return new StackFunctionFsmBuilderImpl<>();
    }

    @Test
    public void returnsCorrectOutput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction);
                })
                .build();
        final var output = fsm.apply(SAY_GOODBYE);
        assertEquals(SAY_GOODBYE.toString().length(), output);
    }

    @Test
    public void returnsNullIfNoMatch() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {})
                .build();
        final var output = fsm.apply(BAD_INPUT);
        assertNull(output);
    }

    @Test
    public void handlesNullInput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(isNull);
                })
                .build();
        final var output = fsm.apply(null);
        assertEquals(0, output);
    }

    @Test
    public void shiftsToCorrectState() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).shiftTo(GOODBYE);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertEquals(GOODBYE, fsm.getCurrentState());
    }

    @Test
    public void pushesState() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).pushState(GOODBYE);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        // n.b.: reverse order because it is a stack!
        assertIterableEquals(List.of(GOODBYE, HELLO), fsm.getStateStack());
    }

    @Test
    public void pushesStates() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).pushStates(List.of(GOODBYE, GOODBYE));
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertIterableEquals(List.of(GOODBYE, GOODBYE, HELLO), fsm.getStateStack());
    }

    @Test
    public void popsState() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).pushState(GOODBYE);
                })
                .whileIn(GOODBYE, sc -> {
                    sc.on(sayHelloFunction).popState();
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertIterableEquals(List.of(GOODBYE, HELLO), fsm.getStateStack());
        fsm.apply(SAY_HELLO);
        assertIterableEquals(List.of(HELLO), fsm.getStateStack());
    }

    @Test
    public void popsStates() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).pushStates(List.of(GOODBYE, GOODBYE));
                })
                .whileIn(GOODBYE, sc -> {
                    sc.on(sayHelloFunction).popStates(2);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertIterableEquals(List.of(GOODBYE, GOODBYE, HELLO), fsm.getStateStack());
        fsm.apply(SAY_HELLO);
        assertIterableEquals(List.of(HELLO), fsm.getStateStack());
    }

    @Test
    public void onExecConsumerCalled(@Mock Consumer<Integer> consumer) {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(sayGoodbyeFunction).exec(consumer);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        verify(consumer).accept(SAY_GOODBYE.toString().length());
    }

    @Test
    public void onNoMatchConsumerCalled(@Mock Consumer<GreetingInputs> consumer) {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.onNoMatch().exec(consumer);
                })
                .build();
        fsm.apply(BAD_INPUT);
        verify(consumer).accept(BAD_INPUT);
    }

}
