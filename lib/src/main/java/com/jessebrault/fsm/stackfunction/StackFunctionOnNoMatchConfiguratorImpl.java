package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnNoMatchConfigurator;

final class StackFunctionOnNoMatchConfiguratorImpl<I, S, O>
        extends AbstractStackOnNoMatchConfigurator<I, S, O, StackFunctionOnNoMatchConfigurator<I, S, O>>
        implements StackFunctionOnNoMatchConfigurator<I, S, O> {

    @Override
    protected StackFunctionOnNoMatchConfigurator<I, S, O> getThis() {
        return this;
    }

}
