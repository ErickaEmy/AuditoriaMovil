package io.ktor.client.utils;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClientEvents.kt */
/* loaded from: classes.dex */
public final class HttpResponseReceiveFail {
    private final Throwable cause;
    private final HttpResponse response;

    public HttpResponseReceiveFail(HttpResponse response, Throwable cause) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.response = response;
        this.cause = cause;
    }
}
