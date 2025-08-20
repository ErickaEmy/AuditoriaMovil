package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
/* compiled from: LayoutCoordinates.kt */
/* loaded from: classes.dex */
public interface LayoutCoordinates {
    LayoutCoordinates getParentLayoutCoordinates();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long mo1253getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z);

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    long mo1254localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j);

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    long mo1255localToRootMKHz9U(long j);

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    long mo1256localToWindowMKHz9U(long j);

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    long mo1257windowToLocalMKHz9U(long j);

    /* compiled from: LayoutCoordinates.kt */
    /* renamed from: androidx.compose.ui.layout.LayoutCoordinates$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }
    }
}
