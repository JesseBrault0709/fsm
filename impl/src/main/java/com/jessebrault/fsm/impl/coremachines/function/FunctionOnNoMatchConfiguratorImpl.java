package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionOnNoMatchConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractOnNoMatchConfigurator;

final class FunctionOnNoMatchConfiguratorImpl<I, S>
        extends AbstractOnNoMatchConfigurator<I, S, FunctionOnNoMatchConfigurator<I, S>>
        implements FunctionOnNoMatchConfigurator<I, S> {

    @Override
    protected FunctionOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
