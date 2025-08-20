package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HttpRedirect.kt */
/* loaded from: classes.dex */
public final class HttpRedirect {
    private final boolean allowHttpsDowngrade;
    private final boolean checkHttpMethod;
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey key = new AttributeKey("HttpRedirect");
    private static final EventDefinition HttpResponseRedirect = new EventDefinition();

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes.dex */
    public static final class Config {
        private boolean allowHttpsDowngrade;
        private boolean checkHttpMethod = true;

        public final boolean getAllowHttpsDowngrade() {
            return this.allowHttpsDowngrade;
        }

        public final boolean getCheckHttpMethod() {
            return this.checkHttpMethod;
        }
    }

    public /* synthetic */ HttpRedirect(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    private HttpRedirect(boolean z, boolean z2) {
        this.checkHttpMethod = z;
        this.allowHttpsDowngrade = z2;
    }

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes.dex */
    public static final class Plugin implements HttpClientPlugin {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey getKey() {
            return HttpRedirect.key;
        }

        public final EventDefinition getHttpResponseRedirect() {
            return HttpRedirect.HttpResponseRedirect;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpRedirect prepare(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpRedirect(config.getCheckHttpMethod(), config.getAllowHttpsDowngrade(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpRedirect plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            ((HttpSend) HttpClientPluginKt.plugin(scope, HttpSend.Plugin)).intercept(new HttpRedirect$Plugin$install$1(plugin, scope, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01b1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01cf  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x01b2 -> B:35:0x01b8). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object handleCall(io.ktor.client.plugins.Sender r19, io.ktor.client.request.HttpRequestBuilder r20, io.ktor.client.call.HttpClientCall r21, boolean r22, io.ktor.client.HttpClient r23, kotlin.coroutines.Continuation r24) {
            /*
                Method dump skipped, instructions count: 471
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.handleCall(io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
