package kotlinx.serialization.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Caching.kt */
/* loaded from: classes2.dex */
public abstract class CachingKt {
    private static final boolean useClassValue;

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
        useClassValue = ((Boolean) m2081constructorimpl2).booleanValue();
    }

    public static final SerializerCache createCache(Function1 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return useClassValue ? new ClassValueCache(factory) : new ConcurrentHashMapCache(factory);
    }

    public static final ParametrizedSerializerCache createParametrizedCache(Function2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return useClassValue ? new ClassValueParametrizedCache(factory) : new ConcurrentHashMapParametrizedCache(factory);
    }
}
