package io.ktor.client.utils;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes.dex */
public abstract class ExceptionUtilsJvmKt {
    public static final Throwable unwrapCancellationException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Throwable th2 = th;
        while (th2 instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) th2;
            if (Intrinsics.areEqual(th2, cancellationException.getCause())) {
                return th;
            }
            th2 = cancellationException.getCause();
        }
        return th2 == null ? th : th2;
    }
}
