package com.jessebrault.fsm.components;

import java.util.Collection;

public abstract class AbstractStateGrammar<
        I, S, O, C,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S, O>
        > implements StateGrammar<I, S, O, C, T, NMT> {

    private final Collection<T> transitions;
    private final NMT noMatchTransition;

    public AbstractStateGrammar(Collection<T> transitions, NMT noMatchTransition) {
        this.transitions = transitions;
        this.noMatchTransition = noMatchTransition;
    }

    @Override
    public Collection<T> transitions() {
        return this.transitions;
    }

    @Override
    public NMT noMatchTransition() {
        return this.noMatchTransition;
    }

    @Override
    public String toString() {
        return String.format("StateGrammarImpl(%s, %s)", this.transitions, this.noMatchTransition);
    }

}
