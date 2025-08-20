package af;

import af.f7;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.v;
import e4.ta;
import java.io.IOException;
import m1.g;
import m1.m;
/* loaded from: classes.dex */
public class f7 implements e4.ta {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public gv f195a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f196c;

    /* renamed from: co  reason: collision with root package name */
    public int f198co;

    /* renamed from: d  reason: collision with root package name */
    public long f199d;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public m f200d0;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public m f203fb;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public m f204fh;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f205gv;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f206i4;

    /* renamed from: mg  reason: collision with root package name */
    public boolean f208mg;

    /* renamed from: mt  reason: collision with root package name */
    public int f209mt;

    /* renamed from: p  reason: collision with root package name */
    public int f212p;

    /* renamed from: rz  reason: collision with root package name */
    public int f214rz;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public com.google.android.exoplayer2.drm.gv f215s;

    /* renamed from: ta  reason: collision with root package name */
    public boolean f217ta;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final v.y f219v;

    /* renamed from: w  reason: collision with root package name */
    public int f220w;
    public final q9 y;

    /* renamed from: z6  reason: collision with root package name */
    public boolean f225z6;

    /* renamed from: n3  reason: collision with root package name */
    public final n3 f211n3 = new n3();

    /* renamed from: c5  reason: collision with root package name */
    public int f197c5 = 1000;

    /* renamed from: i9  reason: collision with root package name */
    public int[] f207i9 = new int[1000];

    /* renamed from: f  reason: collision with root package name */
    public long[] f201f = new long[1000];

    /* renamed from: wz  reason: collision with root package name */
    public long[] f221wz = new long[1000];

    /* renamed from: tl  reason: collision with root package name */
    public int[] f218tl = new int[1000];

    /* renamed from: t  reason: collision with root package name */
    public int[] f216t = new int[1000];

    /* renamed from: xc  reason: collision with root package name */
    public ta.y[] f223xc = new ta.y[1000];

    /* renamed from: zn  reason: collision with root package name */
    public final ct<zn> f226zn = new ct<>(new v5.c5() { // from class: af.k
        @Override // v5.c5
        public final void accept(Object obj) {
            f7.b((f7.zn) obj);
        }
    });

    /* renamed from: z  reason: collision with root package name */
    public long f224z = Long.MIN_VALUE;

    /* renamed from: r  reason: collision with root package name */
    public long f213r = Long.MIN_VALUE;

    /* renamed from: x4  reason: collision with root package name */
    public long f222x4 = Long.MIN_VALUE;

    /* renamed from: n  reason: collision with root package name */
    public boolean f210n = true;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f202f3 = true;

    /* loaded from: classes.dex */
    public interface gv {
        void w(m mVar);
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public long f227n3;
        public int y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public ta.y f228zn;
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final a.n3 f229n3;
        public final m y;

        public zn(m mVar, a.n3 n3Var) {
            this.y = mVar;
            this.f229n3 = n3Var;
        }
    }

    public f7(kx.n3 n3Var, @Nullable com.google.android.exoplayer2.drm.a aVar, @Nullable v.y yVar) {
        this.f205gv = aVar;
        this.f219v = yVar;
        this.y = new q9(n3Var);
    }

    public static /* synthetic */ void b(zn znVar) {
        znVar.f229n3.release();
    }

    public static f7 f(kx.n3 n3Var, com.google.android.exoplayer2.drm.a aVar, v.y yVar) {
        return new f7(n3Var, (com.google.android.exoplayer2.drm.a) v5.y.v(aVar), (v.y) v5.y.v(yVar));
    }

    public static f7 t(kx.n3 n3Var) {
        return new f7(n3Var, null, null);
    }

    @Override // e4.ta
    public final void a(v5.rz rzVar, int i, int i5) {
        this.y.p(rzVar, i);
    }

    public final synchronized boolean a8() {
        return this.f206i4;
    }

    public final synchronized long c() {
        return this.f222x4;
    }

