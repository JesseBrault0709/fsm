package com.jessebrault.fsm.groovy.stackfunction;

import com.jessebrault.fsm.stackfunction.StackFunctionOnConfigurator;
import com.jessebrault.fsm.stackfunction.StackFunctionStateConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class StackFunctionStateConfiguratorExtension {

    public static <I, S, O> StackFunctionOnConfigurator<S, O> on(
            StackFunctionStateConfigurator<I, S, O> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<O> closure
    ) {
        return self.on(closure::call);
    }

    private StackFunctionStateConfiguratorExtension() {}

}
