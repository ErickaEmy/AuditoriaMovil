package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: LazyListMeasure.kt */
/* loaded from: classes.dex */
public abstract class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c2  */
    /* renamed from: measureLazyList-CD5nmq0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m247measureLazyListCD5nmq0(int r33, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r34, int r35, int r36, int r37, int r38, int r39, int r40, float r41, long r42, boolean r44, java.util.List r45, androidx.compose.foundation.layout.Arrangement.Vertical r46, androidx.compose.foundation.layout.Arrangement.Horizontal r47, boolean r48, androidx.compose.ui.unit.Density r49, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r50, int r51, java.util.List r52, kotlin.jvm.functions.Function3 r53) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m247measureLazyListCD5nmq0(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, int, java.util.List, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    private static final List createItemsAfterList(List list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List list2) {
        Object last;
        Object last2;
        List emptyList;
        last = CollectionsKt___CollectionsKt.last(list);
        int min = Math.min(((LazyListMeasuredItem) last).getIndex() + i2, i - 1);
        last2 = CollectionsKt___CollectionsKt.last(list);
        int index = ((LazyListMeasuredItem) last2).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(index));
                if (index == min) {
                    break;
                }
                index++;
            }
        }
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Number) list2.get(i3)).intValue();
            if (intValue > min) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(intValue));
            }
        }
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }

    private static final List createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List list) {
        List emptyList;
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(i3));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = ((Number) list.get(i4)).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(intValue));
            }
        }
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }

    private static final List calculateItemsOffsets(List list, List list2, List list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        IntProgression indices;
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z3) {
            int size = list2.size();
            int i7 = i5;
            for (int i8 = 0; i8 < size; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) list2.get(i8);
                i7 -= lazyListMeasuredItem.getSizeWithSpacings();
                lazyListMeasuredItem.position(i7, i, i2);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int i9 = i5;
            for (int i10 = 0; i10 < size2; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) list.get(i10);
                lazyListMeasuredItem2.position(i9, i, i2);
                arrayList.add(lazyListMeasuredItem2);
                i9 += lazyListMeasuredItem2.getSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i11 = 0; i11 < size3; i11++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) list3.get(i11);
                lazyListMeasuredItem3.position(i9, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                i9 += lazyListMeasuredItem3.getSizeWithSpacings();
            }
        } else if (!list2.isEmpty() || !list3.isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else {
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i12 = 0; i12 < size4; i12++) {
                iArr[i12] = ((LazyListMeasuredItem) list.get(calculateItemsOffsets$reverseAware(i12, z2, size4))).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i13 = 0; i13 < size4; i13++) {
                iArr2[i13] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else if (horizontal == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            indices = ArraysKt___ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt___RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i14 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) list.get(calculateItemsOffsets$reverseAware(first, z2, size4));
                    if (z2) {
                        i14 = (i6 - i14) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(i14, i, i2);
                    arrayList.add(lazyListMeasuredItem4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }
}
