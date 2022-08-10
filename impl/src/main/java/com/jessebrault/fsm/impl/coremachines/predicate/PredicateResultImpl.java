package com.jessebrault.fsm.impl.coremachines.predicate;

import com.jessebrault.fsm.coremachines.predicate.PredicateResult;
import com.jessebrault.fsm.impl.coremachines.ResultImpl;

import java.util.function.Predicate;

final class PredicateResultImpl<I, S> extends ResultImpl<I, S> implements PredicateResult<I, S> {

    private final Predicate<I> condition;

    PredicateResultImpl(boolean match, I input, S state, Predicate<I> condition) {
        super(match, input, state);
        this.condition = condition;
    }

    @Override
    public Predicate<I> getCondition() {
        return this.condition;
    }

}
