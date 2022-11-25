package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import org.jetbrains.annotations.NotNull;

public interface StackFunctionOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, StackFunctionOnNoMatchConfigurator<I, S>> {

    StackFunctionOnNoMatchConfigurator<I, S> pushState(@NotNull S state);

    StackFunctionOnNoMatchConfigurator<I, S> popState();

    StackFunctionOnNoMatchConfigurator<I, S> popStates(int numberOfStates);

}
