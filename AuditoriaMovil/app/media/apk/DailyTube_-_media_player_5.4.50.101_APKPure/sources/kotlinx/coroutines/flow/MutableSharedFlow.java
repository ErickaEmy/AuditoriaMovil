package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface MutableSharedFlow<T> extends SharedFlow<T>, FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    Object emit(T t2, Continuation<? super Unit> continuation);

    StateFlow<Integer> getSubscriptionCount();

    void resetReplayCache();

    boolean tryEmit(T t2);
}
