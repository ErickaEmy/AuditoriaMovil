package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyListMeasuredItemProvider.kt */
/* loaded from: classes.dex */
public abstract class LazyListMeasuredItemProvider {
    private final long childConstraints;
    private final LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    public /* synthetic */ LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, lazyListItemProvider, lazyLayoutMeasureScope);
    }

    public abstract LazyListMeasuredItem createItem(int i, Object obj, Object obj2, List list);

    /* renamed from: getChildConstraints-msEJaDk  reason: not valid java name */
    public final long m250getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    private LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider itemProvider, LazyLayoutMeasureScope measureScope) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m1872getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, !z ? Constraints.m1871getMaxHeightimpl(j) : Integer.MAX_VALUE, 5, null);
    }

    public final LazyListMeasuredItem getAndMeasure(int i) {
        return createItem(i, this.itemProvider.getKey(i), this.itemProvider.getContentType(i), this.measureScope.mo268measure0kLqBqw(i, this.childConstraints));
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
