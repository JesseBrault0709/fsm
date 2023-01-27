package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.AbstractStackTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class StackPredicateTransition<I, S> extends AbstractStackTransition<S, I, Predicate<I>> {

    public StackPredicateTransition(
            Predicate<I> on,
            S shiftTo,
            Collection<Consumer<I>> outputConsumers,
            List<S> pushStates,
            int popStates
    ) {
        super(on, shiftTo, outputConsumers, pushStates, popStates);
    }

}
