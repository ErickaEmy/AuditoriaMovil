package kotlinx.coroutines.internal;

import ch.qos.logback.core.CoreConstants;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: Scopes.kt */
/* loaded from: classes2.dex */
public final class ContextScope implements CoroutineScope {
    private final CoroutineContext coroutineContext;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public ContextScope(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
