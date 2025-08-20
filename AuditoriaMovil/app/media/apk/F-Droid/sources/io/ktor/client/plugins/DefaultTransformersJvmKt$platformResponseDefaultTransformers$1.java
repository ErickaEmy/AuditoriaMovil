package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
/* compiled from: DefaultTransformersJvm.kt */
/* loaded from: classes.dex */
final class DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
        DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 defaultTransformersJvmKt$platformResponseDefaultTransformers$1 = new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(continuation);
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$0 = pipelineContext;
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$1 = httpResponseContainer;
        return defaultTransformersJvmKt$platformResponseDefaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PipelineContext pipelineContext = (PipelineContext) this.L$0;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
            TypeInfo component1 = httpResponseContainer.component1();
            Object component2 = httpResponseContainer.component2();
            if (!(component2 instanceof ByteReadChannel)) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(component1.getType(), Reflection.getOrCreateKotlinClass(InputStream.class))) {
                final InputStream inputStream = BlockingKt.toInputStream((ByteReadChannel) component2, (Job) ((HttpClientCall) pipelineContext.getContext()).getCoroutineContext().get(Job.Key));
                HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(component1, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                    @Override // java.io.InputStream
                    public int read() {
                        return inputStream.read();
                    }

                    @Override // java.io.InputStream
                    public int read(byte[] b, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(b, "b");
                        return inputStream.read(b, i2, i3);
                    }

                    @Override // java.io.InputStream
                    public int available() {
                        return inputStream.available();
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        super.close();
                        inputStream.close();
                        HttpResponseKt.complete(((HttpClientCall) pipelineContext.getContext()).getResponse());
                    }
                });
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(httpResponseContainer2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
