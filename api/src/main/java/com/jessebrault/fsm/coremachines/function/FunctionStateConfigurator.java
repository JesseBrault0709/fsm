package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

import java.util.function.Function;

public interface FunctionStateConfigurator<I, S, O> extends StateConfigurator<
        I, S, Function<I, O>, O,
        FunctionOnConfigurator<S, O>,
        FunctionOnNoMatchConfigurator<I, S>
        > {}
