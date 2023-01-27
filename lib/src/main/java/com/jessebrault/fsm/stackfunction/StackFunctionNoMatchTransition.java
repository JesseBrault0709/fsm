package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.StackNoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public record StackFunctionNoMatchTransition<I, S, O>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, O> instead,
        List<S> pushStates,
        int popStates
) implements StackNoMatchTransition<I, S, O> {}
