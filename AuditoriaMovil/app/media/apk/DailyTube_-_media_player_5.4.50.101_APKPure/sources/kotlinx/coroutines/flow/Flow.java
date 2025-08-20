package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface Flow<T> {
    Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
