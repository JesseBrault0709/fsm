package com.jessebrault.fsm.impl.coremachines.simple;

import com.jessebrault.fsm.coremachines.simple.SimpleResult;
import com.jessebrault.fsm.impl.coremachines.ResultImpl;

final class SimpleResultImpl<I, S> extends ResultImpl<I, S> implements SimpleResult<I, S> {

    SimpleResultImpl(boolean match, I input, S state) {
        super(match, input, state);
    }

}
