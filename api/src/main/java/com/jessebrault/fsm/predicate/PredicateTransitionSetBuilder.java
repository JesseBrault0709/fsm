package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.function.Predicate;

public interface PredicateTransitionSetBuilder<I, S> extends TransitionSetBuilder<I, S, Predicate<I>, I> {}
