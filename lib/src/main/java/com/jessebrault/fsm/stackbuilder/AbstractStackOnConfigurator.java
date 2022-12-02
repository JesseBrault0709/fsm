package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.AbstractOnConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStackOnConfigurator<S, O, ON extends StackOnConfigurator<S, O, ON>>
        extends AbstractOnConfigurator<S, O, ON> implements StackOnConfigurator<S, O, ON> {

    private final List<S> pushStates = new ArrayList<>();
    private int popStates;

    @Override
    public final ON pushState(@NotNull S state) {
        this.pushStates.add(state);
        return this.getThis();
    }

    @Override
    public final ON pushStates(@NotNull List<S> states) {
        this.pushStates.addAll(states);
        return this.getThis();
    }

    @Override
    public final ON popState() {
        this.popStates++;
        return this.getThis();
    }

    @Override
    public final ON popStates(int numberOfStates) {
        this.popStates += numberOfStates;
        return this.getThis();
    }

    @Override
    public final List<S> getPushStates() {
        return this.pushStates;
    }

    @Override
    public final int getPopStates() {
        return this.popStates;
    }

}
