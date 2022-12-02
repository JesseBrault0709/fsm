package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.components.StackStateGrammar;

import java.util.Collection;

public record StackSimpleStateGrammar<I, S>(
        Collection<StackSimpleTransition<I, S>> transitions,
        StackSimpleNoMatchTransition<I, S> noMatchTransition
) implements StackStateGrammar<I, S, I, I, StackSimpleTransition<I, S>, StackSimpleNoMatchTransition<I, S>> {}
