package mv;

import e4.tl;
import e4.xc;
import java.io.IOException;
import java.util.Arrays;
import v5.rz;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: gv  reason: collision with root package name */
    public int f11613gv;

    /* renamed from: v  reason: collision with root package name */
    public boolean f11615v;
    public final a y = new a();

    /* renamed from: n3  reason: collision with root package name */
    public final rz f11614n3 = new rz(new byte[65025], 0);

    /* renamed from: zn  reason: collision with root package name */
    public int f11616zn = -1;

    public void a() {
        if (this.f11614n3.v().length == 65025) {
            return;
        }
        rz rzVar = this.f11614n3;
        rzVar.o(Arrays.copyOf(rzVar.v(), Math.max(65025, this.f11614n3.fb())), this.f11614n3.fb());
    }

    public boolean gv(tl tlVar) throws IOException {
        boolean z2;
        boolean z3;
        int i;
        if (tlVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.f11615v) {
            this.f11615v = false;
            this.f11614n3.j5(0);
        }
        while (!this.f11615v) {
            if (this.f11616zn < 0) {
                if (!this.y.zn(tlVar) || !this.y.y(tlVar, true)) {
                    return false;
                }
                a aVar = this.y;
                int i5 = aVar.f11577s;
                if ((aVar.f11576n3 & 1) == 1 && this.f11614n3.fb() == 0) {
                    i5 += y(0);
                    i = this.f11613gv;
                } else {
                    i = 0;
                }
                if (!xc.v(tlVar, i5)) {
                    return false;
                }
                this.f11616zn = i;
            }
            int y = y(this.f11616zn);
            int i6 = this.f11616zn + this.f11613gv;
            if (y > 0) {
                rz rzVar = this.f11614n3;
                rzVar.zn(rzVar.fb() + y);
                if (!xc.gv(tlVar, this.f11614n3.v(), this.f11614n3.fb(), y)) {
                    return false;
                }
                rz rzVar2 = this.f11614n3;
                rzVar2.j(rzVar2.fb() + y);
                if (this.y.f11575i9[i6 - 1] != 255) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f11615v = z3;
            }
            if (i6 == this.y.f11573fb) {
                i6 = -1;
            }
            this.f11616zn = i6;
        }
        return true;
    }

    public a n3() {
        return this.y;
    }

    public void v() {
        this.y.n3();
        this.f11614n3.j5(0);
        this.f11616zn = -1;
        this.f11615v = false;
    }

    public final int y(int i) {
        int i5;
        int i6 = 0;
        this.f11613gv = 0;
        do {
            int i8 = this.f11613gv;
            int i10 = i + i8;
            a aVar = this.y;
            if (i10 >= aVar.f11573fb) {
                break;
            }
            int[] iArr = aVar.f11575i9;
            this.f11613gv = i8 + 1;
            i5 = iArr[i8 + i];
            i6 += i5;
        } while (i5 == 255);
        return i6;
    }

    public rz zn() {
        return this.f11614n3;
    }
}
