package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.StackFiniteStateMachine;
import com.jessebrault.fsm.builder.FsmBuilder;
import com.jessebrault.fsm.components.StackNoMatchTransition;
import com.jessebrault.fsm.components.StackStateGrammar;
import com.jessebrault.fsm.components.StackTransition;

public interface StackFsmBuilder<
        I, S, O, C,
        SC extends StackStateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT>,
        ON extends StackOnConfigurator<S, O, ON>,
        ONM extends StackOnNoMatchConfigurator<I, S, O, ONM>,
        SG extends StackStateGrammar<I, S, O, C, T, NMT>,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S, O>,
        M extends StackFiniteStateMachine<I, S, O>,
        B extends StackFsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B>
        > extends FsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B> {}
