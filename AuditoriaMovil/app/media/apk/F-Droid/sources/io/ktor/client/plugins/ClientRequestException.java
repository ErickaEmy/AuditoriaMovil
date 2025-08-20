package io.ktor.client.plugins;

import ch.qos.logback.core.CoreConstants;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes.dex */
public final class ClientRequestException extends ResponseException {
    private final String message;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientRequestException(HttpResponse response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.message = "Client request(" + response.getCall().getRequest().getMethod().getValue() + ' ' + response.getCall().getRequest().getUrl() + ") invalid: " + response.getStatus() + ". Text: \"" + cachedResponseText + CoreConstants.DOUBLE_QUOTE_CHAR;
    }
}
