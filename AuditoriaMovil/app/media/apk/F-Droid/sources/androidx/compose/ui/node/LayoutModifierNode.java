package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutModifierNode.kt */
/* loaded from: classes.dex */
public interface LayoutModifierNode extends DelegatableNode {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* renamed from: measure-3p2s80s */
    MeasureResult mo117measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* compiled from: LayoutModifierNode.kt */
    /* renamed from: androidx.compose.ui.node.LayoutModifierNode$-CC */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static int $default$minIntrinsicWidth(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode$minIntrinsicWidth$1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo1304measure3p2s80s(MeasureScope minWidth, Measurable intrinsicMeasurable, long j) {
                    Intrinsics.checkNotNullParameter(minWidth, "$this$minWidth");
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo117measure3p2s80s(minWidth, intrinsicMeasurable, j);
                }
            }, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$minIntrinsicHeight(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode$minIntrinsicHeight$1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo1304measure3p2s80s(MeasureScope minHeight, Measurable intrinsicMeasurable, long j) {
                    Intrinsics.checkNotNullParameter(minHeight, "$this$minHeight");
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo117measure3p2s80s(minHeight, intrinsicMeasurable, j);
                }
            }, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$maxIntrinsicWidth(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode$maxIntrinsicWidth$1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo1304measure3p2s80s(MeasureScope maxWidth, Measurable intrinsicMeasurable, long j) {
                    Intrinsics.checkNotNullParameter(maxWidth, "$this$maxWidth");
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo117measure3p2s80s(maxWidth, intrinsicMeasurable, j);
                }
            }, intrinsicMeasureScope, measurable, i);
        }

        public static int $default$maxIntrinsicHeight(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode$maxIntrinsicHeight$1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* renamed from: measure-3p2s80s  reason: not valid java name */
                public final MeasureResult mo1304measure3p2s80s(MeasureScope maxHeight, Measurable intrinsicMeasurable, long j) {
                    Intrinsics.checkNotNullParameter(maxHeight, "$this$maxHeight");
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo117measure3p2s80s(maxHeight, intrinsicMeasurable, j);
                }
            }, intrinsicMeasureScope, measurable, i);
        }
    }
}
