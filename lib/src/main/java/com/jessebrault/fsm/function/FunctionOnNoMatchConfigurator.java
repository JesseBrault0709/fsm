package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

public interface FunctionOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, FunctionOnNoMatchConfigurator<I, S>> {}
