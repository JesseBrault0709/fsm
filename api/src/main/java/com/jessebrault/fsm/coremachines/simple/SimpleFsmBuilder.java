package com.jessebrault.fsm.coremachines.simple;

import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;

import java.util.ServiceLoader;

/**
 * A builder for an fsm which simply accepts an input, tests
 * if the input is equal to one of the given condition values, and then
 * if a match is found, possibly shifts state and forwards
 * the input to any given actions.
 *
 * @param <I> Fsm input type
 * @param <S> Fsm state type
 */
public interface SimpleFsmBuilder<I, S> extends CoreFsmBuilder<
        I, S, I, I,
        SimpleResult<I, S>,
        SimpleFsm<I, S>,
        SimpleFsmBuilder<I, S>,
        SimpleStateConfigurator<I, S>,
        SimpleOnConfigurator<I, S>,
        SimpleOnNoMatchConfigurator<I, S>
        > {

    interface Service {
        <I, S> SimpleFsmBuilder<I, S> getBuilder();
    }

    static <I, S> SimpleFsmBuilder<I, S> get() {
        return ServiceLoader.load(Service.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find an implementation of SimpleFsmBuilder.Factory."))
                .getBuilder();
    }

}
