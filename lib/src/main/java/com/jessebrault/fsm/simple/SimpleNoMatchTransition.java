package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.NoMatchTransition;

import java.util.Collection;
import java.util.function.Consumer;

public record SimpleNoMatchTransition<I, S>(
        S shiftTo,
        Collection<Consumer<I>> inputConsumers
) implements NoMatchTransition<I, S> {}
