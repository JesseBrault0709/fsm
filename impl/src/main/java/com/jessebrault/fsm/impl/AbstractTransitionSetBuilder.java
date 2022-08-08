package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.Transition;
import com.jessebrault.fsm.TransitionSet;
import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractTransitionSetBuilder<I, S, C, R> implements TransitionSetBuilder<I, S, C, R> {

    private final Set<Transition<S, C, R>> transitions = new HashSet<>();
    private C curCondition;
    private OnBuilderImpl<S, R> curOb;

    private final OnNoMatchBuilderImpl<I, S> onmb = new OnNoMatchBuilderImpl<>();

    private void reset() {
        this.curCondition = null;
        this.curOb = null;
    }

    private void flush() {
        if (this.curOb != null) {
            final var shiftTo = this.curOb.getShiftTo();
            final var actions = this.curOb.getActions();
            this.transitions.add(new TransitionImpl<>(this.curCondition, shiftTo, actions));
        }
        this.reset();
    }

    @Override
    public OnBuilderImpl<S, R> on(C condition) {
        Objects.requireNonNull(condition, "condition must not be null");
        this.flush();
        this.curCondition = condition;
        this.curOb = new OnBuilderImpl<>();
        return this.curOb;
    }

    @Override
    public OnNoMatchBuilderImpl<I, S> onNoMatch() {
        this.flush();
        return this.onmb;
    }

    @Override
    public TransitionSet<I, S, C, R> build() {
        this.flush();
        return new TransitionSetImpl<>(
                this.transitions,
                this.onmb.getShiftTo(),
                this.onmb.getActions()
        );
    }

}
