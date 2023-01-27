package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.AbstractStateGrammar;

import java.util.Collection;

public final class SimpleStateGrammar<I, S> extends AbstractStateGrammar<
        I, S, I, I,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>
        > {

    public SimpleStateGrammar(
            Collection<SimpleTransition<I, S>> transitions,
            SimpleNoMatchTransition<I, S> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
