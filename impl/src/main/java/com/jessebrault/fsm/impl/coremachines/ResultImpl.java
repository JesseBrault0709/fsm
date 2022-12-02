package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.Result;

public class ResultImpl<I, S> implements Result<I, S> {

    private final boolean match;
    private final I input;
    private final S state;

    public ResultImpl(
            boolean match,
            I input,
            S state
    ) {
        this.match = match;
        this.input = input;
        this.state = state;
    }

    @Override
    public final boolean isMatch() {
        return this.match;
    }

    @Override
    public final I getInput() {
        return this.input;
    }

    @Override
    public final S getUpdatedState() {
        return this.state;
    }
    
}
