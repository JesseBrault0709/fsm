package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.OnBuilder;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public class OnBuilderExtension {

    public static <S, R> OnBuilder<S, R> exec(
            OnBuilder<S, R> self,
            @ClosureParams(value = FromString.class, options = "R")
            Closure<?> action
    ) {
        self.exec(result -> action.call(result));
        return self;
    }

}
