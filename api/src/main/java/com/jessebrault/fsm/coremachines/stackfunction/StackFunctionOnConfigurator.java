package com.jessebrault.fsm.coremachines.stackfunction;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface StackFunctionOnConfigurator<S, O> {

    StackFunctionOnConfigurator<S, O> shiftTo(@NotNull S state);

    StackFunctionOnConfigurator<S, O> pushState(@NotNull S state);

    StackFunctionOnConfigurator<S, O> popState();
    
    StackFunctionOnConfigurator<S, O> exec(@NotNull Consumer<O> outputConsumer);

}
