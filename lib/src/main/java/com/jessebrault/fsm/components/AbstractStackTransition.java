package com.jessebrault.fsm.components;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractStackTransition<S, O, C>
        extends AbstractTransition<S, O, C>
        implements StackTransition<S, O, C> {

    private final List<S> pushStates;
    private final int popStates;

    public AbstractStackTransition(
            C on,
            S shiftTo,
            Collection<Consumer<O>> outputConsumers,
            List<S> pushStates,
            int popStates
    ) {
        super(on, shiftTo, outputConsumers);
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
