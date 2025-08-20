package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.TextContent;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Charsets;
import org.slf4j.Logger;
/* compiled from: HttpPlainText.kt */
/* loaded from: classes.dex */
public final class HttpPlainText {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey key = new AttributeKey("HttpPlainText");
    private final String acceptCharsetHeader;
    private final Charset requestCharset;
    private final Charset responseCharsetFallback;

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes.dex */
    public static final class Config {
        private Charset sendCharset;
        private final Set charsets = new LinkedHashSet();
        private final Map charsetQuality = new LinkedHashMap();
        private Charset responseCharsetFallback = Charsets.UTF_8;

        public final Map getCharsetQuality$ktor_client_core() {
            return this.charsetQuality;
        }

        public final Set getCharsets$ktor_client_core() {
            return this.charsets;
        }

        public final Charset getResponseCharsetFallback() {
            return this.responseCharsetFallback;
        }

        public final Charset getSendCharset() {
            return this.sendCharset;
        }
    }

    public HttpPlainText(Set charsets, Map charsetQuality, Charset charset, Charset responseCharsetFallback) {
        List list;
        List<Pair> sortedWith;
        List<Charset> sortedWith2;
        Object firstOrNull;
        Object firstOrNull2;
        int roundToInt;
        Intrinsics.checkNotNullParameter(charsets, "charsets");
        Intrinsics.checkNotNullParameter(charsetQuality, "charsetQuality");
        Intrinsics.checkNotNullParameter(responseCharsetFallback, "responseCharsetFallback");
        this.responseCharsetFallback = responseCharsetFallback;
        list = MapsKt___MapsKt.toList(charsetQuality);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues((Float) ((Pair) obj2).getSecond(), (Float) ((Pair) obj).getSecond());
                return compareValues;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : charsets) {
            if (!charsetQuality.containsKey((Charset) obj)) {
                arrayList.add(obj);
            }
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(CharsetJVMKt.getName((Charset) obj2), CharsetJVMKt.getName((Charset) obj3));
                return compareValues;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Charset charset2 : sortedWith2) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(CharsetJVMKt.getName(charset2));
        }
        for (Pair pair : sortedWith) {
            Charset charset3 = (Charset) pair.component1();
            float floatValue = ((Number) pair.component2()).floatValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            double d = floatValue;
            if (0.0d > d || d > 1.0d) {
                throw new IllegalStateException("Check failed.".toString());
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(100 * floatValue);
            sb.append(CharsetJVMKt.getName(charset3) + ";q=" + (roundToInt / 100.0d));
        }
        if (sb.length() == 0) {
            sb.append(CharsetJVMKt.getName(this.responseCharsetFallback));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.acceptCharsetHeader = sb2;
        if (charset == null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(sortedWith2);
            charset = (Charset) firstOrNull;
            if (charset == null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull(sortedWith);
                Pair pair2 = (Pair) firstOrNull2;
                charset = pair2 != null ? (Charset) pair2.getFirst() : null;
                if (charset == null) {
                    charset = Charsets.UTF_8;
                }
            }
        }
        this.requestCharset = charset;
    }

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes.dex */
    public static final class Plugin implements HttpClientPlugin {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey getKey() {
            return HttpPlainText.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpPlainText prepare(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpPlainText(config.getCharsets$ktor_client_core(), config.getCharsetQuality$ktor_client_core(), config.getSendCharset(), config.getResponseCharsetFallback());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpPlainText plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new HttpPlainText$Plugin$install$1(plugin, null));
            scope.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new HttpPlainText$Plugin$install$2(plugin, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object wrapContent(HttpRequestBuilder httpRequestBuilder, String str, ContentType contentType) {
        Charset charset;
        Logger logger;
        ContentType plain = contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType;
        if (contentType == null || (charset = ContentTypesKt.charset(contentType)) == null) {
            charset = this.requestCharset;
        }
        logger = HttpPlainTextKt.LOGGER;
        logger.trace("Sending request body to " + httpRequestBuilder.getUrl() + " as text/plain with charset " + charset);
        return new TextContent(str, ContentTypesKt.withCharset(plain, charset), null, 4, null);
    }

    public final String read$ktor_client_core(HttpClientCall call, Input body) {
        Logger logger;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(body, "body");
        Charset charset = HttpMessagePropertiesKt.charset(call.getResponse());
        if (charset == null) {
            charset = this.responseCharsetFallback;
        }
        logger = HttpPlainTextKt.LOGGER;
        logger.trace("Reading response body for " + call.getRequest().getUrl() + " as String with charset " + charset);
        return StringsKt.readText$default(body, charset, 0, 2, null);
    }

    public final void addCharsetHeaders$ktor_client_core(HttpRequestBuilder context) {
        Logger logger;
        Intrinsics.checkNotNullParameter(context, "context");
        HeadersBuilder headers = context.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (headers.get(httpHeaders.getAcceptCharset()) != null) {
            return;
        }
        logger = HttpPlainTextKt.LOGGER;
        logger.trace("Adding Accept-Charset=" + this.acceptCharsetHeader + " to " + context.getUrl());
        context.getHeaders().set(httpHeaders.getAcceptCharset(), this.acceptCharsetHeader);
    }
}
