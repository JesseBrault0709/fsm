package com.jessebrault.fsm.impl.coremachines;

public final class FsmHelper {

    public void checkTransitionSet(Object transitionSet, Object curState) {
        if (transitionSet == null) {
            final var message = "There is no transitionSet defined for the current state ("
                    + curState + "). Did you forget to call whileIn() during the building code?";
            throw new RuntimeException(message);
        }
    }

}
