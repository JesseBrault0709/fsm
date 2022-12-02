package com.jessebrault.fsm.groovy.function;

import com.jessebrault.fsm.function.FunctionOnConfigurator;
import com.jessebrault.fsm.function.FunctionStateConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class FunctionStateConfiguratorExtension {

    public static <I, S, O> FunctionOnConfigurator<I, S, O> on(
            FunctionStateConfigurator<I, S, O> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<O> condition
    ) {
        return self.on(condition::call);
    }

    private FunctionStateConfiguratorExtension() {}

}
