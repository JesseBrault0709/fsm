package com.jessebrault.fsm.impl;

import java.util.Collection;
import java.util.function.Consumer;

public record Transition<S, C, R>(
        C on,
        S shiftTo,
        Collection<Consumer<R>> actions
) {}
