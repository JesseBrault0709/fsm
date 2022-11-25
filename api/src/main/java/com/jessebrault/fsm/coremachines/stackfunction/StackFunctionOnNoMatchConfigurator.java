package com.jessebrault.fsm.coremachines.stackfunction;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface StackFunctionOnNoMatchConfigurator<I, S> {

    StackFunctionOnNoMatchConfigurator<I, S> shiftTo(@NotNull S state);

    StackFunctionOnNoMatchConfigurator<I, S> pushState(@NotNull S state);

    StackFunctionOnNoMatchConfigurator<I, S> popState();

    StackFunctionOnNoMatchConfigurator<I, S> exec(Consumer<I> inputConsumer);
    
}
