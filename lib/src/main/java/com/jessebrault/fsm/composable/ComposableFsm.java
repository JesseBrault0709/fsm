package com.jessebrault.fsm.composable;

import com.jessebrault.fsm.AbstractFiniteStateMachine;
import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public final class ComposableFsm<
        I, S, O, C,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S>
        > extends AbstractFiniteStateMachine<I, S, O, C, SG, T, NMT> {

    private final StateManager<I, S, O, C, T, NMT> stateManager;
    private final Consumer<I> inputValidator;
    private final BiFunction<C, I, O> tester;
    private final Function<I, O> onNoMatchFunction;

    public ComposableFsm(
            Map<S, SG> grammar,
            StateManager<I, S, O, C, T, NMT> stateManager,
            Consumer<I> inputValidator,
            BiFunction<C, I, O> tester,
            Function<I, O> onNoMatchFunction
    ) {
        super(grammar);
        this.stateManager = stateManager;
        this.inputValidator = inputValidator;
        this.tester = tester;
        this.onNoMatchFunction = onNoMatchFunction;
    }

    @Override
    protected @Nullable O test(@NotNull C on, @Nullable I input) {
        return this.tester.apply(on, input);
    }

    @Override
    protected void shiftTo(@Nullable S state) {
        this.stateManager.shiftTo(state);
    }

    @Override
    protected @Nullable O getOnNoMatchOutput(I input) {
        return this.onNoMatchFunction.apply(input);
    }

    @Override
    public S getCurrentState() {
        return this.stateManager.getCurrentState();
    }

    @Override
    protected void validateInput(@Nullable I input) {
        this.inputValidator.accept(input);
    }

    @Override
    protected void onMatch(T transition, O output) {
        this.stateManager.onMatch(transition);
        super.onMatch(transition, output);
    }

    @Override
    protected void onNoMatch(NMT noMatchTransition, I input) {
        this.stateManager.onNoMatch(noMatchTransition);
        super.onNoMatch(noMatchTransition, input);
    }

}
