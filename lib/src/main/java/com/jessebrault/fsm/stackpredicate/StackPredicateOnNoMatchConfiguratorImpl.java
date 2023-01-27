package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnNoMatchConfigurator;

final class StackPredicateOnNoMatchConfiguratorImpl<I, S>
        extends AbstractStackOnNoMatchConfigurator<I, S, I, StackPredicateOnNoMatchConfigurator<I, S>>
        implements StackPredicateOnNoMatchConfigurator<I, S> {

    @Override
    protected StackPredicateOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
