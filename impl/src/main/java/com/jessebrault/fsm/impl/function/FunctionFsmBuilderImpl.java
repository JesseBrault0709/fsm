package com.jessebrault.fsm.impl.function;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.function.FunctionFsmBuilder;
import com.jessebrault.fsm.impl.AbstractFsmBuilderImpl;
import com.jessebrault.fsm.impl.FsmImpl;

import java.util.function.Function;

final class FunctionFsmBuilderImpl<I, S, R> extends AbstractFsmBuilderImpl<I, S, Function<I, R>, R, FunctionFsmBuilder<I, S, R>>
        implements FunctionFsmBuilder<I, S, R> {

    @Override
    protected FunctionFsmBuilder<I, S, R> getThis() {
        return this;
    }

    @Override
    public FiniteStateMachine<I, S, R> build() {
        this.checkInitialState();
        return new FsmImpl<>(
                this.getInitialState(),
                this.getGrammar(),
                (input, on, result) -> result != null,
                (input, on) -> on.apply(input)
        );
    }

}
