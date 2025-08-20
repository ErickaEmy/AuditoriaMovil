package rq;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class n3 implements sq.n3 {
    public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // sq.n3
    public String n3(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return zn().n3(data);
    }

    @Override // sq.n3
    public String y(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return zn().y(data);
    }

    public abstract sq.n3 zn();

    public n3() {
    }
}
