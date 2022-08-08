package com.jessebrault.fsm.function;

import com.jessebrault.fsm.TransitionSetBuilder;

import java.util.function.Function;

public interface FunctionTransitionSetBuilder<I, S, R> extends TransitionSetBuilder<I, S, Function<I, R>, R> {}
