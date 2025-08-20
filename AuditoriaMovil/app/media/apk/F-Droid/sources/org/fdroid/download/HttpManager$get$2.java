package org.fdroid.download;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.Url;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpManager.kt */
/* loaded from: classes2.dex */
public final class HttpManager$get$2 extends SuspendLambda implements Function3 {
    final /* synthetic */ BytesReceiver $receiver;
    final /* synthetic */ DownloadRequest $request;
    final /* synthetic */ Ref$LongRef $skipBytes;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HttpManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpManager$get$2(HttpManager httpManager, DownloadRequest downloadRequest, Ref$LongRef ref$LongRef, BytesReceiver bytesReceiver, Continuation continuation) {
        super(3, continuation);
        this.this$0 = httpManager;
        this.$request = downloadRequest;
        this.$skipBytes = ref$LongRef;
        this.$receiver = bytesReceiver;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Mirror mirror, Url url, Continuation continuation) {
        HttpManager$get$2 httpManager$get$2 = new HttpManager$get$2(this.this$0, this.$request, this.$skipBytes, this.$receiver, continuation);
        httpManager$get$2.L$0 = mirror;
        httpManager$get$2.L$1 = url;
        return httpManager$get$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpManager.kt */
    /* renamed from: org.fdroid.download.HttpManager$get$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ BytesReceiver $receiver;
        final /* synthetic */ Ref$LongRef $skipBytes;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref$LongRef ref$LongRef, BytesReceiver bytesReceiver, Continuation continuation) {
            super(2, continuation);
            this.$skipBytes = ref$LongRef;
            this.$receiver = bytesReceiver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$skipBytes, this.$receiver, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(HttpResponse httpResponse, Continuation continuation) {
            return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b8 -> B:30:0x00c0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00de -> B:36:0x00e5). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManager$get$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mirror mirror = (Mirror) this.L$0;
            Url url = (Url) this.L$1;
            HttpManager httpManager = this.this$0;
            DownloadRequest downloadRequest = this.$request;
            long j = this.$skipBytes.element;
            this.L$0 = null;
            this.label = 1;
            obj = httpManager.getHttpStatement(downloadRequest, mirror, url, j, this);
            if (obj == coroutine_suspended) {
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$skipBytes, this.$receiver, null);
        this.label = 2;
        if (((HttpStatement) obj).execute(anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
