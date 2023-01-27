package com.jessebrault.fsm.components;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractStackNoMatchTransition<I, S, O>
        extends AbstractNoMatchTransition<I, S, O>
        implements StackNoMatchTransition<I, S, O> {

    private final List<S> pushStates;
    private final int popStates;

    public AbstractStackNoMatchTransition(
            S shiftTo,
            Collection<Consumer<I>> inputConsumers,
            Function<I, O> instead,
            List<S> pushStates,
            int popStates
    ) {
        super(shiftTo, inputConsumers, instead);
        this.pushStates = pushStates;
        this.popStates = popStates;
    }

    @Override
    public List<S> pushStates() {
        return this.pushStates;
    }

    @Override
    public int popStates() {
        return this.popStates;
    }

}
