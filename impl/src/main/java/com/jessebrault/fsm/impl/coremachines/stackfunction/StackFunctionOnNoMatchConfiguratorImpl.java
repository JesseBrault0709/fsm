package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionOnNoMatchConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

final class StackFunctionOnNoMatchConfiguratorImpl<I, S> implements StackFunctionOnNoMatchConfigurator<I, S> {

    private S shiftTo;
    private S pushState;
    private boolean popState;
    private final Collection<Consumer<I>> inputConsumers = new ArrayList<>();

    public S getShiftTo() {
        return this.shiftTo;
    }

    public S getPushState() {
        return this.pushState;
    }

    public boolean getPopState() {
        return this.popState;
    }

    public Collection<Consumer<I>> getInputConsumers() {
        return this.inputConsumers;
    }

    @Override
    public StackFunctionOnNoMatchConfigurator<I, S> shiftTo(@NotNull S state) {
        this.shiftTo = state;
        return this;
    }

    @Override
    public StackFunctionOnNoMatchConfigurator<I, S> pushState(@NotNull S state) {
        this.pushState = state;
        return this;
    }

    @Override
    public StackFunctionOnNoMatchConfigurator<I, S> popState() {
        this.popState = true;
        return this;
    }

    @Override
    public StackFunctionOnNoMatchConfigurator<I, S> exec(Consumer<I> inputConsumer) {
        this.inputConsumers.add(inputConsumer);
        return this;
    }

}
