package com.jessebrault.fsm.builder;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface FsmBuilder<
        I, S, O, C,
        SC extends StateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT>,
        ON extends OnConfigurator<S, O, ON>,
        ONM extends OnNoMatchConfigurator<I, S, O, ONM>,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S, O>,
        M extends FiniteStateMachine<I, S, O>,
        B extends FsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B>
        > {

    B setInitialState(@NotNull S initialState);

    B whileIn(S state, Consumer<SC> stateConfiguratorConsumer);

    M build();

}
