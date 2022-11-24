package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateFsm;
import com.jessebrault.fsm.coremachines.predicate.PredicateFsmBuilder;
import com.jessebrault.fsm.coremachines.predicate.PredicateStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.FsmBuilderHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

final class PredicateFsmBuilderImpl<I, S> implements PredicateFsmBuilder<I, S> {

    private final FsmBuilderHelper helper = new FsmBuilderHelper();

    private S initialState;
    private final Map<S, TransitionSet<I, S, Predicate<I>, I>> grammar = new HashMap<>();

    @Override
    public S getInitialState() {
        return this.initialState;
    }

    @Override
    public PredicateFsmBuilder<I, S> setInitialState(@NotNull S state) {
        this.helper.checkSetInitialState(state);
        this.initialState = state;
        return this;
    }

    @Override
    public PredicateFsmBuilder<I, S> whileIn(@NotNull S state, @NotNull Consumer<PredicateStateConfigurator<I, S>> configureState) {
        this.helper.checkWhileIn(state, configureState);
        final var sc = new PredicateStateConfiguratorImpl<I, S>();
        configureState.accept(sc);
        this.grammar.put(state, sc.getTransitionSet());
        return this;
    }

    @Override
    public PredicateFsm<I, S> build() {
        this.helper.checkBuild(this.initialState);
        return new PredicateFsmImpl<>(this.initialState, this.grammar);
    }

}
