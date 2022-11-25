package com.jessebrault.fsm.coremachines.builder;

/**
 * The interface used by {@link CoreFsmBuilder} to configure the grammar for a
 * given state.
 *
 * @param <I> Fsm input type
 * @param <S> Fsm state type
 * @param <C> Fsm condition type ("on"); see {@link #on(C condition) on()}
 *            method
 * @param <O> Result type of the condition (given to success actions)
 * @param <ON> OnMatchConfigurator type
 * @param <ONM> OnNoMatchConfigurator type
 */
public interface StateConfigurator<
        I, S, C, O,
        ON extends OnConfigurator<S, O, ON>,
        ONM extends OnNoMatchConfigurator<I, S, ONM>
        > {

    /**
     * Receives a "condition" to be processed by the Fsm and met; the exact
     * semantics of "condition" are dependent on the implementing Builder/Fsm.
     * The returned {@link OnConfigurator} configures to which state to shift
     * (if desired), as well as any actions to be taken, if the given
     * "condition" is met (again, the precise semantics depend upon the
     * implementation).
     *
     * @param condition the condition to be processed and met before changing
     *                  state and performing actions, if any
     * @return an {@link OnConfigurator} to configure the grammar for this
     * condition
     */
    ON on(C condition);

    /**
     * In the event that no processed conditions are met, the Fsm will check if
     * there is a "no match" transition configured; if so, the Fsm will shift to
     * the given State and perform the associated actions, if any.
     *
     * @return an {@link OnNoMatchConfigurator} to configure the grammar for
     * when no conditions met
     */
    ONM onNoMatch();

}
