package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static com.jessebrault.fsm.greeting.GreetingStates.*;
import static com.jessebrault.fsm.greeting.GreetingInputs.*;

@ExtendWith(MockitoExtension.class)
public class SimpleFsmTests {

    private static SimpleFsmBuilder<GreetingInputs, GreetingStates> getBuilder() {
        return new SimpleFsmBuilderImpl<>();
    }

    @Test
    public void returnsTheInput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(SAY_GOODBYE);
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
        final var output = fsm.apply(BAD_INPUT);
        assertNull(output);
    }

    @Test
    public void throwsIfGivenNull() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {})
                .build();
        assertThrows(RuntimeException.class, () -> {
            fsm.apply(null);
        });
    }

    @Test
    public void shiftsToCorrectState() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(SAY_GOODBYE).shiftTo(GOODBYE);
                })
                .build();
        fsm.apply(SAY_GOODBYE);
        assertEquals(GOODBYE, fsm.getCurrentState());
    }

    @Test
    public void onExecConsumerCalled(@Mock Consumer<GreetingInputs> consumer) {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.on(SAY_HELLO).exec(consumer);
                })
                .build();
        fsm.apply(SAY_HELLO);
        verify(consumer).accept(SAY_HELLO);
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

    @Test
    public void onNoMatchReturnsInsteadOutput() {
        final var fsm = getBuilder()
                .setInitialState(HELLO)
                .whileIn(HELLO, sc -> {
                    sc.onNoMatch().instead(input -> SAY_HELLO);
                })
                .build();
        final var output = fsm.apply(BAD_INPUT);
        assertEquals(SAY_HELLO, output);
    }

}
