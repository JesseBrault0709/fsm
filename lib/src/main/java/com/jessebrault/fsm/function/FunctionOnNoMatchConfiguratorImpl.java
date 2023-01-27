package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.AbstractOnNoMatchConfigurator;

final class FunctionOnNoMatchConfiguratorImpl<I, S, O>
        extends AbstractOnNoMatchConfigurator<I, S, O, FunctionOnNoMatchConfigurator<I, S, O>>
        implements FunctionOnNoMatchConfigurator<I, S, O> {

    @Override
    protected FunctionOnNoMatchConfigurator<I, S, O> getThis() {
        return this;
    }

}
