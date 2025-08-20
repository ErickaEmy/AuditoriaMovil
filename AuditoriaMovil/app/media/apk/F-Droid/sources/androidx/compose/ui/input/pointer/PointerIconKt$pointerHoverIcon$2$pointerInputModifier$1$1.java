package androidx.compose.ui.input.pointer;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(PointerIconModifierLocal pointerIconModifierLocal, Continuation continuation) {
        super(2, continuation);
        this.$pointerIconModifierLocal = pointerIconModifierLocal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(this.$pointerIconModifierLocal, continuation);
        pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.L$0 = obj;
        return pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PointerIcon.kt */
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerIconModifierLocal pointerIconModifierLocal, Continuation continuation) {
            super(2, continuation);
            this.$pointerIconModifierLocal = pointerIconModifierLocal;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pointerIconModifierLocal, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please submit an issue!!! */
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
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r9)
                r3 = r1
                r1 = r0
                r0 = r8
                goto L39
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
                r1 = r9
                r9 = r8
            L27:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                r9.L$0 = r1
                r9.label = r2
                java.lang.Object r3 = r1.awaitPointerEvent(r3, r9)
                if (r3 != r0) goto L34
                return r0
            L34:
                r7 = r0
                r0 = r9
                r9 = r3
                r3 = r1
                r1 = r7
            L39:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                int r4 = r9.m1170getType7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r6 = r5.m1176getEnter7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m1175equalsimpl0(r4, r6)
                if (r4 == 0) goto L51
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r9 = r0.$pointerIconModifierLocal
                r9.enter()
                goto L64
            L51:
                int r9 = r9.m1170getType7fucELk()
                int r4 = r5.m1177getExit7fucELk()
                boolean r9 = androidx.compose.ui.input.pointer.PointerEventType.m1175equalsimpl0(r9, r4)
                if (r9 == 0) goto L64
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r9 = r0.$pointerIconModifierLocal
                r9.exit()
            L64:
                r9 = r0
                r0 = r1
                r1 = r3
                goto L27
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pointerIconModifierLocal, null);
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
