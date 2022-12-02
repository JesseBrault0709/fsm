package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.AbstractOnNoMatchConfigurator;

final class FunctionOnNoMatchConfiguratorImpl<I, S>
        extends AbstractOnNoMatchConfigurator<I, S, FunctionOnNoMatchConfigurator<I, S>>
        implements FunctionOnNoMatchConfigurator<I, S> {

    @Override
    protected FunctionOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
