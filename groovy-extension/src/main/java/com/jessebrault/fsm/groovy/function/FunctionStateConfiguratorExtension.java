package com.jessebrault.fsm.groovy.function;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.function.FunctionStateConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class FunctionStateConfiguratorExtension {

    public static <I, S, R> OnConfigurator<S, R> on(
            FunctionStateConfigurator<I, S, R> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<R> condition
    ) {
        return self.on(condition::call);
    }

    private FunctionStateConfiguratorExtension() {}

}
