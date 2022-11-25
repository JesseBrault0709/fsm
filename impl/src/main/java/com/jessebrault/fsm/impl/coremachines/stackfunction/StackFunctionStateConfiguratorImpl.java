package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionOnConfigurator;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionOnNoMatchConfigurator;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionStateConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

final class StackFunctionStateConfiguratorImpl<I, S, O> implements StackFunctionStateConfigurator<I, S, O> {

    private final Set<StackFunctionTransition<I, S, O>> transitions = new HashSet<>();

    private Function<I, O> curIoFunction;
    private StackFunctionOnConfiguratorImpl<S, O> curOnConfigurator;
    private final StackFunctionOnNoMatchConfiguratorImpl<I, S> onNoMatchConfigurator = new StackFunctionOnNoMatchConfiguratorImpl<>();

    public StackFunctionStateGrammar<I, S, O> getStateGrammar() {
        return new StackFunctionStateGrammar<>(
                this.transitions,
                new StackFunctionOnNoMatchTransition<>(
                        this.onNoMatchConfigurator.getShiftTo(),
                        this.onNoMatchConfigurator.getPushState(),
                        this.onNoMatchConfigurator.getPopState(),
                        this.onNoMatchConfigurator.getInputConsumers()
                )
        );
    }

    private void flush() {
        if (this.curIoFunction != null) {
            this.transitions.add(new StackFunctionTransition<>(
                    this.curIoFunction,
                    this.curOnConfigurator.getShiftTo(),
                    this.curOnConfigurator.getPushState(),
                    this.curOnConfigurator.getPopState(),
                    this.curOnConfigurator.getOutputConsumers()
            ));
        }
        this.curIoFunction = null;
        this.curOnConfigurator = null;
    }

    @Override
    public StackFunctionOnConfigurator<S, O> on(@NotNull Function<I, O> ioFunction) {
        this.flush();
        this.curIoFunction = ioFunction;
        this.curOnConfigurator = new StackFunctionOnConfiguratorImpl<>();
        return this.curOnConfigurator;
    }

    @Override
    public StackFunctionOnNoMatchConfigurator<I, S> onNoMatch() {
        return this.onNoMatchConfigurator;
    }

}
