package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.coremachines.builder.CoreFsmBuilder;

import java.util.ServiceLoader;
import java.util.function.Predicate;

/**
 * A builder for an fsm which uses Predicates as conditions to
 * be checked. The accepted input is run through the given predicates
 * for the current state until one returns true, and then performs the
 * associated transition (i.e., possibly shifting to the next state
 * and running any externally effectful actions).
 *
 * @param <I> Fsm input type
 * @param <S> Fsm state type
 */
public interface PredicateFsmBuilder<I, S> extends CoreFsmBuilder<
        I, S, Predicate<I>, I,
        PredicateResult<I, S>,
        PredicateFsm<I, S>,
        PredicateFsmBuilder<I, S>,
        PredicateStateConfigurator<I, S>,
        PredicateOnConfigurator<I, S>,
        PredicateOnNoMatchConfigurator<I, S>
        > {

    interface Service {
        <I, S> PredicateFsmBuilder<I, S> getBuilder();
    }

    static <I, S> PredicateFsmBuilder<I, S> get() {
        return ServiceLoader.load(Service.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find an implementation of PredicateFsmBuilder.Factory"))
                .getBuilder();
    }

}
