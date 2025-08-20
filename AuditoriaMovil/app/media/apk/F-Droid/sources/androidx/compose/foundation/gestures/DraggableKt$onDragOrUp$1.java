package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableKt$onDragOrUp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DraggableKt$onDragOrUp$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m144onDragOrUpAxegvzg;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m144onDragOrUpAxegvzg = DraggableKt.m144onDragOrUpAxegvzg(null, null, 0L, null, this);
        return m144onDragOrUpAxegvzg;
    }
}
