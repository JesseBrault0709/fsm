package com.jessebrault.fsm.impl.simple;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.impl.AbstractFsmBuilderImpl;
import com.jessebrault.fsm.impl.FsmImpl;
import com.jessebrault.fsm.simple.SimpleFsmBuilder;

import java.util.Objects;

final class SimpleFsmBuilderImpl<I, S> extends AbstractFsmBuilderImpl<I, S, I, I, SimpleFsmBuilder<I, S>>
        implements SimpleFsmBuilder<I, S> {

    @Override
    protected SimpleFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    public FiniteStateMachine<I, S, I> build() {
        this.checkInitialState();
        return new FsmImpl<>(
                this.getInitialState(),
                this.getGrammar(),
                (input, on, result) -> Objects.equals(input, on),
                (input, on) -> input
        );
    }

}
