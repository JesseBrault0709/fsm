package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

public interface PredicateOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, PredicateOnNoMatchConfigurator<I, S>> {}
