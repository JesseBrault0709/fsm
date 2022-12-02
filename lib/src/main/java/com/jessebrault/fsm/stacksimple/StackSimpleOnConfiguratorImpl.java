package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnConfigurator;

final class StackSimpleOnConfiguratorImpl<I, S>
        extends AbstractStackOnConfigurator<S, I, StackSimpleOnConfigurator<I, S>>
        implements StackSimpleOnConfigurator<I, S> {

    @Override
    protected StackSimpleOnConfigurator<I, S> getThis() {
        return this;
    }

}
