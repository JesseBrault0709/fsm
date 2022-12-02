package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.builder.FsmBuilder;

public interface SimpleFsmBuilder<I, S> extends FsmBuilder<
        I, S, I, I,
        SimpleStateConfigurator<I, S>,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>,
        SimpleStateGrammar<I, S>,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>,
        SimpleFsm<I, S>,
        SimpleFsmBuilder<I, S>
        > {}
