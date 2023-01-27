package com.jessebrault.fsm.components;

import java.util.Collection;

public abstract class AbstractStackStateGrammar<
        I, S, O, C,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S, O>
        > extends AbstractStateGrammar<I, S, O, C, T, NMT>
        implements StackStateGrammar<I, S, O, C, T, NMT> {

    public AbstractStackStateGrammar(
            Collection<T> transitions,
            NMT noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
