package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: CoroutineLiveData.kt */
/* loaded from: classes.dex */
public final class LiveDataScopeImpl implements LiveDataScope {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData target;

    public final CoroutineLiveData getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public LiveDataScopeImpl(CoroutineLiveData target, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(Dispatchers.getMain().getImmediate());
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emit(Object obj, Continuation continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, obj, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }
}
