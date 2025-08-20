package io.ktor.client.engine.okhttp;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;
/* compiled from: OkHttpEngine.kt */
/* loaded from: classes.dex */
public abstract class OkHttpEngineKt {
    public static final /* synthetic */ Throwable access$mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return mapExceptions(th, httpRequestData);
    }

    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return CoroutinesKt.writer$default(GlobalScope.INSTANCE, coroutineContext, false, new OkHttpEngineKt$toChannel$1(bufferedSource, coroutineContext, httpRequestData, null), 2, null).getChannel();
    }

    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().toString());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(key, HttpHeaders.INSTANCE.getContentLength())) {
                    return;
                }
                Request.Builder.this.addHeader(key, value);
            }
        });
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext) : null);
        return builder.build();
    }

    public static final RequestBody convertToOkHttpBody(final OutgoingContent outgoingContent, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bytes = ((OutgoingContent.ByteArrayContent) outgoingContent).bytes();
            return RequestBody.Companion.create(bytes, MediaType.Companion.parse(String.valueOf(outgoingContent.getContentType())), 0, bytes.length);
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Function0() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ByteReadChannel invoke() {
                    return ((OutgoingContent.ReadChannelContent) OutgoingContent.this).readFrom();
                }
            });
        } else {
            if (outgoingContent instanceof OutgoingContent.NoContent) {
                return RequestBody.Companion.create(new byte[0], null, 0, 0);
            }
            throw new UnsupportedContentTypeException(outgoingContent);
        }
    }

    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long connectTimeoutMillis = httpTimeoutCapabilityConfiguration.getConnectTimeoutMillis();
        if (connectTimeoutMillis != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(connectTimeoutMillis.longValue()), TimeUnit.MILLISECONDS);
        }
        Long socketTimeoutMillis = httpTimeoutCapabilityConfiguration.getSocketTimeoutMillis();
        if (socketTimeoutMillis != null) {
            long longValue = socketTimeoutMillis.longValue();
            long convertLongTimeoutToLongWithInfiniteAsZero = HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.readTimeout(convertLongTimeoutToLongWithInfiniteAsZero, timeUnit);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue), timeUnit);
        }
        return builder;
    }
}
