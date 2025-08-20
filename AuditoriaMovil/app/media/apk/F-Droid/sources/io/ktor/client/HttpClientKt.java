package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
/* compiled from: HttpClient.kt */
/* loaded from: classes.dex */
public abstract class HttpClientKt {
    public static final HttpClient HttpClient(HttpClientEngineFactory engineFactory, Function1 block) {
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        final HttpClientEngine create = engineFactory.create(httpClientConfig.getEngineConfig$ktor_client_core());
        HttpClient httpClient = new HttpClient(create, httpClientConfig, true);
        CoroutineContext.Element element = httpClient.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(element);
        ((Job) element).invokeOnCompletion(new Function1() { // from class: io.ktor.client.HttpClientKt$HttpClient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                HttpClientEngine.this.close();
            }
        });
        return httpClient;
    }
}
