package kotlinx.coroutines.reactive;

import he1.y;
import kotlin.coroutines.CoroutineContext;
/* loaded from: classes.dex */
public interface ContextInjector {
    <T> y<T> injectCoroutineContext(y<T> yVar, CoroutineContext coroutineContext);
}
