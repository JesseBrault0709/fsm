package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class OnNoMatchBuilderExtension {

    public static <I, S> OnNoMatchConfigurator<I, S> exec(
            OnNoMatchConfigurator<I, S> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<?> action
    ) {
        self.exec(action::call);
        return self;
    }

    private OnNoMatchBuilderExtension() {}

}
