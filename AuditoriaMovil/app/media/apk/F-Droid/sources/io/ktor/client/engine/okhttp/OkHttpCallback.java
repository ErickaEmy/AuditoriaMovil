package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkUtils.kt */
/* loaded from: classes.dex */
public final class OkHttpCallback implements Callback {
    private final CancellableContinuation continuation;
    private final HttpRequestData requestData;

    public OkHttpCallback(HttpRequestData requestData, CancellableContinuation continuation) {
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.requestData = requestData;
        this.continuation = continuation;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Throwable mapOkHttpException;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.continuation.isCancelled()) {
            return;
        }
        CancellableContinuation cancellableContinuation = this.continuation;
        Result.Companion companion = Result.Companion;
        mapOkHttpException = OkUtilsKt.mapOkHttpException(this.requestData, e);
        cancellableContinuation.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(mapOkHttpException)));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (call.isCanceled()) {
            return;
        }
        this.continuation.resumeWith(Result.m2081constructorimpl(response));
    }
}
