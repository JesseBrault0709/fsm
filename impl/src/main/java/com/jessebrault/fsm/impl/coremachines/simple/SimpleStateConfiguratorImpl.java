package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractStateConfigurator;

final class SimpleStateConfiguratorImpl<I, S> extends AbstractStateConfigurator<
        I, S, I, I,
        SimpleOnConfiguratorImpl<I, S>,
        SimpleOnNoMatchConfiguratorImpl<I, S>
        > implements SimpleStateConfigurator<I, S> {

    SimpleStateConfiguratorImpl() {
        super(SimpleOnConfiguratorImpl::new, new SimpleOnNoMatchConfiguratorImpl<>());
    }

}
