package ud1;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n3(String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
