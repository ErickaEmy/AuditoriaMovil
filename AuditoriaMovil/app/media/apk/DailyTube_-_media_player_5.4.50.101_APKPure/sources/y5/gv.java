package y5;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* loaded from: classes.dex */
public final class gv<T> extends n<T> {

    /* renamed from: tl  reason: collision with root package name */
    public y5.n3<T> f15287tl;

    /* renamed from: wz  reason: collision with root package name */
    public c5 f15288wz;

    @DebugMetadata(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {234}, m = "clearSource$lifecycle_livedata_ktx_release")
    /* loaded from: classes.dex */
    public static final class n3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public n3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return gv.this.co(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function0<Unit> {
        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            gv.this.f15287tl = null;
        }
    }

    public gv(CoroutineContext context, long j2, Function2<? super i4<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.f15287tl = new y5.n3<>(this, block, j2, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(context).plus(SupervisorKt.SupervisorJob((Job) context.get(Job.Key)))), new y());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object co(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof y5.gv.n3
            if (r0 == 0) goto L13
            r0 = r5
            y5.gv$n3 r0 = (y5.gv.n3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            y5.gv$n3 r0 = new y5.gv$n3
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r0 = r0.L$0
            y5.gv r0 = (y5.gv) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L38
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r5)
            r0 = r4
        L38:
            r5 = 0
            r0.f15288wz = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.gv.co(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // y5.n, androidx.lifecycle.LiveData
    public void f() {
        super.f();
        y5.n3<T> n3Var = this.f15287tl;
        if (n3Var != null) {
            n3Var.fb();
        }
    }

    @Override // y5.n, androidx.lifecycle.LiveData
    public void i9() {
        super.i9();
        y5.n3<T> n3Var = this.f15287tl;
        if (n3Var != null) {
            n3Var.s();
        }
    }
}
