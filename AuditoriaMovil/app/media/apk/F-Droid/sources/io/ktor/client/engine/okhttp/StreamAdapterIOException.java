package io.ktor.client.engine.okhttp;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StreamRequestBody.kt */
/* loaded from: classes.dex */
public final class StreamAdapterIOException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamAdapterIOException(Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
