package com.jessebrault.fsm.function;

import com.jessebrault.fsm.AbstractSingleStateFsm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;

final class FunctionFsmImpl<I, S, O> extends AbstractSingleStateFsm<
        I, S, O, Function<I, O>,
        FunctionStateGrammar<I, S, O>,
        FunctionTransition<I, S, O>,
        FunctionNoMatchTransition<I, S, O>
        > implements FunctionFsm<I, S, O> {

    public FunctionFsmImpl(Map<S, FunctionStateGrammar<I, S, O>> grammar, S initialState) {
        super(grammar, initialState);
    }

    @Override
    protected @Nullable O test(@NotNull Function<I, O> on, @Nullable I input) {
        return on.apply(input);
    }

}
