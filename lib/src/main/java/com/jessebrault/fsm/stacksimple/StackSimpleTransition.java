package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.StackTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public record StackSimpleTransition<I, S>(
        I on,
        @Nullable S shiftTo,
        Collection<Consumer<I>> outputConsumers,
        List<S> pushStates,
        int popStates
) implements StackTransition<S, I, I> {}
