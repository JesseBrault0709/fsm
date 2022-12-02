package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateOnNoMatchConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractOnNoMatchConfigurator;

public class PredicateOnNoMatchConfiguratorImpl<I, S>
        extends AbstractOnNoMatchConfigurator<I, S, PredicateOnNoMatchConfigurator<I, S>>
        implements PredicateOnNoMatchConfigurator<I, S> {

    @Override
    protected PredicateOnNoMatchConfigurator<I, S> getThis() {
        return this;
    }

}
