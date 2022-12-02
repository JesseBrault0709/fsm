package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.AbstractFsmBuilder;

public final class SimpleFsmBuilderImpl<I, S> extends AbstractFsmBuilder<
        I, S, I, I,
        SimpleStateConfigurator<I, S>,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>,
        SimpleStateGrammar<I, S>,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>,
        SimpleFsm<I, S>,
        SimpleFsmBuilder<I, S>
        > implements SimpleFsmBuilder<I, S> {

    @Override
    protected SimpleFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    protected SimpleStateConfigurator<I, S> getStateConfigurator() {
        return new SimpleStateConfiguratorImpl<>();
    }

    @Override
    public SimpleFsm<I, S> build() {
        return new SimpleFsmImpl<>(this.getGrammar(), this.getInitialState());
    }

}
