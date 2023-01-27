package com.jessebrault.fsm.components;

public interface StackStateGrammar<
        I, S, O, C,
        T extends StackTransition<S, O, C>,
        NMT extends StackNoMatchTransition<I, S, O>
        > extends StateGrammar<I, S, O, C, T, NMT> {}
