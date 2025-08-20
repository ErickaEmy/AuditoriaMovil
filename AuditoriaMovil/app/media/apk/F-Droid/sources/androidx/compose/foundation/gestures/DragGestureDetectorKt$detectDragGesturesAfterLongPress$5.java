package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2 {
    final /* synthetic */ Function2 $onDrag;
    final /* synthetic */ Function0 $onDragCancel;
    final /* synthetic */ Function0 $onDragEnd;
    final /* synthetic */ Function1 $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x0040), top: B:47:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x0040), top: B:47:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5 A[Catch: CancellationException -> 0x0019, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x0040), top: B:47:0x0009 }] */
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
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L24
            if (r1 != r2) goto L1c
            java.lang.Object r0 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L19
            goto L86
        L19:
            r12 = move-exception
            goto Lbd
        L1c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L24:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L19
            goto L5e
        L2c:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L19
            goto L4d
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L19
            r11.label = r4     // Catch: java.util.concurrent.CancellationException -> L19
            r5 = r1
            r8 = r11
            java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L19
            if (r12 != r0) goto L4d
            return r0
        L4d:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> L19
            long r4 = r12.m1195getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> L19
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L19
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L19
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m132awaitLongPressOrCancellationrnUCldI(r1, r4, r11)     // Catch: java.util.concurrent.CancellationException -> L19
            if (r12 != r0) goto L5e
            return r0
        L5e:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> L19
            if (r12 == 0) goto Lba
            kotlin.jvm.functions.Function1 r3 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L19
            long r4 = r12.m1196getPositionF1C5BW0()     // Catch: java.util.concurrent.CancellationException -> L19
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m698boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> L19
            r3.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> L19
            long r3 = r12.m1195getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> L19
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> L19
            kotlin.jvm.functions.Function2 r5 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> L19
            r12.<init>()     // Catch: java.util.concurrent.CancellationException -> L19
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L19
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L19
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m133dragjO51t88(r1, r3, r12, r11)     // Catch: java.util.concurrent.CancellationException -> L19
            if (r12 != r0) goto L85
            return r0
        L85:
            r0 = r1
        L86:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.util.concurrent.CancellationException -> L19
            boolean r12 = r12.booleanValue()     // Catch: java.util.concurrent.CancellationException -> L19
            if (r12 == 0) goto Lb5
            androidx.compose.ui.input.pointer.PointerEvent r12 = r0.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> L19
            java.util.List r12 = r12.getChanges()     // Catch: java.util.concurrent.CancellationException -> L19
            int r0 = r12.size()     // Catch: java.util.concurrent.CancellationException -> L19
            r1 = 0
        L9b:
            if (r1 >= r0) goto Laf
            java.lang.Object r2 = r12.get(r1)     // Catch: java.util.concurrent.CancellationException -> L19
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch: java.util.concurrent.CancellationException -> L19
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r2)     // Catch: java.util.concurrent.CancellationException -> L19
            if (r3 == 0) goto Lac
            r2.consume()     // Catch: java.util.concurrent.CancellationException -> L19
        Lac:
            int r1 = r1 + 1
            goto L9b
        Laf:
            kotlin.jvm.functions.Function0 r12 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L19
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L19
            goto Lba
        Lb5:
            kotlin.jvm.functions.Function0 r12 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L19
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L19
        Lba:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lbd:
            kotlin.jvm.functions.Function0 r0 = r11.$onDragCancel
            r0.invoke()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
