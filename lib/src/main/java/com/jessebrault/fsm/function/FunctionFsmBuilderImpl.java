package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.AbstractFsmBuilder;

import java.util.function.Function;

public final class FunctionFsmBuilderImpl<I, S, O> extends AbstractFsmBuilder<
        I, S, O, Function<I, O>,
        FunctionStateConfigurator<I, S, O>,
        FunctionOnConfigurator<I, S, O>,
        FunctionOnNoMatchConfigurator<I, S, O>,
        FunctionStateGrammar<I, S, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S, O>,
        FunctionFsm<I, S, O>,
        FunctionFsmBuilder<I, S, O>
        > implements FunctionFsmBuilder<I, S, O> {

    @Override
    protected FunctionFsmBuilder<I, S, O> getThis() {
        return this;
    }

    @Override
    protected FunctionStateConfigurator<I, S, O> getStateConfigurator() {
        return new FunctionStateConfiguratorImpl<>();
    }

    @Override
    public FunctionFsm<I, S, O> build() {
        return new FunctionFsmImpl<>(this.getGrammar(), this.getInitialState());
    }

}
