package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.AbstractOnNoMatchConfigurator;

final class SimpleOnNoMatchConfiguratorImpl<I, S>
        extends AbstractOnNoMatchConfigurator<I, S, SimpleOnNoMatchConfigurator<I, S>>
        implements SimpleOnNoMatchConfigurator<I, S> {

    @Override
    protected SimpleOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
