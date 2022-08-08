package com.jessebrault.fsm.groovy.function;

import com.jessebrault.fsm.OnBuilder;
import com.jessebrault.fsm.function.FunctionTransitionSetBuilder;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public class FunctionTransitionSetBuilderExtension {

    public static <I, S, R> OnBuilder<S, R> on(
            FunctionTransitionSetBuilder<I, S, R> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<R> condition
    ) {
        return self.on(condition::call);
    }

}
