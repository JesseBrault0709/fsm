package com.jessebrault.fsm.impl.predicate;

import com.jessebrault.fsm.impl.AbstractTransitionSetBuilder;
import com.jessebrault.fsm.predicate.PredicateTransitionSetBuilder;

import java.util.function.Predicate;

final class PredicateTransitionSetBuilderImpl<I, S> extends AbstractTransitionSetBuilder<I, S, Predicate<I>, I>
        implements PredicateTransitionSetBuilder<I, S> {}
