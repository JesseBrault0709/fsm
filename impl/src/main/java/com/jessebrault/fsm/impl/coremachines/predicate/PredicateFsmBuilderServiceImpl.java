package com.jessebrault.fsm.impl.coremachines.predicate;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.coremachines.predicate.PredicateFsmBuilder;

@AutoService(PredicateFsmBuilder.Service.class)
public final class PredicateFsmBuilderServiceImpl implements PredicateFsmBuilder.Service {

    @Override
    public <I, S> PredicateFsmBuilder<I, S> getBuilder() {
        return new PredicateFsmBuilderImpl<>();
    }

}
