package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.components.StackTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public record StackPredicateTransition<I, S>(
        Predicate<I> on,
        @Nullable S shiftTo,
        Collection<Consumer<I>> outputConsumers,
        List<S> pushStates,
        int popStates
) implements StackTransition<S, I, Predicate<I>> {}
