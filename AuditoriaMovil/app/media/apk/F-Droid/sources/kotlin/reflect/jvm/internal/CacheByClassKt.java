package kotlin.reflect.jvm.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CacheByClass.kt */
/* loaded from: classes2.dex */
public abstract class CacheByClassKt {
    private static final boolean useClassValue = false;

    static {
        Object m2081constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2081constructorimpl = Result.m2081constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2087isSuccessimpl(m2081constructorimpl)) {
            Class cls = (Class) m2081constructorimpl;
            m2081constructorimpl = Boolean.TRUE;
        }
        Object m2081constructorimpl2 = Result.m2081constructorimpl(m2081constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m2086isFailureimpl(m2081constructorimpl2)) {
            m2081constructorimpl2 = bool;
        }
        ((Boolean) m2081constructorimpl2).booleanValue();
    }

    public static final CacheByClass createCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        return useClassValue ? new ClassValueCache(compute) : new ConcurrentHashMapCache(compute);
    }
}
