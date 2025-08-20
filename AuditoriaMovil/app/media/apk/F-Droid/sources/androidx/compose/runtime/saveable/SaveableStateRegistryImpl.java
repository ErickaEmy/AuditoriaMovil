package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: SaveableStateRegistry.kt */
/* loaded from: classes.dex */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1 canBeSaved;
    private final Map restored;
    private final Map valueProviders;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
        r2 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SaveableStateRegistryImpl(java.util.Map r2, kotlin.jvm.functions.Function1 r3) {
        /*
            r1 = this;
            java.lang.String r0 = "canBeSaved"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r1.<init>()
            r1.canBeSaved = r3
            if (r2 == 0) goto L12
            java.util.Map r2 = kotlin.collections.MapsKt.toMutableMap(r2)
            if (r2 != 0) goto L17
        L12:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
        L17:
            r1.restored = r2
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            r1.valueProviders = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.<init>(java.util.Map, kotlin.jvm.functions.Function1):void");
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ((Boolean) this.canBeSaved.invoke(value)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        List list = (List) this.restored.remove(key);
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        if (list.size() > 1) {
            this.restored.put(key, list.subList(1, list.size()));
        }
        return list.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(final String key, final Function0 valueProvider) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueProvider, "valueProvider");
        isBlank = StringsKt__StringsJVMKt.isBlank(key);
        if (!(!isBlank)) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        Map map = this.valueProviders;
        Object obj = map.get(key);
        if (obj == null) {
            obj = new ArrayList();
            map.put(key, obj);
        }
        ((List) obj).add(valueProvider);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                Map map2;
                Map map3;
                map2 = SaveableStateRegistryImpl.this.valueProviders;
                List list = (List) map2.remove(key);
                if (list != null) {
                    list.remove(valueProvider);
                }
                if (list == null || !(!list.isEmpty())) {
                    return;
                }
                map3 = SaveableStateRegistryImpl.this.valueProviders;
                map3.put(key, list);
            }
        };
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map performSave() {
        Map mutableMap;
        ArrayList arrayListOf;
        mutableMap = MapsKt__MapsKt.toMutableMap(this.restored);
        for (Map.Entry entry : this.valueProviders.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() == 1) {
                Object invoke = ((Function0) list.get(0)).invoke();
                if (invoke == null) {
                    continue;
                } else if (!canBeSaved(invoke)) {
                    throw new IllegalStateException("Check failed.".toString());
                } else {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(invoke);
                    mutableMap.put(str, arrayListOf);
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object invoke2 = ((Function0) list.get(i)).invoke();
                    if (invoke2 != null && !canBeSaved(invoke2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    arrayList.add(invoke2);
                }
                mutableMap.put(str, arrayList);
            }
        }
        return mutableMap;
    }
}
