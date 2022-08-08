package com.jessebrault.fsm.groovy.predicate;

import com.jessebrault.fsm.OnBuilder;
import com.jessebrault.fsm.predicate.PredicateTransitionSetBuilder;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public class PredicateTransitionSetBuilderExtension {

    public static <I, S> OnBuilder<S, I> on(
            PredicateTransitionSetBuilder<I, S> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<Boolean> condition
    ) {
        return self.on(condition::call);
    }

}
