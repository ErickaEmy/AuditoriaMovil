package io.ktor.client.plugins;

import ch.qos.logback.core.CoreConstants;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes.dex */
public class ResponseException extends IllegalStateException {
    private final transient HttpResponse response;

    public final HttpResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseException(HttpResponse response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + CoreConstants.DOUBLE_QUOTE_CHAR);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.response = response;
    }
}
