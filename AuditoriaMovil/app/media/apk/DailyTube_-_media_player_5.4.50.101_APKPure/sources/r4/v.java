package r4;

import androidx.annotation.Nullable;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: t  reason: collision with root package name */
    public static final byte[] f13102t = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final byte f13103a;

    /* renamed from: c5  reason: collision with root package name */
    public final int f13104c5;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f13105f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f13106fb;

    /* renamed from: gv  reason: collision with root package name */
    public final byte f13107gv;

    /* renamed from: i9  reason: collision with root package name */
    public final byte[] f13108i9;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f13109n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f13110s;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f13111v;
    public final byte y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f13112zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f13113a;

        /* renamed from: gv  reason: collision with root package name */
        public int f13115gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f13116n3;

        /* renamed from: v  reason: collision with root package name */
        public long f13118v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public byte f13119zn;

        /* renamed from: fb  reason: collision with root package name */
        public byte[] f13114fb = v.f13102t;

        /* renamed from: s  reason: collision with root package name */
        public byte[] f13117s = v.f13102t;

        public v c5() {
            return new v(this);
        }

        public n3 f(boolean z2) {
            this.f13116n3 = z2;
            return this;
        }

        public n3 i9(byte[] bArr) {
            v5.y.v(bArr);
            this.f13114fb = bArr;
            return this;
        }

        public n3 p(long j2) {
            this.f13118v = j2;
            return this;
        }

        public n3 t(boolean z2) {
            this.y = z2;
            return this;
        }

        public n3 tl(byte[] bArr) {
            v5.y.v(bArr);
            this.f13117s = bArr;
            return this;
        }

        public n3 w(int i) {
            this.f13113a = i;
            return this;
        }

        public n3 wz(byte b2) {
            this.f13119zn = b2;
            return this;
        }

        public n3 xc(int i) {
            boolean z2;
            if (i >= 0 && i <= 65535) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.f13115gv = i & 65535;
            return this;
        }
    }

    @Nullable
    public static v gv(rz rzVar) {
        boolean z2;
        byte[] bArr;
        if (rzVar.y() < 12) {
            return null;
        }
        int ej2 = rzVar.ej();
        byte b2 = (byte) (ej2 >> 6);
        boolean z3 = true;
        if (((ej2 >> 5) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        byte b3 = (byte) (ej2 & 15);
        if (b2 != 2) {
            return null;
        }
        int ej3 = rzVar.ej();
        if (((ej3 >> 7) & 1) != 1) {
            z3 = false;
        }
        byte b4 = (byte) (ej3 & 127);
        int yt2 = rzVar.yt();
        long a82 = rzVar.a8();
        int p2 = rzVar.p();
        if (b3 > 0) {
            bArr = new byte[b3 * 4];
            for (int i = 0; i < b3; i++) {
                rzVar.t(bArr, i * 4, 4);
            }
        } else {
            bArr = f13102t;
        }
        byte[] bArr2 = new byte[rzVar.y()];
        rzVar.t(bArr2, 0, rzVar.y());
        return new n3().t(z2).f(z3).wz(b4).xc(yt2).p(a82).w(p2).i9(bArr).tl(bArr2).c5();
    }

    public static int n3(int i) {
        return c1.n3.n3(i + 1, 65536);
    }

    public static int zn(int i) {
        return c1.n3.n3(i - 1, 65536);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f13103a == vVar.f13103a && this.f13106fb == vVar.f13106fb && this.f13111v == vVar.f13111v && this.f13110s == vVar.f13110s && this.f13104c5 == vVar.f13104c5) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f13110s;
        return ((((((((527 + this.f13103a) * 31) + this.f13106fb) * 31) + (this.f13111v ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f13104c5;
    }

    public String toString() {
        return j5.rz("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f13103a), Integer.valueOf(this.f13106fb), Long.valueOf(this.f13110s), Integer.valueOf(this.f13104c5), Boolean.valueOf(this.f13111v));
    }

    public v(n3 n3Var) {
        this.y = (byte) 2;
        this.f13109n3 = n3Var.y;
        this.f13112zn = false;
        this.f13111v = n3Var.f13116n3;
        this.f13103a = n3Var.f13119zn;
        this.f13106fb = n3Var.f13115gv;
        this.f13110s = n3Var.f13118v;
        this.f13104c5 = n3Var.f13113a;
        byte[] bArr = n3Var.f13114fb;
        this.f13108i9 = bArr;
        this.f13107gv = (byte) (bArr.length / 4);
        this.f13105f = n3Var.f13117s;
    }
}
