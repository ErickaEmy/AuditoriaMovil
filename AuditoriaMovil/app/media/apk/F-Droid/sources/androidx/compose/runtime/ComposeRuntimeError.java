package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposeRuntimeError extends IllegalStateException {
    private final String message;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public ComposeRuntimeError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }
}
