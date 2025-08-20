package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
/* compiled from: Caching.kt */
/* loaded from: classes2.dex */
final class ConcurrentHashMapParametrizedCache implements ParametrizedSerializerCache {
    private final ConcurrentHashMap cache;
    private final Function2 compute;

    public ConcurrentHashMapParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s */
    public Object mo2296getgIAlus(KClass key, List types) {
        ConcurrentHashMap concurrentHashMap;
        Object m2081constructorimpl;
        Object putIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        ConcurrentHashMap concurrentHashMap2 = this.cache;
        Class javaClass = JvmClassMappingKt.getJavaClass(key);
        Object obj = concurrentHashMap2.get(javaClass);
        if (obj == null && (putIfAbsent = concurrentHashMap2.putIfAbsent(javaClass, (obj = new ParametrizedCacheEntry()))) != null) {
            obj = putIfAbsent;
        }
        concurrentHashMap = ((ParametrizedCacheEntry) obj).serializers;
        Object obj2 = concurrentHashMap.get(types);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.Companion;
                m2081constructorimpl = Result.m2081constructorimpl((KSerializer) this.compute.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
            }
            Result m2080boximpl = Result.m2080boximpl(m2081constructorimpl);
            Object putIfAbsent2 = concurrentHashMap.putIfAbsent(types, m2080boximpl);
            obj2 = putIfAbsent2 == null ? m2080boximpl : putIfAbsent2;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).m2089unboximpl();
    }
}
