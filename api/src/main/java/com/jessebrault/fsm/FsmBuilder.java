package com.jessebrault.fsm;

public interface FsmBuilder<I, S, R extends Result<I, S>, M extends FiniteStateMachine<I, S, R>> {
    M build();
}
