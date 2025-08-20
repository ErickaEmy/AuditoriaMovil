package io.ktor.client.plugins.websocket;

import io.ktor.client.engine.HttpClientEngineCapability;
/* compiled from: WebSockets.kt */
/* loaded from: classes.dex */
public final class WebSocketCapability implements HttpClientEngineCapability {
    public static final WebSocketCapability INSTANCE = new WebSocketCapability();

    private WebSocketCapability() {
    }

    public String toString() {
        return "WebSocketCapability";
    }
}
