package com.jessebrault.fsm.integration.function;

import com.jessebrault.fsm.coremachines.function.FunctionFsm;
import com.jessebrault.fsm.coremachines.function.FunctionFsmBuilder;
import com.jessebrault.fsm.greeting.FunctionGreetingFsmFactory;
import com.jessebrault.fsm.greeting.GreetingInputs;
import com.jessebrault.fsm.greeting.GreetingStates;

import java.util.Objects;

import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingInputs.SAY_HELLO;
import static com.jessebrault.fsm.greeting.GreetingStates.GOODBYE;
import static com.jessebrault.fsm.greeting.GreetingStates.HELLO;

public class JavaFunctionGreetingFsmFactory implements FunctionGreetingFsmFactory<Integer> {

    @Override
    public FunctionFsm<GreetingInputs, GreetingStates, Integer> get() {
        return FunctionFsmBuilder.<GreetingInputs, GreetingStates, Integer>get()
                .setInitialState(HELLO)
                .whileIn(HELLO, tsb ->
                        tsb.on(input -> Objects.equals(input, SAY_GOODBYE) ? input.name().length() : null).shiftTo(GOODBYE)
                )
                .whileIn(GOODBYE, tsb ->
                        tsb.on(input -> Objects.equals(input, SAY_HELLO) ? input.name().length() : null).shiftTo(HELLO)
                )
                .build();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
