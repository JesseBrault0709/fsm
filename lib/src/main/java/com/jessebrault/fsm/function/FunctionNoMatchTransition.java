package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.NoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public record FunctionNoMatchTransition<I, S, O>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, O> instead
) implements NoMatchTransition<I, S, O> {}
