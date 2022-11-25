package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.Result;
import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;
import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import com.jessebrault.fsm.coremachines.builder.StateConfigurator;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class CoreFsmBuilderExtension {

    public static <
            I, S, C, O,
            R extends Result<I, S>,
            M extends FiniteStateMachine<I, S, R>,
            B extends CoreFsmBuilder<I, S, C, O, R, M, B, SC, ON, ONM>,
            SC extends StateConfigurator<I, S, C, O, ON, ONM>,
            ON extends OnConfigurator<S, O>,
            ONM extends OnNoMatchConfigurator<I, S>
            > B whileIn(
            B self,
            S state,
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, type = "SC")
            Closure<?> configureState
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
