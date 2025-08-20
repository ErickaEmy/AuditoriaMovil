package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
/* compiled from: OkHttpWebsocketSession.kt */
/* loaded from: classes.dex */
public abstract class OkHttpWebsocketSessionKt {
    private static final CloseReason DEFAULT_CLOSE_REASON_ERROR = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Client failure");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isReserved(CloseReason closeReason) {
        CloseReason.Codes byCode = CloseReason.Codes.Companion.byCode(closeReason.getCode());
        return byCode == null || byCode == CloseReason.Codes.CLOSED_ABNORMALLY;
    }
}
