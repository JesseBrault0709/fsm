package com.jessebrault.fsm.impl.coremachines.stackfunction;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

record StackFunctionTransition<I, S, O>(
        Function<I, O> on,
        S shiftTo,
        S pushState,
        boolean popState,
        Collection<Consumer<O>> outputConsumers
) {}
