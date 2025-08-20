package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import org.slf4j.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultTransform.kt */
/* loaded from: classes.dex */
public final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformKt$defaultTransformers$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext pipelineContext, Object obj, Continuation continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        OutgoingContent platformRequestDefaultTransform;
        Logger logger;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PipelineContext pipelineContext = (PipelineContext) this.L$0;
            final Object obj2 = this.L$1;
            HeadersBuilder headers = ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders();
            HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
            if (headers.get(httpHeaders.getAccept()) == null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(httpHeaders.getAccept(), "*/*");
            }
            final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (contentType == null) {
                    contentType = ContentType.Text.INSTANCE.getPlain();
                }
                platformRequestDefaultTransform = new TextContent(str, contentType, null, 4, null);
            } else if (obj2 instanceof byte[]) {
                platformRequestDefaultTransform = new OutgoingContent.ByteArrayContent(contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                    final /* synthetic */ Object $body;
                    private final long contentLength;
                    private final ContentType contentType;

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType getContentType() {
                        return this.contentType;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$body = obj2;
                        this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        this.contentLength = ((byte[]) obj2).length;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long getContentLength() {
                        return Long.valueOf(this.contentLength);
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                    public byte[] bytes() {
                        return (byte[]) this.$body;
                    }
                };
            } else if (obj2 instanceof ByteReadChannel) {
                platformRequestDefaultTransform = new OutgoingContent.ReadChannelContent(pipelineContext, contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                    final /* synthetic */ Object $body;
                    private final Long contentLength;
                    private final ContentType contentType;

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long getContentLength() {
                        return this.contentLength;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType getContentType() {
                        return this.contentType;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$body = obj2;
                        String str2 = ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                        this.contentLength = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                        this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public ByteReadChannel readFrom() {
                        return (ByteReadChannel) this.$body;
                    }
                };
            } else {
                platformRequestDefaultTransform = obj2 instanceof OutgoingContent ? (OutgoingContent) obj2 : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
            }
            if ((platformRequestDefaultTransform != null ? platformRequestDefaultTransform.getContentType() : null) != null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(httpHeaders.getContentType());
                logger = DefaultTransformKt.LOGGER;
                logger.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(obj2.getClass()));
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(platformRequestDefaultTransform, this) == coroutine_suspended) {
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
