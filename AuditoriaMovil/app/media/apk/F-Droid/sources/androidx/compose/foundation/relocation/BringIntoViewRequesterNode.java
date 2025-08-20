package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public final class BringIntoViewRequesterNode extends BringIntoViewChildNode {
    private BringIntoViewRequester requester;

    public BringIntoViewRequesterNode(BringIntoViewRequester requester) {
        Intrinsics.checkNotNullParameter(requester, "requester");
        this.requester = requester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateRequester(this.requester);
    }

    public final void updateRequester(BringIntoViewRequester requester) {
        Intrinsics.checkNotNullParameter(requester, "requester");
        disposeRequester();
        if (requester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) requester).getModifiers().add(this);
        }
        this.requester = requester;
    }

    private final void disposeRequester() {
        BringIntoViewRequester bringIntoViewRequester = this.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().remove(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeRequester();
    }

    public final Object bringIntoView(final Rect rect, Continuation continuation) {
        Object coroutine_suspended;
        BringIntoViewParent parent = getParent();
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Unit.INSTANCE;
        }
        Object bringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new Function0() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterNode$bringIntoView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                Rect rect2 = Rect.this;
                if (rect2 == null) {
                    LayoutCoordinates layoutCoordinates2 = this.getLayoutCoordinates();
                    if (layoutCoordinates2 != null) {
                        return SizeKt.m753toRectuvyYCjk(IntSizeKt.m1957toSizeozmzZPI(layoutCoordinates2.mo1253getSizeYbymL2g()));
                    }
                    return null;
                }
                return rect2;
            }
        }, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return bringChildIntoView == coroutine_suspended ? bringChildIntoView : Unit.INSTANCE;
    }
}
