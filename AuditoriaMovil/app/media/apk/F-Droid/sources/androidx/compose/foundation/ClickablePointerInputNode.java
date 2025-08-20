package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
final class ClickablePointerInputNode extends AbstractClickablePointerInputNode {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickablePointerInputNode(boolean z, MutableInteractionSource interactionSource, Function0 onClick, AbstractClickableNode.InteractionData interactionData) {
        super(z, interactionSource, onClick, interactionData, null);
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(interactionData, "interactionData");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    public Object pointerInput(PointerInputScope pointerInputScope, Continuation continuation) {
        Object coroutine_suspended;
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long m1956getCenterozmzZPI = IntSizeKt.m1956getCenterozmzZPI(pointerInputScope.mo1207getSizeYbymL2g());
        interactionData.m64setCentreOffsetk4lQ0M(OffsetKt.Offset(IntOffset.m1937getXimpl(m1956getCenterozmzZPI), IntOffset.m1938getYimpl(m1956getCenterozmzZPI)));
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new ClickablePointerInputNode$pointerInput$2(this, null), new Function1() { // from class: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m99invokek4lQ0M(((Offset) obj).m718unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
            public final void m99invokek4lQ0M(long j) {
                if (ClickablePointerInputNode.this.getEnabled()) {
                    ClickablePointerInputNode.this.getOnClick().invoke();
                }
            }
        }, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return detectTapAndPress == coroutine_suspended ? detectTapAndPress : Unit.INSTANCE;
    }

    public final void update(boolean z, MutableInteractionSource interactionSource, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        setEnabled(z);
        setOnClick(onClick);
        setInteractionSource(interactionSource);
    }
}
