package y5;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* loaded from: classes.dex */
public final class f3<T> implements i4<T> {

    /* renamed from: n3  reason: collision with root package name */
    public gv<T> f15286n3;
    public final CoroutineContext y;

    @DebugMetadata(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(Object obj, Continuation continuation) {
            super(2, continuation);
            this.$value = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new y(this.$value, completion);
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
                gv<T> y = f3.this.y();
                this.label = 1;
                if (y.co(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            f3.this.y().xc((T) this.$value);
            return Unit.INSTANCE;
        }
    }

    public f3(gv<T> target, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15286n3 = target;
        this.y = context.plus(Dispatchers.getMain().getImmediate());
    }

    @Override // y5.i4
    public Object emit(T t2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.y, new y(t2, null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final gv<T> y() {
        return this.f15286n3;
    }
}
