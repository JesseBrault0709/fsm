package com.jessebrault.fsm.impl.coremachines;

import java.util.Collection;
import java.util.function.Consumer;

public record Transition<S, C, O>(
        C on,
        S shiftTo,
        Collection<Consumer<O>> actions
) {}
