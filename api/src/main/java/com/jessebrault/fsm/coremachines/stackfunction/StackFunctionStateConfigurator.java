package com.jessebrault.fsm.coremachines.stackfunction;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface StackFunctionStateConfigurator<I, S, O> {

    StackFunctionOnConfigurator<S, O> on(@NotNull Function<I, O> ioFunction);

    StackFunctionOnNoMatchConfigurator<I, S> onNoMatch();
    
}
