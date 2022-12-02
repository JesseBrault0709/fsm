package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleOnConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractOnConfigurator;

final class SimpleOnConfiguratorImpl<I, S> extends AbstractOnConfigurator<S, I, SimpleOnConfiguratorImpl<I, S>>
         {

    @Override
    protected SimpleOnConfiguratorImpl<I, S> getThis() {
        return this;
    }

}
