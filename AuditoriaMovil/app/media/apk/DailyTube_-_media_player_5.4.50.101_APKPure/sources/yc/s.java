package yc;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import kotlin.jvm.internal.Intrinsics;
@SuppressLint({"NewApi", "ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class s extends c5 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Class<android.adservices.topics.TopicsManager> r0 = android.adservices.topics.TopicsManager.class
            java.lang.Object r2 = r2.getSystemService(r0)
            java.lang.String r0 = "context.getSystemService…opicsManager::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.adservices.topics.TopicsManager r2 = (android.adservices.topics.TopicsManager) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.s.<init>(android.content.Context):void");
    }

    @Override // yc.c5
    public GetTopicsRequest zn(n3 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(request.y()).setShouldRecordObservation(request.n3()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ion)\n            .build()");
        return build;
    }
}
