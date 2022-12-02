package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.StackOnNoMatchConfigurator;

public interface StackSimpleOnNoMatchConfigurator<I, S>
        extends StackOnNoMatchConfigurator<I, S, StackSimpleOnNoMatchConfigurator<I, S>> {}
