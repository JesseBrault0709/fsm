package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.StackNoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public record StackFunctionNoMatchTransition<I, S>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        List<S> pushStates,
        int popStates
) implements StackNoMatchTransition<I, S> {}
