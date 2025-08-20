package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: collections.kt */
/* loaded from: classes2.dex */
public abstract class CollectionsKt {
    public static final Map mapToIndex(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : iterable) {
            linkedHashMap.put(obj, Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final void addIfNotNull(Collection collection, Object obj) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (obj != null) {
            collection.add(obj);
        }
    }

    public static final HashMap newHashMapWithExpectedSize(int i) {
        return new HashMap(capacity(i));
    }

    public static final HashSet newHashSetWithExpectedSize(int i) {
        return new HashSet(capacity(i));
    }

    public static final LinkedHashSet newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet(capacity(i));
    }

    private static final int capacity(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    public static final List compact(ArrayList arrayList) {
        List emptyList;
        Object first;
        List listOf;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        } else if (size == 1) {
            first = CollectionsKt___CollectionsKt.first((List) arrayList);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(first);
            return listOf;
        } else {
            arrayList.trimToSize();
            return arrayList;
        }
    }
}
