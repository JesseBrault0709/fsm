package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;

public interface FunctionOnConfigurator<S, O> extends OnConfigurator<S, O, FunctionOnConfigurator<S, O>> {}
