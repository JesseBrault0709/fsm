package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.StackFsmBuilder;

public interface StackSimpleFsmBuilder<I, S> extends StackFsmBuilder<
        I, S, I, I,
        StackSimpleStateConfigurator<I, S>,
        StackSimpleOnConfigurator<I, S>,
        StackSimpleOnNoMatchConfigurator<I, S>,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>,
        StackSimpleFsm<I, S>,
        StackSimpleFsmBuilder<I, S>
        > {}
