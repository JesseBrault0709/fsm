package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.FsmBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class FsmBuilderExtension {

    public static <I, S, C, R, B extends FsmBuilder<I, S, C, R, B>> B whileIn(
            B self,
            S state,
            @DelegatesTo(
                    strategy = Closure.DELEGATE_FIRST,
                    type = "com.jessebrault.fsm.TransitionSetBuilder<I, S, C, R>"
            )
            Closure<?> configureState
    ) {
        self.whileIn(state, tsb -> {
            configureState.setResolveStrategy(Closure.DELEGATE_FIRST);
            configureState.setDelegate(tsb);
            configureState.run();
        });
        return self;
    }

}
