package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.StackTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public record StackFunctionTransition<I, S, O>(
        Function<I, O> on,
        @Nullable S shiftTo,
        Collection<Consumer<O>> outputConsumers,
        List<S> pushStates,
        int popStates
) implements StackTransition<S, O, Function<I, O>> {}
