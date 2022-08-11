package com.jessebrault.fsm.impl.coremachines.function;

import com.jessebrault.fsm.coremachines.function.FunctionFsm;
import com.jessebrault.fsm.coremachines.function.FunctionResult;
import com.jessebrault.fsm.impl.coremachines.FsmHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.function.Function;

final class FunctionFsmImpl<I, S, O> implements FunctionFsm<I, S, O> {

    private static final Logger logger = LoggerFactory.getLogger(FunctionFsmImpl.class);

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
            final var on = transition.on();
            final var output = on.apply(input);
            if (output != null) {
                logger.debug("matched {}; output: {}", on, output);
                final var shiftTo = transition.shiftTo();
                if (shiftTo != null) {
                    logger.debug("shifting from {} to {}", this.curState, shiftTo);
                    this.curState = shiftTo;
                }
                transition.actions().forEach(action -> action.accept(output));
                return new FunctionResultImpl<>(true, input, this.curState, transition.on(), output);
            }
        }
        logger.debug("no match");
        final var shiftTo = transitionSet.onNoMatchShiftTo();
        if (shiftTo != null) {
            logger.debug("shifting from {} to {}", this.curState, shiftTo);
            this.curState = shiftTo;
        }
        transitionSet.onNoMatchActions().forEach(action -> action.accept(input));
        return new FunctionResultImpl<>(false, input, this.curState, null, null);
    }

}
