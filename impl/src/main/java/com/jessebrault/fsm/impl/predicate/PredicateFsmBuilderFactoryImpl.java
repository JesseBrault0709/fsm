package com.jessebrault.fsm.impl.predicate;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.predicate.PredicateFsmBuilder;

@AutoService(PredicateFsmBuilder.Factory.class)
public final class PredicateFsmBuilderFactoryImpl implements PredicateFsmBuilder.Factory {

    @Override
    public <I, S> PredicateFsmBuilder<I, S> getBuilder() {
        return new PredicateFsmBuilderImpl<>();
    }

}
