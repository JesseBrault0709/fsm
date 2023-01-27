package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.AbstractStackNoMatchTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StackFunctionNoMatchTransition<I, S, O> extends AbstractStackNoMatchTransition<I, S, O> {

    public StackFunctionNoMatchTransition(
            S shiftTo,
            Collection<Consumer<I>> inputConsumers,
            Function<I, O> instead,
            List<S> pushStates,
            int popStates
    ) {
        super(shiftTo, inputConsumers, instead, pushStates, popStates);
    }

}
