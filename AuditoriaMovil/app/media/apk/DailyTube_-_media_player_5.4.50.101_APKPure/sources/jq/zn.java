package jq;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn implements sq.zn, vq.n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final /* synthetic */ qq.y f9552n3 = qq.y.n3;

    /* renamed from: zn  reason: collision with root package name */
    public final Lazy f9553zn = LazyKt.lazy(n3.y);

    /* renamed from: gv  reason: collision with root package name */
    public final Lazy f9551gv = LazyKt.lazy(y.y);

    public String a(vq.y fileType, String originName) {
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(originName, "originName");
        return this.f9552n3.a(fileType, originName);
    }

    @Override // sq.zn
    public sq.n3 fb() {
        return (sq.n3) this.f9553zn.getValue();
    }

    @Override // sq.zn
    public sq.y gv(uq.y codeMap) {
        Intrinsics.checkNotNullParameter(codeMap, "codeMap");
        return new nq.y(codeMap.getKey(), codeMap.getValue());
    }

    @Override // sq.zn
    public sq.n3 n3() {
        return (sq.n3) this.f9551gv.getValue();
    }

    @Override // sq.zn
    public sq.n3 v(byte b2) {
        return new gv(b2);
    }

    public Map<String, String> y() {
        return this.f9552n3.y();
    }

    public String zn(vq.y fileType, String originName) {
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(originName, "originName");
        return this.f9552n3.zn(fileType, originName);
    }
}
