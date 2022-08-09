package com.jessebrault.fsm.coremachines.predicate;

import com.jessebrault.fsm.FiniteStateMachine;

public interface PredicateFsm<I, S> extends FiniteStateMachine<I, S, PredicateResult<I, S>> {}
