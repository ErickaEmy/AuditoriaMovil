package okhttp3.internal.cache;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
/* compiled from: CacheInterceptor.kt */
/* loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);

    public CacheInterceptor(Cache cache) {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        EventListener eventListener;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), null).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        if (realCall == null || (eventListener = realCall.getEventListener$okhttp()) == null) {
            eventListener = EventListener.NONE;
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener.cacheConditionalHit(call, cacheResponse);
            }
            Response proceed = chain.proceed(networkRequest);
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response.Builder newBuilder = cacheResponse.newBuilder();
                    Companion companion = Companion;
                    newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                    ResponseBody body = proceed.body();
                    Intrinsics.checkNotNull(body);
                    body.close();
                    Intrinsics.checkNotNull(null);
                    throw null;
                }
                ResponseBody body2 = cacheResponse.body();
                if (body2 != null) {
                    Util.closeQuietly(body2);
                }
            }
            Intrinsics.checkNotNull(proceed);
            Response.Builder newBuilder2 = proceed.newBuilder();
            Companion companion2 = Companion;
            return newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
        }
    }

    /* compiled from: CacheInterceptor.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            int i;
            boolean equals;
            boolean startsWith$default;
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (i = 0; i < size; i = i + 1) {
                String name = headers.name(i);
                String value = headers.value(i);
                equals = StringsKt__StringsJVMKt.equals("Warning", name, true);
                if (equals) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(value, "1", false, 2, null);
                    i = startsWith$default ? i + 1 : 0;
                }
                if (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isEndToEnd(String str) {
            boolean equals;
            boolean equals2;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            boolean equals6;
            boolean equals7;
            boolean equals8;
            equals = StringsKt__StringsJVMKt.equals("Connection", str, true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals("Keep-Alive", str, true);
                if (!equals2) {
                    equals3 = StringsKt__StringsJVMKt.equals("Proxy-Authenticate", str, true);
                    if (!equals3) {
                        equals4 = StringsKt__StringsJVMKt.equals("Proxy-Authorization", str, true);
                        if (!equals4) {
                            equals5 = StringsKt__StringsJVMKt.equals("TE", str, true);
                            if (!equals5) {
                                equals6 = StringsKt__StringsJVMKt.equals("Trailers", str, true);
                                if (!equals6) {
                                    equals7 = StringsKt__StringsJVMKt.equals("Transfer-Encoding", str, true);
                                    if (!equals7) {
                                        equals8 = StringsKt__StringsJVMKt.equals("Upgrade", str, true);
                                        if (!equals8) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        private final boolean isContentSpecificHeader(String str) {
            boolean equals;
            boolean equals2;
            boolean equals3;
            equals = StringsKt__StringsJVMKt.equals("Content-Length", str, true);
            if (equals) {
                return true;
            }
            equals2 = StringsKt__StringsJVMKt.equals("Content-Encoding", str, true);
            if (equals2) {
                return true;
            }
            equals3 = StringsKt__StringsJVMKt.equals("Content-Type", str, true);
            return equals3;
        }
    }
}
