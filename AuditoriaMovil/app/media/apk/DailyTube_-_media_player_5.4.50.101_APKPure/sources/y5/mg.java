package y5;

import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
/* loaded from: classes.dex */
public final class mg {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {162}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class y<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2 $block;
        final /* synthetic */ v.zn $minState;
        final /* synthetic */ androidx.lifecycle.v $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(androidx.lifecycle.v vVar, v.zn znVar, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_whenStateAtLeast = vVar;
            this.$minState = znVar;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            y yVar = new y(this.$this_whenStateAtLeast, this.$minState, this.$block, completion);
            yVar.L$0 = obj;
            return yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((y) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LifecycleController lifecycleController;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    lifecycleController = (LifecycleController) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th) {
                        th = th;
                        lifecycleController.zn();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Job job = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
                if (job != null) {
                    rz rzVar = new rz();
                    LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, rzVar.y, job);
                    try {
                        Function2 function2 = this.$block;
                        this.L$0 = lifecycleController2;
                        this.label = 1;
                        obj = BuildersKt.withContext(rzVar, function2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lifecycleController = lifecycleController2;
                    } catch (Throwable th2) {
                        th = th2;
                        lifecycleController = lifecycleController2;
                        lifecycleController.zn();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("when[State] methods should have a parent job");
                }
            }
            lifecycleController.zn();
            return obj;
        }
    }

    public static final <T> Object gv(androidx.lifecycle.v vVar, v.zn znVar, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new y(vVar, znVar, function2, null), continuation);
    }

    public static final <T> Object n3(androidx.lifecycle.v vVar, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return gv(vVar, v.zn.RESUMED, function2, continuation);
    }

    public static final <T> Object y(androidx.lifecycle.v vVar, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return gv(vVar, v.zn.CREATED, function2, continuation);
    }

    public static final <T> Object zn(androidx.lifecycle.v vVar, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return gv(vVar, v.zn.STARTED, function2, continuation);
    }
}
