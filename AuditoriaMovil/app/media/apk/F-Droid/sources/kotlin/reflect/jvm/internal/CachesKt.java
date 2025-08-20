package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClassifiers;
/* compiled from: caches.kt */
/* loaded from: classes2.dex */
public abstract class CachesKt {
    private static final CacheByClass K_CLASS_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$K_CLASS_CACHE$1
        @Override // kotlin.jvm.functions.Function1
        public final KClassImpl invoke(Class it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new KClassImpl(it);
        }
    });
    private static final CacheByClass K_PACKAGE_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$K_PACKAGE_CACHE$1
        @Override // kotlin.jvm.functions.Function1
        public final KPackageImpl invoke(Class it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new KPackageImpl(it);
        }
    });
    private static final CacheByClass CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$CACHE_FOR_BASE_CLASSIFIERS$1
        @Override // kotlin.jvm.functions.Function1
        public final KType invoke(Class it) {
            List emptyList;
            List emptyList2;
            Intrinsics.checkNotNullParameter(it, "it");
            KClassImpl orCreateKotlinClass = CachesKt.getOrCreateKotlinClass(it);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return KClassifiers.createType(orCreateKotlinClass, emptyList, false, emptyList2);
        }
    });
    private static final CacheByClass CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1
        @Override // kotlin.jvm.functions.Function1
        public final KType invoke(Class it) {
            List emptyList;
            List emptyList2;
            Intrinsics.checkNotNullParameter(it, "it");
            KClassImpl orCreateKotlinClass = CachesKt.getOrCreateKotlinClass(it);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return KClassifiers.createType(orCreateKotlinClass, emptyList, true, emptyList2);
        }
    });
    private static final CacheByClass CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$CACHE_FOR_GENERIC_CLASSIFIERS$1
        @Override // kotlin.jvm.functions.Function1
        public final ConcurrentHashMap invoke(Class it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new ConcurrentHashMap();
        }
    });

    public static final KClassImpl getOrCreateKotlinClass(Class jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Object obj = K_CLASS_CACHE.get(jClass);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (KClassImpl) obj;
    }

    public static final KDeclarationContainer getOrCreateKotlinPackage(Class jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return (KDeclarationContainer) K_PACKAGE_CACHE.get(jClass);
    }

    public static final KType getOrCreateKType(Class jClass, List arguments, boolean z) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.isEmpty()) {
            if (z) {
                return (KType) CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(jClass);
            }
            return (KType) CACHE_FOR_BASE_CLASSIFIERS.get(jClass);
        }
        return getOrCreateKTypeWithTypeArguments(jClass, arguments, z);
    }

    private static final KType getOrCreateKTypeWithTypeArguments(Class cls, List list, boolean z) {
        List emptyList;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) CACHE_FOR_GENERIC_CLASSIFIERS.get(cls);
        Pair pair = TuplesKt.to(list, Boolean.valueOf(z));
        Object obj = concurrentHashMap.get(pair);
        if (obj == null) {
            KClassImpl orCreateKotlinClass = getOrCreateKotlinClass(cls);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            KType createType = KClassifiers.createType(orCreateKotlinClass, list, z, emptyList);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(pair, createType);
            obj = putIfAbsent == null ? createType : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return (KType) obj;
    }
}
