package com.jessebrault.fsm;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractSingleStateFsm<
        I, S, O, C,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > extends AbstractFiniteStateMachine<I, S, O, C, SG, T, NMT> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSingleStateFsm.class);

    private S currentState;

    public AbstractSingleStateFsm(Map<S, SG> grammar, S initialState) {
        super(grammar);
        Objects.requireNonNull(initialState);
        this.currentState = initialState;
    }

    @Override
    protected final void shiftTo(@Nullable S state) {
        if (state != null) {
            logger.debug("shifting from {} to {}", this.currentState, state);
            this.currentState = state;
        }
    }

    @Override
    public final S getCurrentState() {
        logger.debug("currentState: {}", this.currentState);
        return this.currentState;
    }



}
