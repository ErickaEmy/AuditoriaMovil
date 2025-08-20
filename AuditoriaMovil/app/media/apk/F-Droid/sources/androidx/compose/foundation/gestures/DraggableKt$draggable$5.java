package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableKt$draggable$5 extends SuspendLambda implements Function3 {
    final /* synthetic */ Function3 $onDragStopped;
    final /* synthetic */ Orientation $orientation;
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$5(Function3 function3, Orientation orientation, Continuation continuation) {
        super(3, continuation);
        this.$onDragStopped = function3;
        this.$orientation = orientation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m149invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m1996unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-LuvzFrg  reason: not valid java name */
    public final Object m149invokeLuvzFrg(CoroutineScope coroutineScope, long j, Continuation continuation) {
        DraggableKt$draggable$5 draggableKt$draggable$5 = new DraggableKt$draggable$5(this.$onDragStopped, this.$orientation, continuation);
        draggableKt$draggable$5.L$0 = coroutineScope;
        draggableKt$draggable$5.J$0 = j;
        return draggableKt$draggable$5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        float m146toFloatsFctU;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.J$0;
            Function3 function3 = this.$onDragStopped;
            m146toFloatsFctU = DraggableKt.m146toFloatsFctU(j, this.$orientation);
            Float boxFloat = Boxing.boxFloat(m146toFloatsFctU);
            this.label = 1;
            if (function3.invoke((CoroutineScope) this.L$0, boxFloat, this) == coroutine_suspended) {
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
