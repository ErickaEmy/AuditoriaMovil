package io.ktor.client.engine.okhttp;

import ch.qos.logback.core.CoreConstants;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ActorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
/* compiled from: OkHttpWebsocketSession.kt */
/* loaded from: classes.dex */
public final class OkHttpWebsocketSession extends WebSocketListener implements CoroutineScope {
    private final CompletableDeferred _closeReason;
    private final Channel _incoming;
    private final CoroutineContext coroutineContext;
    private final OkHttpClient engine;
    private final CompletableDeferred originResponse;
    private final SendChannel outgoing;
    private final CompletableDeferred self;
    private final WebSocket.Factory webSocketFactory;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final CompletableDeferred getOriginResponse$ktor_client_okhttp() {
        return this.originResponse;
    }

    public SendChannel getOutgoing() {
        return this.outgoing;
    }

    public OkHttpWebsocketSession(OkHttpClient engine, WebSocket.Factory webSocketFactory, Request engineRequest, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(engineRequest, "engineRequest");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.engine = engine;
        this.webSocketFactory = webSocketFactory;
        this.coroutineContext = coroutineContext;
        this.self = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.originResponse = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this._incoming = ChannelKt.Channel$default(0, null, null, 7, null);
        this._closeReason = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.outgoing = ActorKt.actor$default(this, null, 0, null, null, new OkHttpWebsocketSession$outgoing$1(this, engineRequest, null), 15, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        this.originResponse.complete(response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        super.onMessage(webSocket, bytes);
        ChannelsKt.trySendBlocking(this._incoming, new Frame.Binary(true, bytes.toByteArray()));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(text, "text");
        super.onMessage(webSocket, text);
        Channel channel = this._incoming;
        byte[] bytes = text.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ChannelsKt.trySendBlocking(channel, new Frame.Text(true, bytes));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i, String reason) {
        Object valueOf;
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.onClosed(webSocket, i, reason);
        short s = (short) i;
        this._closeReason.complete(new CloseReason(s, reason));
        SendChannel.DefaultImpls.close$default(this._incoming, null, 1, null);
        SendChannel outgoing = getOutgoing();
        StringBuilder sb = new StringBuilder();
        sb.append("WebSocket session closed with code ");
        CloseReason.Codes byCode = CloseReason.Codes.Companion.byCode(s);
        if (byCode == null || (valueOf = byCode.toString()) == null) {
            valueOf = Integer.valueOf(i);
        }
        sb.append(valueOf);
        sb.append(CoreConstants.DOT);
        outgoing.close(new CancellationException(sb.toString()));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i, String reason) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.onClosing(webSocket, i, reason);
        short s = (short) i;
        this._closeReason.complete(new CloseReason(s, reason));
        try {
            ChannelsKt.trySendBlocking(getOutgoing(), new Frame.Close(new CloseReason(s, reason)));
        } catch (Throwable unused) {
        }
        SendChannel.DefaultImpls.close$default(this._incoming, null, 1, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(t, "t");
        super.onFailure(webSocket, t, response);
        this._closeReason.completeExceptionally(t);
        this.originResponse.completeExceptionally(t);
        this._incoming.close(t);
        getOutgoing().close(t);
    }

    public final void start() {
        this.self.complete(this);
    }
}
