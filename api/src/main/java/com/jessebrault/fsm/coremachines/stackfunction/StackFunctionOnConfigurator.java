package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import org.jetbrains.annotations.NotNull;

public interface StackFunctionOnConfigurator<S, O> extends OnConfigurator<S, O, StackFunctionOnConfigurator<S, O>> {

    StackFunctionOnConfigurator<S, O> pushState(@NotNull S state);

    StackFunctionOnConfigurator<S, O> popState();

    StackFunctionOnConfigurator<S, O> popStates(int numberOfStates);

}
