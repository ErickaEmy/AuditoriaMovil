package io.ktor.client.engine;

import java.net.Proxy;
/* compiled from: HttpClientEngineConfig.kt */
/* loaded from: classes.dex */
public abstract class HttpClientEngineConfig {
    private boolean pipelining;
    private Proxy proxy;
    private int threadsCount = 4;

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final void setPipelining(boolean z) {
        this.pipelining = z;
    }

    public final void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
}
