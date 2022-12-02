package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.StateConfigurator;

import java.util.function.Predicate;

public interface PredicateStateConfigurator<I, S> extends StateConfigurator<
        I, S, I, Predicate<I>,
        PredicateOnConfigurator<I, S>,
        PredicateOnNoMatchConfigurator<I, S>,
        PredicateStateGrammar<I, S>,
        PredicateTransition<I, S>,
        PredicateNoMatchTransition<I, S>
        > {
}
