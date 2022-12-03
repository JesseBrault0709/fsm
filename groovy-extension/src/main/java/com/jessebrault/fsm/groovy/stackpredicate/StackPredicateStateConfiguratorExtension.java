package com.jessebrault.fsm.groovy.stackpredicate;

import com.jessebrault.fsm.stackpredicate.StackPredicateOnConfigurator;
import com.jessebrault.fsm.stackpredicate.StackPredicateStateConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class StackPredicateStateConfiguratorExtension {

    public static <I, S> StackPredicateOnConfigurator<I, S> on(
            StackPredicateStateConfigurator<I, S> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<Boolean> condition
    ) {
        return self.on(condition::call);
    }

    private StackPredicateStateConfiguratorExtension() {}

}
