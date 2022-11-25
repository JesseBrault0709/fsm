package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

public interface SimpleStateConfigurator<I, S> extends StateConfigurator<
        I, S, I, I,
        OnConfigurator<S, I>,
        OnNoMatchConfigurator<I, S>
        > {}
