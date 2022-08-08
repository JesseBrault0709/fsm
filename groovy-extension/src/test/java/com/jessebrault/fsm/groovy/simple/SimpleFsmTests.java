package com.jessebrault.fsm.groovy.simple;

import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import com.jessebrault.fsm.simple.SimpleFsmBuilder;
import groovy.lang.Closure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.jessebrault.fsm.greeting.GreetingInputs.BAD_INPUT;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SimpleFsmTests {

    @Test
    public void onExecClosureCalled(@Mock Closure<?> closure) {
        final SimpleFsmBuilder<GreetingInputs, GreetingStates> b = SimpleFsmBuilder.get();
        b.setInitialState(HELLO);
        b.whileIn(HELLO, tsb -> {
            tsb.on(SAY_HELLO).exec(closure);
        });
        final var fsm = b.build();
        fsm.accept(SAY_HELLO);
        verify(closure).call(SAY_HELLO);
    }

    @Test
    public void onNoMatchClosureCalled(@Mock Closure<?> closure) {
        final var b = SimpleFsmBuilder.get();
        b.setInitialState(HELLO);
        b.whileIn(HELLO, tsb -> tsb.onNoMatch().exec(closure));
        final var fsm = b.build();
        fsm.accept(BAD_INPUT);
        verify(closure).call(BAD_INPUT);
    }

}
