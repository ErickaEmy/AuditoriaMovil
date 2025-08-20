package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* compiled from: LazyLayoutKeyIndexMap.kt */
/* loaded from: classes.dex */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    private final Object[] keys;
    private final int keysStartIndex;
    private final Map map;

    public NearestRangeKeyIndexMap(IntRange nearestRange, LazyLayoutIntervalContent intervalContent) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(nearestRange, "nearestRange");
        Intrinsics.checkNotNullParameter(intervalContent, "intervalContent");
        IntervalList intervals = intervalContent.getIntervals();
        final int first = nearestRange.getFirst();
        if (first < 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        final int min = Math.min(nearestRange.getLast(), intervals.getSize() - 1);
        if (min < first) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.map = emptyMap;
            this.keys = new Object[0];
            this.keysStartIndex = 0;
            return;
        }
        this.keys = new Object[(min - first) + 1];
        this.keysStartIndex = first;
        final HashMap hashMap = new HashMap();
        intervals.forEach(first, min, new Function1() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IntervalList.Interval) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x003c, code lost:
                if (r3 == null) goto L12;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(androidx.compose.foundation.lazy.layout.IntervalList.Interval r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.Object r0 = r7.getValue()
                    androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
                    kotlin.jvm.functions.Function1 r0 = r0.getKey()
                    int r1 = r1
                    int r2 = r7.getStartIndex()
                    int r1 = java.lang.Math.max(r1, r2)
                    int r2 = r2
                    int r3 = r7.getStartIndex()
                    int r4 = r7.getSize()
                    int r3 = r3 + r4
                    int r3 = r3 + (-1)
                    int r2 = java.lang.Math.min(r2, r3)
                    if (r1 > r2) goto L60
                L2c:
                    if (r0 == 0) goto L3e
                    int r3 = r7.getStartIndex()
                    int r3 = r1 - r3
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    java.lang.Object r3 = r0.invoke(r3)
                    if (r3 != 0) goto L42
                L3e:
                    java.lang.Object r3 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r1)
                L42:
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
                    java.util.HashMap r5 = r3
                    r5.put(r3, r4)
                    androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r4 = r4
                    java.lang.Object[] r4 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.access$getKeys$p(r4)
                    androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r5 = r4
                    int r5 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.access$getKeysStartIndex$p(r5)
                    int r5 = r1 - r5
                    r4[r5] = r3
                    if (r1 == r2) goto L60
                    int r1 = r1 + 1
                    goto L2c
                L60:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$1$1.invoke(androidx.compose.foundation.lazy.layout.IntervalList$Interval):void");
            }
        });
        this.map = hashMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = this.map.get(key);
        if (i == null) {
            i = -1;
        }
        return ((Number) i).intValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int i) {
        int lastIndex;
        Object[] objArr = this.keys;
        int i2 = i - this.keysStartIndex;
        if (i2 >= 0) {
            lastIndex = ArraysKt___ArraysKt.getLastIndex(objArr);
            if (i2 <= lastIndex) {
                return objArr[i2];
            }
        }
        return null;
    }
}
