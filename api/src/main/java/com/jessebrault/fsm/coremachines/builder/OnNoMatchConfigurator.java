package com.jessebrault.fsm.coremachines.builder;

import java.util.function.Consumer;

public interface OnNoMatchConfigurator<I, S> {
    OnNoMatchConfigurator<I, S> shiftTo(S state);
    OnNoMatchConfigurator<I, S> exec(Consumer<I> action);
}
