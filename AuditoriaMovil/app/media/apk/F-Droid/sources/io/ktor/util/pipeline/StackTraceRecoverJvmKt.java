package io.ktor.util.pipeline;

import io.ktor.utils.io.ExceptionUtilsJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackTraceRecoverJvm.kt */
/* loaded from: classes.dex */
public abstract class StackTraceRecoverJvmKt {
    public static final Throwable withCause(Throwable th, Throwable th2) {
        Throwable tryCopyException;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th2 == null || Intrinsics.areEqual(th.getCause(), th2) || (tryCopyException = ExceptionUtilsJvmKt.tryCopyException(th, th2)) == null) {
            return th;
        }
        tryCopyException.setStackTrace(th.getStackTrace());
        return tryCopyException;
    }
}
