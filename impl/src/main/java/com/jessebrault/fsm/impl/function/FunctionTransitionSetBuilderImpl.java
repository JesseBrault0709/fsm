package com.jessebrault.fsm.impl.function;

import com.jessebrault.fsm.function.FunctionTransitionSetBuilder;
import com.jessebrault.fsm.impl.AbstractTransitionSetBuilder;

import java.util.function.Function;

final class FunctionTransitionSetBuilderImpl<I, S, R> extends AbstractTransitionSetBuilder<I, S, Function<I, R>, R>
        implements FunctionTransitionSetBuilder<I, S, R> {}
