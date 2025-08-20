package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.gv;
/* loaded from: classes.dex */
public class y implements gv {
    public transient fb y;

    @Override // androidx.databinding.gv
    public void gv(@NonNull gv.y yVar) {
        synchronized (this) {
            try {
                if (this.y == null) {
                    this.y = new fb();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.y.n3(yVar);
    }

    public void k(int i) {
        synchronized (this) {
            try {
                fb fbVar = this.y;
                if (fbVar == null) {
                    return;
                }
                fbVar.a(this, i, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        synchronized (this) {
            try {
                fb fbVar = this.y;
                if (fbVar == null) {
                    return;
                }
                fbVar.a(this, 0, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.gv
    public void r(@NonNull gv.y yVar) {
        synchronized (this) {
            try {
                fb fbVar = this.y;
                if (fbVar == null) {
                    return;
                }
                fbVar.f(yVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
