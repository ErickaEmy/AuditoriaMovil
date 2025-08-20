package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T> {
    public DeferredCoroutine(CoroutineContext coroutineContext, boolean z2) {
        super(coroutineContext, true, z2);
    }

    public static /* synthetic */ <T> Object await$suspendImpl(DeferredCoroutine<T> deferredCoroutine, Continuation<? super T> continuation) {
        Object awaitInternal = deferredCoroutine.awaitInternal(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitInternal;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation<? super T> continuation) {
        return await$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }
}
