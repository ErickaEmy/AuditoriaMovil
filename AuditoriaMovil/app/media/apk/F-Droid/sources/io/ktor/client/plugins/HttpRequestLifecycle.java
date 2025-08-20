package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HttpRequestLifecycle.kt */
/* loaded from: classes.dex */
public final class HttpRequestLifecycle {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey key = new AttributeKey("RequestLifecycle");

    private HttpRequestLifecycle() {
    }

    public /* synthetic */ HttpRequestLifecycle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HttpRequestLifecycle.kt */
    /* loaded from: classes.dex */
    public static final class Plugin implements HttpClientPlugin {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey getKey() {
            return HttpRequestLifecycle.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpRequestLifecycle prepare(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new HttpRequestLifecycle(null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpRequestLifecycle plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getBefore(), new HttpRequestLifecycle$Plugin$install$1(scope, null));
        }
    }
}
