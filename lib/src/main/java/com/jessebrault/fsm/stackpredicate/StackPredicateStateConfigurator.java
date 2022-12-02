package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.StackStateConfigurator;

import java.util.function.Predicate;

public interface StackPredicateStateConfigurator<I, S> extends StackStateConfigurator<
        I, S, I, Predicate<I>,
        StackPredicateOnConfigurator<I, S>,
        StackPredicateOnNoMatchConfigurator<I, S>,
        StackPredicateStateGrammar<I, S>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>
        > {
}
