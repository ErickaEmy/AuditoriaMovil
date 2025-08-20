package org.fdroid.download.glide;

import com.bumptech.glide.load.data.DataFetcher;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.download.DownloadRequest;
import org.fdroid.download.HttpManager;
/* compiled from: HttpFetcher.kt */
/* loaded from: classes2.dex */
final class HttpFetcher$loadData$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ DataFetcher.DataCallback $callback;
    int label;
    final /* synthetic */ HttpFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpFetcher$loadData$1(HttpFetcher httpFetcher, DataFetcher.DataCallback dataCallback, Continuation continuation) {
        super(2, continuation);
        this.this$0 = httpFetcher;
        this.$callback = dataCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpFetcher$loadData$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpFetcher$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HttpManager httpManager;
        DownloadRequest downloadRequest;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                httpManager = this.this$0.httpManager;
                downloadRequest = this.this$0.downloadRequest;
                this.label = 1;
                obj = HttpManager.getChannel$download_release$default(httpManager, downloadRequest, null, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.$callback.onDataReady(BlockingKt.toInputStream$default((ByteReadChannel) obj, null, 1, null));
        } catch (Exception e) {
            this.$callback.onLoadFailed(e);
        }
        return Unit.INSTANCE;
    }
}
