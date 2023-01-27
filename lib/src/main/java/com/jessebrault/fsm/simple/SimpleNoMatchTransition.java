package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.AbstractNoMatchTransition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public final class SimpleNoMatchTransition<I, S> extends AbstractNoMatchTransition<I, S, I> {

    public SimpleNoMatchTransition(S shiftTo, Collection<Consumer<I>> inputConsumers, Function<I, I> instead) {
        super(shiftTo, inputConsumers, instead);
    }

}
