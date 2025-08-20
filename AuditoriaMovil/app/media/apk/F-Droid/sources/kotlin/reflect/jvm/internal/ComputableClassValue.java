package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CacheByClass.kt */
/* loaded from: classes2.dex */
final class ComputableClassValue extends ClassValue {
    public final Function1 compute;

    public ComputableClassValue(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoftReference computeValue(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new SoftReference(this.compute.invoke(type));
    }
}
