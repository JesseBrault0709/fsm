package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.AbstractStackStateGrammar;

import java.util.Collection;
import java.util.function.Function;

public final class StackFunctionStateGrammar<I, S, O> extends AbstractStackStateGrammar<
        I, S, O, Function<I, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>
        > {

    public StackFunctionStateGrammar(
            Collection<StackFunctionTransition<I, S, O>> transitions,
            StackFunctionNoMatchTransition<I, S, O> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
