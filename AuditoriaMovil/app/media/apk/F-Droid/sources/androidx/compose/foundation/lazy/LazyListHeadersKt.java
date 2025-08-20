package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyListHeaders.kt */
/* loaded from: classes.dex */
public abstract class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List composedVisibleItems, LazyListMeasuredItemProvider itemProvider, List headerIndexes, int i, int i2, int i3) {
        Object first;
        int i4;
        int lastIndex;
        Intrinsics.checkNotNullParameter(composedVisibleItems, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        first = CollectionsKt___CollectionsKt.first(composedVisibleItems);
        int index = ((LazyListMeasuredItem) first).getIndex();
        int size = headerIndexes.size();
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i7 < size && ((Number) headerIndexes.get(i7)).intValue() <= index) {
            i5 = ((Number) headerIndexes.get(i7)).intValue();
            i7++;
            if (i7 >= 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(headerIndexes);
                if (i7 <= lastIndex) {
                    i4 = headerIndexes.get(i7);
                    i6 = ((Number) i4).intValue();
                }
            }
            i4 = -1;
            i6 = ((Number) i4).intValue();
        }
        int size2 = composedVisibleItems.size();
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MIN_VALUE;
        int i10 = -1;
        for (int i11 = 0; i11 < size2; i11++) {
            LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) composedVisibleItems.get(i11);
            if (lazyListMeasuredItem.getIndex() == i5) {
                i8 = lazyListMeasuredItem.getOffset();
                i10 = i11;
            } else if (lazyListMeasuredItem.getIndex() == i6) {
                i9 = lazyListMeasuredItem.getOffset();
            }
        }
        if (i5 == -1) {
            return null;
        }
        LazyListMeasuredItem andMeasure = itemProvider.getAndMeasure(i5);
        int max = i8 != Integer.MIN_VALUE ? Math.max(-i, i8) : -i;
        if (i9 != Integer.MIN_VALUE) {
            max = Math.min(max, i9 - andMeasure.getSize());
        }
        andMeasure.position(max, i2, i3);
        if (i10 != -1) {
            composedVisibleItems.set(i10, andMeasure);
        } else {
            composedVisibleItems.add(0, andMeasure);
        }
        return andMeasure;
    }
}
