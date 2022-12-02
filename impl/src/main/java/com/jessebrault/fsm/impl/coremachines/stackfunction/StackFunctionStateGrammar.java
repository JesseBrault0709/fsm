package com.jessebrault.fsm.impl.coremachines.stackfunction;

import java.util.Set;

record StackFunctionStateGrammar<I, S, O>(
        Set<StackFunctionTransition<I, S, O>> transitions,
        StackFunctionOnNoMatchTransition<I, S> onNoMatchTransition
) {}
