package com.jessebrault.fsm.groovy.predicate;

import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.predicate.PredicateStateConfigurator;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public final class PredicateStateConfiguratorExtension {

    public static <I, S> OnConfigurator<S, I> on(
            PredicateStateConfigurator<I, S> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<Boolean> condition
    ) {
        return self.on(condition::call);
    }

    private PredicateStateConfiguratorExtension() {}

}
