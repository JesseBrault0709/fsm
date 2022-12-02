package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;

public record SimpleTransition<I, S>(
        I on,
        @Nullable S shiftTo,
        Collection<Consumer<I>> outputConsumers
) implements Transition<S, I, I> {}
