package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionStateConfigurator;
import com.jessebrault.fsm.impl.coremachines.AbstractStateConfigurator;

import java.util.function.Function;

final class FunctionStateConfiguratorImpl<I, S, O> extends AbstractStateConfigurator<I, S, Function<I, O>, O>
        implements FunctionStateConfigurator<I, S, O> {}
