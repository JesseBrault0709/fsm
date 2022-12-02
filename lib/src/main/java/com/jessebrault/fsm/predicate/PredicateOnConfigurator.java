package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.OnConfigurator;

public interface PredicateOnConfigurator<I, S> extends OnConfigurator<S, I, PredicateOnConfigurator<I, S>> {}
