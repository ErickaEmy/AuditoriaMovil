package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
/* compiled from: Flow.kt */
/* loaded from: classes2.dex */
public interface Flow {
    Object collect(FlowCollector flowCollector, Continuation continuation);
}
