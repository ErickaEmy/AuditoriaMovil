package io.ktor.client.call;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: HttpClientCall.kt */
/* loaded from: classes.dex */
public final class DoubleReceiveException extends IllegalStateException {
    private final String message;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public DoubleReceiveException(HttpClientCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.message = "Response already received: " + call;
    }
}
