package com.jessebrault.fsm.impl.coremachines;

import com.jessebrault.fsm.coremachines.builder.OnNoMatchConfigurator;
import com.jessebrault.fsm.coremachines.builder.StateConfigurator;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public abstract class AbstractStateConfigurator<
        I, S, C, O,
        AON extends AbstractOnConfigurator<S, O, AON>,
        AONM extends AbstractOnNoMatchConfigurator<I, S, AONM>
        > implements StateConfigurator<I, S, C, O, AON, AONM> {

    private final Supplier<AON> onConfiguratorSupplier;
    private final AONM onNoMatchConfigurator;
    private final Set<Transition<S, C, O>> transitions = new HashSet<>();

    private C curOnCondition;
    private AON curOnConfigurator;

    public AbstractStateConfigurator(Supplier<AON> onConfiguratorSupplier, AONM onNoMatchConfigurator) {
        this.onConfiguratorSupplier = onConfiguratorSupplier;
        this.onNoMatchConfigurator = onNoMatchConfigurator;
    }

    private void flush() {
        if (this.curOnCondition != null) {
            transitions.add(new Transition<>(
                    this.curOnCondition, this.curOnConfigurator.getShiftTo(), this.curOnConfigurator.getActions()
            ));
        }
        this.curOnCondition = null;
        this.curOnConfigurator = null;
    }

    public final TransitionSet<I, S, C, O> getTransitionSet() {
        this.flush();
        return new TransitionSet<>(
                this.transitions, this.onNoMatchConfigurator.getShiftTo(), this.onNoMatchConfigurator.getActions()
        );
    }

    @Override
    public final AON on(C condition) {
        this.flush();
        this.curOnCondition = condition;
        this.curOnConfigurator = this.onConfiguratorSupplier.get();
        return this.curOnConfigurator;
    }

    @Override
    public final AONM onNoMatch() {
        return this.onNoMatchConfigurator;
    }

}
