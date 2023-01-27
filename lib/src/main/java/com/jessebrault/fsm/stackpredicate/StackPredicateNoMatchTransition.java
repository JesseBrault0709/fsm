package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.AbstractStackNoMatchTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StackPredicateNoMatchTransition<I, S> extends AbstractStackNoMatchTransition<I, S, I> {

    public StackPredicateNoMatchTransition(
            S shiftTo,
            Collection<Consumer<I>> inputConsumers,
            Function<I, I> instead,
            List<S> pushStates,
            int popStates
    ) {
        super(shiftTo, inputConsumers, instead, pushStates, popStates);
    }

}
