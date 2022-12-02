package com.jessebrault.fsm.function;

import com.jessebrault.fsm.builder.OnConfigurator;

public interface FunctionOnConfigurator<I, S, O> extends OnConfigurator<S, O, FunctionOnConfigurator<I, S, O>> {}
