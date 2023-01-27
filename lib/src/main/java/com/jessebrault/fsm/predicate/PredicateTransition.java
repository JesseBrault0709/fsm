package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.components.AbstractTransition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class PredicateTransition<I, S> extends AbstractTransition<S, I, Predicate<I>> {

    public PredicateTransition(Predicate<I> on, S shiftTo, Collection<Consumer<I>> outputConsumers) {
        super(on, shiftTo, outputConsumers);
    }
    
}
