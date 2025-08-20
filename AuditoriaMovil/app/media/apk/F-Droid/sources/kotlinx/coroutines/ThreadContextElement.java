package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: ThreadContextElement.kt */
/* loaded from: classes2.dex */
public interface ThreadContextElement extends CoroutineContext.Element {
    void restoreThreadContext(CoroutineContext coroutineContext, Object obj);

    Object updateThreadContext(CoroutineContext coroutineContext);
}
