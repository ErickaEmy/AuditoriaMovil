package androidx.lifecycle;

import androidx.lifecycle.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import y5.co;
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends y5.tl implements a {

    /* renamed from: v  reason: collision with root package name */
    public final CoroutineContext f2584v;
    public final v y;

    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public y(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            y yVar = new y(completion);
            yVar.L$0 = obj;
            return yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (LifecycleCoroutineScopeImpl.this.y().n3().compareTo(v.zn.INITIALIZED) < 0) {
                    JobKt__JobKt.cancel$default(coroutineScope.getCoroutineContext(), null, 1, null);
                } else {
                    LifecycleCoroutineScopeImpl.this.y().y(LifecycleCoroutineScopeImpl.this);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LifecycleCoroutineScopeImpl(v lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.y = lifecycle;
        this.f2584v = coroutineContext;
        if (y().n3() == v.zn.DESTROYED) {
            JobKt__JobKt.cancel$default(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f2584v;
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(co source, v.n3 event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (y().n3().compareTo(v.zn.DESTROYED) <= 0) {
            y().zn(this);
            JobKt__JobKt.cancel$default(getCoroutineContext(), null, 1, null);
        }
    }

    public final void v() {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().getImmediate(), null, new y(null), 2, null);
    }

    @Override // y5.tl
    public v y() {
        return this.y;
    }
}
