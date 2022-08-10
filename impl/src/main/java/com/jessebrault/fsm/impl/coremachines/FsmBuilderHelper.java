package com.jessebrault.fsm.impl.coremachines;

import java.util.Objects;

public final class FsmBuilderHelper {

    public void checkSetInitialState(Object state) {
        Objects.requireNonNull(state, "setInitialState(): state must not be null");
    }

    public void checkWhileIn(Object state, Object configureState) {
        Objects.requireNonNull(state, "whileIn(): state must not be null");
        Objects.requireNonNull(configureState, "whileIn(): configureState must not be null");
    }

    public void checkBuild(Object initialState) {
        Objects.requireNonNull(initialState, "build(): initialState must not be null");
    }

}
