package gq;

import androidx.annotation.NonNull;
import l.wz;
import y5.d0;
/* loaded from: classes.dex */
public class zn implements wz {

    /* renamed from: zn  reason: collision with root package name */
    public final d0<wz.n3> f8412zn = new d0<>();

    /* renamed from: gv  reason: collision with root package name */
    public final ro.zn<wz.n3.zn> f8411gv = ro.zn.co();

    public zn() {
        y(wz.f10229n3);
    }

    public void y(@NonNull wz.n3 n3Var) {
        this.f8412zn.t(n3Var);
        if (n3Var instanceof wz.n3.zn) {
            this.f8411gv.xc((wz.n3.zn) n3Var);
        } else if (n3Var instanceof wz.n3.y) {
            this.f8411gv.w(((wz.n3.y) n3Var).y());
        }
    }
}
