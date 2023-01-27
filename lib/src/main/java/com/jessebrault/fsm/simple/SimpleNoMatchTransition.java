package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.NoMatchTransition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public record SimpleNoMatchTransition<I, S>(
        S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, I> instead
) implements NoMatchTransition<I, S, I> {}
