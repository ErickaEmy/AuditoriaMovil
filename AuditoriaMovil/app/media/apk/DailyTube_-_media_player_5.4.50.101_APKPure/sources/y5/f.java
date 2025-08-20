package y5;

import androidx.lifecycle.LiveData;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* loaded from: classes.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {149}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class n3<T> extends SuspendLambda implements Function2<i4<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* loaded from: classes.dex */
        public static final class y implements FlowCollector<T> {
            public final /* synthetic */ i4 y;

            public y(i4 i4Var) {
                this.y = i4Var;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                Object emit = this.y.emit(obj, continuation);
                if (emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(Flow flow, Continuation continuation) {
            super(2, continuation);
            this.$this_asLiveData = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            n3 n3Var = new n3(this.$this_asLiveData, completion);
            n3Var.L$0 = obj;
            return n3Var;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((n3) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Flow flow = this.$this_asLiveData;
                y yVar = new y((i4) this.L$0);
                this.label = 1;
                if (flow.collect(yVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {96, 100, 101}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class y<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveData $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class n3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ fh $observer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n3(fh fhVar, Continuation continuation) {
                super(2, continuation);
                this.$observer = fhVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                return new n3(this.$observer, completion);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((n3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    y.this.$this_asFlow.tl(this.$observer);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* renamed from: y5.f$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0252y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ fh $observer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0252y(fh fhVar, Continuation continuation) {
                super(2, continuation);
                this.$observer = fhVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                return new C0252y(this.$observer, completion);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0252y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    y.this.$this_asFlow.c5(this.$observer);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* loaded from: classes.dex */
        public static final class zn<T> implements fh<T> {
            public final /* synthetic */ Channel y;

            public zn(Channel channel) {
                this.y = channel;
            }

            @Override // y5.fh
            public final void onChanged(T t2) {
                this.y.offer(t2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            y yVar = new y(this.$this_asFlow, completion);
            yVar.L$0 = obj;
            return yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((y) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0091 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009d A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:8:0x001e, B:24:0x0083, B:28:0x0095, B:30:0x009d, B:15:0x003a), top: B:39:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v2, types: [y5.fh] */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ad -> B:9:0x0021). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 224
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y5.f.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> LiveData<T> n3(Flow<? extends T> asLiveData, CoroutineContext context, long j2) {
        Intrinsics.checkNotNullParameter(asLiveData, "$this$asLiveData");
        Intrinsics.checkNotNullParameter(context, "context");
        return v.y(context, j2, new n3(asLiveData, null));
    }

    public static final <T> Flow<T> y(LiveData<T> asFlow) {
        Intrinsics.checkNotNullParameter(asFlow, "$this$asFlow");
        return FlowKt.flow(new y(asFlow, null));
    }

    public static /* synthetic */ LiveData zn(Flow flow, CoroutineContext coroutineContext, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j2 = 5000;
        }
        return n3(flow, coroutineContext, j2);
    }
}
