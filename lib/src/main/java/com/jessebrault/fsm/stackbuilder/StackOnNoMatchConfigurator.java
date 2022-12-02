package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

import java.util.List;

public interface StackOnNoMatchConfigurator<I, S, ONM extends StackOnNoMatchConfigurator<I, S, ONM>>
        extends OnNoMatchConfigurator<I, S, ONM> {

    ONM pushState(S state);

    ONM pushStates(List<S> states);

    ONM popState();

    ONM popState(int numberOfStates);

    List<S> getPushStates();

    int getPopStates();

}
