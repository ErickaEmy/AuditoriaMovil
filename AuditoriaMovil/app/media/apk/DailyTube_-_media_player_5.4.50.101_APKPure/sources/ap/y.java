package ap;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import yc.a;
import yc.zn;
/* loaded from: classes.dex */
public abstract class y {
    public static final n3 y = new n3(null);

    /* loaded from: classes.dex */
    public static final class n3 {
        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final y y(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            a y = a.y.y(context);
            if (y != null) {
                return new C0033y(y);
            }
            return null;
        }

        public n3() {
        }
    }

    /* renamed from: ap.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0033y extends y {

        /* renamed from: n3  reason: collision with root package name */
        public final a f3814n3;

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {56}, m = "invokeSuspend")
        /* renamed from: ap.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0034y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super zn>, Object> {
            final /* synthetic */ yc.n3 $request;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0034y(yc.n3 n3Var, Continuation<? super C0034y> continuation) {
                super(2, continuation);
                this.$request = n3Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0034y(this.$request, continuation);
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
                    a aVar = C0033y.this.f3814n3;
                    yc.n3 n3Var = this.$request;
                    this.label = 1;
                    obj = aVar.y(n3Var, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super zn> continuation) {
                return ((C0034y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C0033y(a mTopicsManager) {
            Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
            this.f3814n3 = mTopicsManager;
        }

        @Override // ap.y
        public f1.zn<zn> n3(yc.n3 request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0034y(request, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }
    }

    public static final y y(Context context) {
        return y.y(context);
    }

    public abstract f1.zn<zn> n3(yc.n3 n3Var);
}
