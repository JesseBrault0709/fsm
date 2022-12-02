package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.AbstractStackFsmBuilder;

public final class StackSimpleFsmBuilderImpl<I, S> extends AbstractStackFsmBuilder<
        I, S, I, I,
        StackSimpleStateConfigurator<I, S>,
        StackSimpleOnConfigurator<I, S>,
        StackSimpleOnNoMatchConfigurator<I, S>,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>,
        StackSimpleFsm<I, S>,
        StackSimpleFsmBuilder<I, S>
        > implements StackSimpleFsmBuilder<I, S> {

    @Override
    protected StackSimpleFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    protected StackSimpleStateConfigurator<I, S> getStateConfigurator() {
        return new StackSimpleStateConfiguratorImpl<>();
    }

    @Override
    public StackSimpleFsm<I, S> build() {

        return null;
    }

}
