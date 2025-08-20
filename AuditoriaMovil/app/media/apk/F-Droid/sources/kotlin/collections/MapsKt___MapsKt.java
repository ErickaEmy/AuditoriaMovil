package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Maps.kt */
/* loaded from: classes.dex */
public abstract class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public static List toList(Map map) {
        List listOf;
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.size() == 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (!it.hasNext()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(entry.getKey(), entry.getValue()));
            return listOf;
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        do {
            Map.Entry entry2 = (Map.Entry) it.next();
            arrayList.add(new Pair(entry2.getKey(), entry2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
