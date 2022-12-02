package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.AbstractStateConfigurator;

import java.util.Collection;

final class SimpleStateConfiguratorImpl<I, S> extends AbstractStateConfigurator<
        I, S, I, I,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>,
        SimpleStateGrammar<I, S>,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>
        > implements SimpleStateConfigurator<I, S> {

    public SimpleStateConfiguratorImpl() {
        super(new SimpleOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected SimpleOnConfigurator<I, S> getOnConfigurator() {
        return new SimpleOnConfiguratorImpl<>();
    }

    @Override
    public SimpleStateGrammar<I, S> getStateGrammar() {
        final Collection<SimpleTransition<I, S>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var condition = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    final var shiftTo = onConfigurator.getShiftTo();
                    final var outputConsumers = onConfigurator.getOutputConsumers();
                    return new SimpleTransition<>(condition, shiftTo, outputConsumers);
                })
                .toList();
        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new SimpleNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers()
        );
        return new SimpleStateGrammar<>(transitions, noMatchTransition);
    }

}
