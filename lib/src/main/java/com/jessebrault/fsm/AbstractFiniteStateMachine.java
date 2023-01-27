package com.jessebrault.fsm;

import com.jessebrault.fsm.components.NoMatchTransition;
import com.jessebrault.fsm.components.StateGrammar;
import com.jessebrault.fsm.components.Transition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractFiniteStateMachine<
        I, S, O, C,
        SG extends StateGrammar<I, S, O, C, T, NMT>,
        T extends Transition<S, O, C>,
        NMT extends NoMatchTransition<I, S, O>
        > implements FiniteStateMachine<I, S, O> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractFiniteStateMachine.class);
    private static final Marker flow = MarkerFactory.getMarker("FLOW");
    private static final Marker enter = MarkerFactory.getMarker("ENTER");
    private static final Marker exit = MarkerFactory.getMarker("EXIT");

    private final Map<S, SG> grammar;

    public AbstractFiniteStateMachine(Map<S, SG> grammar) {
        Objects.requireNonNull(grammar);
        this.grammar = grammar;
    }

    /**
     * Validates the input.
     *
     * @param input the input passed to {@link #apply(I input)}
     * @implNote Overriding methods do not need to call <code>super.validateInput</code>,
     * as it (currently) does nothing.
     */
    protected void validateInput(@Nullable I input) {
        logger.trace(flow, "(no-op) input: {}", input);
    }

    protected abstract @Nullable O test(@NotNull C on, @Nullable I input);

    protected abstract void shiftTo(@Nullable S state);

    /**
     * Calls {@link #shiftTo(S state)}, then iterates through all of the output
     * consumers in the given transition, supplying each with the output.
     *
     * @param transition the matched transition
     * @param output the output produced by the {@link #test(C on, I input)} method
     *
     * @implNote While not required, overriding methods should call
     * <code>super.onMatch()</code> in order to ensure proper handling of shifting
     * and outputConsumers.
     */
    protected void onMatch(T transition, O output) {
        logger.trace(enter, "transition: {}, output: {}", transition, output);
        this.shiftTo(transition.shiftTo());
        transition.outputConsumers().forEach(outputConsumer -> outputConsumer.accept(output));
        logger.trace(exit, "");
    }

    /**
     * Calls {@link #shiftTo(S state)}, then iterates through all of the input
     * consumers in the given noMatchTransition, supplying each with the input.
     *
     * @param noMatchTransition the NoMatchTransition
     * @param input the input passed to {@link #apply(I input)}
     *
     * @implNote While not required, overriding methods should call
     * <code>super.onNoMatch()</code> in order to ensure proper handling of shifting
     * and outputConsumers.
     */
    protected void onNoMatch(NMT noMatchTransition, I input) {
        logger.trace(enter, "noMatchTransition: {}, input: {}", noMatchTransition, input);
        this.shiftTo(noMatchTransition.shiftTo());
        noMatchTransition.inputConsumers().forEach(inputConsumer -> inputConsumer.accept(input));
        logger.trace(exit, "");
    }

    @Override
    public final @Nullable O apply(I input) {
        logger.trace(enter, "input: {}", input);
        this.validateInput(input);
        final var stateGrammar = this.grammar.get(this.getCurrentState());
        if (stateGrammar == null) {
            throw new IllegalStateException("there is no stateGrammar defined for the currentState");
        }
        for (final var transition : stateGrammar.transitions()) {
            final var output = this.test(transition.on(), input);
            if (output != null) {
                logger.debug("matched {}, output: {}", transition.on(), output);
                this.onMatch(transition, output);
                logger.trace(exit, "output: {}", output);
                return output;
            }
        }
        final var noMatchTransition = stateGrammar.noMatchTransition();
        this.onNoMatch(noMatchTransition, input);
        O output = null;
        final var instead = noMatchTransition.instead();
        if (instead != null) {
            output = instead.apply(input);
            logger.trace(exit, "output: {}", output);
        }
        logger.trace(exit, "output: {}", output);
        return output;
    }

}
