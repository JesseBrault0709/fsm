package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.AbstractStackTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StackFunctionTransition<I, S, O> extends AbstractStackTransition<S, O, Function<I, O>> {

    public StackFunctionTransition(
            Function<I, O> on,
            S shiftTo,
            Collection<Consumer<O>> outputConsumers,
            List<S> pushStates,
            int popStates
    ) {
        super(on, shiftTo, outputConsumers, pushStates, popStates);
    }

}
