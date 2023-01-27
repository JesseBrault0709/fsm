package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.AbstractTransition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FunctionTransition<I, S, O> extends AbstractTransition<S, O, Function<I, O>> {

    public FunctionTransition(Function<I, O> on, S shiftTo, Collection<Consumer<O>> outputConsumers) {
        super(on, shiftTo, outputConsumers);
    }

}
