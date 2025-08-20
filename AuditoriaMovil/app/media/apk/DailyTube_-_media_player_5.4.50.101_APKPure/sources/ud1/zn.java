package ud1;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zn(String msg, Exception parent) {
        super(msg, parent);
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(parent, "parent");
    }
}
