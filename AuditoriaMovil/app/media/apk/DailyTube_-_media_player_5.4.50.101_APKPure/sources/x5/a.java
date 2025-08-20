package x5;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import l.f;
import l.t;
import le.w;
/* loaded from: classes.dex */
public class a extends zn<w2.n3> {

    /* renamed from: v  reason: collision with root package name */
    public static final String f14918v = f.a("NetworkNotRoamingCtrlr");

    public a(Context context, ix.y yVar) {
        super(q5.fb.zn(context, yVar).gv());
    }

    @Override // x5.zn
    /* renamed from: c5 */
    public boolean zn(@NonNull w2.n3 n3Var) {
        if (Build.VERSION.SDK_INT < 24) {
            f.zn().y(f14918v, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !n3Var.y();
        } else if (!n3Var.y() || !n3Var.zn()) {
            return true;
        } else {
            return false;
        }
    }

    @Override // x5.zn
    public boolean n3(@NonNull w wVar) {
        if (wVar.f10336i9.n3() == t.NOT_ROAMING) {
            return true;
        }
        return false;
    }
}
