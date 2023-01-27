package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.AbstractTransition;

import java.util.Collection;
import java.util.function.Consumer;

public final class SimpleTransition<I, S> extends AbstractTransition<S, I, I> {

    public SimpleTransition(I on, S shiftTo, Collection<Consumer<I>> outputConsumers) {
        super(on, shiftTo, outputConsumers);
    }

}
