package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.AbstractStackOnNoMatchConfigurator;

final class StackSimpleOnNoMatchConfiguratorImpl<I, S>
        extends AbstractStackOnNoMatchConfigurator<I, S, I, StackSimpleOnNoMatchConfigurator<I, S>>
        implements StackSimpleOnNoMatchConfigurator<I, S> {

    @Override
    protected StackSimpleOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
