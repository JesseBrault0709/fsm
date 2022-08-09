package com.jessebrault.fsm.coremachines.builder;

import java.util.function.Consumer;

public interface OnConfigurator<S, O> {
    OnConfigurator<S, O> shiftTo(S state);
    OnConfigurator<S, O> exec(Consumer<O> action);
}
