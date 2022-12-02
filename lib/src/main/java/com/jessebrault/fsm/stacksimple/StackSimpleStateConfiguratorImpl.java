package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.AbstractStackStateConfigurator;

final class StackSimpleStateConfiguratorImpl<I, S> extends AbstractStackStateConfigurator<
        I, S, I, I,
        StackSimpleOnConfigurator<I, S>,
        StackSimpleOnNoMatchConfigurator<I, S>,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>
        > implements StackSimpleStateConfigurator<I, S> {

    public StackSimpleStateConfiguratorImpl() {
        super(new StackSimpleOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected StackSimpleOnConfigurator<I, S> getOnConfigurator() {
        return new StackSimpleOnConfiguratorImpl<>();
    }

    @Override
    public StackSimpleStateGrammar<I, S> getStateGrammar() {
        // TODO
        return null;
    }

}
