package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.AbstractStackStateGrammar;

import java.util.Collection;

public final class StackSimpleStateGrammar<I, S>
        extends AbstractStackStateGrammar<
        I, S, I, I,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>
        > {

    public StackSimpleStateGrammar(
            Collection<StackSimpleTransition<I, S>> transitions,
            StackSimpleNoMatchTransition<I, S> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
