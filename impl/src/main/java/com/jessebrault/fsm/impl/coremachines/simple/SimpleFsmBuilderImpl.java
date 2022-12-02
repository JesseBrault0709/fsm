package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;
import com.jessebrault.fsm.coremachines.simple.SimpleFsmBuilder;
import com.jessebrault.fsm.coremachines.simple.SimpleResult;
import com.jessebrault.fsm.coremachines.simple.SimpleStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractCoreFsmBuilder;
import com.jessebrault.fsm.impl.coremachines.FsmBuilderHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

final class SimpleFsmBuilderImpl<I, S> extends AbstractCoreFsmBuilder<
        I, S, I, I,
        SimpleResult<I, S>,
        SimpleFsm<I, S>,
        SimpleFsmBuilderImpl<I, S>,
        SimpleStateConfiguratorImpl<I, S>,
        SimpleOnConfiguratorImpl<I, S>,
        SimpleOnNoMatchConfiguratorImpl<I, S>
        > implements SimpleFsmBuilder<I, S> {

    private final FsmBuilderHelper helper = new FsmBuilderHelper();

    public SimpleFsmBuilderImpl() {
        super(SimpleStateConfiguratorImpl::new);
    }

    @Override
    protected SimpleFsmBuilderImpl<I, S> getThis() {
        return this;
    }

    @Override
    public SimpleFsm<I, S> build() {
        final var initialState = this.getInitialState();
        Objects.requireNonNull(initialState);
        return new SimpleFsmImpl<>(initialState, this.getStatesAndTransitionSets());
    }

}
