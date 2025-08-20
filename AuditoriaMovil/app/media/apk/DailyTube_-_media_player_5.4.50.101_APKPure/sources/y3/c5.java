package y3;

import androidx.annotation.Nullable;
import d9.y;
import java.util.Arrays;
import java.util.Collections;
import m1.m;
import m1.ne;
import v5.j5;
import y3.ud;
/* loaded from: classes.dex */
public final class c5 implements tl {

    /* renamed from: x4  reason: collision with root package name */
    public static final byte[] f14969x4 = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    public e4.ta f14970a;

    /* renamed from: c5  reason: collision with root package name */
    public int f14971c5;

    /* renamed from: co  reason: collision with root package name */
    public long f14972co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14973f;

    /* renamed from: fb  reason: collision with root package name */
    public e4.ta f14974fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final String f14975gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14976i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f14977mt;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.fh f14978n3;

    /* renamed from: p  reason: collision with root package name */
    public long f14979p;

    /* renamed from: r  reason: collision with root package name */
    public long f14980r;

    /* renamed from: s  reason: collision with root package name */
    public int f14981s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14982t;

    /* renamed from: tl  reason: collision with root package name */
    public int f14983tl;

    /* renamed from: v  reason: collision with root package name */
    public String f14984v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f14985w;

    /* renamed from: wz  reason: collision with root package name */
    public int f14986wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f14987xc;
    public final boolean y;

    /* renamed from: z  reason: collision with root package name */
    public e4.ta f14988z;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.rz f14989zn;

    public c5(boolean z2) {
        this(z2, null);
    }

    private boolean c5(v5.rz rzVar, byte[] bArr, int i) {
        int min = Math.min(rzVar.y(), i - this.f14971c5);
        rzVar.t(bArr, this.f14971c5, min);
        int i5 = this.f14971c5 + min;
        this.f14971c5 = i5;
        if (i5 == i) {
            return true;
        }
        return false;
    }

