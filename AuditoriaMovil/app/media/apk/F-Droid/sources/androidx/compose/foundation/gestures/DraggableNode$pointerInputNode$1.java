package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DraggableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$pointerInputNode$1(DraggableNode draggableNode, Continuation continuation) {
        super(2, continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, continuation);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            z = this.this$0.enabled;
            if (!z) {
                return Unit.INSTANCE;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(pointerInputScope, this.this$0, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Draggable.kt */
    /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, DraggableNode draggableNode, Continuation continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = draggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Draggable.kt */
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00041 extends SuspendLambda implements Function2 {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00041(DraggableNode draggableNode, Continuation continuation) {
                super(2, continuation);
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00041 c00041 = new C00041(this.this$0, continuation);
                c00041.L$0 = obj;
                return c00041;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00c5 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00cd A[Catch: CancellationException -> 0x00e4, TryCatch #3 {CancellationException -> 0x00e4, blocks: (B:37:0x00c7, B:39:0x00cd, B:43:0x00e6, B:45:0x00ea), top: B:64:0x00c7 }] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00e6 A[Catch: CancellationException -> 0x00e4, TryCatch #3 {CancellationException -> 0x00e4, blocks: (B:37:0x00c7, B:39:0x00cd, B:43:0x00e6, B:45:0x00ea), top: B:64:0x00c7 }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x010d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0114  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00fa -> B:21:0x0065). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0110 -> B:21:0x0065). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00041.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Draggable.kt */
            /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C00051 extends SuspendLambda implements Function2 {
                final /* synthetic */ Ref$ObjectRef $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ DraggableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00051(Ref$ObjectRef ref$ObjectRef, DraggableNode draggableNode, Continuation continuation) {
                    super(2, continuation);
                    this.$event = ref$ObjectRef;
                    this.this$0 = draggableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C00051 c00051 = new C00051(this.$event, this.this$0, continuation);
                    c00051.L$0 = obj;
                    return c00051;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(DragScope dragScope, Continuation continuation) {
                    return ((C00051) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0068 -> B:23:0x006e). Please submit an issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r8.label
                        r2 = 1
                        if (r1 == 0) goto L23
                        if (r1 != r2) goto L1b
                        java.lang.Object r1 = r8.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                        java.lang.Object r3 = r8.L$0
                        androidx.compose.foundation.gestures.DragScope r3 = (androidx.compose.foundation.gestures.DragScope) r3
                        kotlin.ResultKt.throwOnFailure(r9)
                        r4 = r3
                        r3 = r1
                        r1 = r0
                        r0 = r8
                        goto L6e
                    L1b:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L23:
                        kotlin.ResultKt.throwOnFailure(r9)
                        java.lang.Object r9 = r8.L$0
                        androidx.compose.foundation.gestures.DragScope r9 = (androidx.compose.foundation.gestures.DragScope) r9
                        r3 = r9
                        r9 = r8
                    L2c:
                        kotlin.jvm.internal.Ref$ObjectRef r1 = r9.$event
                        java.lang.Object r1 = r1.element
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                        if (r4 != 0) goto L74
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                        if (r4 != 0) goto L74
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                        if (r4 == 0) goto L3f
                        androidx.compose.foundation.gestures.DragEvent$DragDelta r1 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r1
                        goto L40
                    L3f:
                        r1 = 0
                    L40:
                        if (r1 == 0) goto L53
                        androidx.compose.foundation.gestures.DraggableNode r4 = r9.this$0
                        long r5 = r1.m127getDeltaF1C5BW0()
                        androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.DraggableNode.access$getOrientation$p(r4)
                        float r1 = androidx.compose.foundation.gestures.DraggableKt.m141access$toFloat3MmeM6k(r5, r1)
                        r3.dragBy(r1)
                    L53:
                        kotlin.jvm.internal.Ref$ObjectRef r1 = r9.$event
                        androidx.compose.foundation.gestures.DraggableNode r4 = r9.this$0
                        kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.DraggableNode.access$getChannel$p(r4)
                        r9.L$0 = r3
                        r9.L$1 = r1
                        r9.label = r2
                        java.lang.Object r4 = r4.receive(r9)
                        if (r4 != r0) goto L68
                        return r0
                    L68:
                        r7 = r0
                        r0 = r9
                        r9 = r4
                        r4 = r3
                        r3 = r1
                        r1 = r7
                    L6e:
                        r3.element = r9
                        r9 = r0
                        r0 = r1
                        r3 = r4
                        goto L2c
                    L74:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00041.C00051.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r11.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L13
                goto L53
            L13:
                r12 = move-exception
                goto L4d
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
                r4 = 0
                kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1 r6 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1
                androidx.compose.foundation.gestures.DraggableNode r1 = r11.this$0
                r9 = 0
                r6.<init>(r1, r9)
                r7 = 1
                r8 = 0
                r3 = r12
                kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                androidx.compose.ui.input.pointer.PointerInputScope r1 = r11.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L49
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2     // Catch: java.util.concurrent.CancellationException -> L49
                androidx.compose.foundation.gestures.DraggableNode r4 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> L49
                r3.<init>(r12, r4, r9)     // Catch: java.util.concurrent.CancellationException -> L49
                r11.L$0 = r12     // Catch: java.util.concurrent.CancellationException -> L49
                r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L49
                java.lang.Object r12 = r1.awaitPointerEventScope(r3, r11)     // Catch: java.util.concurrent.CancellationException -> L49
                if (r12 != r0) goto L53
                return r0
            L49:
                r0 = move-exception
                r10 = r0
                r0 = r12
                r12 = r10
            L4d:
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                if (r0 == 0) goto L56
            L53:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L56:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Draggable.kt */
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2  reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2 {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CoroutineScope coroutineScope, DraggableNode draggableNode, Continuation continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$coroutineScope, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:27|(1:28)|29|30|31|32|(1:34)(4:35|9|10|(0))) */
            /* JADX WARN: Can't wrap try/catch for region: R(8:(3:6|7|8)|9|10|(6:12|(1:14)(1:63)|15|16|17|(2:19|(1:21)(4:23|24|25|(7:27|28|29|30|31|32|(1:34)(4:35|9|10|(0)))(3:60|17|(2:61|62)(0))))(0))|64|16|17|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x010f, code lost:
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0112, code lost:
                r11 = r20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
                r12 = r2;
                r2 = r15;
                r11 = r20;
                r10 = r13;
                r14 = r22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x013a, code lost:
                throw r0;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x013a A[Catch: all -> 0x013b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x013b, blocks: (B:51:0x0131, B:54:0x013a), top: B:72:0x0131 }] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0160  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x016a  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0173  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d1 -> B:68:0x00da). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0137 -> B:40:0x0104). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x016a -> B:18:0x0052). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r24) {
                /*
                    Method dump skipped, instructions count: 374
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }
}
