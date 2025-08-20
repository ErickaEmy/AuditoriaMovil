package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class PrioritySet {
    private final List list;

    public PrioritySet(List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final void add(int i) {
        List list;
        if (!this.list.isEmpty()) {
            if (((Number) this.list.get(0)).intValue() == i) {
                return;
            }
            if (((Number) this.list.get(list.size() - 1)).intValue() == i) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i));
        while (size > 0) {
            int i2 = ((size + 1) >>> 1) - 1;
            int intValue = ((Number) this.list.get(i2)).intValue();
            if (i <= intValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(intValue));
            size = i2;
        }
        this.list.set(size, Integer.valueOf(i));
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        Object first;
        first = CollectionsKt___CollectionsKt.first(this.list);
        return ((Number) first).intValue();
    }

    public final int takeMax() {
        Object last;
        int intValue;
        if (this.list.size() > 0) {
            int intValue2 = ((Number) this.list.get(0)).intValue();
            while ((!this.list.isEmpty()) && ((Number) this.list.get(0)).intValue() == intValue2) {
                List list = this.list;
                last = CollectionsKt___CollectionsKt.last(list);
                list.set(0, last);
                List list2 = this.list;
                list2.remove(list2.size() - 1);
                int size = this.list.size();
                int size2 = this.list.size() >>> 1;
                int i = 0;
                while (i < size2) {
                    int intValue3 = ((Number) this.list.get(i)).intValue();
                    int i2 = (i + 1) * 2;
                    int i3 = i2 - 1;
                    int intValue4 = ((Number) this.list.get(i3)).intValue();
                    if (i2 >= size || (intValue = ((Number) this.list.get(i2)).intValue()) <= intValue4) {
                        if (intValue4 > intValue3) {
                            this.list.set(i, Integer.valueOf(intValue4));
                            this.list.set(i3, Integer.valueOf(intValue3));
                            i = i3;
                        }
                    } else if (intValue > intValue3) {
                        this.list.set(i, Integer.valueOf(intValue));
                        this.list.set(i2, Integer.valueOf(intValue3));
                        i = i2;
                    }
                }
            }
            return intValue2;
        }
        ComposerKt.composeRuntimeError("Set is empty".toString());
        throw new KotlinNothingValueException();
    }
}
