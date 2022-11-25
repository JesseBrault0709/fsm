package com.jessebrault.fsm.coremachines.stackfunction;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public interface StackFunctionResult<I, O> {

    boolean matched();

    @Nullable Function<I, O> getMatchedFunction();

    @Nullable O getOutput();

}
