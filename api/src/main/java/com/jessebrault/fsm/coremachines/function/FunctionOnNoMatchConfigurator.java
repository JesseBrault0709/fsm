package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;

public interface FunctionOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, FunctionOnNoMatchConfigurator<I, S>> {}
