package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

public interface SimpleOnNoMatchConfigurator<I, S> extends OnNoMatchConfigurator<I, S, SimpleOnNoMatchConfigurator<I, S>> {}
