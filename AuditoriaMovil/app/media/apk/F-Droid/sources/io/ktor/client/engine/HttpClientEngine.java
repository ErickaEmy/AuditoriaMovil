package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpSendPipeline;
import java.io.Closeable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: HttpClientEngine.kt */
/* loaded from: classes.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {
    Object execute(HttpRequestData httpRequestData, Continuation continuation);

    HttpClientEngineConfig getConfig();

    Set getSupportedCapabilities();

    void install(HttpClient httpClient);

    /* compiled from: HttpClientEngine.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Set getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            Set emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine httpClientEngine) {
            Job job = (Job) httpClientEngine.getCoroutineContext().get(Job.Key);
            return !(job != null ? job.isActive() : false);
        }

        public static void install(HttpClientEngine httpClientEngine, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            client.getSendPipeline().intercept(HttpSendPipeline.Phases.getEngine(), new HttpClientEngine$install$1(client, httpClientEngine, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007b A[PHI: r12 
          PHI: (r12v7 java.lang.Object) = (r12v6 java.lang.Object), (r12v1 java.lang.Object) binds: [B:21:0x0078, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object executeWithinCallContext(io.ktor.client.engine.HttpClientEngine r10, io.ktor.client.request.HttpRequestData r11, kotlin.coroutines.Continuation r12) {
            /*
                boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L13
                r0 = r12
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.throwOnFailure(r12)
                goto L7b
            L2c:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L34:
                java.lang.Object r10 = r0.L$1
                r11 = r10
                io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
                java.lang.Object r10 = r0.L$0
                io.ktor.client.engine.HttpClientEngine r10 = (io.ktor.client.engine.HttpClientEngine) r10
                kotlin.ResultKt.throwOnFailure(r12)
            L40:
                r4 = r10
                goto L56
            L42:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.Job r12 = r11.getExecutionContext()
                r0.L$0 = r10
                r0.L$1 = r11
                r0.label = r4
                java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.createCallContext(r10, r12, r0)
                if (r12 != r1) goto L40
                return r1
            L56:
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
                io.ktor.client.engine.KtorCallContextElement r10 = new io.ktor.client.engine.KtorCallContextElement
                r10.<init>(r12)
                kotlin.coroutines.CoroutineContext r5 = r12.plus(r10)
                r6 = 0
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r7 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r10 = 0
                r7.<init>(r4, r11, r10)
                r8 = 2
                r9 = 0
                kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r10
                r0.L$1 = r10
                r0.label = r3
                java.lang.Object r12 = r11.await(r0)
                if (r12 != r1) goto L7b
                return r1
            L7b:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.executeWithinCallContext(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability httpClientEngineCapability : httpRequestData.getRequiredCapabilities$ktor_client_core()) {
                if (!httpClientEngine.getSupportedCapabilities().contains(httpClientEngineCapability)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
            }
        }
    }
}
