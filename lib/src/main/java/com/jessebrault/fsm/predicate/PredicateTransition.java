package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public record PredicateTransition<I, S>(
        Predicate<I> on,
        @Nullable S shiftTo,
        Collection<Consumer<I>> outputConsumers
) implements Transition<S, I, Predicate<I>> {}
