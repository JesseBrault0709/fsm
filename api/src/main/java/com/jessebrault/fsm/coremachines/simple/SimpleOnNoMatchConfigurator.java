package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;

public interface SimpleOnNoMatchConfigurator<I, S>
        extends OnNoMatchConfigurator<I, S, SimpleOnNoMatchConfigurator<I, S>> {}
