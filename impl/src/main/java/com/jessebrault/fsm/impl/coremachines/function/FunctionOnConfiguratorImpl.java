package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionOnConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractOnConfigurator;

final class FunctionOnConfiguratorImpl<S, O> extends AbstractOnConfigurator<S, O, FunctionOnConfigurator<S, O>>
        implements FunctionOnConfigurator<S, O> {

    @Override
    protected FunctionOnConfigurator<S, O> getThis() {
        return this;
    }

}
