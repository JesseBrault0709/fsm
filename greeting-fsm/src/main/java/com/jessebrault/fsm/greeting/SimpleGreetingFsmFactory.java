package com.jessebrault.fsm.greeting;

import com.jessebrault.fsm.coremachines.simple.SimpleFsm;

public interface SimpleGreetingFsmFactory {
    SimpleFsm<GreetingInputs, GreetingStates> get();
}
