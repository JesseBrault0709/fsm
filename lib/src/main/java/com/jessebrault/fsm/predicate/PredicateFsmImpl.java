package com.jessebrault.fsm.predicate;

import com.jessebrault.fsm.AbstractSingleStateFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Predicate;

final class PredicateFsmImpl<I, S> extends AbstractSingleStateFsm<
        I, S, I, Predicate<I>,
        PredicateStateGrammar<I, S>,
        PredicateTransition<I, S>,
        PredicateNoMatchTransition<I, S>
        > implements PredicateFsm<I, S> {

    public PredicateFsmImpl(Map<S, PredicateStateGrammar<I, S>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected @Nullable I test(@NotNull Predicate<I> on, @Nullable I input) {
        if (on.test(input)) {
            return input;
        } else {
            return null;
        }
    }

}
