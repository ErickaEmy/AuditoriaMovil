package rb;

import com.uv.v7.R;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import rb.p;
/* loaded from: classes.dex */
public final class a {
    public static final y y = new y(null);

    /* loaded from: classes.dex */
    public static final class y {

        /* JADX INFO: Add missing generic type declarations: [R] */
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {R.styleable.AppCompatTheme_textColorAlertDialogListItem}, m = "invokeSuspend")
        /* renamed from: rb.a$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0195y<R> extends SuspendLambda implements Function2<FlowCollector<R>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ i4 $db;
            final /* synthetic */ boolean $inTransaction;
            final /* synthetic */ String[] $tableNames;
            private /* synthetic */ Object L$0;
            int label;

            @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {136}, m = "invokeSuspend")
            /* renamed from: rb.a$y$y$y  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0196y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ FlowCollector<R> $$this$flow;
                final /* synthetic */ Callable<R> $callable;
                final /* synthetic */ i4 $db;
                final /* synthetic */ boolean $inTransaction;
                final /* synthetic */ String[] $tableNames;
                private /* synthetic */ Object L$0;
                int label;

                /* renamed from: rb.a$y$y$y$n3 */
                /* loaded from: classes.dex */
                public static final class n3 extends p.zn {

                    /* renamed from: n3  reason: collision with root package name */
                    public final /* synthetic */ Channel<Unit> f13147n3;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public n3(String[] strArr, Channel<Unit> channel) {
                        super(strArr);
                        this.f13147n3 = channel;
                    }

                    @Override // rb.p.zn
                    public void zn(Set<String> tables) {
                        Intrinsics.checkNotNullParameter(tables, "tables");
                        this.f13147n3.mo85trySendJP2dKIU(Unit.INSTANCE);
                    }
                }

                @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {127, 129}, m = "invokeSuspend")
                /* renamed from: rb.a$y$y$y$y  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C0197y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Callable<R> $callable;
                    final /* synthetic */ i4 $db;
                    final /* synthetic */ n3 $observer;
                    final /* synthetic */ Channel<Unit> $observerChannel;
                    final /* synthetic */ Channel<R> $resultChannel;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0197y(i4 i4Var, n3 n3Var, Channel<Unit> channel, Callable<R> callable, Channel<R> channel2, Continuation<? super C0197y> continuation) {
                        super(2, continuation);
                        this.$db = i4Var;
                        this.$observer = n3Var;
                        this.$observerChannel = channel;
                        this.$callable = callable;
                        this.$resultChannel = channel2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0197y(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:20:0x0047 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:7:0x0012, B:18:0x003d, B:22:0x004b, B:24:0x0053, B:14:0x0025, B:17:0x0037), top: B:31:0x0008 }] */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:8:0x0015). Please submit an issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                        /*
                            r6 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r6.label
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L29
                            if (r1 == r3) goto L21
                            if (r1 != r2) goto L19
                            java.lang.Object r1 = r6.L$0
                            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L17
                        L15:
                            r7 = r1
                            goto L3d
                        L17:
                            r7 = move-exception
                            goto L77
                        L19:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L21:
                            java.lang.Object r1 = r6.L$0
                            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L17
                            goto L4b
                        L29:
                            kotlin.ResultKt.throwOnFailure(r7)
                            rb.i4 r7 = r6.$db
                            rb.p r7 = r7.getInvalidationTracker()
                            rb.a$y$y$y$n3 r1 = r6.$observer
                            r7.n3(r1)
                            kotlinx.coroutines.channels.Channel<kotlin.Unit> r7 = r6.$observerChannel     // Catch: java.lang.Throwable -> L17
                            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L17
                        L3d:
                            r6.L$0 = r7     // Catch: java.lang.Throwable -> L17
                            r6.label = r3     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r1 = r7.hasNext(r6)     // Catch: java.lang.Throwable -> L17
                            if (r1 != r0) goto L48
                            return r0
                        L48:
                            r5 = r1
                            r1 = r7
                            r7 = r5
                        L4b:
                            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L17
                            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L17
                            if (r7 == 0) goto L69
                            r1.next()     // Catch: java.lang.Throwable -> L17
                            java.util.concurrent.Callable<R> r7 = r6.$callable     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r7 = r7.call()     // Catch: java.lang.Throwable -> L17
                            kotlinx.coroutines.channels.Channel<R> r4 = r6.$resultChannel     // Catch: java.lang.Throwable -> L17
                            r6.L$0 = r1     // Catch: java.lang.Throwable -> L17
                            r6.label = r2     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r7 = r4.send(r7, r6)     // Catch: java.lang.Throwable -> L17
                            if (r7 != r0) goto L15
                            return r0
                        L69:
                            rb.i4 r7 = r6.$db
                            rb.p r7 = r7.getInvalidationTracker()
                            rb.a$y$y$y$n3 r0 = r6.$observer
                            r7.xc(r0)
                            kotlin.Unit r7 = kotlin.Unit.INSTANCE
                            return r7
                        L77:
                            rb.i4 r0 = r6.$db
                            rb.p r0 = r0.getInvalidationTracker()
                            rb.a$y$y$y$n3 r1 = r6.$observer
                            r0.xc(r1)
                            throw r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: rb.a.y.C0195y.C0196y.C0197y.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0197y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0196y(boolean z2, i4 i4Var, FlowCollector<R> flowCollector, String[] strArr, Callable<R> callable, Continuation<? super C0196y> continuation) {
                    super(2, continuation);
                    this.$inTransaction = z2;
                    this.$db = i4Var;
                    this.$$this$flow = flowCollector;
                    this.$tableNames = strArr;
                    this.$callable = callable;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0196y c0196y = new C0196y(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, continuation);
                    c0196y.L$0 = obj;
                    return c0196y;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ContinuationInterceptor y;
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
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        Channel Channel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
                        n3 n3Var = new n3(this.$tableNames, Channel$default);
                        Channel$default.mo85trySendJP2dKIU(Unit.INSTANCE);
                        ej ejVar = (ej) coroutineScope.getCoroutineContext().get(ej.f13163v);
                        if (ejVar == null || (y = ejVar.y()) == null) {
                            if (this.$inTransaction) {
                                y = fb.n3(this.$db);
                            } else {
                                y = fb.y(this.$db);
                            }
                        }
                        Channel Channel$default2 = ChannelKt.Channel$default(0, null, null, 7, null);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, y, null, new C0197y(this.$db, n3Var, Channel$default, this.$callable, Channel$default2, null), 2, null);
                        FlowCollector<R> flowCollector = this.$$this$flow;
                        this.label = 1;
                        if (FlowKt.emitAll(flowCollector, Channel$default2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0196y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0195y(boolean z2, i4 i4Var, String[] strArr, Callable<R> callable, Continuation<? super C0195y> continuation) {
                super(2, continuation);
                this.$inTransaction = z2;
                this.$db = i4Var;
                this.$tableNames = strArr;
                this.$callable = callable;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0195y c0195y = new C0195y(this.$inTransaction, this.$db, this.$tableNames, this.$callable, continuation);
                c0195y.L$0 = obj;
                return c0195y;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
                return invoke((FlowCollector) ((FlowCollector) obj), continuation);
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
                    C0196y c0196y = new C0196y(this.$inTransaction, this.$db, (FlowCollector) this.L$0, this.$tableNames, this.$callable, null);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c0196y, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invoke(FlowCollector<R> flowCollector, Continuation<? super Unit> continuation) {
                return ((C0195y) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <R> Flow<R> y(i4 db, boolean z2, String[] tableNames, Callable<R> callable) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return FlowKt.flow(new C0195y(z2, db, tableNames, callable, null));
        }

        public y() {
        }
    }

    public static final <R> Flow<R> y(i4 i4Var, boolean z2, String[] strArr, Callable<R> callable) {
        return y.y(i4Var, z2, strArr, callable);
    }
}
