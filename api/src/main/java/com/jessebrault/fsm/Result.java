package com.jessebrault.fsm;

public interface Result<I, S> {
    boolean isMatch();
    I getInput();
    S getState();
}
