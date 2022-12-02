package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.StateConfigurator;
import com.jessebrault.fsm.components.StackNoMatchTransition;
import com.jessebrault.fsm.components.StackStateGrammar;
import com.jessebrault.fsm.components.StackTransition;

public interface StackStateConfigurator<
        I, S, O, C,
        ON extends StackOnConfigurator<S, O, ON>,
        ONM extends StackOnNoMatchConfigurator<I, S, ONM>,
        SG extends StackStateGrammar<I, S, O, C, T, NMT>,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S>
        > extends StateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT> {}
