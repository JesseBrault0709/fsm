package com.jessebrault.fsm.impl.coremachines.simple;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.coremachines.simple.SimpleFsmBuilder;

@AutoService(SimpleFsmBuilder.Service.class)
public final class SimpleFsmBuilderServiceImpl implements SimpleFsmBuilder.Service {

    @Override
    public <I, S> SimpleFsmBuilder<I, S> getBuilder() {
        return new SimpleFsmBuilderImpl<>();
    }

}
