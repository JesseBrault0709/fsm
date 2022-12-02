package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.components.StateGrammar;

import java.util.Collection;

public record SimpleStateGrammar<I, S>(
        Collection<SimpleTransition<I, S>> transitions,
        SimpleNoMatchTransition<I, S> noMatchTransition
) implements StateGrammar<I, S, I, I, SimpleTransition<I, S>, SimpleNoMatchTransition<I, S>> {}
