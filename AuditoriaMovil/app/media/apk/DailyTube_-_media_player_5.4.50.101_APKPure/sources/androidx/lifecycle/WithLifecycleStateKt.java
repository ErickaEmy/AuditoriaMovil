package androidx.lifecycle;

import androidx.lifecycle.v;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import y5.co;
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Function0 $block$inlined;
        final /* synthetic */ boolean $dispatchNeeded$inlined;
        final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
        final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 $observer;
        final /* synthetic */ v.zn $state$inlined;
        final /* synthetic */ v $this_suspendWithStateAtLeastUnchecked$inlined;

        /* loaded from: classes.dex */
        public static final class y implements Runnable {
            public y() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                n3 n3Var = n3.this;
                n3Var.$this_suspendWithStateAtLeastUnchecked$inlined.zn(n3Var.$observer);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, v vVar, v.zn znVar, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
            super(1);
            this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1;
            this.$this_suspendWithStateAtLeastUnchecked$inlined = vVar;
            this.$state$inlined = znVar;
            this.$block$inlined = function0;
            this.$dispatchNeeded$inlined = z2;
            this.$lifecycleDispatcher$inlined = coroutineDispatcher;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher$inlined;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
                this.$lifecycleDispatcher$inlined.mo109dispatch(emptyCoroutineContext, new y());
            } else {
                this.$this_suspendWithStateAtLeastUnchecked$inlined.zn(this.$observer);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f2610f;

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ v.zn f2611fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ Function0 f2612s;

        /* renamed from: t  reason: collision with root package name */
        public final /* synthetic */ CoroutineDispatcher f2613t;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ v f2614v;
        public final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 y;

        public y(WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, v vVar, v.zn znVar, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
            this.y = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1;
            this.f2614v = vVar;
            this.f2611fb = znVar;
            this.f2612s = function0;
            this.f2610f = z2;
            this.f2613t = coroutineDispatcher;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2614v.y(this.y);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, y5.mt] */
    public static final <R> Object y(final v vVar, final v.zn znVar, final boolean z2, final CoroutineDispatcher coroutineDispatcher, final Function0<? extends R> function0, Continuation<? super R> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ?? r15 = new a() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.lifecycle.a
            public void onStateChanged(co source, v.n3 event) {
                Object m28constructorimpl;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == v.n3.a(znVar)) {
                    vVar.zn(this);
                    CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                    Function0 function02 = function0;
                    try {
                        Result.Companion companion = Result.Companion;
                        m28constructorimpl = Result.m28constructorimpl(function02.invoke());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                    }
                    cancellableContinuation.resumeWith(m28constructorimpl);
                } else if (event == v.n3.ON_DESTROY) {
                    vVar.zn(this);
                    CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                    y5.wz wzVar = new y5.wz();
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuation2.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(wzVar)));
                }
            }
        };
        if (z2) {
            coroutineDispatcher.mo109dispatch(EmptyCoroutineContext.INSTANCE, new y(r15, vVar, znVar, function0, z2, coroutineDispatcher));
        } else {
            vVar.y(r15);
        }
        cancellableContinuationImpl.invokeOnCancellation(new n3(r15, vVar, znVar, function0, z2, coroutineDispatcher));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
