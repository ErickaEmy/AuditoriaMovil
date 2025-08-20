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
final class ClassValueParametrizedCache implements ParametrizedSerializerCache {
    private final ClassValueParametrizedCache$initClassValue$1 classValue;
    private final Function2 compute;

    public ClassValueParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = initClassValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.internal.ClassValueParametrizedCache$initClassValue$1] */
    private final ClassValueParametrizedCache$initClassValue$1 initClassValue() {
        return new ClassValue() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$initClassValue$1
            /* JADX INFO: Access modifiers changed from: protected */
            public ParametrizedCacheEntry computeValue(Class type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new ParametrizedCacheEntry();
            }
        };
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s  reason: not valid java name */
    public Object mo2296getgIAlus(KClass key, List types) {
        Object obj;
        ConcurrentHashMap concurrentHashMap;
        Object m2081constructorimpl;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        obj = get(JvmClassMappingKt.getJavaClass(key));
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
            Object putIfAbsent = concurrentHashMap.putIfAbsent(types, m2080boximpl);
            obj2 = putIfAbsent == null ? m2080boximpl : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).m2089unboximpl();
    }
}
