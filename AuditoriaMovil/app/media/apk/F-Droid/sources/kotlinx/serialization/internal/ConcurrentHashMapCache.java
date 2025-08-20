package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
/* compiled from: Caching.kt */
/* loaded from: classes2.dex */
final class ConcurrentHashMapCache implements SerializerCache {
    private final ConcurrentHashMap cache;
    private final Function1 compute;

    public ConcurrentHashMapCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer get(KClass key) {
        Object putIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap concurrentHashMap = this.cache;
        Class javaClass = JvmClassMappingKt.getJavaClass(key);
        Object obj = concurrentHashMap.get(javaClass);
        if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (obj = new CacheEntry((KSerializer) this.compute.invoke(key))))) != null) {
            obj = putIfAbsent;
        }
        return ((CacheEntry) obj).serializer;
    }
}
