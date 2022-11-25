package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionFsm;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionFsmBuilder;
import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionStateConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

final class StackFunctionFsmBuilderImpl<I, S, O> implements StackFunctionFsmBuilder<I, S, O> {

    private S initialState;

    @Override
    public StackFunctionFsmBuilder<I, S, O> setInitialState(S initialState) {
        this.initialState = initialState;
        return this;
    }

    @Override
    public S getInitialState() {
        return this.initialState;
    }

    @Override
    public StackFunctionFsm<I, S, O> build() {
        return null; // TODO
    }

    @Override
    public StackFunctionFsmBuilder<I, S, O> whileIn(
            @NotNull S state,
            @NotNull Consumer<StackFunctionStateConfigurator<I, S, O>> stateConfiguratorConsumer
    ) {
        return null;
    }

}
