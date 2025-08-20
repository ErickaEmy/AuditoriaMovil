package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ByteBufferChannelInternals.kt */
/* loaded from: classes.dex */
public final class ClosedElement {
    public static final Companion Companion = new Companion(null);
    private static final ClosedElement EmptyCause = new ClosedElement(null);
    private final Throwable cause;

    public final Throwable getCause() {
        return this.cause;
    }

    public ClosedElement(Throwable th) {
        this.cause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.cause;
        return th == null ? new ClosedWriteChannelException("The channel was closed") : th;
    }

    public String toString() {
        return "Closed[" + getSendException() + ']';
    }

    /* compiled from: ByteBufferChannelInternals.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClosedElement getEmptyCause() {
            return ClosedElement.EmptyCause;
        }
    }
}
