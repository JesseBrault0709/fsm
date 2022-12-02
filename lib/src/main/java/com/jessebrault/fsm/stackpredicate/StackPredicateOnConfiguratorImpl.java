package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnConfigurator;

final class StackPredicateOnConfiguratorImpl<I, S>
        extends AbstractStackOnConfigurator<S, I, StackPredicateOnConfigurator<I, S>>
        implements StackPredicateOnConfigurator<I, S> {

    @Override
    protected StackPredicateOnConfigurator<I, S> getThis() {
        return this;
    }

}
