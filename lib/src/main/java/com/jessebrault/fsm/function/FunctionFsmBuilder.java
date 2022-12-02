package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.FsmBuilder;

import java.util.function.Function;

public interface FunctionFsmBuilder<I, S, O> extends FsmBuilder<
        I, S, O, Function<I, O>,
        FunctionStateConfigurator<I, S, O>,
        FunctionOnConfigurator<I, S, O>,
        FunctionOnNoMatchConfigurator<I, S>,
        FunctionStateGrammar<I, S, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S>,
        FunctionFsm<I, S, O>,
        FunctionFsmBuilder<I, S, O>
        > {}
