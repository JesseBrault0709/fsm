package com.jessebrault.fsm.stacksimple;

import com.jessebrault.fsm.AbstractStackFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

final class StackSimpleFsmImpl<I, S> extends AbstractStackFsm<
        I, S, I, I,
        StackSimpleStateGrammar<I, S>,
        StackSimpleTransition<I, S>,
        StackSimpleNoMatchTransition<I, S>
        > implements StackSimpleFsm<I, S> {

    public StackSimpleFsmImpl(Map<S, StackSimpleStateGrammar<I, S>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected void validateInput(@Nullable I input) {
        Objects.requireNonNull(input);
    }

    @Override
    protected @Nullable I test(@NotNull I on, @Nullable I input) {
        if (Objects.equals(on, input)) {
            return input;
        } else {
            return null;
        }
    }

}
