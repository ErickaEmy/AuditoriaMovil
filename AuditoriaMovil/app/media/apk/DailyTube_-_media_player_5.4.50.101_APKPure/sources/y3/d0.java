package y3;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import e4.fh;
import java.io.IOException;
import java.util.Map;
import m1.ne;
import v5.k5;
import y3.ud;
/* loaded from: classes.dex */
public final class d0 implements e4.t {

    /* renamed from: t  reason: collision with root package name */
    public static final e4.mt f15018t = new e4.mt() { // from class: y3.c
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] gv2;
            gv2 = d0.gv();
            return gv2;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f15019a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public f3 f15020c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15021f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f15022fb;

    /* renamed from: gv  reason: collision with root package name */
    public final n f15023gv;

    /* renamed from: i9  reason: collision with root package name */
    public e4.wz f15024i9;

    /* renamed from: n3  reason: collision with root package name */
    public final SparseArray<y> f15025n3;

    /* renamed from: s  reason: collision with root package name */
    public long f15026s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f15027v;
    public final k5 y;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.rz f15028zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15029a;

        /* renamed from: fb  reason: collision with root package name */
        public int f15030fb;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f15031gv;

        /* renamed from: n3  reason: collision with root package name */
        public final k5 f15032n3;

        /* renamed from: s  reason: collision with root package name */
        public long f15033s;

        /* renamed from: v  reason: collision with root package name */
        public boolean f15034v;
        public final tl y;

        /* renamed from: zn  reason: collision with root package name */
        public final v5.fh f15035zn = new v5.fh(new byte[64]);

        public y(tl tlVar, k5 k5Var) {
            this.y = tlVar;
            this.f15032n3 = k5Var;
        }

        public void gv() {
            this.f15029a = false;
            this.y.zn();
        }

        public final void n3() {
            this.f15035zn.mt(8);
            this.f15031gv = this.f15035zn.fb();
            this.f15034v = this.f15035zn.fb();
            this.f15035zn.mt(6);
            this.f15030fb = this.f15035zn.s(8);
        }

        public void y(v5.rz rzVar) throws ne {
            rzVar.t(this.f15035zn.y, 0, 3);
            this.f15035zn.w(0);
            n3();
            rzVar.t(this.f15035zn.y, 0, this.f15030fb);
            this.f15035zn.w(0);
            zn();
            this.y.a(this.f15033s, 4);
            this.y.n3(rzVar);
            this.y.gv();
        }

