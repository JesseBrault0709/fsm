package com.jessebrault.fsm.impl.simple;

import com.jessebrault.fsm.impl.AbstractTransitionSetBuilder;
import com.jessebrault.fsm.simple.SimpleTransitionSetBuilder;

final class SimpleTransitionSetBuilderImpl<I, S> extends AbstractTransitionSetBuilder<I, S, I, I>
        implements SimpleTransitionSetBuilder<I, S> {}
