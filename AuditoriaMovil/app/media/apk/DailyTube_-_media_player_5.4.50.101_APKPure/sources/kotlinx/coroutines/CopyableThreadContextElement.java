package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* loaded from: classes.dex */
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {
    CopyableThreadContextElement<S> copyForChild();

    CoroutineContext mergeForChild(CoroutineContext.Element element);
}
