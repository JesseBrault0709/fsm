package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.FsmBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface StackFunctionFsmBuilder<I, S, O> extends FsmBuilder<
        I, S, StackFunctionResult<I, O>,
        StackFunctionFsm<I, S, O>,
        StackFunctionFsmBuilder<I, S, O>
        > {

    StackFunctionFsmBuilder<I, S, O> whileIn(
            @NotNull S state,
            @NotNull Consumer<StackFunctionStateConfigurator<I, S, O>> stateConfiguratorConsumer
    );
    
}
