package kx;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class fb implements tl {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public p f10025gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayList<o> f10026n3 = new ArrayList<>(1);
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public int f10027zn;

    public fb(boolean z2) {
        this.y = z2;
    }

    @Override // kx.tl
    public /* synthetic */ Map fb() {
        return t.y(this);
    }

    public final void i4(p pVar) {
        this.f10025gv = pVar;
        for (int i = 0; i < this.f10027zn; i++) {
            this.f10026n3.get(i).y(this, pVar, this.y);
        }
    }

    @Override // kx.tl
    public final void i9(o oVar) {
        v5.y.v(oVar);
        if (!this.f10026n3.contains(oVar)) {
            this.f10026n3.add(oVar);
            this.f10027zn++;
        }
    }

    public final void mt(int i) {
        p pVar = (p) v5.j5.i9(this.f10025gv);
        for (int i5 = 0; i5 < this.f10027zn; i5++) {
            this.f10026n3.get(i5).v(this, pVar, this.y, i);
        }
    }

    public final void r() {
        p pVar = (p) v5.j5.i9(this.f10025gv);
        for (int i = 0; i < this.f10027zn; i++) {
            this.f10026n3.get(i).gv(this, pVar, this.y);
        }
        this.f10025gv = null;
    }

    public final void x4(p pVar) {
        for (int i = 0; i < this.f10027zn; i++) {
            this.f10026n3.get(i).fb(this, pVar, this.y);
        }
    }
}
