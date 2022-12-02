package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.AbstractOnConfigurator;

final class PredicateOnConfiguratorImpl<I, S>
        extends AbstractOnConfigurator<S, I, PredicateOnConfigurator<I, S>>
        implements PredicateOnConfigurator<I, S> {

    @Override
    protected PredicateOnConfigurator<I, S> getThis() {
        return this;
    }

}
