package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.components.AbstractStateGrammar;

import java.util.Collection;
import java.util.function.Predicate;

public final class PredicateStateGrammar<I, S> extends AbstractStateGrammar<
        I, S, I, Predicate<I>,
        PredicateTransition<I, S>,
        PredicateNoMatchTransition<I, S>
        > {

    public PredicateStateGrammar(
            Collection<PredicateTransition<I, S>> transitions,
            PredicateNoMatchTransition<I, S> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
