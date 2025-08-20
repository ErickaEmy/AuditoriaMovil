package kotlin.reflect.jvm.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CacheByClass.kt */
/* loaded from: classes2.dex */
final class ConcurrentHashMapCache extends CacheByClass {
    private final ConcurrentHashMap cache;
    private final Function1 compute;

    @Override // kotlin.reflect.jvm.internal.CacheByClass
    public Object get(Class key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap concurrentHashMap = this.cache;
        Object obj = concurrentHashMap.get(key);
        if (obj == null) {
            Object invoke = this.compute.invoke(key);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(key, invoke);
            return putIfAbsent == null ? invoke : putIfAbsent;
        }
        return obj;
    }

    public ConcurrentHashMapCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap();
    }
}
