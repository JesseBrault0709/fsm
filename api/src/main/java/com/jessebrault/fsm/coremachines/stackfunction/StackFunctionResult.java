package com.jessebrault.fsm.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.function.FunctionResult;

import java.util.Deque;

public interface StackFunctionResult<I, S, O>  extends FunctionResult<I, S, O> {
    Deque<S> getStateStack();
}
