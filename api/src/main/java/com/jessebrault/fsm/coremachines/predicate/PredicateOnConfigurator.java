package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;

public interface PredicateOnConfigurator<I, S> extends OnConfigurator<S, I, PredicateOnConfigurator<I, S>> {}
