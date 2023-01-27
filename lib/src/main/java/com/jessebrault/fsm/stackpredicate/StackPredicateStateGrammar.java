package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.AbstractStackStateGrammar;

import java.util.Collection;
import java.util.function.Predicate;

public final class StackPredicateStateGrammar<I, S> extends AbstractStackStateGrammar<
        I, S, I, Predicate<I>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>
        > {

    public StackPredicateStateGrammar(
            Collection<StackPredicateTransition<I, S>> transitions,
            StackPredicateNoMatchTransition<I, S> noMatchTransition
    ) {
        super(transitions, noMatchTransition);
    }

}
