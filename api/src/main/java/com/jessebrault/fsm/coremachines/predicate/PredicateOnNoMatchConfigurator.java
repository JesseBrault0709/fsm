package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;

public interface PredicateOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, PredicateOnNoMatchConfigurator<I, S>> {}
