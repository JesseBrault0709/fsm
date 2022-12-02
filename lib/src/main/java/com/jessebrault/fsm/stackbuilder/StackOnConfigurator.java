package com.jessebrault.fsm.stackbuilder;

import com.jessebrault.fsm.builder.OnConfigurator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface StackOnConfigurator<S, O, ON extends StackOnConfigurator<S, O, ON>>
        extends OnConfigurator<S, O, ON> {

    ON pushState(@NotNull S state);

    ON pushStates(@NotNull List<S> states);

    ON popState();

    ON popStates(int numberOfStates);

    List<S> getPushStates();

    int getPopStates();

}
