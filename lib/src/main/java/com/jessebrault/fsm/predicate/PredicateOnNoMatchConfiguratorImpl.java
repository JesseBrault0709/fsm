package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.AbstractOnNoMatchConfigurator;

final class PredicateOnNoMatchConfiguratorImpl<I, S>
        extends AbstractOnNoMatchConfigurator<I, S, I, PredicateOnNoMatchConfigurator<I, S>>
        implements PredicateOnNoMatchConfigurator<I, S> {

    @Override
    protected PredicateOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
