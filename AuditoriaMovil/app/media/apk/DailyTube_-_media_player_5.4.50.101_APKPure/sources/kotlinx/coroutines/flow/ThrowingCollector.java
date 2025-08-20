package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public final class ThrowingCollector implements FlowCollector<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f9986e;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation<? super Unit> continuation) {
        throw this.f9986e;
    }
}
