package com.jessebrault.fsm.builder;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractFsmBuilder<
        I, S, O, C,
        SC extends StateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT>,
        ON extends OnConfigurator<S, O, ON>,
        ONM extends OnNoMatchConfigurator<I, S, ONM>,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>,
        M extends FiniteStateMachine<I, S, O>,
        B extends FsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B>
        > implements FsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B> {

    private final Map<S, SG> statesAndStateGrammars = new HashMap<>();

    @Nullable
    private S initialState;

    protected abstract B getThis();

    protected abstract SC getStateConfigurator();

    protected final @Nullable S getInitialState() {
        return this.initialState;
    }

    @Override
    public final B setInitialState(@NotNull S initialState) {
        Objects.requireNonNull(initialState);
        this.initialState = initialState;
        return this.getThis();
    }

    @Override
    public final B whileIn(S state, Consumer<SC> stateConfiguratorConsumer) {
        Objects.requireNonNull(state);
        Objects.requireNonNull(stateConfiguratorConsumer);
        final var sc = this.getStateConfigurator();
        stateConfiguratorConsumer.accept(sc);
        this.statesAndStateGrammars.put(state, sc.getStateGrammar());
        return this.getThis();
    }

    protected final Map<S, SG> getGrammar() {
        return this.statesAndStateGrammars;
    }

}
