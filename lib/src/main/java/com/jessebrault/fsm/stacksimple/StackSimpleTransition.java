package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.AbstractStackTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public final class StackSimpleTransition<I, S> extends AbstractStackTransition<S, I, I> {

    public StackSimpleTransition(
            I on,
            S shiftTo,
            Collection<Consumer<I>> outputConsumers,
            List<S> pushStates,
            int popStates
    ) {
        super(on, shiftTo, outputConsumers, pushStates, popStates);
    }

}
