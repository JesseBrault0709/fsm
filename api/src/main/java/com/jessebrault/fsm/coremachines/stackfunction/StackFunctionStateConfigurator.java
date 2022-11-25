package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

import java.util.function.Function;

public interface StackFunctionStateConfigurator<I, S, O>
        extends StateConfigurator<
                I, S, Function<I, O>, O,
                StackFunctionOnConfigurator<S, O>,
                StackFunctionOnNoMatchConfigurator<I, S>
        > {}
