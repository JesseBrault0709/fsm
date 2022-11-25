package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;

import java.util.function.Function;

public interface StackFunctionFsmBuilder<I, S, O> extends CoreFsmBuilder<
        I, S, Function<I, O>, O,
        StackFunctionResult<I, S, O>,
        StackFunctionFsm<I, S, O>,
        StackFunctionFsmBuilder<I, S, O>,
        StackFunctionStateConfigurator<I, S, O>,
        StackFunctionOnConfigurator<S, O>,
        StackFunctionOnNoMatchConfigurator<I, S>
        > {}
