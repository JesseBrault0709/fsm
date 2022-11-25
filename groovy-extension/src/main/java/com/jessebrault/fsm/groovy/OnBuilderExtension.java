package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class OnBuilderExtension {

    public static <S, R> OnConfigurator<S, R> exec(
            OnConfigurator<S, R> self,
            @ClosureParams(value = FromString.class, options = "R")
            Closure<?> action
    ) {
        self.exec(action::call);
        return self;
    }

    private OnBuilderExtension() {}

}
