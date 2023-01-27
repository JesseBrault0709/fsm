package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.AbstractStateGrammar;

import java.util.Collection;
import java.util.function.Function;

public final class FunctionStateGrammar<I, S, O> extends AbstractStateGrammar<
        I, S, O, Function<I, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S, O>> {

    public FunctionStateGrammar(
            Collection<FunctionTransition<I, S, O>> transitions,
            FunctionNoMatchTransition<I, S, O> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
