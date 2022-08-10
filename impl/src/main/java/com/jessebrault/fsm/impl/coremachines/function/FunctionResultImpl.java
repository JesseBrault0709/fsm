package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionResult;
import com.jessebrault.fsm.impl.coremachines.ResultImpl;

import java.util.function.Function;

final class FunctionResultImpl<I, S, O> extends ResultImpl<I, S> implements FunctionResult<I, S, O> {

    private final Function<I, O> condition;
    private final O output;

    public FunctionResultImpl(boolean match, I input, S state, Function<I, O> condition, O output) {
        super(match, input, state);
        this.condition = condition;
        this.output = output;
    }

    @Override
    public Function<I, O> getCondition() {
        return this.condition;
    }

    @Override
    public O getOutput() {
        return this.output;
    }

}
