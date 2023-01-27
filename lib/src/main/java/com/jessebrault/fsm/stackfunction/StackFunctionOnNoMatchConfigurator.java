package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.StackOnNoMatchConfigurator;

public interface StackFunctionOnNoMatchConfigurator<I, S, O> extends StackOnNoMatchConfigurator<
        I, S, O, StackFunctionOnNoMatchConfigurator<I, S, O>
        > {}
