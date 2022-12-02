package com.jessebrault.fsm.builder;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;

public interface StateConfigurator<
        I, S, O, C,
        ON extends OnConfigurator<S, O, ON>,
        ONM extends OnNoMatchConfigurator<I, S, ONM>,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > {

    ON on(C condition);

    ONM onNoMatch();

    SG getStateGrammar();

}
