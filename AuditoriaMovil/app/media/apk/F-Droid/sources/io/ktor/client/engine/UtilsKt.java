package io.ktor.client.engine;

import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
/* loaded from: classes.dex */
public abstract class UtilsKt {
    private static final Set DATE_HEADERS;
    private static final String KTOR_DEFAULT_USER_AGENT = "Ktor client";

    static {
        Set of;
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        of = SetsKt__SetsKt.setOf((Object[]) new String[]{httpHeaders.getDate(), httpHeaders.getExpires(), httpHeaders.getLastModified(), httpHeaders.getIfModifiedSince(), httpHeaders.getIfUnmodifiedSince()});
        DATE_HEADERS = of;
    }

    public static final void mergeHeaders(final Headers requestHeaders, final OutgoingContent content, final Function2 block) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(block, "block");
        HeadersKt.buildHeaders(new Function1() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HeadersBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HeadersBuilder buildHeaders) {
                Intrinsics.checkNotNullParameter(buildHeaders, "$this$buildHeaders");
                buildHeaders.appendAll(Headers.this);
                buildHeaders.appendAll(content.getHeaders());
            }
        }).forEach(new Function2() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (List) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String key, List values) {
                Set set;
                String joinToString$default;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(values, "values");
                HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                if (Intrinsics.areEqual(httpHeaders.getContentLength(), key) || Intrinsics.areEqual(httpHeaders.getContentType(), key)) {
                    return;
                }
                set = UtilsKt.DATE_HEADERS;
                if (!set.contains(key)) {
                    String str3 = Intrinsics.areEqual(httpHeaders.getCookie(), key) ? "; " : ",";
                    Function2 function2 = Function2.this;
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(values, str3, null, null, 0, null, null, 62, null);
                    function2.invoke(key, joinToString$default);
                    return;
                }
                Function2 function22 = Function2.this;
                Iterator it = values.iterator();
                while (it.hasNext()) {
                    function22.invoke(key, (String) it.next());
                }
            }
        });
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (requestHeaders.get(httpHeaders.getUserAgent()) == null && content.getHeaders().get(httpHeaders.getUserAgent()) == null && needUserAgent()) {
            block.invoke(httpHeaders.getUserAgent(), KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = content.getContentType();
        if ((contentType == null || (str = contentType.toString()) == null) && (str = content.getHeaders().get(httpHeaders.getContentType())) == null) {
            str = requestHeaders.get(httpHeaders.getContentType());
        }
        Long contentLength = content.getContentLength();
        if ((contentLength == null || (str2 = contentLength.toString()) == null) && (str2 = content.getHeaders().get(httpHeaders.getContentLength())) == null) {
            str2 = requestHeaders.get(httpHeaders.getContentLength());
        }
        if (str != null) {
            block.invoke(httpHeaders.getContentType(), str);
        }
        if (str2 != null) {
            block.invoke(httpHeaders.getContentLength(), str2);
        }
    }

    public static final Object callContext(Continuation continuation) {
        CoroutineContext.Element element = continuation.getContext().get(KtorCallContextElement.Companion);
        Intrinsics.checkNotNull(element);
        return ((KtorCallContextElement) element).getCallContext();
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }
}
