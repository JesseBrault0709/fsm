package com.jessebrault.fsm.function;

import com.jessebrault.fsm.FsmBuilder;

import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * A builder for an fsm which uses Functions as conditions to be checked.
 * For each accepted input, the fsm runs the Functions available for a current
 * state until it finds one that returns a non-null value. If one is found, the
 * fsm performs the associated transition, possibly shifting to a new state and
 * forwarding the result of the Function to the associated effectful actions.
 *
 * @param <I> Fsm input type
 * @param <S> Fsm state type
 * @param <R> Condition function return type
 */
public interface FunctionFsmBuilder<I, S, R> extends FsmBuilder<I, S, Function<I, R>, R, FunctionFsmBuilder<I, S, R>>{

    interface Factory {
        <I, S, R> FunctionFsmBuilder<I, S, R> getBuilder();
    }

    static <I, S, R> FunctionFsmBuilder<I, S, R> get() {
        return ServiceLoader.load(FunctionFsmBuilder.Factory.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find an implementation of FunctionFsmBuilder.Factory"))
                .getBuilder();
    }

}
