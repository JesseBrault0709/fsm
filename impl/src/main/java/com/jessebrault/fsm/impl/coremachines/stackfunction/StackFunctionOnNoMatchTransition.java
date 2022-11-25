package com.jessebrault.fsm.impl.coremachines.stackfunction;

import java.util.Collection;
import java.util.function.Consumer;

record StackFunctionOnNoMatchTransition<I, S>(
        S shiftTo,
        S pushState,
        boolean popState,
        Collection<Consumer<I>> inputConsumers
) {}
