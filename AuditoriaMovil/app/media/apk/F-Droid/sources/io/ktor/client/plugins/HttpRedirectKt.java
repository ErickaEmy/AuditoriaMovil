package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import org.slf4j.Logger;
/* compiled from: HttpRedirect.kt */
/* loaded from: classes.dex */
public abstract class HttpRedirectKt {
    private static final Set ALLOWED_FOR_REDIRECT;
    private static final Logger LOGGER;

    static {
        Set of;
        HttpMethod.Companion companion = HttpMethod.Companion;
        of = SetsKt__SetsKt.setOf((Object[]) new HttpMethod[]{companion.getGet(), companion.getHead()});
        ALLOWED_FOR_REDIRECT = of;
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        int value = httpStatusCode.getValue();
        HttpStatusCode.Companion companion = HttpStatusCode.Companion;
        return value == companion.getMovedPermanently().getValue() || value == companion.getFound().getValue() || value == companion.getTemporaryRedirect().getValue() || value == companion.getPermanentRedirect().getValue() || value == companion.getSeeOther().getValue();
    }
}
