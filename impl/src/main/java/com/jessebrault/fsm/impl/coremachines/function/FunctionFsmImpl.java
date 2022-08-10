package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionFsm;
import com.jessebrault.fsm.coremachines.function.FunctionResult;
import com.jessebrault.fsm.impl.coremachines.FsmHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;

import java.util.Map;
import java.util.function.Function;

final class FunctionFsmImpl<I, S, O> implements FunctionFsm<I, S, O> {

    private final FsmHelper helper = new FsmHelper();
    private final Map<S, TransitionSet<I, S, Function<I, O>, O>> grammar;

    private S curState;

    public FunctionFsmImpl(S initialState, Map<S, TransitionSet<I, S, Function<I, O>, O>> grammar) {
        this.curState = initialState;
        this.grammar = grammar;
    }

    @Override
    public FunctionResult<I, S, O> accept(I input) {
        final var transitionSet = this.grammar.get(this.curState);
        this.helper.checkTransitionSet(transitionSet, this.curState);
        for (final var transition : transitionSet.transitions()) {
            final var output = transition.on().apply(input);
            if (output != null) {
                if (transition.shiftTo() != null) {
                    this.curState = transition.shiftTo();
                }
                transition.actions().forEach(action -> action.accept(output));
                return new FunctionResultImpl<>(true, input, this.curState, transition.on(), output);
            }
        }
        if (transitionSet.onNoMatchShiftTo() != null) {
            this.curState = transitionSet.onNoMatchShiftTo();
        }
        transitionSet.onNoMatchActions().forEach(action -> action.accept(input));
        return new FunctionResultImpl<>(false, input, this.curState, null, null);
    }

}
