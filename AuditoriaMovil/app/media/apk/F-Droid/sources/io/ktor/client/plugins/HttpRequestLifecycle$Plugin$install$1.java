package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestLifecycle.kt */
/* loaded from: classes.dex */
public final class HttpRequestLifecycle$Plugin$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycle$Plugin$install$1(HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext pipelineContext, Object obj, Continuation continuation) {
        HttpRequestLifecycle$Plugin$install$1 httpRequestLifecycle$Plugin$install$1 = new HttpRequestLifecycle$Plugin$install$1(this.$scope, continuation);
        httpRequestLifecycle$Plugin$install$1.L$0 = pipelineContext;
        return httpRequestLifecycle$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CompletableJob completableJob;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(((HttpRequestBuilder) pipelineContext.getContext()).getExecutionContext());
            CoroutineContext.Element element = this.$scope.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(element);
            HttpRequestLifecycleKt.attachToClientEngineJob(SupervisorJob, (Job) element);
            try {
                ((HttpRequestBuilder) pipelineContext.getContext()).setExecutionContext$ktor_client_core(SupervisorJob);
                this.L$0 = SupervisorJob;
                this.label = 1;
                if (pipelineContext.proceed(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                completableJob = SupervisorJob;
            } catch (Throwable th) {
                th = th;
                completableJob = SupervisorJob;
                completableJob.completeExceptionally(th);
                throw th;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            completableJob = (CompletableJob) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    completableJob.completeExceptionally(th);
                    throw th;
                } catch (Throwable th3) {
                    completableJob.complete();
                    throw th3;
                }
            }
        }
        completableJob.complete();
        return Unit.INSTANCE;
    }
}
