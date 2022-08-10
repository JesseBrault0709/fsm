package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;
import com.jessebrault.fsm.coremachines.simple.SimpleResult;
import com.jessebrault.fsm.impl.coremachines.FsmHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;

import java.util.Map;
import java.util.Objects;

final class SimpleFsmImpl<I, S> implements SimpleFsm<I, S> {

    private final FsmHelper helper = new FsmHelper();
    private S curState;
    private final Map<S, TransitionSet<I, S, I, I>> grammar;

    SimpleFsmImpl(S initialState, Map<S, TransitionSet<I, S, I, I>> grammar) {
        this.curState = initialState;
        this.grammar = grammar;
    }

    @Override
    public SimpleResult<I, S> accept(I input) {
        final var transitionSet = this.grammar.get(this.curState);
        this.helper.checkTransitionSet(transitionSet, this.curState);
        for (final var transition : transitionSet.transitions()) {
            if (Objects.equals(transition.on(), input)) {
                if (transition.shiftTo() != null) {
                    this.curState = transition.shiftTo();
                }
                transition.actions().forEach(action -> action.accept(input));
                return new SimpleResultImpl<>(true, input, this.curState);
            }
        }
        if (transitionSet.onNoMatchShiftTo() != null) {
            this.curState = transitionSet.onNoMatchShiftTo();
        }
        transitionSet.onNoMatchActions().forEach(action -> action.accept(input));
        return new SimpleResultImpl<>(false, input, this.curState);
    }

}
