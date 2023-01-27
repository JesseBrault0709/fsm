package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.stackbuilder.StackOnNoMatchConfigurator;

public interface StackPredicateOnNoMatchConfigurator<I, S>
        extends StackOnNoMatchConfigurator<I, S, I, StackPredicateOnNoMatchConfigurator<I, S>> {}
