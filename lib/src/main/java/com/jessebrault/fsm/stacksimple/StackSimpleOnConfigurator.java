package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.stackbuilder.StackOnConfigurator;

public interface StackSimpleOnConfigurator<I, S> extends StackOnConfigurator<S, I, StackSimpleOnConfigurator<I, S>> {}
