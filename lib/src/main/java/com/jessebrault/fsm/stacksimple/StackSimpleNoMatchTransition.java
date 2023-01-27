package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.AbstractStackNoMatchTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StackSimpleNoMatchTransition<I, S> extends AbstractStackNoMatchTransition<I, S, I> {

    public StackSimpleNoMatchTransition(
            S shiftTo,
            Collection<Consumer<I>> inputConsumers,
            Function<I, I> instead,
            List<S> pushStates,
            int popStates
    ) {
        super(shiftTo, inputConsumers, instead, pushStates, popStates);
    }

}
