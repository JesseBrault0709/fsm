package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.stackbuilder.StackOnConfigurator;

public interface StackFunctionOnConfigurator<S, O> extends StackOnConfigurator<
        S, O, StackFunctionOnConfigurator<S, O>
        > {}
