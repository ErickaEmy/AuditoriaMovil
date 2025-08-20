package org.fdroid.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.download.HttpDownloaderV2;
/* compiled from: HttpDownloaderV2.kt */
/* loaded from: classes2.dex */
final class HttpDownloaderV2$download$4 extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref$BooleanRef $resumable;
    int label;
    final /* synthetic */ HttpDownloaderV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpDownloaderV2$download$4(HttpDownloaderV2 httpDownloaderV2, Ref$BooleanRef ref$BooleanRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = httpDownloaderV2;
        this.$resumable = ref$BooleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpDownloaderV2$download$4(this.this$0, this.$resumable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpDownloaderV2$download$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HttpDownloaderV2.Companion companion;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (NoResumeException unused) {
            if (!this.this$0.outputFile.delete()) {
                companion = HttpDownloaderV2.Companion;
                companion.getLog().warn(new Function0() { // from class: org.fdroid.download.HttpDownloaderV2$download$4.1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "Warning: outputFile not deleted";
                    }
                });
            }
            HttpDownloaderV2 httpDownloaderV2 = this.this$0;
            this.label = 2;
            if (httpDownloaderV2.downloadFromBytesReceiver(false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpDownloaderV2 httpDownloaderV22 = this.this$0;
            boolean z = this.$resumable.element;
            this.label = 1;
            if (httpDownloaderV22.downloadFromBytesReceiver(z, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
