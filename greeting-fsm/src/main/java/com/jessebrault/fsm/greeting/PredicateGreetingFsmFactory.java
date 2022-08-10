package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.coremachines.predicate.PredicateFsm;

public interface PredicateGreetingFsmFactory {
    PredicateFsm<GreetingInputs, GreetingStates> get();
}
