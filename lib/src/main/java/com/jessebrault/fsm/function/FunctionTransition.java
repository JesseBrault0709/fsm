package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public record FunctionTransition<I, S, O>(
        Function<I, O> on,
        @Nullable S shiftTo,
        Collection<Consumer<O>> outputConsumers
) implements Transition<S, O, Function<I, O>> {}
