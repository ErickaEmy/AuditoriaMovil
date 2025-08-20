package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.SendChannel;
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public abstract class DraggableKt {
    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        return draggable(modifier, draggableState, orientation, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : mutableInteractionSource, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? new DraggableKt$draggable$1(null) : function3, (i & 64) != 0 ? new DraggableKt$draggable$2(null) : function32, (i & 128) != 0 ? false : z3);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState state, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, final boolean z2, Function3 onDragStarted, Function3 onDragStopped, boolean z3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return modifier.then(new DraggableElement(state, new Function1() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        }, orientation, z, mutableInteractionSource, new Function0() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(z2);
            }
        }, onDragStarted, new DraggableKt$draggable$5(onDragStopped, orientation, null), z3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02df A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x0228 -> B:168:0x0237). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x0291 -> B:179:0x0296). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x02e1 -> B:168:0x0237). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function0 r22, androidx.compose.ui.input.pointer.util.VelocityTracker r23, androidx.compose.foundation.gestures.Orientation r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitDrag-Su4bsnU */
    public static final Object m143awaitDragSu4bsnU(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, long j, final VelocityTracker velocityTracker, final SendChannel sendChannel, final boolean z, Orientation orientation, Continuation continuation) {
        sendChannel.mo2270trySendJP2dKIU(new DragEvent.DragStarted(Offset.m713minusMKHz9U(pointerInputChange.m1196getPositionF1C5BW0(), OffsetKt.Offset(Offset.m709getXimpl(j) * Math.signum(Offset.m709getXimpl(pointerInputChange.m1196getPositionF1C5BW0())), Offset.m710getYimpl(j) * Math.signum(Offset.m710getYimpl(pointerInputChange.m1196getPositionF1C5BW0())))), null));
        sendChannel.mo2270trySendJP2dKIU(new DragEvent.DragDelta(z ? Offset.m715timestuRUvjQ(j, -1.0f) : j, null));
        return m144onDragOrUpAxegvzg(awaitPointerEventScope, orientation, pointerInputChange.m1195getIdJ3iCeTQ(), new Function1() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PointerInputChange event) {
                Intrinsics.checkNotNullParameter(event, "event");
                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, event);
                if (PointerEventKt.changedToUpIgnoreConsumed(event)) {
                    return;
                }
                long positionChange = PointerEventKt.positionChange(event);
                event.consume();
                SendChannel sendChannel2 = sendChannel;
                if (z) {
                    positionChange = Offset.m715timestuRUvjQ(positionChange, -1.0f);
                }
                sendChannel2.mo2270trySendJP2dKIU(new DragEvent.DragDelta(positionChange, null));
            }
        }, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0117, code lost:
        if ((!r16) != false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0095 -> B:104:0x009a). Please submit an issue!!! */
    /* renamed from: onDragOrUp-Axegvzg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m144onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, androidx.compose.foundation.gestures.Orientation r21, long r22, kotlin.jvm.functions.Function1 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m144onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.Orientation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: toFloat-3MmeM6k */
    public static final float m145toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m710getYimpl(j) : Offset.m709getXimpl(j);
    }

    /* renamed from: toFloat-sF-c-tU */
    public static final float m146toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m1990getYimpl(j) : Velocity.m1989getXimpl(j);
    }
}
