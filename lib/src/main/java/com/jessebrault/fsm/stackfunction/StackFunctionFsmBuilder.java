package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.StackFsmBuilder;

import java.util.function.Function;

public interface StackFunctionFsmBuilder<I, S, O> extends StackFsmBuilder<
        I, S, O, Function<I, O>,
        StackFunctionStateConfigurator<I, S, O>,
        StackFunctionOnConfigurator<S, O>,
        StackFunctionOnNoMatchConfigurator<I, S, O>,
        StackFunctionStateGrammar<I, S, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>,
        StackFunctionFsm<I, S, O>,
        StackFunctionFsmBuilder<I, S, O>
        > {}
