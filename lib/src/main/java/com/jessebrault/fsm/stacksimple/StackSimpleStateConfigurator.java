package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.StackStateConfigurator;

public interface StackSimpleStateConfigurator<I, S> extends StackStateConfigurator<
        I, S, I, I,
        StackSimpleOnConfigurator<I, S>,
        StackSimpleOnNoMatchConfigurator<I, S>,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>
        > {
}
