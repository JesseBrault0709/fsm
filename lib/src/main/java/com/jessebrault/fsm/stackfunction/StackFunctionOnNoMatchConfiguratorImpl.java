package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnNoMatchConfigurator;

final class StackFunctionOnNoMatchConfiguratorImpl<I, S>
        extends AbstractStackOnNoMatchConfigurator<I, S, StackFunctionOnNoMatchConfigurator<I, S>>
        implements StackFunctionOnNoMatchConfigurator<I, S> {

    @Override
    protected StackFunctionOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
