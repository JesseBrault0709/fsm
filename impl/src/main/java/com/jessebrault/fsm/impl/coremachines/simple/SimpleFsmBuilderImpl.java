package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;
import com.jessebrault.fsm.coremachines.simple.SimpleFsmBuilder;
import com.jessebrault.fsm.coremachines.simple.SimpleStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.FsmBuilderHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class SimpleFsmBuilderImpl<I, S> implements SimpleFsmBuilder<I, S> {

    private final FsmBuilderHelper helper = new FsmBuilderHelper();
    private S initialState;
    private final Map<S, TransitionSet<I, S, I, I>> grammar = new HashMap<>();

    @Override
    public S getInitialState() {
        return this.initialState;
    }

    @Override
    public SimpleFsmBuilder<I, S> setInitialState(S state) {
        this.helper.checkSetInitialState(state);
        this.initialState = state;
        return this;
    }

    @Override
    public SimpleFsmBuilder<I, S> whileIn(S state, Consumer<SimpleStateConfigurator<I, S>> configureState) {
        this.helper.checkWhileIn(state, configureState);
        final var sc = new SimpleStateConfiguratorImpl<I, S>();
        configureState.accept(sc);
        this.grammar.put(state, sc.getTransitionSet());
        return this;
    }

    @Override
    public SimpleFsm<I, S> build() {
        this.helper.checkBuild(this.initialState);
        return new SimpleFsmImpl<>(this.initialState, this.grammar);
    }

}
