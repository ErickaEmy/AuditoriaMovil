package io.ktor.client.engine;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes.dex */
public final class ClientEngineClosedException extends IllegalStateException {
    private final Throwable cause;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public /* synthetic */ ClientEngineClosedException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }

    public ClientEngineClosedException(Throwable th) {
        super("Client already closed");
        this.cause = th;
    }
}
