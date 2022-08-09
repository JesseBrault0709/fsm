package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

import java.util.function.Predicate;

public interface PredicateStateConfigurator<I, S> extends StateConfigurator<I, S, Predicate<I>, I> {}
