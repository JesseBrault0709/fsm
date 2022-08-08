package com.jessebrault.fsm.groovy.function;

import com.jessebrault.fsm.function.FunctionFsmBuilder;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;
import groovy.lang.Closure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FunctionFsmTests {

    @Test
    public void onExecClosureCalled(@Mock Closure<?> closure) {
        final FunctionFsmBuilder<GreetingInputs, GreetingStates, Integer> b = FunctionFsmBuilder.get();
        b.setInitialState(HELLO);
        b.whileIn(HELLO, tsb -> tsb.on(input -> {
            if (Objects.equals(SAY_GOODBYE, input)) {
                return input.name().length();
            } else {
                return null;
            }
        }).exec(closure));
        final var fsm = b.build();
        fsm.accept(SAY_GOODBYE);
        verify(closure).call(SAY_GOODBYE.name().length());
    }

}
