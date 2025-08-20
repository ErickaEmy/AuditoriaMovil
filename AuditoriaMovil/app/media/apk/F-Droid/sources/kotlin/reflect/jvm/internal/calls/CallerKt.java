package kotlin.reflect.jvm.internal.calls;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Caller.kt */
/* loaded from: classes2.dex */
public abstract class CallerKt {
    public static final int getArity(Caller caller) {
        Intrinsics.checkNotNullParameter(caller, "<this>");
        return caller.getParameterTypes().size();
    }
}
