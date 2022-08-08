package com.jessebrault.fsm;

/**
 * A little-bit complicated interface for building sets of transitions.
 * The "on" method receives a condition to be checked by the fsm. (The
 * exact semantics of the "condition being checked and met" are specific
 * to each type of implementing builder; see their documentation). If the
 * condition is, met, the fsm shifts to the state received by the "shiftTo"
 * method and executes any actions received by the various "exec" methods.
 *
 * The "onNoMatch" method may be used to specify what the fsm is to do
 * in the event that the input causes no conditions to be met.
 *
 * @param <I> Fsm input type
 * @param <S> Fsm state type
 * @param <C> Fsm condition type ("on")
 * @param <R> Result type of the condition (given to success actions)
 */
public interface TransitionSetBuilder<I, S, C, R> {

    /**
     * Adds a condition to be checked. The exact meaning of "checked" is
     * specific to each implementing builder. The condition may return a result
     * to be used in the given actions, or the input itself may be forwarded to
     * those actions. See the documentation for each extending builder for more information.
     *
     * @param condition the condition to be checked
     * @return the builder
     */
    OnBuilder<S, R> on(C condition);

    /**
     * Specifies a transition to be executed when none of the provided conditions
     * are met.
     *
     * @return the builder
     */
    OnNoMatchBuilder<I, S> onNoMatch();

}
