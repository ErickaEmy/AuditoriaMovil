package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutNodeAlignmentLines.kt */
/* loaded from: classes.dex */
public final class LookaheadAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public Map getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.getMeasureResult$ui_release().getAlignmentLines();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.get(alignmentLine);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* renamed from: calculatePositionInParent-R5De75A */
    protected long mo1288calculatePositionInParentR5De75A(NodeCoordinator calculatePositionInParent, long j) {
        Intrinsics.checkNotNullParameter(calculatePositionInParent, "$this$calculatePositionInParent");
        LookaheadDelegate lookaheadDelegate = calculatePositionInParent.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        long mo1341getPositionnOccac = lookaheadDelegate.mo1341getPositionnOccac();
        return Offset.m714plusMKHz9U(OffsetKt.Offset(IntOffset.m1937getXimpl(mo1341getPositionnOccac), IntOffset.m1938getYimpl(mo1341getPositionnOccac)), j);
    }
}
