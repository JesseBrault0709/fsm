package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.Result;

import java.util.function.Function;

public interface FunctionResult<I, S, O> extends Result<I, S> {
    Function<I, O> getCondition();
    O getOutput();
}
