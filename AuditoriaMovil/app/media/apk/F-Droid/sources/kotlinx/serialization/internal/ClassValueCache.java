package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
/* compiled from: Caching.kt */
/* loaded from: classes2.dex */
final class ClassValueCache implements SerializerCache {
    private final ClassValueCache$initClassValue$1 classValue;
    private final Function1 compute;

    public ClassValueCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = initClassValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.internal.ClassValueCache$initClassValue$1] */
    private final ClassValueCache$initClassValue$1 initClassValue() {
        return new ClassValue() { // from class: kotlinx.serialization.internal.ClassValueCache$initClassValue$1
            /* JADX INFO: Access modifiers changed from: protected */
            public CacheEntry computeValue(Class type) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(type, "type");
                function1 = ClassValueCache.this.compute;
                return new CacheEntry((KSerializer) function1.invoke(JvmClassMappingKt.getKotlinClass(type)));
            }
        };
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer get(KClass key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        obj = get(JvmClassMappingKt.getJavaClass(key));
        return ((CacheEntry) obj).serializer;
    }
}
