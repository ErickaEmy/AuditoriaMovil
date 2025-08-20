package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
/* compiled from: LazyListState.kt */
/* loaded from: classes.dex */
final class EmptyLazyListLayoutInfo implements LazyListLayoutInfo {
    public static final EmptyLazyListLayoutInfo INSTANCE = new EmptyLazyListLayoutInfo();
    private static final Orientation orientation;
    private static final int totalItemsCount = 0;
    private static final long viewportSize;
    private static final List visibleItemsInfo;

    private EmptyLazyListLayoutInfo() {
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public List getVisibleItemsInfo() {
        return visibleItemsInfo;
    }

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        visibleItemsInfo = emptyList;
        viewportSize = IntSize.Companion.m1955getZeroYbymL2g();
        orientation = Orientation.Vertical;
    }
}
