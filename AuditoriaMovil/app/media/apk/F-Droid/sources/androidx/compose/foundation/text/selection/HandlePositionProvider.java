package androidx.compose.foundation.text.selection;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidSelectionHandles.android.kt */
/* loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    private final HandleReferencePoint handleReferencePoint;
    private final long offset;

    /* compiled from: AndroidSelectionHandles.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            try {
                iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HandleReferencePoint.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(handleReferencePoint, j);
    }

    private HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j) {
        Intrinsics.checkNotNullParameter(handleReferencePoint, "handleReferencePoint");
        this.handleReferencePoint = handleReferencePoint;
        this.offset = j;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long mo389calculatePositionllwVHH4(IntRect anchorBounds, long j, LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int i = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return IntOffsetKt.IntOffset((anchorBounds.getLeft() + IntOffset.m1937getXimpl(this.offset)) - (IntSize.m1951getWidthimpl(j2) / 2), anchorBounds.getTop() + IntOffset.m1938getYimpl(this.offset));
                }
                throw new NoWhenBranchMatchedException();
            }
            return IntOffsetKt.IntOffset((anchorBounds.getLeft() + IntOffset.m1937getXimpl(this.offset)) - IntSize.m1951getWidthimpl(j2), anchorBounds.getTop() + IntOffset.m1938getYimpl(this.offset));
        }
        return IntOffsetKt.IntOffset(anchorBounds.getLeft() + IntOffset.m1937getXimpl(this.offset), anchorBounds.getTop() + IntOffset.m1938getYimpl(this.offset));
    }
}
