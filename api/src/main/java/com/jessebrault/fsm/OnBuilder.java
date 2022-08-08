package com.jessebrault.fsm;

import java.util.function.Consumer;

public interface OnBuilder<S, R> {
    OnBuilder<S, R> shiftTo(S state);
    OnBuilder<S, R> exec(Consumer<R> action);
    OnBuilder<S, R> exec(Runnable action);
}
