package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.FsmBuilder;
import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractFsmBuilderImpl<I, S, C, R, B extends FsmBuilder<I, S, C, R, B>> implements FsmBuilder<I, S, C, R, B> {

    private static void checkWhileIn(Object state, Object configureState) {
        Objects.requireNonNull(state, "whileIn(): state must not be null");
        Objects.requireNonNull(configureState, "whileIn(): configureState must not be null");
    }

    private final Map<S, TransitionSet<I, S, C, R>> grammar = new HashMap<>();

    private S initialState;

    protected Map<S, TransitionSet<I, S, C, R>> getGrammar() {
        return this.grammar;
    }

    protected void checkInitialState() {
        Objects.requireNonNull(this.initialState, "initialState must not be null");
    }

    protected abstract B getThis();

    @Override
    public S getInitialState() {
        return this.initialState;
    }

    @Override
    public B setInitialState(S state) {
        Objects.requireNonNull(state, "state must not be null");
        this.initialState = state;
        return getThis();
    }

    @Override
    public B whileIn(S state, Consumer<TransitionSetBuilder<I, S, C, R>> configureState) {
        checkWhileIn(state, configureState);
        final var tsb = new TransitionSetBuilderImpl<I, S, C, R>();
        configureState.accept(tsb);
        tsb.flush();
        this.grammar.put(state, tsb.build());
        return getThis();
    }

}