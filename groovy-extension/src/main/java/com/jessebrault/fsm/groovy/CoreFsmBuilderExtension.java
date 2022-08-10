package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.Result;
import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;
import com.jessebrault.fsm.coremachines.builder.StateConfigurator;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class CoreFsmBuilderExtension {

    public static <
            I, S, C, O,
            R extends Result<I, S>,
            M extends FiniteStateMachine<I, S, R>,
            B extends CoreFsmBuilder<I, S, C, O, R, M, B, SC>,
            SC extends StateConfigurator<I, S, C, O>
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

    // private CoreFsmBuilderExtension() {}

}
