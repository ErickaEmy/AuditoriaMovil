package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: HttpRequest.kt */
/* loaded from: classes.dex */
public interface HttpRequest extends HttpMessage, CoroutineScope {
    Attributes getAttributes();

    HttpClientCall getCall();

    CoroutineContext getCoroutineContext();

    HttpMethod getMethod();

    Url getUrl();

    /* compiled from: HttpRequest.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static CoroutineContext getCoroutineContext(HttpRequest httpRequest) {
            return httpRequest.getCall().getCoroutineContext();
        }
    }
}
