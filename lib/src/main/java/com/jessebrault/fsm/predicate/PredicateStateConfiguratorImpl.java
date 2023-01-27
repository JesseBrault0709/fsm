package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.builder.AbstractStateConfigurator;

import java.util.Collection;
import java.util.function.Predicate;

final class PredicateStateConfiguratorImpl<I, S>
        extends AbstractStateConfigurator<
                I, S, I, Predicate<I>,
                PredicateOnConfigurator<I, S>,
                PredicateOnNoMatchConfigurator<I, S>,
                PredicateStateGrammar<I, S>,
                PredicateTransition<I, S>,
                PredicateNoMatchTransition<I, S>
        > implements PredicateStateConfigurator<I, S> {

    public PredicateStateConfiguratorImpl() {
        super(new PredicateOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected PredicateOnConfigurator<I, S> getOnConfigurator() {
        return new PredicateOnConfiguratorImpl<>();
    }

    @Override
    public PredicateStateGrammar<I, S> getStateGrammar() {
        final Collection<PredicateTransition<I, S>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var on = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    return new PredicateTransition<>(on, onConfigurator.getShiftTo(), onConfigurator.getOutputConsumers());
                })
                .toList();
        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new PredicateNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers(),
                onNoMatchConfigurator.getInstead()
        );
        return new PredicateStateGrammar<>(transitions, noMatchTransition);
    }

}
