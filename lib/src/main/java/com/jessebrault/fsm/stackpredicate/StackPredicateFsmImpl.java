package com.jessebrault.fsm.stackpredicate;

import com.jessebrault.fsm.AbstractStackFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Predicate;

final class StackPredicateFsmImpl<I, S> extends AbstractStackFsm<
        I, S, I, Predicate<I>,
        StackPredicateStateGrammar<I, S>,
        StackPredicateTransition<I, S>,
        StackPredicateNoMatchTransition<I, S>
        > implements StackPredicateFsm<I, S> {

    public StackPredicateFsmImpl(Map<S, StackPredicateStateGrammar<I, S>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected @Nullable I test(@NotNull Predicate<I> on, @Nullable I input) {
        return on.test(input) ? input : null;
    }

    @Override
    protected @Nullable I getOnNoMatchOutput(I input) {
        return null;
    }

}
