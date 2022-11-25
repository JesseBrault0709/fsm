package com.jessebrault.fsm.coremachines.function;

import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;
import com.jessebrault.fsm.coremachines.builder.OnConfigurator;
import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;

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
 * @param <O> Condition function return type
 */
public interface FunctionFsmBuilder<I, S, O> extends CoreFsmBuilder<
        I, S, Function<I, O>, O,
        FunctionResult<I, S, O>,
        FunctionFsm<I, S, O>,
        FunctionFsmBuilder<I, S, O>,
        FunctionStateConfigurator<I, S, O>,
        OnConfigurator<S, O>,
        OnNoMatchConfigurator<I, S>
        > {

    interface Service {
        <I, S, R> FunctionFsmBuilder<I, S, R> getBuilder();
    }

    static <I, S, R> FunctionFsmBuilder<I, S, R> get() {
        return ServiceLoader.load(Service.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find an implementation of FunctionFsmBuilder.Factory"))
                .getBuilder();
    }

}
