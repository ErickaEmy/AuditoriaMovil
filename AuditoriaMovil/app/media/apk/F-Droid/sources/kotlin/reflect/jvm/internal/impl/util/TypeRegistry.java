package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* compiled from: ArrayMapOwner.kt */
/* loaded from: classes2.dex */
public abstract class TypeRegistry {
    private final ConcurrentHashMap idPerType = new ConcurrentHashMap();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public abstract int customComputeIfAbsent(ConcurrentHashMap concurrentHashMap, String str, Function1 function1);

    public final NullableArrayMapAccessor generateNullableAccessor(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new NullableArrayMapAccessor(getId(kClass));
    }

    public final int getId(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String qualifiedName = kClass.getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        return getId(qualifiedName);
    }

    public final int getId(String keyQualifiedName) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        return customComputeIfAbsent(this.idPerType, keyQualifiedName, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.TypeRegistry$getId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(String it) {
                AtomicInteger atomicInteger;
                Intrinsics.checkNotNullParameter(it, "it");
                atomicInteger = TypeRegistry.this.idCounter;
                return Integer.valueOf(atomicInteger.getAndIncrement());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection getIndices() {
        Collection values = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return values;
    }
}
