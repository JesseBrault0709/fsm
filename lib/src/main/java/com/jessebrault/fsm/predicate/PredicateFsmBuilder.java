package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.FsmBuilder;

import java.util.function.Predicate;

public interface PredicateFsmBuilder<I, S> extends FsmBuilder<
        I, S, I, Predicate<I>,
        PredicateStateConfigurator<I, S>,
        PredicateOnConfigurator<I, S>,
        PredicateOnNoMatchConfigurator<I, S>,
        PredicateStateGrammar<I, S>,
        PredicateTransition<I, S>,
        PredicateNoMatchTransition<I, S>,
        PredicateFsm<I, S>,
        PredicateFsmBuilder<I, S>
        > {}
