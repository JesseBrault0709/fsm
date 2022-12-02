package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateOnConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractOnConfigurator;

final class PredicateOnConfiguratorImpl<I, S> extends AbstractOnConfigurator<S, I, PredicateOnConfigurator<I, S>>
        implements PredicateOnConfigurator<I, S> {

    @Override
    protected PredicateOnConfigurator<I, S> getThis() {
        return this;
    }

}
