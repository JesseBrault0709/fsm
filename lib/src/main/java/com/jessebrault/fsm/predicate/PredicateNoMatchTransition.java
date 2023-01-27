package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.components.NoMatchTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public record PredicateNoMatchTransition<I, S>(
        @Nullable S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, I> instead
)
        implements NoMatchTransition<I, S, I> {}
