package sc1;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class wz extends IOException {
    public final n3 errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wz(n3 errorCode) {
        super("stream was reset: " + errorCode);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
