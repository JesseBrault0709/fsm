package com.jessebrault.fsm.components;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public interface NoMatchTransition<I, S, O> {
    @Nullable S shiftTo();
    Collection<Consumer<I>> inputConsumers();

    @Nullable Function<I, O> instead();
}
