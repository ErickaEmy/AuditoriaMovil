package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    private final Continuation<Unit> continuation;

    public LazyDeferredCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }
}
