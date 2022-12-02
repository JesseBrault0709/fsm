package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.StateConfigurator;

public interface SimpleStateConfigurator<I, S> extends StateConfigurator<
        I, S, I, I,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>,
        SimpleStateGrammar<I, S>,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>
        > {}
