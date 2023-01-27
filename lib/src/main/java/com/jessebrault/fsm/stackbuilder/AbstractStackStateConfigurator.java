package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.*;
import com.jessebrault.fsm.components.StackNoMatchTransition;
import com.jessebrault.fsm.components.StackStateGrammar;
import com.jessebrault.fsm.components.StackTransition;

public abstract class AbstractStackStateConfigurator<
        I, S, O, C,
        ON extends StackOnConfigurator<S, O, ON>,
        ONM extends StackOnNoMatchConfigurator<I, S, O, ONM>,
        SG extends StackStateGrammar<I, S, O, C, T, NMT>,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S, O>
        > extends AbstractStateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT>
        implements StackStateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT> {

    public AbstractStackStateConfigurator(ONM onNoMatchConfigurator) {
        super(onNoMatchConfigurator);
    }

}
