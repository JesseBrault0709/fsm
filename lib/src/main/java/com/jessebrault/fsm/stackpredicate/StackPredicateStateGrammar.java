package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.StackStateGrammar;

import java.util.Collection;
import java.util.function.Predicate;

public record StackPredicateStateGrammar<I, S>(
        Collection<StackPredicateTransition<I, S>> transitions,
        StackPredicateNoMatchTransition<I, S> noMatchTransition
) implements StackStateGrammar<
        I, S, I, Predicate<I>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>
        > {}
