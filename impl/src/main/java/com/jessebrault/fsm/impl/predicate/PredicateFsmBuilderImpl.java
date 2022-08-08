package com.jessebrault.fsm.impl.predicate;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.impl.AbstractFsmBuilderImpl;
import com.jessebrault.fsm.impl.FsmImpl;
import com.jessebrault.fsm.predicate.PredicateFsmBuilder;

import java.util.function.Predicate;

final class PredicateFsmBuilderImpl<I, S> extends AbstractFsmBuilderImpl<I, S, Predicate<I>, I, PredicateFsmBuilder<I, S>>
        implements PredicateFsmBuilder<I, S> {

    @Override
    protected PredicateFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    public FiniteStateMachine<I, S, I> build() {
        this.checkInitialState();
        return new FsmImpl<>(
                this.getInitialState(),
                this.getGrammar(),
                (input, on, result) -> on.test(input),
                (input, on) -> input
        );
    }

}
