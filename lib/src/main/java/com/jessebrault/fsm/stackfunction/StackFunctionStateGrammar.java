package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.components.StackStateGrammar;

import java.util.Collection;
import java.util.function.Function;

public record StackFunctionStateGrammar<I, S, O>(
        Collection<StackFunctionTransition<I, S, O>> transitions,
        StackFunctionNoMatchTransition<I, S> noMatchTransition
) implements StackStateGrammar<
        I, S, O, Function<I, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S>
        > {}
