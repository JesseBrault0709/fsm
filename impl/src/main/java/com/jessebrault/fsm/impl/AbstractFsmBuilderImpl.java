package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.FsmBuilder;
import com.jessebrault.fsm.TransitionSet;
import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractFsmBuilderImpl<
        I, S, C, R,
        B extends FsmBuilder<I, S, C, R, B, TSB>,
        TSB extends TransitionSetBuilder<I, S, C, R>
        > implements FsmBuilder<I, S, C, R, B, TSB> {

    private static void checkWhileIn(Object state, Object configureState) {
        Objects.requireNonNull(state, "whileIn(): state must not be null");
        Objects.requireNonNull(configureState, "whileIn(): configureState must not be null");
    }

    private final Supplier<TSB> tsbSupplier;
    private final Map<S, TransitionSet<I, S, C, R>> grammar = new HashMap<>();

    private S initialState;

    public AbstractFsmBuilderImpl(Supplier<TSB> tsbSupplier) {
        this.tsbSupplier = tsbSupplier;
    }

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
    public B whileIn(S state, Consumer<TSB> configureState) {
        checkWhileIn(state, configureState);
        final var tsb = this.tsbSupplier.get();
        configureState.accept(tsb);
        this.grammar.put(state, tsb.build());
        return getThis();
    }

}
