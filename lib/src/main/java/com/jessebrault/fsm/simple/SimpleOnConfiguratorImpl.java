package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.AbstractOnConfigurator;

final class SimpleOnConfiguratorImpl<I, S>
        extends AbstractOnConfigurator<S, I, SimpleOnConfigurator<I, S>>
        implements SimpleOnConfigurator<I, S> {

    @Override
    protected SimpleOnConfigurator<I, S> getThis() {
        return this;
    }

}
