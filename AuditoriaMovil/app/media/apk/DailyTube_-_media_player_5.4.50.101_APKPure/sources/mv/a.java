package mv;

import e4.tl;
import e4.xc;
import java.io.IOException;
import m1.ne;
import v5.rz;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f11570a;

    /* renamed from: c5  reason: collision with root package name */
    public int f11571c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f11573fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f11574gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f11576n3;

    /* renamed from: s  reason: collision with root package name */
    public int f11577s;

    /* renamed from: v  reason: collision with root package name */
    public long f11578v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public long f11579zn;

    /* renamed from: i9  reason: collision with root package name */
    public final int[] f11575i9 = new int[255];

    /* renamed from: f  reason: collision with root package name */
    public final rz f11572f = new rz(255);

    public boolean gv(tl tlVar, long j2) throws IOException {
        boolean z2;
        int i;
        if (tlVar.getPosition() == tlVar.t()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f11572f.j5(4);
        while (true) {
            i = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
            if ((i == 0 || tlVar.getPosition() + 4 < j2) && xc.n3(tlVar, this.f11572f.v(), 0, 4, true)) {
                this.f11572f.oz(0);
                if (this.f11572f.a8() == 1332176723) {
                    tlVar.s();
                    return true;
                }
                tlVar.p(1);
            }
        }
        do {
            if (i != 0 && tlVar.getPosition() >= j2) {
                break;
            }
        } while (tlVar.xc(1) != -1);
        return false;
    }

    public void n3() {
        this.y = 0;
        this.f11576n3 = 0;
        this.f11579zn = 0L;
        this.f11574gv = 0L;
        this.f11578v = 0L;
        this.f11570a = 0L;
        this.f11573fb = 0;
        this.f11577s = 0;
        this.f11571c5 = 0;
    }

    public boolean y(tl tlVar, boolean z2) throws IOException {
        n3();
        this.f11572f.j5(27);
        if (!xc.n3(tlVar, this.f11572f.v(), 0, 27, z2) || this.f11572f.a8() != 1332176723) {
            return false;
        }
        int ej2 = this.f11572f.ej();
        this.y = ej2;
        if (ej2 != 0) {
            if (z2) {
                return false;
            }
            throw ne.s("unsupported bit stream revision");
        }
        this.f11576n3 = this.f11572f.ej();
        this.f11579zn = this.f11572f.x4();
        this.f11574gv = this.f11572f.f3();
        this.f11578v = this.f11572f.f3();
        this.f11570a = this.f11572f.f3();
        int ej3 = this.f11572f.ej();
        this.f11573fb = ej3;
        this.f11577s = ej3 + 27;
        this.f11572f.j5(ej3);
        if (!xc.n3(tlVar, this.f11572f.v(), 0, this.f11573fb, z2)) {
            return false;
        }
        for (int i = 0; i < this.f11573fb; i++) {
            this.f11575i9[i] = this.f11572f.ej();
            this.f11571c5 += this.f11575i9[i];
        }
        return true;
    }

    public boolean zn(tl tlVar) throws IOException {
        return gv(tlVar, -1L);
    }
}
