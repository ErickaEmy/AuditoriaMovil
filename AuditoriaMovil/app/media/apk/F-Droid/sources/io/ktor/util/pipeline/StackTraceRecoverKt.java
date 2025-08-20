package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackTraceRecover.kt */
/* loaded from: classes.dex */
public abstract class StackTraceRecoverKt {
    public static final Throwable recoverStackTraceBridge(Throwable exception, Continuation continuation) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        try {
            return StackTraceRecoverJvmKt.withCause(exception, exception.getCause());
        } catch (Throwable unused) {
            return exception;
        }
    }
}
