package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
/* compiled from: OkHttp.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001e\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngineContainer;", "", "", "toString", "Lio/ktor/client/engine/HttpClientEngineFactory;", "factory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "getFactory", "()Lio/ktor/client/engine/HttpClientEngineFactory;", "<init>", "()V", "ktor-client-okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class OkHttpEngineContainer {
    private final HttpClientEngineFactory factory = OkHttp.INSTANCE;

    public String toString() {
        return "OkHttp";
    }
}
