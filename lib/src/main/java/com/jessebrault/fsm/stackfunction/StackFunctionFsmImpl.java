package com.jessebrault.fsm.stackfunction;

import com.jessebrault.fsm.AbstractStackFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;

final class StackFunctionFsmImpl<I, S, O> extends AbstractStackFsm<
        I, S, O, Function<I, O>,
        StackFunctionStateGrammar<I, S, O>,
        StackFunctionTransition<I, S, O>,
        StackFunctionNoMatchTransition<I, S, O>
        > implements StackFunctionFsm<I, S, O> {

    public StackFunctionFsmImpl(Map<S, StackFunctionStateGrammar<I, S, O>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected @Nullable O test(@NotNull Function<I, O> on, @Nullable I input) {
        return on.apply(input);
    }

}
