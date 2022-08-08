package com.jessebrault.fsm;

import java.util.Collection;
import java.util.function.Consumer;

public interface Transition<S, C, R> {
    C getOn();
    S getShiftTo();
    Collection<Consumer<R>> getActions();
}
