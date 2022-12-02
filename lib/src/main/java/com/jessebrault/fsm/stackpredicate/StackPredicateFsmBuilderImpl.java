package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.AbstractStackFsmBuilder;

import java.util.function.Predicate;

public final class StackPredicateFsmBuilderImpl<I, S> extends AbstractStackFsmBuilder<
        I, S, I, Predicate<I>,
        StackPredicateStateConfigurator<I, S>,
        StackPredicateOnConfigurator<I, S>,
        StackPredicateOnNoMatchConfigurator<I, S>,
        StackPredicateStateGrammar<I, S>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>,
        StackPredicateFsm<I, S>,
        StackPredicateFsmBuilder<I, S>
        > implements StackPredicateFsmBuilder<I, S> {

    @Override
    protected StackPredicateFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    protected StackPredicateStateConfigurator<I, S> getStateConfigurator() {
        return new StackPredicateStateConfiguratorImpl<>();
    }

    @Override
    public StackPredicateFsm<I, S> build() {
        return new StackPredicateFsmImpl<>(this.getGrammar(), this.getInitialState());
    }

}