        public final void zn() {
            this.f15033s = 0L;
            if (this.f15031gv) {
                this.f15035zn.mt(4);
                this.f15035zn.mt(1);
                this.f15035zn.mt(1);
                long s2 = (this.f15035zn.s(3) << 30) | (this.f15035zn.s(15) << 15) | this.f15035zn.s(15);
                this.f15035zn.mt(1);
                if (!this.f15029a && this.f15034v) {
                    this.f15035zn.mt(4);
                    this.f15035zn.mt(1);
                    this.f15035zn.mt(1);
                    this.f15035zn.mt(1);
                    this.f15032n3.n3((this.f15035zn.s(3) << 30) | (this.f15035zn.s(15) << 15) | this.f15035zn.s(15));
                    this.f15029a = true;
                }
                this.f15033s = this.f15032n3.n3(s2);
            }
        }
    }

    public d0() {
        this(new k5(0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e4.t[] gv() {
        return new e4.t[]{new d0()};
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        byte[] bArr = new byte[14];
        tlVar.z(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        tlVar.wz(bArr[13] & 7);
        tlVar.z(bArr, 0, 3);
        if (1 != (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return false;
        }
        return true;
    }

    public final void fb(long j2) {
        if (!this.f15021f) {
            this.f15021f = true;
            if (this.f15023gv.zn() != -9223372036854775807L) {
                f3 f3Var = new f3(this.f15023gv.gv(), this.f15023gv.zn(), j2);
                this.f15020c5 = f3Var;
                this.f15024i9.t(f3Var.n3());
                return;
            }
            this.f15024i9.t(new fh.n3(this.f15023gv.zn()));
        }
    }

    @Override // e4.t
    public int v(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        long j2;
        long j4;
        tl tlVar2;
        v5.y.c5(this.f15024i9);
        long length = tlVar.getLength();
        int i = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i != 0 && !this.f15023gv.v()) {
            return this.f15023gv.fb(tlVar, d0Var);
        }
        fb(length);
        f3 f3Var = this.f15020c5;
        if (f3Var != null && f3Var.gv()) {
            return this.f15020c5.zn(tlVar, d0Var);
        }
        tlVar.s();
        if (i != 0) {
            j2 = length - tlVar.t();
        } else {
            j2 = -1;
        }
        if ((j2 != -1 && j2 < 4) || !tlVar.v(this.f15028zn.v(), 0, 4, true)) {
            return -1;
        }
        this.f15028zn.oz(0);
        int p2 = this.f15028zn.p();
        if (p2 == 441) {
            return -1;
        }
        if (p2 == 442) {
            tlVar.z(this.f15028zn.v(), 0, 10);
            this.f15028zn.oz(9);
            tlVar.p((this.f15028zn.ej() & 7) + 14);
            return 0;
        } else if (p2 == 443) {
            tlVar.z(this.f15028zn.v(), 0, 2);
            this.f15028zn.oz(0);
            tlVar.p(this.f15028zn.yt() + 6);
            return 0;
        } else if (((p2 & (-256)) >> 8) != 1) {
            tlVar.p(1);
            return 0;
        } else {
            int i5 = p2 & 255;
            y yVar = this.f15025n3.get(i5);
            if (!this.f15027v) {
                if (yVar == null) {
                    if (i5 == 189) {
                        tlVar2 = new zn();
                        this.f15019a = true;
                        this.f15026s = tlVar.getPosition();
                    } else if ((p2 & 224) == 192) {
                        tlVar2 = new z();
                        this.f15019a = true;
                        this.f15026s = tlVar.getPosition();
                    } else if ((p2 & 240) == 224) {
                        tlVar2 = new wz();
                        this.f15022fb = true;
                        this.f15026s = tlVar.getPosition();
                    } else {
                        tlVar2 = null;
                    }
                    if (tlVar2 != null) {
                        tlVar2.v(this.f15024i9, new ud.gv(i5, 256));
                        yVar = new y(tlVar2, this.y);
                        this.f15025n3.put(i5, yVar);
                    }
                }
                if (this.f15019a && this.f15022fb) {
                    j4 = this.f15026s + 8192;
                } else {
                    j4 = 1048576;
                }
                if (tlVar.getPosition() > j4) {
                    this.f15027v = true;
                    this.f15024i9.xc();
                }
            }
            tlVar.z(this.f15028zn.v(), 0, 2);
            this.f15028zn.oz(0);
            int yt2 = this.f15028zn.yt() + 6;
            if (yVar == null) {
                tlVar.p(yt2);
            } else {
                this.f15028zn.j5(yt2);
                tlVar.readFully(this.f15028zn.v(), 0, yt2);
                this.f15028zn.oz(6);
                yVar.y(this.f15028zn);
                v5.rz rzVar = this.f15028zn;
                rzVar.j(rzVar.n3());
            }
            return 0;
        }
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        boolean z2;
        boolean z3 = true;
        if (this.y.v() == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            long zn2 = this.y.zn();
            z2 = (zn2 == -9223372036854775807L || zn2 == 0 || zn2 == j4) ? false : false;
        }
        if (z2) {
            this.y.fb(j4);
        }
        f3 f3Var = this.f15020c5;
        if (f3Var != null) {
            f3Var.s(j4);
        }
        for (int i = 0; i < this.f15025n3.size(); i++) {
            this.f15025n3.valueAt(i).gv();
        }
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f15024i9 = wzVar;
    }

    public d0(k5 k5Var) {
        this.y = k5Var;
        this.f15028zn = new v5.rz(4096);
        this.f15025n3 = new SparseArray<>();
        this.f15023gv = new n();
    }

    @Override // e4.t
    public void release() {
    }
}
