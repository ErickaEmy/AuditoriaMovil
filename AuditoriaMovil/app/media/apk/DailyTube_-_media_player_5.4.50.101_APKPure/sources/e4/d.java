package e4;

import androidx.annotation.Nullable;
import e4.ta;
import java.io.IOException;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f7477a;

    /* renamed from: fb  reason: collision with root package name */
    public int f7478fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f7479gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f7480n3;

    /* renamed from: v  reason: collision with root package name */
    public int f7481v;
    public final byte[] y = new byte[10];

    /* renamed from: zn  reason: collision with root package name */
    public int f7482zn;

    public void gv(tl tlVar) throws IOException {
        if (this.f7480n3) {
            return;
        }
        tlVar.z(this.y, 0, 10);
        tlVar.s();
        if (d9.n3.i9(this.y) == 0) {
            return;
        }
        this.f7480n3 = true;
    }

    public void n3() {
        this.f7480n3 = false;
        this.f7482zn = 0;
    }

    public void y(ta taVar, @Nullable ta.y yVar) {
        if (this.f7482zn > 0) {
            taVar.gv(this.f7479gv, this.f7481v, this.f7477a, this.f7478fb, yVar);
            this.f7482zn = 0;
        }
    }

    public void zn(ta taVar, long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
        boolean z2;
        if (this.f7478fb <= i5 + i6) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.s(z2, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (!this.f7480n3) {
            return;
        }
        int i8 = this.f7482zn;
        int i10 = i8 + 1;
        this.f7482zn = i10;
        if (i8 == 0) {
            this.f7479gv = j2;
            this.f7481v = i;
            this.f7477a = 0;
        }
        this.f7477a += i5;
        this.f7478fb = i6;
        if (i10 >= 16) {
            y(taVar, yVar);
        }
    }
}
