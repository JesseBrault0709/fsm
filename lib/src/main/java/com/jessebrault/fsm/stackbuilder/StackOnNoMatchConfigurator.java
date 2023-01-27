package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.OnNoMatchConfigurator;

import java.util.List;

public interface StackOnNoMatchConfigurator<I, S, O, ONM extends StackOnNoMatchConfigurator<I, S, O, ONM>>
        extends OnNoMatchConfigurator<I, S, O, ONM> {

    ONM pushState(S state);

    ONM pushStates(List<S> states);

    ONM popState();

    ONM popState(int numberOfStates);

    List<S> getPushStates();

    int getPopStates();

}
