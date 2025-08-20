package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface FlowCollector<T> {
    Object emit(T t2, Continuation<? super Unit> continuation);
}
