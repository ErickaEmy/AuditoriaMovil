package pc1;

import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class i9 extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i9(IOException firstConnectException) {
        super(firstConnectException);
        Intrinsics.checkNotNullParameter(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    public final IOException gv() {
        return this.firstConnectException;
    }

    public final IOException v() {
        return this.lastConnectException;
    }

    public final void y(IOException e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        ExceptionsKt.addSuppressed(this.firstConnectException, e2);
        this.lastConnectException = e2;
    }
}
