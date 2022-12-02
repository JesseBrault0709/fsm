package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.StackFsmBuilder;

import java.util.function.Predicate;

public interface StackPredicateFsmBuilder<I, S> extends StackFsmBuilder<
        I, S, I, Predicate<I>,
        StackPredicateStateConfigurator<I, S>,
        StackPredicateOnConfigurator<I, S>,
        StackPredicateOnNoMatchConfigurator<I, S>,
        StackPredicateStateGrammar<I, S>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>,
        StackPredicateFsm<I, S>,
        StackPredicateFsmBuilder<I, S>
        > {}
