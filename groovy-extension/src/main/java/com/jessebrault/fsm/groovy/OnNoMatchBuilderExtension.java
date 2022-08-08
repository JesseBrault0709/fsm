package com.jessebrault.fsm.groovy;

import com.jessebrault.fsm.OnNoMatchBuilder;
import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public class OnNoMatchBuilderExtension {

    public static <I, S>OnNoMatchBuilder<I, S> exec(
            OnNoMatchBuilder<I, S> self,
            @ClosureParams(value = FromString.class, options = "I")
            Closure<?> action
    ) {
        self.exec(input -> action.call(input));
        return self;
    }

}
