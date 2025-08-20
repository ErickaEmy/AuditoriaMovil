package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
/* compiled from: DefaultTransform.kt */
/* loaded from: classes.dex */
public abstract class DefaultTransformKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.defaultTransformers");

    public static final void defaultTransformers(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new DefaultTransformKt$defaultTransformers$1(null));
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getParse(), new DefaultTransformKt$defaultTransformers$2(null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers(httpClient);
    }
}
