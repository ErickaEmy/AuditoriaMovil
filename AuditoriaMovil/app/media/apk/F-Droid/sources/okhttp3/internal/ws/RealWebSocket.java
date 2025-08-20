package okhttp3.internal.ws;

import ch.qos.logback.core.CoreConstants;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.fdroid.fdroid.nearby.httpish.Request;
/* compiled from: RealWebSocket.kt */
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final Companion Companion = new Companion(null);
    private static final List ONLY_HTTP1;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    /* compiled from: RealWebSocket.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long j, WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual(Request.Methods.GET, originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.INSTANCE;
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.cancel();
    }

    public final void connect(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final okhttp3.Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                boolean isValid;
                ArrayDeque arrayDeque;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.checkNotNull(exchange);
                    RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            arrayDeque = realWebSocket.messageAndCloseQueue;
                            arrayDeque.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + build2.url().redact(), newWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                RealWebSocket.this.failWebSocket(e, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (!webSocketExtensions.unknownValues && webSocketExtensions.clientMaxWindowBits == null) {
            return webSocketExtensions.serverMaxWindowBits == null || new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue());
        }
        return false;
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) {
        boolean equals;
        boolean equals2;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String header$default = Response.header$default(response, "Connection", null, 2, null);
        equals = StringsKt__StringsJVMKt.equals("Upgrade", header$default, true);
        if (!equals) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        equals2 = StringsKt__StringsJVMKt.equals("websocket", header$default2, true);
        if (!equals2) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        ByteString.Companion companion = ByteString.Companion;
        String base64 = companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (Intrinsics.areEqual(base64, header$default3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    public final void initReaderAndWriter(String name, Streams streams) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j = this.pingIntervalMillis;
                if (j != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    final String str = name + " ping";
                    this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1
                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            this.writePingFrame$okhttp();
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (i == -1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            try {
                if (this.receivedCloseCode != -1) {
                    throw new IllegalStateException("already closed".toString());
                }
                this.receivedCloseCode = i;
                this.receivedCloseReason = reason;
                streams = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    Streams streams2 = this.streams;
                    this.streams = null;
                    webSocketReader = this.reader;
                    this.reader = null;
                    webSocketWriter = this.writer;
                    this.writer = null;
                    this.taskQueue.shutdown();
                    streams = streams2;
                } else {
                    webSocketReader = null;
                    webSocketWriter = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            this.listener.onClosing(this, i, reason);
            if (streams != null) {
                this.listener.onClosed(this, i, reason);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return close(i, str, CoreConstants.MILLIS_IN_ONE_MINUTE);
    }

    public final synchronized boolean close(int i, String str, long j) {
        ByteString byteString;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i);
            if (str != null) {
                byteString = ByteString.Companion.encodeUtf8(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                byteString = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteString, j));
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean writeOneFrame$okhttp() {
        String str;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        int i;
        Streams streams;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.writer;
                Object poll = this.pongQueue.poll();
                Object obj = null;
                if (poll == null) {
                    Object poll2 = this.messageAndCloseQueue.poll();
                    if (poll2 instanceof Close) {
                        i = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i != -1) {
                            streams = this.streams;
                            this.streams = null;
                            webSocketReader = this.reader;
                            this.reader = null;
                            webSocketWriter = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                        } else {
                            long cancelAfterCloseMillis = ((Close) poll2).getCancelAfterCloseMillis();
                            final String str2 = this.name + " cancel";
                            this.taskQueue.schedule(new Task(str2, true) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.cancel();
                                    return -1L;
                                }
                            }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                            streams = null;
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                    } else if (poll2 == null) {
                        return false;
                    } else {
                        str = null;
                        webSocketReader = null;
                        webSocketWriter = null;
                        i = -1;
                        streams = null;
                    }
                    obj = poll2;
                } else {
                    str = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                    i = -1;
                    streams = null;
                }
                Unit unit = Unit.INSTANCE;
                try {
                    if (poll != null) {
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writePong((ByteString) poll);
                    } else if (obj instanceof Message) {
                        Message message = (Message) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writeMessageFrame(message.getFormatOpcode(), message.getData());
                        synchronized (this) {
                            this.queueSize -= message.getData().size();
                        }
                    } else if (obj instanceof Close) {
                        Close close = (Close) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writeClose(close.getCode(), close.getReason());
                        if (streams != null) {
                            WebSocketListener webSocketListener = this.listener;
                            Intrinsics.checkNotNull(str);
                            webSocketListener.onClosed(this, i, str);
                        }
                    } else {
                        throw new AssertionError();
                    }
                    return true;
                } finally {
                    if (streams != null) {
                        Util.closeQuietly(streams);
                    }
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.closeQuietly(webSocketWriter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                Unit unit = Unit.INSTANCE;
                if (i != -1) {
                    failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e) {
                    failWebSocket(e, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void failWebSocket(Exception e, Response response) {
        Intrinsics.checkNotNullParameter(e, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.onFailure(this, e, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    /* compiled from: RealWebSocket.kt */
    /* loaded from: classes2.dex */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public Message(int i, ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }
    }

    /* compiled from: RealWebSocket.kt */
    /* loaded from: classes2.dex */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* compiled from: RealWebSocket.kt */
    /* loaded from: classes2.dex */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public Streams(boolean z, BufferedSource source, BufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }
    }

    /* compiled from: RealWebSocket.kt */
    /* loaded from: classes2.dex */
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, null);
                return -1L;
            }
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
        ONLY_HTTP1 = listOf;
    }
}
