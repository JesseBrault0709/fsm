package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.NoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public record FunctionNoMatchTransition<I, S>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers
) implements NoMatchTransition<I, S> {}
