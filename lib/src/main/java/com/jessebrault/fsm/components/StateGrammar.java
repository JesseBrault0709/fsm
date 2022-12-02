package com.jessebrault.fsm.components;

import java.util.Collection;

public interface StateGrammar<
        I, S, O, C,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > {
    Collection<T> transitions();
    NMT noMatchTransition();
}
