package com.jessebrault.fsm.impl.simple;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.simple.SimpleFsmBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Consumer;

import static com.jessebrault.fsm.greeting.GreetingInputs.BAD_INPUT;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SimpleFsmImplTests {

    private static SimpleFsmBuilder<GreetingInputs, GreetingStates> getBuilder() {
        return new SimpleFsmBuilderImpl<>();
    }

    @Test
    public void onExecConsumerCalled(@Mock Consumer<GreetingInputs> consumer) {
        final var b = getBuilder();
        b.setInitialState(HELLO);
        b.whileIn(HELLO, tsb -> {
            tsb.on(SAY_HELLO).exec(consumer);
        });
        final var fsm = b.build();
        fsm.accept(SAY_HELLO);
        verify(consumer).accept(SAY_HELLO);
    }

    @Test
    public void onNoMatchConsumerCalled(@Mock Consumer<GreetingInputs> consumer) {
        final var b = getBuilder();
        b.setInitialState(HELLO);
        b.whileIn(HELLO, tsb -> tsb.onNoMatch().exec(consumer));
        final var fsm = b.build();
        fsm.accept(BAD_INPUT);
        verify(consumer).accept(BAD_INPUT);
    }

}
