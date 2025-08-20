package y5;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
/* loaded from: classes.dex */
public final class n3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f15292a;

    /* renamed from: fb  reason: collision with root package name */
    public final Function0<Unit> f15293fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Function2<i4<T>, Continuation<? super Unit>, Object> f15294gv;

    /* renamed from: n3  reason: collision with root package name */
    public Job f15295n3;

    /* renamed from: v  reason: collision with root package name */
    public final long f15296v;
    public Job y;

    /* renamed from: zn  reason: collision with root package name */
    public final gv<T> f15297zn;

    @DebugMetadata(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {176}, m = "invokeSuspend")
    /* renamed from: y5.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0253n3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C0253n3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C0253n3 c0253n3 = new C0253n3(completion);
            c0253n3.L$0 = obj;
            return c0253n3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0253n3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                f3 f3Var = new f3(n3.this.f15297zn, ((CoroutineScope) this.L$0).getCoroutineContext());
                Function2 function2 = n3.this.f15294gv;
                this.label = 1;
                if (function2.invoke(f3Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            n3.this.f15293fb.invoke();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {187}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public y(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new y(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long j2 = n3.this.f15296v;
                this.label = 1;
                if (DelayKt.delay(j2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!n3.this.f15297zn.fb()) {
                Job job = n3.this.y;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                n3.this.y = null;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n3(gv<T> liveData, Function2<? super i4<T>, ? super Continuation<? super Unit>, ? extends Object> block, long j2, CoroutineScope scope, Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.f15297zn = liveData;
        this.f15294gv = block;
        this.f15296v = j2;
        this.f15292a = scope;
        this.f15293fb = onDone;
    }

    public final void fb() {
        Job launch$default;
        if (this.f15295n3 == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.f15292a, Dispatchers.getMain().getImmediate(), null, new y(null), 2, null);
            this.f15295n3 = launch$default;
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
    }

    public final void s() {
        Job launch$default;
        Job job = this.f15295n3;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.f15295n3 = null;
        if (this.y == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.f15292a, null, null, new C0253n3(null), 3, null);
            this.y = launch$default;
        }
    }
}
