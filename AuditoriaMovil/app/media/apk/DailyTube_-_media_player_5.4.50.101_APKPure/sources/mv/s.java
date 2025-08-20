package mv;

import com.google.android.exoplayer2.metadata.Metadata;
import d9.a8;
import e4.ej;
import java.util.Arrays;
import java.util.List;
import m1.m;
import m1.ne;
import mv.c5;
import v5.rz;
import z0.x4;
/* loaded from: classes.dex */
public final class s extends c5 {

    /* renamed from: wz  reason: collision with root package name */
    public boolean f11612wz;

    /* renamed from: xc  reason: collision with root package name */
    public static final byte[] f11611xc = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: w  reason: collision with root package name */
    public static final byte[] f11610w = {79, 112, 117, 115, 84, 97, 103, 115};

    public static boolean wz(rz rzVar, byte[] bArr) {
        if (rzVar.y() < bArr.length) {
            return false;
        }
        int a2 = rzVar.a();
        byte[] bArr2 = new byte[bArr.length];
        rzVar.t(bArr2, 0, bArr.length);
        rzVar.oz(a2);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean xc(rz rzVar) {
        return wz(rzVar, f11611xc);
    }

    @Override // mv.c5
    public long a(rz rzVar) {
        return zn(a8.v(rzVar.v()));
    }

    @Override // mv.c5
    public boolean c5(rz rzVar, long j2, c5.n3 n3Var) throws ne {
        if (wz(rzVar, f11611xc)) {
            byte[] copyOf = Arrays.copyOf(rzVar.v(), rzVar.fb());
            int zn2 = a8.zn(copyOf);
            List<byte[]> y = a8.y(copyOf);
            if (n3Var.y != null) {
                return true;
            }
            n3Var.y = new m.n3().o4("audio/opus").a8(zn2).rs(48000).ut(y).z6();
            return true;
        }
        byte[] bArr = f11610w;
        if (wz(rzVar, bArr)) {
            v5.y.c5(n3Var.y);
            if (this.f11612wz) {
                return true;
            }
            this.f11612wz = true;
            rzVar.ut(bArr.length);
            Metadata zn3 = ej.zn(x4.ud(ej.i9(rzVar, false, false).f7492n3));
            if (zn3 == null) {
                return true;
            }
            n3Var.y = n3Var.y.n3().en(zn3.n3(n3Var.y.f10972z)).z6();
            return true;
        }
        v5.y.c5(n3Var.y);
        return false;
    }

    @Override // mv.c5
    public void t(boolean z2) {
        super.t(z2);
        if (z2) {
            this.f11612wz = false;
        }
    }
}
