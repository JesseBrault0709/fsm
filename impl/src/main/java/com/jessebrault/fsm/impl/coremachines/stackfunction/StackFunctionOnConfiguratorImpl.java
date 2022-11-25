package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionOnConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

final class StackFunctionOnConfiguratorImpl<S, O> implements StackFunctionOnConfigurator<S, O> {

    private S shiftTo;
    private S pushState;
    private boolean popState;
    private final Collection<Consumer<O>> outputConsumers = new ArrayList<>();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public S getPushState() {
        return this.pushState;
    }

    public boolean getPopState() {
        return this.popState;
    }

    public Collection<Consumer<O>> getOutputConsumers() {
        return this.outputConsumers;
    }

    @Override
    public StackFunctionOnConfigurator<S, O> shiftTo(@NotNull S state) {
        this.shiftTo = state;
        return this;
    }

    @Override
    public StackFunctionOnConfigurator<S, O> pushState(@NotNull S state) {
        this.pushState = state;
        return this;
    }

    @Override
    public StackFunctionOnConfigurator<S, O> popState() {
        this.popState = true;
        return this;
    }

    @Override
    public StackFunctionOnConfigurator<S, O> exec(@NotNull Consumer<O> outputConsumer) {
        this.outputConsumers.add(outputConsumer);
        return this;
    }

}
