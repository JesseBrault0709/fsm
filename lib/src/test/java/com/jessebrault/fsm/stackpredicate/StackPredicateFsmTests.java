package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.jessebrault.fsm.greeting.GreetingInputs.*;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StackPredicateFsmTests {

    private static final Predicate<GreetingInputs> isSayHello = input -> input.ordinal() == 0;
    private static final Predicate<GreetingInputs> isSayGoodbye = input -> input.ordinal() == 1;
    private static final Predicate<GreetingInputs> isNull = Objects::isNull;

    private static StackPredicateFsmBuilder<GreetingInputs, GreetingStates> getBuilder() {
        return new StackPredicateFsmBuilderImpl<>();
    }

    @Test
    public void returnsTheInput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(isSayGoodbye);
                })
                .build();
        final var output = fsm.apply(SAY_GOODBYE);
        assertEquals(SAY_GOODBYE, output);
    }

    @Test
    public void returnsNullIfNoMatch() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {})
                .build();
        final var output = fsm.apply(SAY_GOODBYE);
        assertNull(output);
    }

    // TODO: when a Result interface is added back to the lib,
    // simply test assertTrue(result.matched())
    @Test
    @Disabled
    public void handlesNullInput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(isNull).shiftTo(GOODBYE);
                })
                .build();
        final var output = fsm.apply(null);
        assertNull(output);
        assertEquals(GOODBYE, fsm.getCurrentState());
    }

    @Test
    public void shiftsToCorrectState() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(isSayGoodbye).shiftTo(GOODBYE);
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
                    sc.on(isSayGoodbye).pushState(GOODBYE);
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
                    sc.on(isSayGoodbye).pushStates(List.of(GOODBYE, GOODBYE));
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
                    sc.on(isSayGoodbye).pushState(GOODBYE);
                })
                .whileIn(GOODBYE, sc -> {
                    sc.on(isSayHello).popState();
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
                    sc.on(isSayGoodbye).pushStates(List.of(GOODBYE, GOODBYE));
                })
                .whileIn(GOODBYE, sc -> {
                    sc.on(isSayHello).popStates(2);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertIterableEquals(List.of(GOODBYE, GOODBYE, HELLO), fsm.getStateStack());
        fsm.apply(SAY_HELLO);
        assertIterableEquals(List.of(HELLO), fsm.getStateStack());
    }

    @Test
    public void onExecConsumerCalled(@Mock Consumer<GreetingInputs> consumer) {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(isSayGoodbye).exec(consumer);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        verify(consumer).accept(SAY_GOODBYE);
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
