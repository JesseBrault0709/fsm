package com.jessebrault.fsm.impl;

import com.jessebrault.fsm.FiniteStateMachine;
import com.jessebrault.fsm.impl.util.TriPredicate;

import java.util.Map;
import java.util.function.BiFunction;

public final class FsmImpl<I, S, C, R> implements FiniteStateMachine<I, S, R> {

    private final Map<S, TransitionSet<I, S, C, R>> grammar;
    private final TriPredicate<I, C, R> matcher;
    private final BiFunction<I, C, R> inputFunction;

    private S curState;

    public FsmImpl(
            S initialState,
            Map<S, TransitionSet<I, S, C, R>> grammar,
            TriPredicate<I, C, R> matcher,
            BiFunction<I, C, R> inputFunction
    ) {
        this.curState = initialState;
        this.grammar = grammar;
        this.matcher = matcher;
        this.inputFunction = inputFunction;
    }

    @Override
    public S getCurrentState() {
        return this.curState;
    }

    @Override
    public R accept(I input) {
        final var transitionSet = this.grammar.get(this.curState);
        if (transitionSet == null) {
            throw new RuntimeException(
                    "There is no TransitionSet defined for the currentState '" + this.curState + "'"
            );
        }

        for (final var transition : transitionSet.transitions()) {
            final var on = transition.on();
            final var result = this.inputFunction.apply(input, on);
            if (this.matcher.test(input, on, result)) {
                // Successfully matched
                final var shiftTo = transition.shiftTo();
                if (shiftTo != null) {
                    this.curState = transition.shiftTo();
                }
                transition.actions().forEach(action -> action.accept(result));
                return result;
            }
        }

        // Did not match
        final var noMatchShiftTo = transitionSet.noMatchShiftTo();
        if (noMatchShiftTo != null) {
            this.curState = noMatchShiftTo;
        }
        transitionSet.noMatchActions().forEach(action -> action.accept(input));
        return null;
    }

}
