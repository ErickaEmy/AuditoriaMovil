package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: LookaheadLayoutCoordinates.kt */
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo1253getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0  reason: not valid java name */
    private final long m1264getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        LayoutCoordinates coordinates = rootLookaheadDelegate.getCoordinates();
        Offset.Companion companion = Offset.Companion;
        return Offset.m713minusMKHz9U(mo1254localPositionOfR5De75A(coordinates, companion.m721getZeroF1C5BW0()), getCoordinator().mo1254localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), companion.m721getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo1257windowToLocalMKHz9U(long j) {
        return Offset.m714plusMKHz9U(getCoordinator().mo1257windowToLocalMKHz9U(j), m1264getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo1256localToWindowMKHz9U(long j) {
        return getCoordinator().mo1256localToWindowMKHz9U(Offset.m714plusMKHz9U(j, m1264getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo1255localToRootMKHz9U(long j) {
        return getCoordinator().mo1255localToRootMKHz9U(Offset.m714plusMKHz9U(j, m1264getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo1254localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long j) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!(sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl)) {
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            return Offset.m714plusMKHz9U(mo1254localPositionOfR5De75A(rootLookaheadDelegate.getLookaheadLayoutCoordinates(), j), rootLookaheadDelegate.getCoordinator().getCoordinates().mo1254localPositionOfR5De75A(sourceCoordinates, Offset.Companion.m721getZeroF1C5BW0()));
        }
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinatesImpl) sourceCoordinates).lookaheadDelegate;
        lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui_release();
        LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            long m1343positionInBjo55l4$ui_release = lookaheadDelegate.m1343positionInBjo55l4$ui_release(lookaheadDelegate2);
            roundToInt3 = MathKt__MathJVMKt.roundToInt(Offset.m709getXimpl(j));
            roundToInt4 = MathKt__MathJVMKt.roundToInt(Offset.m710getYimpl(j));
            long IntOffset = IntOffsetKt.IntOffset(roundToInt3, roundToInt4);
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1343positionInBjo55l4$ui_release) + IntOffset.m1937getXimpl(IntOffset), IntOffset.m1938getYimpl(m1343positionInBjo55l4$ui_release) + IntOffset.m1938getYimpl(IntOffset));
            long m1343positionInBjo55l4$ui_release2 = this.lookaheadDelegate.m1343positionInBjo55l4$ui_release(lookaheadDelegate2);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset2) - IntOffset.m1937getXimpl(m1343positionInBjo55l4$ui_release2), IntOffset.m1938getYimpl(IntOffset2) - IntOffset.m1938getYimpl(m1343positionInBjo55l4$ui_release2));
            return OffsetKt.Offset(IntOffset.m1937getXimpl(IntOffset3), IntOffset.m1938getYimpl(IntOffset3));
        }
        LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
        long m1343positionInBjo55l4$ui_release3 = lookaheadDelegate.m1343positionInBjo55l4$ui_release(rootLookaheadDelegate2);
        long mo1341getPositionnOccac = rootLookaheadDelegate2.mo1341getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1343positionInBjo55l4$ui_release3) + IntOffset.m1937getXimpl(mo1341getPositionnOccac), IntOffset.m1938getYimpl(m1343positionInBjo55l4$ui_release3) + IntOffset.m1938getYimpl(mo1341getPositionnOccac));
        roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m709getXimpl(j));
        roundToInt2 = MathKt__MathJVMKt.roundToInt(Offset.m710getYimpl(j));
        long IntOffset5 = IntOffsetKt.IntOffset(roundToInt, roundToInt2);
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset4) + IntOffset.m1937getXimpl(IntOffset5), IntOffset.m1938getYimpl(IntOffset4) + IntOffset.m1938getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate3 = this.lookaheadDelegate;
        long m1343positionInBjo55l4$ui_release4 = lookaheadDelegate3.m1343positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3));
        long mo1341getPositionnOccac2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3).mo1341getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1343positionInBjo55l4$ui_release4) + IntOffset.m1937getXimpl(mo1341getPositionnOccac2), IntOffset.m1938getYimpl(m1343positionInBjo55l4$ui_release4) + IntOffset.m1938getYimpl(mo1341getPositionnOccac2));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset6) - IntOffset.m1937getXimpl(IntOffset7), IntOffset.m1938getYimpl(IntOffset6) - IntOffset.m1938getYimpl(IntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate2.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.mo1254localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset(IntOffset.m1937getXimpl(IntOffset8), IntOffset.m1938getYimpl(IntOffset8)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, z);
    }
}
