package com.jessebrault.fsm.components;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public interface Transition<S, O, C> {
    C on();
    @Nullable S shiftTo();
    Collection<Consumer<O>> outputConsumers();
}
