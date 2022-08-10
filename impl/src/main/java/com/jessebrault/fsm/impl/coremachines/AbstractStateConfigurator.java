package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStateConfigurator<I, S, C, O> implements StateConfigurator<I, S, C, O> {

    private final Set<Transition<S, C, O>> transitions = new HashSet<>();

    private C curOn;
    private OnConfiguratorImpl<S, O> curOnConfigurator;
    private final OnNoMatchConfiguratorImpl<I, S> onNoMatchConfigurator = new OnNoMatchConfiguratorImpl<>();

    private void flush() {
        if (this.curOn != null) {
            transitions.add(new Transition<>(
                    this.curOn, this.curOnConfigurator.getShiftTo(), this.curOnConfigurator.getActions()
            ));
        }
        this.curOn = null;
        this.curOnConfigurator = null;
    }

    public final TransitionSet<I, S, C, O> getTransitionSet() {
        this.flush();
        return new TransitionSet<>(
                this.transitions, this.onNoMatchConfigurator.getShiftTo(), this.onNoMatchConfigurator.getActions()
        );
    }

    @Override
    public final OnConfigurator<S, O> on(C condition) {
        this.flush();
        this.curOn = condition;
        this.curOnConfigurator = new OnConfiguratorImpl<>();
        return this.curOnConfigurator;
    }

    @Override
    public final OnNoMatchConfigurator<I, S> onNoMatch() {
        return this.onNoMatchConfigurator;
    }

}
