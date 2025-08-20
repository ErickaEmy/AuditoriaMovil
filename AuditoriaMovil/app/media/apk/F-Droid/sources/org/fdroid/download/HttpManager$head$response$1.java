package org.fdroid.download;

import ch.qos.logback.core.spi.AbstractComponentTracker;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpManager.kt */
/* loaded from: classes2.dex */
public final class HttpManager$head$response$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ DownloadRequest $request;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HttpManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpManager$head$response$1(HttpManager httpManager, DownloadRequest downloadRequest, Continuation continuation) {
        super(3, continuation);
        this.this$0 = httpManager;
        this.$request = downloadRequest;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Mirror mirror, Url url, Continuation continuation) {
        HttpManager$head$response$1 httpManager$head$response$1 = new HttpManager$head$response$1(this.this$0, this.$request, continuation);
        httpManager$head$response$1.L$0 = mirror;
        httpManager$head$response$1.L$1 = url;
        return httpManager$head$response$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HttpClient httpClient;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mirror mirror = (Mirror) this.L$0;
            final Url url = (Url) this.L$1;
            this.this$0.resetProxyIfNeeded(this.$request.getProxy(), mirror);
            HttpManager.Companion.getLog$download_release().debug(new Function0() { // from class: org.fdroid.download.HttpManager$head$response$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Url url2 = Url.this;
                    return "HEAD " + url2;
                }
            });
            httpClient = this.this$0.httpClient;
            HttpManager httpManager = this.this$0;
            DownloadRequest downloadRequest = this.$request;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
            httpManager.addQueryParameters(httpRequestBuilder);
            httpManager.basicAuth(httpRequestBuilder, downloadRequest);
            if (mirror.isOnion()) {
                HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: org.fdroid.download.HttpManager$head$response$1$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((HttpTimeout.HttpTimeoutCapabilityConfiguration) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
                        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
                        timeout.setConnectTimeoutMillis(Long.valueOf((long) AbstractComponentTracker.LINGERING_TIMEOUT));
                    }
                });
            }
            httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            this.L$0 = null;
            this.label = 1;
            obj = httpStatement.execute(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
