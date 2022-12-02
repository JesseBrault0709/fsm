package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.predicate.PredicateFsm;

public interface PredicateGreetingFsmFactory {
    PredicateFsm<GreetingInputs, GreetingStates> get();
}
