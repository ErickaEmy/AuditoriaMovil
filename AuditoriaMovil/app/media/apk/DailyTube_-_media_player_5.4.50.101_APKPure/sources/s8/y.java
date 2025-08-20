package s8;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
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
import yg.zn;
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
            zn y = zn.y.y(context);
            if (y != null) {
                return new C0212y(y);
            }
            return null;
        }

        public n3() {
        }
    }

    /* renamed from: s8.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0212y extends y {

        /* renamed from: n3  reason: collision with root package name */
        public final yg.zn f13523n3;

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1", f = "MeasurementManagerFutures.kt", l = {161}, m = "invokeSuspend")
        /* renamed from: s8.y$y$a */
        /* loaded from: classes.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ yg.v $request;
            int label;

            public a(yg.v vVar, Continuation<? super a> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(null, continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    this.label = 1;
                    if (znVar.a(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1", f = "MeasurementManagerFutures.kt", l = {141}, m = "invokeSuspend")
        /* renamed from: s8.y$y$gv */
        /* loaded from: classes.dex */
        public static final class gv extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Uri $trigger;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public gv(Uri uri, Continuation<? super gv> continuation) {
                super(2, continuation);
                this.$trigger = uri;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new gv(this.$trigger, continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    Uri uri = this.$trigger;
                    this.label = 1;
                    if (znVar.gv(uri, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((gv) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1", f = "MeasurementManagerFutures.kt", l = {169}, m = "invokeSuspend")
        /* renamed from: s8.y$y$n3 */
        /* loaded from: classes.dex */
        public static final class n3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
            int label;

            public n3(Continuation<? super n3> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new n3(continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    this.label = 1;
                    obj = znVar.n3(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
                return ((n3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {151}, m = "invokeSuspend")
        /* renamed from: s8.y$y$v */
        /* loaded from: classes.dex */
        public static final class v extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ yg.gv $request;
            int label;

            public v(yg.gv gvVar, Continuation<? super v> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new v(null, continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    this.label = 1;
                    if (znVar.v(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((v) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1", f = "MeasurementManagerFutures.kt", l = {122}, m = "invokeSuspend")
        /* renamed from: s8.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0213y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ yg.y $deletionRequest;
            int label;

            public C0213y(yg.y yVar, Continuation<? super C0213y> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0213y(null, continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    this.label = 1;
                    if (znVar.y(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0213y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {133}, m = "invokeSuspend")
        /* renamed from: s8.y$y$zn */
        /* loaded from: classes.dex */
        public static final class zn extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Uri $attributionSource;
            final /* synthetic */ InputEvent $inputEvent;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public zn(Uri uri, InputEvent inputEvent, Continuation<? super zn> continuation) {
                super(2, continuation);
                this.$attributionSource = uri;
                this.$inputEvent = inputEvent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new zn(this.$attributionSource, this.$inputEvent, continuation);
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
                    yg.zn znVar = C0212y.this.f13523n3;
                    Uri uri = this.$attributionSource;
                    InputEvent inputEvent = this.$inputEvent;
                    this.label = 1;
                    if (znVar.zn(uri, inputEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((zn) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C0212y(yg.zn mMeasurementManager) {
            Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
            this.f13523n3 = mMeasurementManager;
        }

        public f1.zn<Unit> a(Uri trigger) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new gv(trigger, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }

        public f1.zn<Unit> fb(yg.gv request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new v(request, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }

        @Override // s8.y
        public f1.zn<Integer> n3() {
            Deferred async$default;
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new n3(null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }

        public f1.zn<Unit> s(yg.v request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new a(request, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }

        public f1.zn<Unit> v(yg.y deletionRequest) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(deletionRequest, "deletionRequest");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C0213y(deletionRequest, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }

        @Override // s8.y
        public f1.zn<Unit> zn(Uri attributionSource, InputEvent inputEvent) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(attributionSource, "attributionSource");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new zn(attributionSource, inputEvent, null), 3, null);
            return e.n3.zn(async$default, null, 1, null);
        }
    }

    public static final y y(Context context) {
        return y.y(context);
    }

    public abstract f1.zn<Integer> n3();

    public abstract f1.zn<Unit> zn(Uri uri, InputEvent inputEvent);
}
