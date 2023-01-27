package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.AbstractStackStateConfigurator;

import java.util.Collection;
import java.util.function.Predicate;

final class StackPredicateStateConfiguratorImpl<I, S> extends AbstractStackStateConfigurator<
        I, S, I, Predicate<I>,
        StackPredicateOnConfigurator<I, S>,
        StackPredicateOnNoMatchConfigurator<I, S>,
        StackPredicateStateGrammar<I, S>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>
        > implements StackPredicateStateConfigurator<I, S> {

    public StackPredicateStateConfiguratorImpl() {
        super(new StackPredicateOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected StackPredicateOnConfigurator<I, S> getOnConfigurator() {
        return new StackPredicateOnConfiguratorImpl<>();
    }

    @Override
    public StackPredicateStateGrammar<I, S> getStateGrammar() {
        final Collection<StackPredicateTransition<I, S>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var on = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    return new StackPredicateTransition<>(
                            on,
                            onConfigurator.getShiftTo(),
                            onConfigurator.getOutputConsumers(),
                            onConfigurator.getPushStates(),
                            onConfigurator.getPopStates()
                    );
                })
                .toList();

        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new StackPredicateNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers(),
                onNoMatchConfigurator.getInstead(),
                onNoMatchConfigurator.getPushStates(),
                onNoMatchConfigurator.getPopStates()
        );

        return new StackPredicateStateGrammar<>(transitions, noMatchTransition);
    }

}
