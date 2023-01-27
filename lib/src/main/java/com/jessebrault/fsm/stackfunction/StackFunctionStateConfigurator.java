package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.StackStateConfigurator;

import java.util.function.Function;

public interface StackFunctionStateConfigurator<I, S, O> extends StackStateConfigurator<
        I, S, O, Function<I, O>,
        StackFunctionOnConfigurator<S, O>,
        StackFunctionOnNoMatchConfigurator<I, S, O>,
        StackFunctionStateGrammar<I, S, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>
        > {}
