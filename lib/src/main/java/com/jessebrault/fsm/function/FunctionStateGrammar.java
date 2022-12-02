package com.jessebrault.fsm.function;

import com.jessebrault.fsm.components.StateGrammar;

import java.util.Collection;
import java.util.function.Function;

public record FunctionStateGrammar<I, S, O>(
        Collection<FunctionTransition<I, S, O>> transitions,
        FunctionNoMatchTransition<I, S> noMatchTransition
) implements StateGrammar<
        I, S, O, Function<I, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S>> {}
