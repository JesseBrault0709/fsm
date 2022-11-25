package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;

public interface SimpleOnConfigurator<I, S> extends OnConfigurator<S, I, SimpleOnConfigurator<I, S>> {}
