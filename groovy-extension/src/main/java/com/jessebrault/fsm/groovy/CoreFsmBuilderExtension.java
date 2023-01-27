package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.builder.*;
import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class CoreFsmBuilderExtension {

    public static <
            I, S, O, C,
            SC extends StateConfigurator<I, S, O, C, ON, ONM, SG, T, NMT>,
            ON extends OnConfigurator<S, O, ON>,
            ONM extends OnNoMatchConfigurator<I, S, O, ONM>,
            SG extends StateGrammar<I, S, O, C, T, NMT>,
            T extends Transition<S, O, C>,
            NMT extends NoMatchTransition<I, S, O>,
            M extends FiniteStateMachine<I, S, O>,
            B extends FsmBuilder<I, S, O, C, SC, ON, ONM, SG, T, NMT, M, B>
            > B whileIn(
            B self,
            S state,
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, type = "SC")
            Closure<Void> configureState
    ) {
        self.whileIn(state, sc -> {
            configureState.setResolveStrategy(Closure.DELEGATE_FIRST);
            configureState.setDelegate(sc);
            configureState.run();
        });
        return self;
    }

    private CoreFsmBuilderExtension() {}

}