    public final synchronized void c5(long j2, int i, long j4, int i5, @Nullable ta.y yVar) {
        boolean z2;
        a.n3 n3Var;
        boolean z3;
        try {
            int i6 = this.f220w;
            if (i6 > 0) {
                int mg2 = mg(i6 - 1);
                if (this.f201f[mg2] + this.f216t[mg2] <= j4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v5.y.y(z3);
            }
            if ((536870912 & i) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f206i4 = z2;
            this.f222x4 = Math.max(this.f222x4, j2);
            int mg3 = mg(this.f220w);
            this.f221wz[mg3] = j2;
            this.f201f[mg3] = j4;
            this.f216t[mg3] = i5;
            this.f218tl[mg3] = i;
            this.f223xc[mg3] = yVar;
            this.f207i9[mg3] = this.f214rz;
            if (this.f226zn.fb() || !this.f226zn.a().y.equals(this.f204fh)) {
                com.google.android.exoplayer2.drm.a aVar = this.f205gv;
                if (aVar != null) {
                    n3Var = aVar.zn(this.f219v, this.f204fh);
                } else {
                    n3Var = a.n3.y;
                }
                this.f226zn.y(z6(), new zn((m) v5.y.v(this.f204fh), n3Var));
            }
            int i8 = this.f220w + 1;
            this.f220w = i8;
            int i10 = this.f197c5;
            if (i8 == i10) {
                int i11 = i10 + 1000;
                int[] iArr = new int[i11];
                long[] jArr = new long[i11];
                long[] jArr2 = new long[i11];
                int[] iArr2 = new int[i11];
                int[] iArr3 = new int[i11];
                ta.y[] yVarArr = new ta.y[i11];
                int i12 = this.f209mt;
                int i13 = i10 - i12;
                System.arraycopy(this.f201f, i12, jArr, 0, i13);
                System.arraycopy(this.f221wz, this.f209mt, jArr2, 0, i13);
                System.arraycopy(this.f218tl, this.f209mt, iArr2, 0, i13);
                System.arraycopy(this.f216t, this.f209mt, iArr3, 0, i13);
                System.arraycopy(this.f223xc, this.f209mt, yVarArr, 0, i13);
                System.arraycopy(this.f207i9, this.f209mt, iArr, 0, i13);
                int i14 = this.f209mt;
                System.arraycopy(this.f201f, 0, jArr, i13, i14);
                System.arraycopy(this.f221wz, 0, jArr2, i13, i14);
                System.arraycopy(this.f218tl, 0, iArr2, i13, i14);
                System.arraycopy(this.f216t, 0, iArr3, i13, i14);
                System.arraycopy(this.f223xc, 0, yVarArr, i13, i14);
                System.arraycopy(this.f207i9, 0, iArr, i13, i14);
                this.f201f = jArr;
                this.f221wz = jArr2;
                this.f218tl = iArr2;
                this.f216t = iArr3;
                this.f223xc = yVarArr;
                this.f207i9 = iArr;
                this.f209mt = 0;
                this.f197c5 = i11;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void co() {
        this.y.n3(xc());
    }

    public final void ct(int i) {
        this.f214rz = i;
    }

    @Nullable
    public final synchronized m d() {
        m mVar;
        if (this.f210n) {
            mVar = null;
        } else {
            mVar = this.f204fh;
        }
        return mVar;
    }

    public final synchronized long d0() {
        return Math.max(this.f213r, fh(this.f198co));
    }

    public final synchronized void dm(int i) {
        boolean z2;
        if (i >= 0) {
            try {
                if (this.f198co + i <= this.f220w) {
                    z2 = true;
                    v5.y.y(z2);
                    this.f198co += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        v5.y.y(z2);
        this.f198co += i;
    }

    public final boolean ej() {
        if (this.f198co != this.f220w) {
            return true;
        }
        return false;
    }

    public final synchronized boolean en(long j2, boolean z2) {
        k();
        int mg2 = mg(this.f198co);
        if (ej() && j2 >= this.f221wz[mg2] && (j2 <= this.f222x4 || z2)) {
            int x42 = x4(mg2, this.f220w - this.f198co, j2, true);
            if (x42 == -1) {
                return false;
            }
            this.f224z = j2;
            this.f198co += x42;
            return true;
        }
        return false;
    }

    public final int f3() {
        return this.f212p;
    }

    public final synchronized boolean f7(int i) {
        k();
        int i5 = this.f212p;
        if (i >= i5 && i <= this.f220w + i5) {
            this.f224z = Long.MIN_VALUE;
            this.f198co = i - i5;
            return true;
        }
        return false;
    }

    public final long fh(int i) {
        long j2 = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int mg2 = mg(i - 1);
        for (int i5 = 0; i5 < i; i5++) {
            j2 = Math.max(j2, this.f221wz[mg2]);
            if ((this.f218tl[mg2] & 1) != 0) {
                break;
            }
            mg2--;
            if (mg2 == -1) {
                mg2 = this.f197c5 - 1;
            }
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    @Override // e4.ta
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void gv(long r12, int r14, int r15, int r16, @androidx.annotation.Nullable e4.ta.y r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f196c
            if (r0 == 0) goto L10
            m1.m r0 = r8.f200d0
            java.lang.Object r0 = v5.y.c5(r0)
            m1.m r0 = (m1.m) r0
            r11.v(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = 1
            goto L19
        L18:
            r3 = 0
        L19:
            boolean r4 = r8.f202f3
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f202f3 = r1
        L22:
            long r4 = r8.f199d
            long r4 = r4 + r12
            boolean r6 = r8.f208mg
            if (r6 == 0) goto L54
            long r6 = r8.f224z
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L54
            boolean r0 = r8.f217ta
            if (r0 != 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            m1.m r6 = r8.f204fh
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            v5.r.c5(r6, r0)
            r8.f217ta = r2
        L50:
            r0 = r14 | 1
            r6 = r0
            goto L55
        L54:
            r6 = r14
        L55:
            boolean r0 = r8.f225z6
            if (r0 == 0) goto L66
            if (r3 == 0) goto L65
            boolean r0 = r11.s(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.f225z6 = r1
            goto L66
        L65:
            return
        L66:
            af.q9 r0 = r8.y
            long r0 = r0.v()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.c5(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: af.f7.gv(long, int, int, int, e4.ta$y):void");
    }

    public final synchronized int hw(g gVar, a9.fb fbVar, boolean z2, boolean z3, n3 n3Var) {
        try {
            fbVar.f58s = false;
            if (!ej()) {
                if (!z3 && !this.f206i4) {
                    m mVar = this.f204fh;
                    if (mVar == null || (!z2 && mVar == this.f203fb)) {
                        return -3;
                    }
                    vl((m) v5.y.v(mVar), gVar);
                    return -5;
                }
                fbVar.w(4);
                return -4;
            }
            m mVar2 = this.f226zn.v(rz()).y;
            if (!z2 && mVar2 == this.f203fb) {
                int mg2 = mg(this.f198co);
                if (!k5(mg2)) {
                    fbVar.f58s = true;
                    return -3;
                }
                fbVar.w(this.f218tl[mg2]);
                if (this.f198co == this.f220w - 1 && (z3 || this.f206i4)) {
                    fbVar.v(536870912);
                }
                long j2 = this.f221wz[mg2];
                fbVar.f55f = j2;
                if (j2 < this.f224z) {
                    fbVar.v(Integer.MIN_VALUE);
                }
                n3Var.y = this.f216t[mg2];
                n3Var.f227n3 = this.f201f[mg2];
                n3Var.f228zn = this.f223xc[mg2];
                return -4;
            }
            vl(mVar2, gVar);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    public m i4(m mVar) {
        if (this.f199d != 0 && mVar.f10951fh != Long.MAX_VALUE) {
            return mVar.n3().nf(mVar.f10951fh + this.f199d).z6();
        }
        return mVar;
    }

    public final int i9(long j2) {
        int i = this.f220w;
        int mg2 = mg(i - 1);
        while (i > this.f198co && this.f221wz[mg2] >= j2) {
            i--;
            mg2--;
            if (mg2 == -1) {
                mg2 = this.f197c5 - 1;
            }
        }
        return i;
    }

    public void j() {
        q9(true);
        oz();
    }

    public final synchronized int j5() {
        int i;
        try {
            int mg2 = mg(this.f198co);
            if (ej()) {
                i = this.f207i9[mg2];
            } else {
                i = this.f214rz;
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public final void jz(long j2) {
        if (this.f199d != j2) {
            this.f199d = j2;
            ud();
        }
    }

    public final synchronized void k() {
        this.f198co = 0;
        this.y.xc();
    }

    public final boolean k5(int i) {
        com.google.android.exoplayer2.drm.gv gvVar = this.f215s;
        if (gvVar != null && gvVar.getState() != 4 && ((this.f218tl[i] & 1073741824) != 0 || !this.f215s.gv())) {
            return false;
        }
        return true;
    }

    public final int mg(int i) {
        int i5 = this.f209mt + i;
        int i6 = this.f197c5;
        if (i5 >= i6) {
            return i5 - i6;
        }
        return i5;
    }

    public final void mt() {
        this.y.n3(wz());
    }

    public final synchronized long n() {
        long j2;
        if (this.f220w == 0) {
            j2 = Long.MIN_VALUE;
        } else {
            j2 = this.f221wz[this.f209mt];
        }
        return j2;
    }

    @Override // e4.ta
    public /* synthetic */ int n3(kx.c5 c5Var, int i, boolean z2) {
        return e4.mg.y(this, c5Var, i, z2);
    }

    public int o(g gVar, a9.fb fbVar, int i, boolean z2) {
        boolean z3;
        boolean z4 = false;
        if ((i & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int hw2 = hw(gVar, fbVar, z3, z2, this.f211n3);
        if (hw2 == -4 && !fbVar.t()) {
            if ((i & 1) != 0) {
                z4 = true;
            }
            if ((i & 4) == 0) {
                if (z4) {
                    this.y.a(fbVar, this.f211n3);
                } else {
                    this.y.tl(fbVar, this.f211n3);
                }
            }
            if (!z4) {
                this.f198co++;
            }
        }
        return hw2;
    }

    public final void o4() {
        this.f225z6 = true;
    }

    public final void oz() {
        com.google.android.exoplayer2.drm.gv gvVar = this.f215s;
        if (gvVar != null) {
            gvVar.n3(this.f219v);
            this.f215s = null;
            this.f203fb = null;
        }
    }

    public final void p(long j2, boolean z2, boolean z3) {
        this.y.n3(tl(j2, z2, z3));
    }

    public void q9(boolean z2) {
        this.y.wz();
        this.f220w = 0;
        this.f212p = 0;
        this.f209mt = 0;
        this.f198co = 0;
        this.f202f3 = true;
        this.f224z = Long.MIN_VALUE;
        this.f213r = Long.MIN_VALUE;
        this.f222x4 = Long.MIN_VALUE;
        this.f206i4 = false;
        this.f226zn.n3();
        if (z2) {
            this.f200d0 = null;
            this.f204fh = null;
            this.f210n = true;
        }
    }

    public void qn() {
        mt();
        oz();
    }

    public final void r(int i) {
        this.y.zn(z(i));
    }

    public final int rz() {
        return this.f212p + this.f198co;
    }

    public final synchronized boolean s(long j2) {
        boolean z2 = false;
        if (this.f220w == 0) {
            if (j2 > this.f213r) {
                z2 = true;
            }
            return z2;
        } else if (d0() >= j2) {
            return false;
        } else {
            z(this.f212p + i9(j2));
            return true;
        }
    }

    public final synchronized int ta(long j2, boolean z2) {
        int mg2 = mg(this.f198co);
        if (ej() && j2 >= this.f221wz[mg2]) {
            if (j2 > this.f222x4 && z2) {
                return this.f220w - this.f198co;
            }
            int x42 = x4(mg2, this.f220w - this.f198co, j2, true);
            if (x42 == -1) {
                return 0;
            }
            return x42;
        }
        return 0;
    }

    public final synchronized long tl(long j2, boolean z2, boolean z3) {
        int i;
        try {
            int i5 = this.f220w;
            if (i5 != 0) {
                long[] jArr = this.f221wz;
                int i6 = this.f209mt;
                if (j2 >= jArr[i6]) {
                    if (z3 && (i = this.f198co) != i5) {
                        i5 = i + 1;
                    }
                    int x42 = x4(i6, i5, j2, z2);
                    if (x42 == -1) {
                        return -1L;
                    }
                    return w(x42);
                }
            }
            return -1L;
        } finally {
        }
    }

    public final void u(long j2) {
        this.f224z = j2;
    }

    public final void ud() {
        this.f196c = true;
    }

    public final void ut() {
        q9(false);
    }

    @Override // e4.ta
    public final void v(m mVar) {
        m i42 = i4(mVar);
        this.f196c = false;
        this.f200d0 = mVar;
        boolean y52 = y5(i42);
        gv gvVar = this.f195a;
        if (gvVar != null && y52) {
            gvVar.w(i42);
        }
    }

    public final void vl(m mVar, g gVar) {
        boolean z2;
        DrmInitData drmInitData;
        m mVar2;
        m mVar3 = this.f203fb;
        if (mVar3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            drmInitData = null;
        } else {
            drmInitData = mVar3.f10944d0;
        }
        this.f203fb = mVar;
        DrmInitData drmInitData2 = mVar.f10944d0;
        com.google.android.exoplayer2.drm.a aVar = this.f205gv;
        if (aVar != null) {
            mVar2 = mVar.zn(aVar.n3(mVar));
        } else {
            mVar2 = mVar;
        }
        gVar.f10757n3 = mVar2;
        gVar.y = this.f215s;
        if (this.f205gv == null) {
            return;
        }
        if (!z2 && v5.j5.zn(drmInitData, drmInitData2)) {
            return;
        }
        com.google.android.exoplayer2.drm.gv gvVar = this.f215s;
        com.google.android.exoplayer2.drm.gv y2 = this.f205gv.y(this.f219v, mVar);
        this.f215s = y2;
        gVar.y = y2;
        if (gvVar != null) {
            gvVar.n3(this.f219v);
        }
    }

    public final long w(int i) {
        int i5;
        this.f213r = Math.max(this.f213r, fh(i));
        this.f220w -= i;
        int i6 = this.f212p + i;
        this.f212p = i6;
        int i8 = this.f209mt + i;
        this.f209mt = i8;
        int i10 = this.f197c5;
        if (i8 >= i10) {
            this.f209mt = i8 - i10;
        }
        int i11 = this.f198co - i;
        this.f198co = i11;
        if (i11 < 0) {
            this.f198co = 0;
        }
        this.f226zn.gv(i6);
        if (this.f220w == 0) {
            int i12 = this.f209mt;
            if (i12 == 0) {
                i12 = this.f197c5;
            }
            return this.f201f[i12 - 1] + this.f216t[i5];
        }
        return this.f201f[this.f209mt];
    }

    public final synchronized long wz() {
        int i = this.f220w;
        if (i == 0) {
            return -1L;
        }
        return w(i);
    }

    public synchronized boolean x(boolean z2) {
        m mVar;
        boolean z3 = true;
        if (!ej()) {
            if (!z2 && !this.f206i4 && ((mVar = this.f204fh) == null || mVar == this.f203fb)) {
                z3 = false;
            }
            return z3;
        } else if (this.f226zn.v(rz()).y != this.f203fb) {
            return true;
        } else {
            return k5(mg(this.f198co));
        }
    }

    public final int x4(int i, int i5, long j2, boolean z2) {
        int i6 = -1;
        for (int i8 = 0; i8 < i5; i8++) {
            long j4 = this.f221wz[i];
            if (j4 <= j2) {
                if (!z2 || (this.f218tl[i] & 1) != 0) {
                    if (j4 == j2) {
                        return i8;
                    }
                    i6 = i8;
                }
                i++;
                if (i == this.f197c5) {
                    i = 0;
                }
            } else {
                return i6;
            }
        }
        return i6;
    }

    public synchronized long xc() {
        int i = this.f198co;
        if (i == 0) {
            return -1L;
        }
        return w(i);
    }

    public final void xg(@Nullable gv gvVar) {
        this.f195a = gvVar;
    }

    @Override // e4.ta
    public final int y(kx.c5 c5Var, int i, boolean z2, int i5) throws IOException {
        return this.y.w(c5Var, i, z2);
    }

    public final synchronized boolean y5(m mVar) {
        try {
            this.f210n = false;
            if (v5.j5.zn(mVar, this.f204fh)) {
                return false;
            }
            if (!this.f226zn.fb() && this.f226zn.a().y.equals(mVar)) {
                this.f204fh = this.f226zn.a().y;
            } else {
                this.f204fh = mVar;
            }
            m mVar2 = this.f204fh;
            this.f208mg = v5.n.y(mVar2.f10948f3, mVar2.f10942co);
            this.f217ta = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void yt() throws IOException {
        com.google.android.exoplayer2.drm.gv gvVar = this.f215s;
        if (gvVar != null && gvVar.getState() == 1) {
            throw ((gv.y) v5.y.v(this.f215s.getError()));
        }
    }

    public final long z(int i) {
        boolean z2;
        int z62 = z6() - i;
        boolean z3 = false;
        if (z62 >= 0 && z62 <= this.f220w - this.f198co) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int i5 = this.f220w - z62;
        this.f220w = i5;
        this.f222x4 = Math.max(this.f213r, fh(i5));
        if (z62 == 0 && this.f206i4) {
            z3 = true;
        }
        this.f206i4 = z3;
        this.f226zn.zn(i);
        int i6 = this.f220w;
        if (i6 != 0) {
            int mg2 = mg(i6 - 1);
            return this.f201f[mg2] + this.f216t[mg2];
        }
        return 0L;
    }

    public final int z6() {
        return this.f212p + this.f220w;
    }

    @Override // e4.ta
    public /* synthetic */ void zn(v5.rz rzVar, int i) {
        e4.mg.n3(this, rzVar, i);
    }
}
