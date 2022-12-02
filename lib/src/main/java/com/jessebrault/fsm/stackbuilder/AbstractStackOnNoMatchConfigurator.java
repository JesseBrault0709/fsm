package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.AbstractOnNoMatchConfigurator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStackOnNoMatchConfigurator<I, S, ONM extends StackOnNoMatchConfigurator<I, S, ONM>>
        extends AbstractOnNoMatchConfigurator<I, S, ONM> implements StackOnNoMatchConfigurator<I, S, ONM> {

    private final List<S> pushStates = new ArrayList<>();
    private int popStates;

    @Override
    public final ONM pushState(S state) {
        this.pushStates.add(state);
        return this.getThis();
    }

    @Override
    public ONM pushStates(List<S> states) {
        this.pushStates.addAll(states);
        return this.getThis();
    }

    @Override
    public ONM popState() {
        this.popStates++;
        return this.getThis();
    }

    @Override
    public ONM popState(int numberOfStates) {
        this.popStates += numberOfStates;
        return this.getThis();
    }

    @Override
    public List<S> getPushStates() {
        return this.pushStates;
    }

    @Override
    public int getPopStates() {
        return this.popStates;
    }

}
