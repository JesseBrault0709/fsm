package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.AbstractNoMatchTransition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FunctionNoMatchTransition<I, S, O> extends AbstractNoMatchTransition<I, S, O> {

    public FunctionNoMatchTransition(S shiftTo, Collection<Consumer<I>> inputConsumers, Function<I, O> instead) {
        super(shiftTo, inputConsumers, instead);
    }

}
