package kotlinx.coroutines.selects;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
/* loaded from: classes.dex */
public interface SelectInstance<R> {
    void disposeOnCompletion(DisposableHandle disposableHandle);

    CoroutineContext getContext();

    void selectInRegistrationPhase(Object obj);

    boolean trySelect(Object obj, Object obj2);
}
