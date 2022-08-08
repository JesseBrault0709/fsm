package com.jessebrault.fsm.impl.function;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.function.FunctionFsmBuilder;

@AutoService(FunctionFsmBuilder.Factory.class)
public final class FunctionFsmBuilderFactoryImpl implements FunctionFsmBuilder.Factory {

    @Override
    public <I, S, R> FunctionFsmBuilder<I, S, R> getBuilder() {
        return new FunctionFsmBuilderImpl<>();
    }

}
