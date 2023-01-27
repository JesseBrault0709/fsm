package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class OnNoMatchBuilderExtension {

    public static <I, S, O, ONM extends OnNoMatchConfigurator<I, S, O, ONM>> ONM exec(
            ONM self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<Void> action
    ) {
        self.exec(action::call);
        return self;
    }

    private OnNoMatchBuilderExtension() {}

}
