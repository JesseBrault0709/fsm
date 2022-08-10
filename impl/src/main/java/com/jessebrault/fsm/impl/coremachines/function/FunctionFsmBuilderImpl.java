package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionFsm;
import com.jessebrault.fsm.coremachines.function.FunctionFsmBuilder;
import com.jessebrault.fsm.coremachines.function.FunctionStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.FsmBuilderHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

final class FunctionFsmBuilderImpl<I, S, O> implements FunctionFsmBuilder<I, S, O> {

    private final FsmBuilderHelper helper = new FsmBuilderHelper();

    private S initialState;
    private final Map<S, TransitionSet<I, S, Function<I, O>, O>> grammar = new HashMap<>();

    @Override
    public S getInitialState() {
        return this.initialState;
    }

    @Override
    public FunctionFsmBuilder<I, S, O> setInitialState(S state) {
        this.helper.checkSetInitialState(state);
        this.initialState = state;
        return this;
    }

    @Override
    public FunctionFsmBuilder<I, S, O> whileIn(S state, Consumer<FunctionStateConfigurator<I, S, O>> configureState) {
        this.helper.checkWhileIn(state, configureState);
        final var sc = new FunctionStateConfiguratorImpl<I, S, O>();
        configureState.accept(sc);
        this.grammar.put(state, sc.getTransitionSet());
        return this;
    }

    @Override
    public FunctionFsm<I, S, O> build() {
        this.helper.checkBuild(this.initialState);
        return new FunctionFsmImpl<>(this.initialState, this.grammar);
    }

}
