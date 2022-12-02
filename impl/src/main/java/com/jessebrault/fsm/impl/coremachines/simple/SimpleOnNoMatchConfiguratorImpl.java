package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.impl.coremachines.AbstractOnNoMatchConfigurator;

final class SimpleOnNoMatchConfiguratorImpl<I, S> extends AbstractOnNoMatchConfigurator<I, S, SimpleOnNoMatchConfiguratorImpl<I, S>> {

    @Override
    protected SimpleOnNoMatchConfiguratorImpl<I, S> getThis() {
        return this;
    }

}
