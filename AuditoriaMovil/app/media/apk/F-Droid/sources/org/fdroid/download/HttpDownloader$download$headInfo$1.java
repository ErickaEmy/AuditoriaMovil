package org.fdroid.download;

import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: HttpDownloader.kt */
/* loaded from: classes2.dex */
final class HttpDownloader$download$headInfo$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ HttpDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpDownloader$download$headInfo$1(HttpDownloader httpDownloader, Continuation continuation) {
        super(2, continuation);
        this.this$0 = httpDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpDownloader$download$headInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpDownloader$download$headInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HttpManager httpManager;
        DownloadRequest downloadRequest;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            httpManager = this.this$0.httpManager;
            downloadRequest = this.this$0.request;
            String cacheTag = this.this$0.getCacheTag();
            this.label = 1;
            obj = httpManager.head(downloadRequest, cacheTag, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        HeadInfo headInfo = (HeadInfo) obj;
        if (headInfo != null) {
            return headInfo;
        }
        throw new IOException();
    }
}
