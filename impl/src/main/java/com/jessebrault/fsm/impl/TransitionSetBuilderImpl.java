package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class TransitionSetBuilderImpl<I, S, C, R> implements TransitionSetBuilder<I, S, C, R> {

    private final Set<Transition<S, C, R>> transitions = new HashSet<>();
    private C curCondition;
    private OnBuilderImpl<S, R> curOb;

    private final OnNoMatchBuilderImpl<I, S> onmb = new OnNoMatchBuilderImpl<>();

    private void reset() {
        this.curCondition = null;
        this.curOb = null;
    }

    public void flush() {
        if (this.curOb != null) {
            final var shiftTo = this.curOb.getShiftTo();
            final var actions = this.curOb.getActions();
            final var transition = new Transition<>(this.curCondition, shiftTo, actions);
            this.transitions.add(transition);
        }
        this.reset();
    }

    public TransitionSet<I, S, C, R> build() {
        return new TransitionSet<>(
                this.transitions,
                this.onmb.getShiftTo(),
                this.onmb.getActions()
        );
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

}
