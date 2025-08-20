package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BodyProgress.kt */
/* loaded from: classes.dex */
public final class BodyProgress {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey key = new AttributeKey("BodyProgress");

    /* JADX INFO: Access modifiers changed from: private */
    public final void handle(HttpClient httpClient) {
        PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
        httpClient.getRequestPipeline().insertPhaseAfter(HttpRequestPipeline.Phases.getRender(), pipelinePhase);
        httpClient.getRequestPipeline().intercept(pipelinePhase, new BodyProgress$handle$1(null));
        httpClient.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getAfter(), new BodyProgress$handle$2(null));
    }

    /* compiled from: BodyProgress.kt */
    /* loaded from: classes.dex */
    public static final class Plugin implements HttpClientPlugin {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey getKey() {
            return BodyProgress.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public BodyProgress prepare(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new BodyProgress();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(BodyProgress plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            plugin.handle(scope);
        }
    }
}
