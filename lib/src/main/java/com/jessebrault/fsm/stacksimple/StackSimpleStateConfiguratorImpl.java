package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.AbstractStackStateConfigurator;

import java.util.Collection;

final class StackSimpleStateConfiguratorImpl<I, S> extends AbstractStackStateConfigurator<
        I, S, I, I,
        StackSimpleOnConfigurator<I, S>,
        StackSimpleOnNoMatchConfigurator<I, S>,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>
        > implements StackSimpleStateConfigurator<I, S> {

    public StackSimpleStateConfiguratorImpl() {
        super(new StackSimpleOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected StackSimpleOnConfigurator<I, S> getOnConfigurator() {
        return new StackSimpleOnConfiguratorImpl<>();
    }

    @Override
    public StackSimpleStateGrammar<I, S> getStateGrammar() {
        final Collection<StackSimpleTransition<I, S>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var on = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    return new StackSimpleTransition<>(
                            on,
                            onConfigurator.getShiftTo(),
                            onConfigurator.getOutputConsumers(),
                            onConfigurator.getPushStates(),
                            onConfigurator.getPopStates()
                    );
                })
                .toList();

        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new StackSimpleNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers(),
                onNoMatchConfigurator.getInstead(),
                onNoMatchConfigurator.getPushStates(),
                onNoMatchConfigurator.getPopStates()
        );

        return new StackSimpleStateGrammar<>(transitions, noMatchTransition);
    }

}
