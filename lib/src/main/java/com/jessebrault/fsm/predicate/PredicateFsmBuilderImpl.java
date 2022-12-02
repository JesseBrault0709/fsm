package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.AbstractFsmBuilder;

import java.util.function.Predicate;

public final class PredicateFsmBuilderImpl<I, S>
        extends AbstractFsmBuilder<
                I, S, I, Predicate<I>,
                PredicateStateConfigurator<I, S>,
                PredicateOnConfigurator<I, S>,
                PredicateOnNoMatchConfigurator<I, S>,
                PredicateStateGrammar<I, S>,
                PredicateTransition<I, S>,
                PredicateNoMatchTransition<I, S>,
                PredicateFsm<I, S>,
                PredicateFsmBuilder<I, S>
        >
        implements PredicateFsmBuilder<I, S> {

    @Override
    protected PredicateFsmBuilder<I, S> getThis() {
        return this;
    }

    @Override
    protected PredicateStateConfigurator<I, S> getStateConfigurator() {
        return new PredicateStateConfiguratorImpl<>();
    }

    @Override
    public PredicateFsm<I, S> build() {
        return new PredicateFsmImpl<>(this.getGrammar(), this.getInitialState());
    }

}
