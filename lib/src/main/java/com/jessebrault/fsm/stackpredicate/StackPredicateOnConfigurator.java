package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.StackOnConfigurator;

public interface StackPredicateOnConfigurator<I, S>
        extends StackOnConfigurator<S, I, StackPredicateOnConfigurator<I, S>> {}
