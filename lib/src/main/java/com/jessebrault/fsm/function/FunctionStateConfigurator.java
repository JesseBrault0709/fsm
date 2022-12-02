package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.StateConfigurator;

import java.util.function.Function;

public interface FunctionStateConfigurator<I, S, O> extends StateConfigurator<
        I, S, O, Function<I, O>,
        FunctionOnConfigurator<I, S, O>,
        FunctionOnNoMatchConfigurator<I, S>,
        FunctionStateGrammar<I, S, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S>
        > {}
