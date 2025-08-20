package yc;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import b.wz;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class c5 extends a {

    /* renamed from: n3  reason: collision with root package name */
    public final TopicsManager f15328n3;

    @DebugMetadata(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {22}, m = "getTopics$suspendImpl")
    /* loaded from: classes.dex */
    public static final class y extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public y(Continuation<? super y> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c5.v(c5.this, null, this);
        }
    }

    public c5(TopicsManager mTopicsManager) {
        Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
        this.f15328n3 = mTopicsManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object v(yc.c5 r4, yc.n3 r5, kotlin.coroutines.Continuation<? super yc.zn> r6) {
        /*
            boolean r0 = r6 instanceof yc.c5.y
            if (r0 == 0) goto L13
            r0 = r6
            yc.c5$y r0 = (yc.c5.y) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            yc.c5$y r0 = new yc.c5$y
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            yc.c5 r4 = (yc.c5) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            android.adservices.topics.GetTopicsRequest r5 = r4.zn(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.a(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            android.adservices.topics.GetTopicsResponse r6 = (android.adservices.topics.GetTopicsResponse) r6
            yc.zn r4 = r4.gv(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.c5.v(yc.c5, yc.n3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(GetTopicsRequest getTopicsRequest, Continuation<? super GetTopicsResponse> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.f15328n3.getTopics(getTopicsRequest, new yg.n3(), wz.y(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final zn gv(GetTopicsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ArrayList arrayList = new ArrayList();
        for (Topic topic : response.getTopics()) {
            arrayList.add(new v(topic.getTaxonomyVersion(), topic.getModelVersion(), topic.getTopicId()));
        }
        return new zn(arrayList);
    }

    @Override // yc.a
    public Object y(n3 n3Var, Continuation<? super zn> continuation) {
        return v(this, n3Var, continuation);
    }

    public GetTopicsRequest zn(n3 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(request.y()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ame)\n            .build()");
        return build;
    }
}
