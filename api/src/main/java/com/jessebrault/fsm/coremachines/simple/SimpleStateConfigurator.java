package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

public interface SimpleStateConfigurator<I, S> extends StateConfigurator<
        I, S, I, I,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>
        > {}
