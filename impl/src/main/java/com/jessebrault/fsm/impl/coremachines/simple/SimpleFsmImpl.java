package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;
import com.jessebrault.fsm.coremachines.simple.SimpleResult;
import com.jessebrault.fsm.impl.coremachines.FsmHelper;
import com.jessebrault.fsm.impl.coremachines.TransitionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

final class SimpleFsmImpl<I, S> implements SimpleFsm<I, S> {

    private static final Logger logger = LoggerFactory.getLogger(SimpleFsmImpl.class);

    private final FsmHelper helper = new FsmHelper();
    private S curState;
    private final Map<S, TransitionSet<I, S, I, I>> grammar;

    SimpleFsmImpl(S initialState, Map<S, TransitionSet<I, S, I, I>> grammar) {
        this.curState = initialState;
        this.grammar = grammar;
    }

    @Override
    public SimpleResult<I, S> apply(I input) {
        final var transitionSet = this.grammar.get(this.curState);
        this.helper.checkTransitionSet(transitionSet, this.curState);
        for (final var transition : transitionSet.transitions()) {
            final var on = transition.on();
            if (Objects.equals(on, input)) {
                logger.debug("matched {}", on);
                final var shiftTo = transition.shiftTo();
                if (shiftTo != null) {
                    logger.debug("shifting from {} to {}", this.curState, shiftTo);
                    this.curState = shiftTo;
                }
                transition.actions().forEach(action -> action.accept(input));
                return new SimpleResultImpl<>(true, input, this.curState);
            }
        }
        logger.debug("no match");
        final var shiftTo = transitionSet.onNoMatchShiftTo();
        if (shiftTo != null) {
            logger.debug("shifting from {} to {}", this.curState, shiftTo);
            this.curState = shiftTo;
        }
        transitionSet.onNoMatchActions().forEach(action -> action.accept(input));
        return new SimpleResultImpl<>(false, input, this.curState);
    }

}
