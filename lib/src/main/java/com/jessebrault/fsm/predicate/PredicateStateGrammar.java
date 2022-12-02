package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.components.StateGrammar;

import java.util.Collection;
import java.util.function.Predicate;

public record PredicateStateGrammar<I, S>(
        Collection<PredicateTransition<I, S>> transitions,
        PredicateNoMatchTransition<I, S> noMatchTransition
) implements StateGrammar<
        I, S, I, Predicate<I>,
        PredicateTransition<I, S>,
        PredicateNoMatchTransition<I, S>
        > {}
