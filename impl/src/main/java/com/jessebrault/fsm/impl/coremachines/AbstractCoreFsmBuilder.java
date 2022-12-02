package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.Result;
import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractCoreFsmBuilder<
        I, S, C, O,
        R extends Result<I, S>,
        M extends FiniteStateMachine<I, S, R>,
        AB extends AbstractCoreFsmBuilder<I, S, C, O, R, M, AB, ASC, AON, AONM>,
        ASC extends AbstractStateConfigurator<I, S, C, O, AON, AONM>,
        AON extends AbstractOnConfigurator<S, O, AON>,
        AONM extends AbstractOnNoMatchConfigurator<I, S, AONM>
        > implements CoreFsmBuilder<I, S, C, O, R, M, AB, ASC, AON, AONM> {

    private final Supplier<ASC> ascSupplier;
    private final Map<S, TransitionSet<I, S, C, O>> statesAndTransitionSets = new HashMap<>();;

    private S initialState;

    public AbstractCoreFsmBuilder(Supplier<ASC> ascSupplier) {
        this.ascSupplier = ascSupplier;
    }

    protected abstract AB getThis();

    protected final Map<S, TransitionSet<I, S, C, O>> getStatesAndTransitionSets() {
        return this.statesAndTransitionSets;
    }

    @Override
    public final @Nullable S getInitialState() {
        return this.initialState;
    }

    @Override
    public final AB setInitialState(@NotNull S state) {
        Objects.requireNonNull(state);
        this.initialState = state;
        return this.getThis();
    }

    @Override
    public final AB whileIn(@NotNull S state, @NotNull Consumer<ASC> configureState) {
        Objects.requireNonNull(state);
        Objects.requireNonNull(configureState);
        final var asc = this.ascSupplier.get();
        configureState.accept(asc);
        this.statesAndTransitionSets.put(state, asc.getTransitionSet());
        return this.getThis();
    }

}
