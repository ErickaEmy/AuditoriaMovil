package x5;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import l.t;
import le.w;
/* loaded from: classes.dex */
public class gv extends zn<w2.n3> {
    public gv(Context context, ix.y yVar) {
        super(q5.fb.zn(context, yVar).gv());
    }

    @Override // x5.zn
    /* renamed from: c5 */
    public boolean zn(@NonNull w2.n3 n3Var) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (!n3Var.y() || !n3Var.gv()) {
                return true;
            }
            return false;
        }
        return !n3Var.y();
    }

    @Override // x5.zn
    public boolean n3(@NonNull w wVar) {
        if (wVar.f10336i9.n3() == t.CONNECTED) {
            return true;
        }
        return false;
    }
}
