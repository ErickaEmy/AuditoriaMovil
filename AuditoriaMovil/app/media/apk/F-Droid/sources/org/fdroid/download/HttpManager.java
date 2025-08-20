package org.fdroid.download;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.ResponseException;
import io.ktor.client.plugins.UserAgent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import mu.KLogger;
import mu.KotlinLogging;
import okhttp3.Dns;
import okhttp3.HttpUrl;
/* compiled from: HttpManager.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\f\b\u0002\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\u0002\u0010\u0010J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0087@¢\u0006\u0002\u0010\"J$\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0080@¢\u0006\u0004\b%\u0010&J$\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0080@¢\u0006\u0004\b)\u0010&J.\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00100J\u001a\u00101\u001a\u00020\u00162\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002J$\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u00105J0\u00106\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0010\b\u0002\u00108\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0086@¢\u0006\u0002\u00109J$\u0010:\u001a\u00020\u001b2\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002J\f\u0010;\u001a\u00020\u001b*\u00020<H\u0002J\u0014\u0010=\u001a\u00020\u001b*\u00020>2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R.\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lorg/fdroid/download/HttpManager;", "", "userAgent", "", "queryString", "proxyConfig", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "customDns", "Lokhttp3/Dns;", "highTimeouts", "", "mirrorChooser", "Lorg/fdroid/download/MirrorChooser;", "httpClientEngineFactory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/Proxy;Lokhttp3/Dns;ZLorg/fdroid/download/MirrorChooser;Lio/ktor/client/engine/HttpClientEngineFactory;)V", "<set-?>", "currentProxy", "getCurrentProxy$download_release", "()Ljava/net/Proxy;", "httpClient", "Lio/ktor/client/HttpClient;", "parameters", "", "Lkotlin/Pair;", "get", "", "request", "Lorg/fdroid/download/DownloadRequest;", "skipFirstBytes", "", "receiver", "Lorg/fdroid/download/BytesReceiver;", "(Lorg/fdroid/download/DownloadRequest;Ljava/lang/Long;Lorg/fdroid/download/BytesReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBytes", "", "getBytes$download_release", "(Lorg/fdroid/download/DownloadRequest;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannel", "Lio/ktor/utils/io/ByteReadChannel;", "getChannel$download_release", "getHttpStatement", "Lio/ktor/client/statement/HttpStatement;", "mirror", "Lorg/fdroid/download/Mirror;", "url", "Lio/ktor/http/Url;", "(Lorg/fdroid/download/DownloadRequest;Lorg/fdroid/download/Mirror;Lio/ktor/http/Url;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewHttpClient", "head", "Lorg/fdroid/download/HeadInfo;", "eTag", "(Lorg/fdroid/download/DownloadRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "json", "proxy", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/Proxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetProxyIfNeeded", "addQueryParameters", "Lio/ktor/client/request/HttpRequestBuilder;", "basicAuth", "Lio/ktor/http/HttpMessageBuilder;", "Companion", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class HttpManager {
    public static final int READ_BUFFER = 8192;
    private static final long TIMEOUT_MILLIS_HIGH = 300000;
    private Proxy currentProxy;
    private final boolean highTimeouts;
    private HttpClient httpClient;
    private final HttpClientEngineFactory httpClientEngineFactory;
    private final MirrorChooser mirrorChooser;
    private final List<Pair> parameters;
    private final String userAgent;
    public static final Companion Companion = new Companion(null);
    private static final KLogger log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.download.HttpManager$Companion$log$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2376invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2376invoke();
            return Unit.INSTANCE;
        }
    });

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent) {
        this(userAgent, null, null, null, false, null, null, 126, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent, String str) {
        this(userAgent, str, null, null, false, null, null, 124, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent, String str, Proxy proxy) {
        this(userAgent, str, proxy, null, false, null, null, 120, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent, String str, Proxy proxy, Dns dns) {
        this(userAgent, str, proxy, dns, false, null, null, 112, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent, String str, Proxy proxy, Dns dns, boolean z) {
        this(userAgent, str, proxy, dns, z, null, null, 96, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpManager(String userAgent, String str, Proxy proxy, Dns dns, boolean z, MirrorChooser mirrorChooser) {
        this(userAgent, str, proxy, dns, z, mirrorChooser, null, 64, null);
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(mirrorChooser, "mirrorChooser");
    }

    public final Object get(DownloadRequest downloadRequest, BytesReceiver bytesReceiver, Continuation continuation) throws ResponseException, NoResumeException, CancellationException {
        return get$default(this, downloadRequest, null, bytesReceiver, continuation, 2, null);
    }

    public final Proxy getCurrentProxy$download_release() {
        return this.currentProxy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
        r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new char[]{'&'}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HttpManager(java.lang.String r8, java.lang.String r9, java.net.Proxy r10, okhttp3.Dns r11, boolean r12, org.fdroid.download.MirrorChooser r13, io.ktor.client.engine.HttpClientEngineFactory r14) {
        /*
            r7 = this;
            java.lang.String r11 = "userAgent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r11)
            java.lang.String r11 = "mirrorChooser"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r11)
            java.lang.String r11 = "httpClientEngineFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r11)
            r7.<init>()
            r7.userAgent = r8
            r7.highTimeouts = r12
            r7.mirrorChooser = r13
            r7.httpClientEngineFactory = r14
            io.ktor.client.HttpClient r8 = r7.getNewHttpClient(r10)
            r7.httpClient = r8
            if (r9 == 0) goto L73
            r8 = 1
            char[] r10 = new char[r8]
            r11 = 38
            r0 = 0
            r10[r0] = r11
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            java.util.List r9 = kotlin.text.StringsKt.split$default(r9, r10, r11, r12, r13, r14)
            if (r9 == 0) goto L73
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r11)
            r10.<init>(r11)
            java.util.Iterator r9 = r9.iterator()
        L43:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L74
            java.lang.Object r11 = r9.next()
            r1 = r11
            java.lang.String r1 = (java.lang.String) r1
            char[] r2 = new char[r8]
            r11 = 61
            r2[r0] = r11
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r11 = kotlin.text.StringsKt.split$default(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r11.get(r0)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r11 = r11.get(r8)
            java.lang.String r11 = (java.lang.String) r11
            kotlin.Pair r13 = new kotlin.Pair
            r13.<init>(r12, r11)
            r10.add(r13)
            goto L43
        L73:
            r10 = 0
        L74:
            r7.parameters = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManager.<init>(java.lang.String, java.lang.String, java.net.Proxy, okhttp3.Dns, boolean, org.fdroid.download.MirrorChooser, io.ktor.client.engine.HttpClientEngineFactory):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ HttpManager(java.lang.String r7, java.lang.String r8, java.net.Proxy r9, okhttp3.Dns r10, boolean r11, org.fdroid.download.MirrorChooser r12, io.ktor.client.engine.HttpClientEngineFactory r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r0 = r14 & 2
            r1 = 0
            if (r0 == 0) goto L7
            r0 = r1
            goto L8
        L7:
            r0 = r8
        L8:
            r2 = r14 & 4
            if (r2 == 0) goto Le
            r2 = r1
            goto Lf
        Le:
            r2 = r9
        Lf:
            r3 = r14 & 8
            if (r3 == 0) goto L14
            goto L15
        L14:
            r1 = r10
        L15:
            r3 = r14 & 16
            if (r3 == 0) goto L1b
            r3 = 0
            goto L1c
        L1b:
            r3 = r11
        L1c:
            r4 = r14 & 32
            if (r4 == 0) goto L26
            org.fdroid.download.MirrorChooserRandom r4 = new org.fdroid.download.MirrorChooserRandom
            r4.<init>()
            goto L27
        L26:
            r4 = r12
        L27:
            r5 = r14 & 64
            if (r5 == 0) goto L30
            io.ktor.client.engine.HttpClientEngineFactory r5 = org.fdroid.download.HttpManagerKt.getHttpClientEngineFactory(r1)
            goto L31
        L30:
            r5 = r13
        L31:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManager.<init>(java.lang.String, java.lang.String, java.net.Proxy, okhttp3.Dns, boolean, org.fdroid.download.MirrorChooser, io.ktor.client.engine.HttpClientEngineFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* compiled from: HttpManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lorg/fdroid/download/HttpManager$Companion;", "", "()V", "READ_BUFFER", "", "TIMEOUT_MILLIS_HIGH", "", "log", "Lmu/KLogger;", "getLog$download_release", "()Lmu/KLogger;", "isInvalidHttpUrl", "", "url", "", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KLogger getLog$download_release() {
            return HttpManager.log;
        }

        public final boolean isInvalidHttpUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return HttpUrl.Companion.parse(url) == null;
        }
    }

    static /* synthetic */ HttpClient getNewHttpClient$default(HttpManager httpManager, Proxy proxy, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                proxy = null;
            }
            return httpManager.getNewHttpClient(proxy);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNewHttpClient");
    }

    private final HttpClient getNewHttpClient(final Proxy proxy) {
        this.currentProxy = proxy;
        return HttpClientKt.HttpClient(this.httpClientEngineFactory, new Function1() { // from class: org.fdroid.download.HttpManager$getNewHttpClient$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HttpClientConfig) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HttpClientConfig HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.setFollowRedirects(false);
                HttpClient.setExpectSuccess(true);
                final Proxy proxy2 = proxy;
                HttpClient.engine(new Function1() { // from class: org.fdroid.download.HttpManager$getNewHttpClient$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((HttpClientEngineConfig) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(HttpClientEngineConfig engine) {
                        Intrinsics.checkNotNullParameter(engine, "$this$engine");
                        engine.setPipelining(true);
                        engine.setProxy(proxy2);
                    }
                });
                UserAgent.Plugin plugin = UserAgent.Plugin;
                final HttpManager httpManager = this;
                HttpClient.install(plugin, new Function1() { // from class: org.fdroid.download.HttpManager$getNewHttpClient$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((UserAgent.Config) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(UserAgent.Config install) {
                        String str;
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        str = HttpManager.this.userAgent;
                        install.setAgent(str);
                    }
                });
                HttpTimeout.Plugin plugin2 = HttpTimeout.Plugin;
                final HttpManager httpManager2 = this;
                final Proxy proxy3 = proxy;
                HttpClient.install(plugin2, new Function1() { // from class: org.fdroid.download.HttpManager$getNewHttpClient$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((HttpTimeout.HttpTimeoutCapabilityConfiguration) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        z = HttpManager.this.highTimeouts;
                        if (z || ProxyKt.isTor(proxy3)) {
                            install.setConnectTimeoutMillis(300000L);
                            install.setSocketTimeoutMillis(300000L);
                            install.setRequestTimeoutMillis(300000L);
                        }
                    }
                });
            }
        });
    }

    public static /* synthetic */ Object head$default(HttpManager httpManager, DownloadRequest downloadRequest, String str, Continuation continuation, int i, Object obj) throws NotFoundException {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            return httpManager.head(downloadRequest, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: head");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object head(org.fdroid.download.DownloadRequest r6, java.lang.String r7, kotlin.coroutines.Continuation r8) throws org.fdroid.download.NotFoundException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof org.fdroid.download.HttpManager$head$1
            if (r0 == 0) goto L13
            r0 = r8
            org.fdroid.download.HttpManager$head$1 r0 = (org.fdroid.download.HttpManager$head$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            org.fdroid.download.HttpManager$head$1 r0 = new org.fdroid.download.HttpManager$head$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            goto L4e
        L2f:
            r6 = move-exception
            goto L9b
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            org.fdroid.download.MirrorChooser r8 = r5.mirrorChooser     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            org.fdroid.download.HttpManager$head$response$1 r2 = new org.fdroid.download.HttpManager$head$response$1     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            r2.<init>(r5, r6, r3)     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            r0.L$0 = r7     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            r0.label = r4     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            java.lang.Object r8 = r8.mirrorRequest(r6, r2, r0)     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            if (r8 != r1) goto L4e
            return r1
        L4e:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8     // Catch: io.ktor.client.plugins.ResponseException -> L2f
            java.lang.Long r6 = io.ktor.http.HttpMessagePropertiesKt.contentLength(r8)
            io.ktor.http.Headers r0 = r8.getHeaders()
            io.ktor.http.HttpHeaders r1 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r1.getLastModified()
            java.lang.String r0 = r0.get(r2)
            if (r7 == 0) goto L89
            io.ktor.http.Headers r2 = r8.getHeaders()
            java.lang.String r3 = r1.getETag()
            java.lang.String r2 = r2.get(r3)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r7 == 0) goto L89
            org.fdroid.download.HeadInfo r7 = new org.fdroid.download.HeadInfo
            io.ktor.http.Headers r8 = r8.getHeaders()
            java.lang.String r1 = r1.getETag()
            java.lang.String r8 = r8.get(r1)
            r1 = 0
            r7.<init>(r1, r8, r6, r0)
            return r7
        L89:
            org.fdroid.download.HeadInfo r7 = new org.fdroid.download.HeadInfo
            io.ktor.http.Headers r8 = r8.getHeaders()
            java.lang.String r1 = r1.getETag()
            java.lang.String r8 = r8.get(r1)
            r7.<init>(r4, r8, r6, r0)
            return r7
        L9b:
            mu.KLogger r7 = org.fdroid.download.HttpManager.log
            org.fdroid.download.HttpManager$head$response$2 r8 = new org.fdroid.download.HttpManager$head$response$2
            r8.<init>()
            r7.warn(r8)
            io.ktor.client.statement.HttpResponse r6 = r6.getResponse()
            io.ktor.http.HttpStatusCode r6 = r6.getStatus()
            io.ktor.http.HttpStatusCode$Companion r7 = io.ktor.http.HttpStatusCode.Companion
            io.ktor.http.HttpStatusCode r7 = r7.getNotFound()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 != 0) goto Lba
            return r3
        Lba:
            org.fdroid.download.NotFoundException r6 = new org.fdroid.download.NotFoundException
            r6.<init>(r3, r4, r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManager.head(org.fdroid.download.DownloadRequest, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object get$default(HttpManager httpManager, DownloadRequest downloadRequest, Long l, BytesReceiver bytesReceiver, Continuation continuation, int i, Object obj) throws ResponseException, NoResumeException, CancellationException {
        if (obj == null) {
            if ((i & 2) != 0) {
                l = null;
            }
            return httpManager.get(downloadRequest, l, bytesReceiver, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public final Object get(DownloadRequest downloadRequest, Long l, BytesReceiver bytesReceiver, Continuation continuation) throws ResponseException, NoResumeException, CancellationException {
        Object coroutine_suspended;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = l != null ? l.longValue() : 0L;
        Object mirrorRequest = this.mirrorChooser.mirrorRequest(downloadRequest, new HttpManager$get$2(this, downloadRequest, ref$LongRef, bytesReceiver, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mirrorRequest == coroutine_suspended ? mirrorRequest : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getHttpStatement(DownloadRequest downloadRequest, Mirror mirror, final Url url, long j, Continuation continuation) {
        resetProxyIfNeeded(downloadRequest.getProxy(), mirror);
        log.debug(new Function0() { // from class: org.fdroid.download.HttpManager$getHttpStatement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url2 = Url.this;
                return "GET " + url2;
            }
        });
        HttpClient httpClient = this.httpClient;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        addQueryParameters(httpRequestBuilder);
        basicAuth(httpRequestBuilder, downloadRequest);
        if (mirror.isOnion()) {
            HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: org.fdroid.download.HttpManager$getHttpStatement$3$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((HttpTimeout.HttpTimeoutCapabilityConfiguration) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
                    Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
                    timeout.setConnectTimeoutMillis(20000L);
                }
            });
        }
        if (j > 0) {
            String range = HttpHeaders.INSTANCE.getRange();
            UtilsKt.header(httpRequestBuilder, range, "bytes=" + j + "-");
        }
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object getChannel$download_release$default(HttpManager httpManager, DownloadRequest downloadRequest, Long l, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                l = null;
            }
            return httpManager.getChannel$download_release(downloadRequest, l, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChannel");
    }

    public final Object getChannel$download_release(DownloadRequest downloadRequest, Long l, Continuation continuation) {
        return this.mirrorChooser.mirrorRequest(downloadRequest, new HttpManager$getChannel$2(this, downloadRequest, l, null), continuation);
    }

    public static /* synthetic */ Object getBytes$download_release$default(HttpManager httpManager, DownloadRequest downloadRequest, Long l, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                l = null;
            }
            return httpManager.getBytes$download_release(downloadRequest, l, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBytes");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.fdroid.download.HttpManager] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getBytes$download_release(org.fdroid.download.DownloadRequest r5, java.lang.Long r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof org.fdroid.download.HttpManager$getBytes$1
            if (r0 == 0) goto L13
            r0 = r7
            org.fdroid.download.HttpManager$getBytes$1 r0 = (org.fdroid.download.HttpManager$getBytes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            org.fdroid.download.HttpManager$getBytes$1 r0 = new org.fdroid.download.HttpManager$getBytes$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.lang.Object r6 = r0.L$0
            java.io.ByteArrayOutputStream r6 = (java.io.ByteArrayOutputStream) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L31
            goto L57
        L31:
            r6 = move-exception
            goto L69
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            org.fdroid.download.HttpManager$getBytes$2$1 r2 = new org.fdroid.download.HttpManager$getBytes$2$1     // Catch: java.lang.Throwable -> L67
            r2.<init>()     // Catch: java.lang.Throwable -> L67
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L67
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L67
            r0.label = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r5 = r4.get(r5, r6, r2, r0)     // Catch: java.lang.Throwable -> L67
            if (r5 != r1) goto L55
            return r1
        L55:
            r5 = r7
            r6 = r5
        L57:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L31
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r7)
            byte[] r5 = r6.toByteArray()
            java.lang.String r6 = "toByteArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        L67:
            r6 = move-exception
            r5 = r7
        L69:
            throw r6     // Catch: java.lang.Throwable -> L6a
        L6a:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManager.getBytes$download_release(org.fdroid.download.DownloadRequest, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object post$default(HttpManager httpManager, String str, String str2, Proxy proxy, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                proxy = null;
            }
            return httpManager.post(str, str2, proxy, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
    }

    public final Object post(String str, String str2, Proxy proxy, Continuation continuation) {
        Object coroutine_suspended;
        resetProxyIfNeeded$default(this, proxy, null, 2, null);
        HttpClient httpClient = this.httpClient;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        addQueryParameters(httpRequestBuilder);
        HttpRequestKt.url(httpRequestBuilder, str);
        UtilsKt.header(httpRequestBuilder, HttpHeaders.INSTANCE.getContentType(), "application/json; utf-8");
        if (str2 == null) {
            httpRequestBuilder.setBody(NullBody.INSTANCE);
            KType typeOf = Reflection.typeOf(String.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(String.class), typeOf));
        } else if (str2 instanceof OutgoingContent) {
            httpRequestBuilder.setBody(str2);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(str2);
            KType typeOf2 = Reflection.typeOf(String.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(String.class), typeOf2));
        }
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        Object execute = new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return execute == coroutine_suspended ? execute : Unit.INSTANCE;
    }

    static /* synthetic */ void resetProxyIfNeeded$default(HttpManager httpManager, Proxy proxy, Mirror mirror, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetProxyIfNeeded");
        }
        if ((i & 2) != 0) {
            mirror = null;
        }
        httpManager.resetProxyIfNeeded(proxy, mirror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetProxyIfNeeded(final Proxy proxy, final Mirror mirror) {
        if (MirrorKt.isLocal(mirror) && proxy != null) {
            if (this.currentProxy != null) {
                log.debug(new Function0() { // from class: org.fdroid.download.HttpManager$resetProxyIfNeeded$newProxy$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Mirror mirror2 = Mirror.this;
                        return "Forcing mirror to null, because mirror is local: " + mirror2;
                    }
                });
            }
            proxy = null;
        }
        if (Intrinsics.areEqual(this.currentProxy, proxy)) {
            return;
        }
        log.debug(new Function0() { // from class: org.fdroid.download.HttpManager$resetProxyIfNeeded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Proxy currentProxy$download_release = HttpManager.this.getCurrentProxy$download_release();
                Proxy proxy2 = proxy;
                return "Switching proxy from [" + currentProxy$download_release + "] to [" + proxy2 + "]";
            }
        });
        this.httpClient.close();
        this.httpClient = getNewHttpClient(proxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void basicAuth(HttpMessageBuilder httpMessageBuilder, DownloadRequest downloadRequest) {
        if (downloadRequest.getHasCredentials()) {
            String username = downloadRequest.getUsername();
            Intrinsics.checkNotNull(username);
            String password = downloadRequest.getPassword();
            Intrinsics.checkNotNull(password);
            UtilsKt.basicAuth(httpMessageBuilder, username, password);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addQueryParameters(HttpRequestBuilder httpRequestBuilder) {
        List<Pair> list = this.parameters;
        if (list != null) {
            for (Pair pair : list) {
                UtilsKt.parameter(httpRequestBuilder, (String) pair.component1(), (String) pair.component2());
            }
        }
    }
}
