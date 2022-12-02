package com.jessebrault.fsm.simple;

import com.jessebrault.fsm.AbstractSingleStateFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

final class SimpleFsmImpl<I, S> extends AbstractSingleStateFsm<
        I, S, I, I,
        SimpleStateGrammar<I, S>,
        SimpleTransition<I, S>,
        SimpleNoMatchTransition<I, S>
        > implements SimpleFsm<I, S> {

    public SimpleFsmImpl(Map<S, SimpleStateGrammar<I, S>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected @Nullable I test(@NotNull I on, @Nullable I input) {
        return Objects.equals(on, input) ? input : null;
    }

    @Override
    protected @Nullable I getOnNoMatchOutput(I input) {
        return null;
    }

    @Override
    protected void validateInput(@Nullable I input) {
        Objects.requireNonNull(input);
    }

}
