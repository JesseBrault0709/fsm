package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.AbstractStackFsmBuilder;

import java.util.function.Function;

public final class StackFunctionFsmBuilderImpl<I, S, O> extends AbstractStackFsmBuilder<
        I, S, O, Function<I, O>,
        StackFunctionStateConfigurator<I, S, O>,
        StackFunctionOnConfigurator<S, O>,
        StackFunctionOnNoMatchConfigurator<I, S, O>,
        StackFunctionStateGrammar<I, S, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>,
        StackFunctionFsm<I, S, O>,
        StackFunctionFsmBuilder<I, S, O>
        > implements StackFunctionFsmBuilder<I, S, O> {

    @Override
    protected StackFunctionFsmBuilder<I, S, O> getThis() {
        return this;
    }

    @Override
    protected StackFunctionStateConfigurator<I, S, O> getStateConfigurator() {
        return new StackFunctionStateConfiguratorImpl<>();
    }

    @Override
    public StackFunctionFsm<I, S, O> build() {
        return new StackFunctionFsmImpl<>(this.getGrammar(), this.getInitialState());
    }

}
