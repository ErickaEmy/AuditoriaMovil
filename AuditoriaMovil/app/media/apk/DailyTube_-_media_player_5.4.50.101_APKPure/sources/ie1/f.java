package ie1;

import com.uv.v7.R;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
/* loaded from: classes.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements ie1.gv<T> {
        public final /* synthetic */ CancellableContinuation y;

        public a(CancellableContinuation cancellableContinuation) {
            this.y = cancellableContinuation;
        }

        @Override // ie1.gv
        public void n3(ie1.n3<T> call, Throwable t2) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t2, "t");
            CancellableContinuation cancellableContinuation = this.y;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(t2)));
        }

        @Override // ie1.gv
        public void y(ie1.n3<T> call, mt<T> response) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            this.y.resumeWith(Result.m28constructorimpl(response));
        }
    }

    /* loaded from: classes.dex */
    public static final class fb implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Exception f9198v;
        public final /* synthetic */ Continuation y;

        public fb(Continuation continuation, Exception exc) {
            this.y = continuation;
            this.f9198v = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation intercepted = IntrinsicsKt.intercepted(this.y);
            Exception exc = this.f9198v;
            Result.Companion companion = Result.Companion;
            intercepted.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class gv<T> implements ie1.gv<T> {
        public final /* synthetic */ CancellableContinuation y;

        public gv(CancellableContinuation cancellableContinuation) {
            this.y = cancellableContinuation;
        }

        @Override // ie1.gv
        public void n3(ie1.n3<T> call, Throwable t2) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t2, "t");
            CancellableContinuation cancellableContinuation = this.y;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(t2)));
        }

        @Override // ie1.gv
        public void y(ie1.n3<T> call, mt<T> response) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            if (response.gv()) {
                this.y.resumeWith(Result.m28constructorimpl(response.y()));
                return;
            }
            CancellableContinuation cancellableContinuation = this.y;
            ie1.s sVar = new ie1.s(response);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(sVar)));
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ie1.n3 $this_await$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(ie1.n3 n3Var) {
            super(1);
            this.$this_await$inlined = n3Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_await$inlined.cancel();
        }
    }

    @DebugMetadata(c = "retrofit2/KotlinExtensions", f = "KotlinExtensions.kt", l = {R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 119}, m = "suspendAndThrow")
    /* loaded from: classes.dex */
    public static final class s extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public s(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.gv(null, this);
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ie1.n3 $this_awaitResponse$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ie1.n3 n3Var) {
            super(1);
            this.$this_awaitResponse$inlined = n3Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_awaitResponse$inlined.cancel();
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ie1.n3 $this_await$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(ie1.n3 n3Var) {
            super(1);
            this.$this_await$inlined = n3Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_await$inlined.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class zn<T> implements ie1.gv<T> {
        public final /* synthetic */ CancellableContinuation y;

        public zn(CancellableContinuation cancellableContinuation) {
            this.y = cancellableContinuation;
        }

        @Override // ie1.gv
        public void n3(ie1.n3<T> call, Throwable t2) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t2, "t");
            CancellableContinuation cancellableContinuation = this.y;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(t2)));
        }

        @Override // ie1.gv
        public void y(ie1.n3<T> call, mt<T> response) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            if (response.gv()) {
                T y = response.y();
                if (y == null) {
                    Object f4 = call.y().f(i9.class);
                    if (f4 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(f4, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((i9) f4).y();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    Intrinsics.checkExpressionValueIsNotNull(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                    CancellableContinuation cancellableContinuation = this.y;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                    return;
                }
                this.y.resumeWith(Result.m28constructorimpl(y));
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.y;
            ie1.s sVar = new ie1.s(response);
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(sVar)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object gv(java.lang.Exception r4, kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof ie1.f.s
            if (r0 == 0) goto L13
            r0 = r5
            ie1.f$s r0 = (ie1.f.s) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ie1.f$s r0 = new ie1.f$s
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            boolean r4 = r5 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L2e
            goto L63
        L2e:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L66
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            ie1.f$fb r3 = new ie1.f$fb
            r3.<init>(r0, r4)
            r5.mo109dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L60
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L60:
            if (r4 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L66:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ie1.f.gv(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> Object n3(ie1.n3<T> n3Var, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new n3(n3Var));
        n3Var.r(new gv(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object y(ie1.n3<T> n3Var, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new y(n3Var));
        n3Var.r(new zn(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object zn(ie1.n3<T> n3Var, Continuation<? super mt<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new v(n3Var));
        n3Var.r(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
