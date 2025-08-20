package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PipelineContext.kt */
/* loaded from: classes.dex */
public abstract class PipelineContext implements CoroutineScope {
    private final Object context;

    public abstract Object execute$ktor_utils(Object obj, Continuation continuation);

    public final Object getContext() {
        return this.context;
    }

    public abstract Object proceed(Continuation continuation);

    public abstract Object proceedWith(Object obj, Continuation continuation);

    public PipelineContext(Object context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}
