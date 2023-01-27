package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.StackNoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public record StackPredicateNoMatchTransition<I, S>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, I> instead,
        List<S> pushStates,
        int popStates
) implements StackNoMatchTransition<I, S, I> {}
