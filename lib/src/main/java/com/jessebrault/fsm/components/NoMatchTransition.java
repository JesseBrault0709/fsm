package com.jessebrault.fsm.components;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public interface NoMatchTransition<I, S> {
    @Nullable S shiftTo();
    Collection<Consumer<I>> inputConsumers();
}
