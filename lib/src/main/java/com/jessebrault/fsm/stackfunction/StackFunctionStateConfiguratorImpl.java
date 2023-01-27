package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.AbstractStackStateConfigurator;

import java.util.Collection;
import java.util.function.Function;

final class StackFunctionStateConfiguratorImpl<I, S, O> extends AbstractStackStateConfigurator<
        I, S, O, Function<I, O>,
        StackFunctionOnConfigurator<S, O>,
        StackFunctionOnNoMatchConfigurator<I, S, O>,
        StackFunctionStateGrammar<I, S, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>
        > implements StackFunctionStateConfigurator<I, S, O> {

    public StackFunctionStateConfiguratorImpl() {
        super(new StackFunctionOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected StackFunctionOnConfigurator<S, O> getOnConfigurator() {
        return new StackFunctionOnConfiguratorImpl<>();
    }

    @Override
    public StackFunctionStateGrammar<I, S, O> getStateGrammar() {
        final Collection<StackFunctionTransition<I, S, O>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var on = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    return new StackFunctionTransition<>(
                            on,
                            onConfigurator.getShiftTo(),
                            onConfigurator.getOutputConsumers(),
                            onConfigurator.getPushStates(),
                            onConfigurator.getPopStates()
                    );
                })
                .toList();

        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new StackFunctionNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers(),
                onNoMatchConfigurator.getInstead(),
                onNoMatchConfigurator.getPushStates(),
                onNoMatchConfigurator.getPopStates()
        );

        return new StackFunctionStateGrammar<>(transitions, noMatchTransition);
    }

}
