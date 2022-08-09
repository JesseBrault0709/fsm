package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.Result;

import java.util.function.Predicate;

public interface PredicateResult<I, S> extends Result<I, S> {
    Predicate<I> getCondition();
}
