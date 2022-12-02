package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.OnConfigurator;

public interface SimpleOnConfigurator<I, S> extends OnConfigurator<S, I, SimpleOnConfigurator<I, S>> {}
