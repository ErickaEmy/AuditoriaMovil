package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: LayoutCoordinates.kt */
/* loaded from: classes.dex */
public abstract class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo1255localToRootMKHz9U(Offset.Companion.m721getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo1256localToWindowMKHz9U(Offset.Companion.m721getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        float coerceIn4;
        float minOf;
        float minOf2;
        float maxOf;
        float maxOf2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float m1951getWidthimpl = IntSize.m1951getWidthimpl(findRootCoordinates.mo1253getSizeYbymL2g());
        float m1950getHeightimpl = IntSize.m1950getHeightimpl(findRootCoordinates.mo1253getSizeYbymL2g());
        coerceIn = RangesKt___RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, m1951getWidthimpl);
        coerceIn2 = RangesKt___RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, m1950getHeightimpl);
        coerceIn3 = RangesKt___RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, m1951getWidthimpl);
        coerceIn4 = RangesKt___RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, m1950getHeightimpl);
        if (coerceIn == coerceIn3 || coerceIn2 == coerceIn4) {
            return Rect.Companion.getZero();
        }
        long mo1256localToWindowMKHz9U = findRootCoordinates.mo1256localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
        long mo1256localToWindowMKHz9U2 = findRootCoordinates.mo1256localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
        long mo1256localToWindowMKHz9U3 = findRootCoordinates.mo1256localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
        long mo1256localToWindowMKHz9U4 = findRootCoordinates.mo1256localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
        minOf = ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m709getXimpl(mo1256localToWindowMKHz9U), Offset.m709getXimpl(mo1256localToWindowMKHz9U2), Offset.m709getXimpl(mo1256localToWindowMKHz9U4), Offset.m709getXimpl(mo1256localToWindowMKHz9U3));
        minOf2 = ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m710getYimpl(mo1256localToWindowMKHz9U), Offset.m710getYimpl(mo1256localToWindowMKHz9U2), Offset.m710getYimpl(mo1256localToWindowMKHz9U4), Offset.m710getYimpl(mo1256localToWindowMKHz9U3));
        maxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m709getXimpl(mo1256localToWindowMKHz9U), Offset.m709getXimpl(mo1256localToWindowMKHz9U2), Offset.m709getXimpl(mo1256localToWindowMKHz9U4), Offset.m709getXimpl(mo1256localToWindowMKHz9U3));
        maxOf2 = ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m710getYimpl(mo1256localToWindowMKHz9U), Offset.m710getYimpl(mo1256localToWindowMKHz9U2), Offset.m710getYimpl(mo1256localToWindowMKHz9U4), Offset.m710getYimpl(mo1256localToWindowMKHz9U3));
        return new Rect(minOf, minOf2, maxOf, maxOf2);
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect localBoundingBoxOf$default;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (localBoundingBoxOf$default = LayoutCoordinates.CC.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m1951getWidthimpl(layoutCoordinates.mo1253getSizeYbymL2g()), IntSize.m1950getHeightimpl(layoutCoordinates.mo1253getSizeYbymL2g())) : localBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }
}
