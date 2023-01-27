package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

public interface FunctionOnNoMatchConfigurator<I, S, O>
        extends OnNoMatchConfigurator<I, S, O, FunctionOnNoMatchConfigurator<I, S, O>> {}
