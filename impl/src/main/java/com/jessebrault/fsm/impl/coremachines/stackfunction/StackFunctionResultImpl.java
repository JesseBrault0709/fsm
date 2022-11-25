package com.jessebrault.fsm.impl.coremachines.stackfunction;

import com.jessebrault.fsm.coremachines.stackfunction.StackFunctionResult;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

final class StackFunctionResultImpl<I, O> implements StackFunctionResult<I, O> {

    private final boolean matched;
    private final Function<I, O> matchedFunction;
    private final O getOutput;

    public StackFunctionResultImpl(boolean matched, Function<I, O> matchedFunction, O getOutput) {
        this.matched = matched;
        this.matchedFunction = matchedFunction;
        this.getOutput = getOutput;
    }

    @Override
    public boolean matched() {
        return this.matched;
    }

    @Override
    public @Nullable Function<I, O> getMatchedFunction() {
        return this.matchedFunction;
    }

    @Override
    public @Nullable O getOutput() {
        return this.getOutput;
    }

}
