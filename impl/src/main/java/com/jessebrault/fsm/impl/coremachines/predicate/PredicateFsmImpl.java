package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateFsm;
import com.jessebrault.fsm.coremachines.predicate.PredicateResult;
import com.jessebrault.fsm.impl.coremachines.FsmHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;

import java.util.Map;
import java.util.function.Predicate;

final class PredicateFsmImpl<I, S> implements PredicateFsm<I, S> {

    private final FsmHelper helper = new FsmHelper();
    private final Map<S, TransitionSet<I, S, Predicate<I>, I>> grammar;
    private S curState;

    PredicateFsmImpl(S initialState, Map<S, TransitionSet<I, S, Predicate<I>, I>> grammar) {
        this.curState = initialState;
        this.grammar = grammar;
    }

    @Override
    public PredicateResult<I, S> accept(I input) {
        final var transitionSet = this.grammar.get(this.curState);
        this.helper.checkTransitionSet(transitionSet, this.curState);
        for (final var transition : transitionSet.transitions()) {
            final var onPredicate = transition.on();
            if (onPredicate.test(input)) {
                if (transition.shiftTo() != null) {
                    this.curState = transition.shiftTo();
                }
                transition.actions().forEach(action -> action.accept(input));
                return new PredicateResultImpl<>(true, input, this.curState, onPredicate);
            }
        }
        if (transitionSet.onNoMatchShiftTo() != null) {
            this.curState = transitionSet.onNoMatchShiftTo();
        }
        transitionSet.onNoMatchActions().forEach(action -> action.accept(input));
        return new PredicateResultImpl<>(false, input, this.curState, null);
    }

}
