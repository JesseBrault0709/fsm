package com.jessebrault.fsm;

import java.util.function.Consumer;

public interface OnNoMatchBuilder<I, S> {
    OnNoMatchBuilder<I, S> shiftTo(S state);
    OnNoMatchBuilder<I, S> exec(Consumer<I> action);
    OnNoMatchBuilder<I, S> exec(Runnable action);
}
