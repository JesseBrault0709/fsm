package com.jessebrault.fsm.impl.coremachines.function;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.coremachines.function.FunctionFsmBuilder;

@AutoService(FunctionFsmBuilder.Service.class)
public final class FunctionFsmBuilderServiceImpl implements FunctionFsmBuilder.Service {

    @Override
    public <I, S, O> FunctionFsmBuilder<I, S, O> getBuilder() {
        return new FunctionFsmBuilderImpl<>();
    }

}
