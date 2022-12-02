package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.StackNoMatchTransition;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public record StackSimpleNoMatchTransition<I, S>(
        S shiftTo,
        Collection<Consumer<I>> inputConsumers,
        List<S> pushStates,
        int popStates
) implements StackNoMatchTransition<I, S> {}
