package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.AbstractOnConfigurator;

final class FunctionOnConfiguratorImpl<I, S, O>
        extends AbstractOnConfigurator<S, O, FunctionOnConfigurator<I, S, O>>
        implements FunctionOnConfigurator<I, S, O> {

    @Override
    protected FunctionOnConfigurator<I, S, O> getThis() {
        return this;
    }

}
