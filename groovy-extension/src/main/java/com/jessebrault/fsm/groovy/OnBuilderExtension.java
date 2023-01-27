package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.builder.OnConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class OnBuilderExtension {

    public static <S, O, ON extends OnConfigurator<S, O, ON>> ON exec(
            ON self,
            @ClosureParams(value = FromString.class, options = "O")
            Closure<Void> action
    ) {
        self.exec(action::call);
        return self;
    }

    private OnBuilderExtension() {}

}
