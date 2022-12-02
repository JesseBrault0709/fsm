package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.AbstractStateConfigurator;

import java.util.Collection;
import java.util.function.Function;

final class FunctionStateConfiguratorImpl<I, S, O> extends AbstractStateConfigurator<
        I, S, O, Function<I, O>,
        FunctionOnConfigurator<I, S, O>,
        FunctionOnNoMatchConfigurator<I, S>,
        FunctionStateGrammar<I, S, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S>
        > implements FunctionStateConfigurator<I, S, O> {

    public FunctionStateConfiguratorImpl() {
        super(new FunctionOnNoMatchConfiguratorImpl<>());
    }

    @Override
    protected FunctionOnConfigurator<I, S, O> getOnConfigurator() {
        return new FunctionOnConfiguratorImpl<>();
    }

    @Override
    public FunctionStateGrammar<I, S, O> getStateGrammar() {
        final Collection<FunctionTransition<I, S, O>> transitions = this.getConditionsToOnConfigurators().entrySet()
                .stream()
                .map(entry -> {
                    final var on = entry.getKey();
                    final var onConfigurator = entry.getValue();
                    return new FunctionTransition<>(on, onConfigurator.getShiftTo(), onConfigurator.getOutputConsumers());
                })
                .toList();
        final var onNoMatchConfigurator = this.getOnNoMatchConfigurator();
        final var noMatchTransition = new FunctionNoMatchTransition<>(
                onNoMatchConfigurator.getShiftTo(),
                onNoMatchConfigurator.getInputConsumers()
        );
        return new FunctionStateGrammar<>(transitions, noMatchTransition);
    }

}
