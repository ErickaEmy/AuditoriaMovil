package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CacheByClass.kt */
/* loaded from: classes2.dex */
final class ClassValueCache extends CacheByClass {
    private volatile ComputableClassValue classValue;

    public ClassValueCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.classValue = new ComputableClassValue(compute);
    }

    @Override // kotlin.reflect.jvm.internal.CacheByClass
    public Object get(Class key) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(key, "key");
        ComputableClassValue computableClassValue = this.classValue;
        obj = computableClassValue.get(key);
        Object obj3 = ((SoftReference) obj).get();
        if (obj3 != null) {
            return obj3;
        }
        computableClassValue.remove(key);
        obj2 = computableClassValue.get(key);
        Object obj4 = ((SoftReference) obj2).get();
        return obj4 != null ? obj4 : computableClassValue.compute.invoke(key);
    }
}
