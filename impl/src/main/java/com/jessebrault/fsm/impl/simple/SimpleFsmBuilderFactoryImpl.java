package com.jessebrault.fsm.impl.simple;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.simple.SimpleFsmBuilder;

@AutoService(SimpleFsmBuilder.Factory.class)
public final class SimpleFsmBuilderFactoryImpl implements SimpleFsmBuilder.Factory {

    @Override
    public <I, S> SimpleFsmBuilder<I, S> getBuilder() {
        return new SimpleFsmBuilderImpl<>();
    }

}
