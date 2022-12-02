package com.jessebrault.fsm.builder;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStateConfigurator<
        I, S, O, C,
        ON extends OnConfigurator<S, O, ON>,
        ONM extends OnNoMatchConfigurator<I, S, ONM>,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > implements StateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT> {

    private final ONM onNoMatchConfigurator;
    private final Map<C, ON> conditionsToOnConfigurators = new HashMap<>();

    public AbstractStateConfigurator(ONM onNoMatchConfigurator) {
        this.onNoMatchConfigurator = onNoMatchConfigurator;
    }

    protected abstract ON getOnConfigurator();

    protected final Map<C, ON> getConditionsToOnConfigurators() {
        return this.conditionsToOnConfigurators;
    }

    @Override
    public final ON on(C condition) {
        final var onConfigurator = this.getOnConfigurator();
        this.conditionsToOnConfigurators.put(condition, onConfigurator);
        return onConfigurator;
    }

    @Override
    public final ONM onNoMatch() {
        return this.onNoMatchConfigurator;
    }

    protected final ONM getOnNoMatchConfigurator() {
        return this.onNoMatchConfigurator;
    }

}