    public static boolean tl(int i) {
        if ((i & 65526) == 65520) {
            return true;
        }
        return false;
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f14972co = j2;
        }
    }

    public final void co() {
        this.f14981s = 0;
        this.f14971c5 = 0;
        this.f14976i9 = 256;
    }

    public long f() {
        return this.f14979p;
    }

    public final void fb(v5.rz rzVar) {
        if (rzVar.y() == 0) {
            return;
        }
        this.f14978n3.y[0] = rzVar.v()[rzVar.a()];
        this.f14978n3.w(2);
        int s2 = this.f14978n3.s(4);
        int i = this.f14986wz;
        if (i != -1 && s2 != i) {
            p();
            return;
        }
        if (!this.f14982t) {
            this.f14982t = true;
            this.f14983tl = this.f14987xc;
            this.f14986wz = s2;
        }
        z();
    }

    public final boolean i4(v5.rz rzVar, byte[] bArr, int i) {
        if (rzVar.y() < i) {
            return false;
        }
        rzVar.t(bArr, 0, i);
        return true;
    }

    public final void i9(v5.rz rzVar) {
        byte[] v2 = rzVar.v();
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        while (a2 < fb2) {
            int i = a2 + 1;
            byte b2 = v2[a2];
            int i5 = b2 & 255;
            if (this.f14976i9 == 512 && t((byte) -1, (byte) i5) && (this.f14982t || s(rzVar, a2 - 1))) {
                this.f14987xc = (b2 & 8) >> 3;
                boolean z2 = true;
                if ((b2 & 1) != 0) {
                    z2 = false;
                }
                this.f14973f = z2;
                if (!this.f14982t) {
                    mt();
                } else {
                    z();
                }
                rzVar.oz(i);
                return;
            }
            int i6 = this.f14976i9;
            int i8 = i5 | i6;
            if (i8 != 329) {
                if (i8 != 511) {
                    if (i8 != 836) {
                        if (i8 != 1075) {
                            if (i6 != 256) {
                                this.f14976i9 = 256;
                            }
                        } else {
                            r();
                            rzVar.oz(i);
                            return;
                        }
                    } else {
                        this.f14976i9 = 1024;
                    }
                } else {
                    this.f14976i9 = 512;
                }
            } else {
                this.f14976i9 = 768;
            }
            a2 = i;
        }
        rzVar.oz(a2);
    }

    public final void mt() {
        this.f14981s = 1;
        this.f14971c5 = 0;
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) throws ne {
        int i;
        y();
        while (rzVar.y() > 0) {
            int i5 = this.f14981s;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                w(rzVar);
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            if (this.f14973f) {
                                i = 7;
                            } else {
                                i = 5;
                            }
                            if (c5(rzVar, this.f14978n3.y, i)) {
                                wz();
                            }
                        }
                    } else if (c5(rzVar, this.f14989zn.v(), 10)) {
                        xc();
                    }
                } else {
                    fb(rzVar);
                }
            } else {
                i9(rzVar);
            }
        }
    }

    public final void p() {
        this.f14982t = false;
        co();
    }

    public final void r() {
        this.f14981s = 2;
        this.f14971c5 = f14969x4.length;
        this.f14977mt = 0;
        this.f14989zn.oz(0);
    }

    public final boolean s(v5.rz rzVar, int i) {
        rzVar.oz(i + 1);
        if (!i4(rzVar, this.f14978n3.y, 1)) {
            return false;
        }
        this.f14978n3.w(4);
        int s2 = this.f14978n3.s(1);
        int i5 = this.f14983tl;
        if (i5 != -1 && s2 != i5) {
            return false;
        }
        if (this.f14986wz != -1) {
            if (!i4(rzVar, this.f14978n3.y, 1)) {
                return true;
            }
            this.f14978n3.w(2);
            if (this.f14978n3.s(4) != this.f14986wz) {
                return false;
            }
            rzVar.oz(i + 2);
        }
        if (!i4(rzVar, this.f14978n3.y, 4)) {
            return true;
        }
        this.f14978n3.w(14);
        int s3 = this.f14978n3.s(13);
        if (s3 < 7) {
            return false;
        }
        byte[] v2 = rzVar.v();
        int fb2 = rzVar.fb();
        int i6 = i + s3;
        if (i6 >= fb2) {
            return true;
        }
        byte b2 = v2[i6];
        if (b2 == -1) {
            int i8 = i6 + 1;
            if (i8 == fb2) {
                return true;
            }
            if (t((byte) -1, v2[i8]) && ((v2[i8] & 8) >> 3) == s2) {
                return true;
            }
            return false;
        } else if (b2 != 73) {
            return false;
        } else {
            int i10 = i6 + 1;
            if (i10 == fb2) {
                return true;
            }
            if (v2[i10] != 68) {
                return false;
            }
            int i11 = i6 + 2;
            if (i11 == fb2 || v2[i11] == 51) {
                return true;
            }
            return false;
        }
    }

    public final boolean t(byte b2, byte b3) {
        return tl(((b2 & 255) << 8) | (b3 & 255));
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f14984v = gvVar.n3();
        e4.ta a2 = wzVar.a(gvVar.zn(), 1);
        this.f14970a = a2;
        this.f14988z = a2;
        if (this.y) {
            gvVar.y();
            e4.ta a3 = wzVar.a(gvVar.zn(), 5);
            this.f14974fb = a3;
            a3.v(new m.n3().oz(gvVar.n3()).o4("application/id3").z6());
            return;
        }
        this.f14974fb = new e4.f();
    }

    public final void w(v5.rz rzVar) {
        int min = Math.min(rzVar.y(), this.f14977mt - this.f14971c5);
        this.f14988z.zn(rzVar, min);
        int i = this.f14971c5 + min;
        this.f14971c5 = i;
        int i5 = this.f14977mt;
        if (i == i5) {
            long j2 = this.f14972co;
            if (j2 != -9223372036854775807L) {
                this.f14988z.gv(j2, 1, i5, 0, null);
                this.f14972co += this.f14980r;
            }
            co();
        }
    }

    public final void wz() throws ne {
        this.f14978n3.w(0);
        if (!this.f14985w) {
            int i = 2;
            int s2 = this.f14978n3.s(2) + 1;
            if (s2 != 2) {
                v5.r.c5("AdtsReader", "Detected audio object type: " + s2 + ", but assuming AAC LC.");
            } else {
                i = s2;
            }
            this.f14978n3.mt(5);
            byte[] n32 = d9.y.n3(i, this.f14986wz, this.f14978n3.s(3));
            y.n3 a2 = d9.y.a(n32);
            m z62 = new m.n3().oz(this.f14984v).o4("audio/mp4a-latm").x(a2.f7227zn).a8(a2.f7226n3).rs(a2.y).ut(Collections.singletonList(n32)).k(this.f14975gv).z6();
            this.f14979p = 1024000000 / z62.f10966ut;
            this.f14970a.v(z62);
            this.f14985w = true;
        } else {
            this.f14978n3.mt(10);
        }
        this.f14978n3.mt(4);
        int s3 = this.f14978n3.s(13);
        int i5 = s3 - 7;
        if (this.f14973f) {
            i5 = s3 - 9;
        }
        x4(this.f14970a, this.f14979p, 0, i5);
    }

    public final void x4(e4.ta taVar, long j2, int i, int i5) {
        this.f14981s = 4;
        this.f14971c5 = i;
        this.f14988z = taVar;
        this.f14980r = j2;
        this.f14977mt = i5;
    }

    public final void xc() {
        this.f14974fb.zn(this.f14989zn, 10);
        this.f14989zn.oz(6);
        x4(this.f14974fb, 0L, 10, this.f14989zn.z6() + 10);
    }

    public final void y() {
        v5.y.v(this.f14970a);
        j5.i9(this.f14988z);
        j5.i9(this.f14974fb);
    }

    public final void z() {
        this.f14981s = 3;
        this.f14971c5 = 0;
    }

    @Override // y3.tl
    public void zn() {
        this.f14972co = -9223372036854775807L;
        p();
    }

    public c5(boolean z2, @Nullable String str) {
        this.f14978n3 = new v5.fh(new byte[7]);
        this.f14989zn = new v5.rz(Arrays.copyOf(f14969x4, 10));
        co();
        this.f14983tl = -1;
        this.f14986wz = -1;
        this.f14979p = -9223372036854775807L;
        this.f14972co = -9223372036854775807L;
        this.y = z2;
        this.f14975gv = str;
    }

    @Override // y3.tl
    public void gv() {
    }
}
