package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.StackNoMatchTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public record StackSimpleNoMatchTransition<I, S>(
        S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        Function<I, I> instead,
        List<S> pushStates,
        int popStates
) implements StackNoMatchTransition<I, S, I> {}
