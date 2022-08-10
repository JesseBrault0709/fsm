package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractStateConfigurator;

import java.util.function.Predicate;

final class PredicateStateConfiguratorImpl<I, S> extends AbstractStateConfigurator<I, S, Predicate<I>, I>
        implements PredicateStateConfigurator<I, S> {}
