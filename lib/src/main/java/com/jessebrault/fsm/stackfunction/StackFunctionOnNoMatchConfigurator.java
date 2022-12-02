package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.StackOnNoMatchConfigurator;

public interface StackFunctionOnNoMatchConfigurator<I, S> extends StackOnNoMatchConfigurator<
        I, S, StackFunctionOnNoMatchConfigurator<I, S>
        > {}
