package x5;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import l.t;
import le.w;
/* loaded from: classes.dex */
public class fb extends zn<w2.n3> {
    public fb(@NonNull Context context, @NonNull ix.y yVar) {
        super(q5.fb.zn(context, yVar).gv());
    }

    @Override // x5.zn
    /* renamed from: c5 */
    public boolean zn(@NonNull w2.n3 n3Var) {
        if (n3Var.y() && !n3Var.n3()) {
            return false;
        }
        return true;
    }

    @Override // x5.zn
    public boolean n3(@NonNull w wVar) {
        if (wVar.f10336i9.n3() != t.UNMETERED && (Build.VERSION.SDK_INT < 30 || wVar.f10336i9.n3() != t.TEMPORARILY_UNMETERED)) {
            return false;
        }
        return true;
    }
}
