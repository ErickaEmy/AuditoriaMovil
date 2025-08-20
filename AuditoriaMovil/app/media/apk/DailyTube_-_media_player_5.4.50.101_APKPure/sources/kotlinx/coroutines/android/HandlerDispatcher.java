package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
/* loaded from: classes.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public DisposableHandle invokeOnTimeout(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j2, runnable, coroutineContext);
    }

    private HandlerDispatcher() {
    }
}
