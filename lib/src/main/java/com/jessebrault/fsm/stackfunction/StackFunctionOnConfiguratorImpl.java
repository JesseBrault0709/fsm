package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnConfigurator;

final class StackFunctionOnConfiguratorImpl<S, O>
        extends AbstractStackOnConfigurator<S, O, StackFunctionOnConfigurator<S, O>>
        implements StackFunctionOnConfigurator<S, O> {

    @Override
    protected StackFunctionOnConfigurator<S, O> getThis() {
        return this;
    }

}
