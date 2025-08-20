package h4;

import af.en;
import java.io.IOException;
import m1.g;
/* loaded from: classes.dex */
public final class tl implements en {

    /* renamed from: fb  reason: collision with root package name */
    public int f8702fb = -1;

    /* renamed from: v  reason: collision with root package name */
    public final p f8703v;
    public final int y;

    public tl(p pVar, int i) {
        this.f8703v = pVar;
        this.y = i;
    }

    @Override // af.en
    public int a(g gVar, a9.fb fbVar, int i) {
        if (this.f8702fb == -3) {
            fbVar.v(4);
            return -4;
        } else if (!zn()) {
            return -3;
        } else {
            return this.f8703v.dm(this.f8702fb, gVar, fbVar, i);
        }
    }

    public void gv() {
        if (this.f8702fb != -1) {
            this.f8703v.yg(this.y);
            this.f8702fb = -1;
        }
    }

    @Override // af.en
    public boolean isReady() {
        if (this.f8702fb != -3 && (!zn() || !this.f8703v.hw(this.f8702fb))) {
            return false;
        }
        return true;
    }

    @Override // af.en
    public void n3() throws IOException {
        int i = this.f8702fb;
        if (i != -2) {
            if (i == -1) {
                this.f8703v.j();
                return;
            } else if (i != -3) {
                this.f8703v.ut(i);
                return;
            } else {
                return;
            }
        }
        throw new mt(this.f8703v.p().n3(this.y).zn(0).f10948f3);
    }

    @Override // af.en
    public int t(long j2) {
        if (zn()) {
            return this.f8703v.ap(this.f8702fb, j2);
        }
        return 0;
    }

    public void y() {
        boolean z2;
        if (this.f8702fb == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f8702fb = this.f8703v.x4(this.y);
    }

    public final boolean zn() {
        int i = this.f8702fb;
        if (i != -1 && i != -3 && i != -2) {
            return true;
        }
        return false;
    }
}
