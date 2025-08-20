package fj;

import af.mg;
import android.util.Base64;
import androidx.annotation.Nullable;
import fj.g3;
import fj.zn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import m1.hy;
/* loaded from: classes.dex */
public final class kp implements g3 {

    /* renamed from: a  reason: collision with root package name */
    public hy f8016a;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public String f8017fb;

    /* renamed from: gv  reason: collision with root package name */
    public final w0.z<String> f8018gv;

    /* renamed from: n3  reason: collision with root package name */
    public final hy.n3 f8019n3;

    /* renamed from: v  reason: collision with root package name */
    public g3.y f8020v;
    public final hy.gv y;

    /* renamed from: zn  reason: collision with root package name */
    public final HashMap<String, y> f8021zn;

    /* renamed from: s  reason: collision with root package name */
    public static final w0.z<String> f8015s = new w0.z() { // from class: fj.yc
        @Override // w0.z
        public final Object get() {
            String t2;
            t2 = kp.t();
            return t2;
        }
    };

    /* renamed from: c5  reason: collision with root package name */
    public static final Random f8014c5 = new Random();

    /* loaded from: classes.dex */
    public final class y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8022a;

        /* renamed from: gv  reason: collision with root package name */
        public mg.n3 f8024gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f8025n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f8026v;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public long f8027zn;

        public y(String str, int i, @Nullable mg.n3 n3Var) {
            long j2;
            this.y = str;
            this.f8025n3 = i;
            if (n3Var == null) {
                j2 = -1;
            } else {
                j2 = n3Var.f238gv;
            }
            this.f8027zn = j2;
            if (n3Var != null && n3Var.n3()) {
                this.f8024gv = n3Var;
            }
        }

        public boolean c5(int i, @Nullable mg.n3 n3Var) {
            if (n3Var == null) {
                if (i != this.f8025n3) {
                    return false;
                }
                return true;
            }
            mg.n3 n3Var2 = this.f8024gv;
            if (n3Var2 == null) {
                if (n3Var.n3() || n3Var.f238gv != this.f8027zn) {
                    return false;
                }
                return true;
            } else if (n3Var.f238gv != n3Var2.f238gv || n3Var.f239n3 != n3Var2.f239n3 || n3Var.f241zn != n3Var2.f241zn) {
                return false;
            } else {
                return true;
            }
        }

        public void f(int i, @Nullable mg.n3 n3Var) {
            if (this.f8027zn == -1 && i == this.f8025n3 && n3Var != null) {
                this.f8027zn = n3Var.f238gv;
            }
        }

        public boolean i9(zn.y yVar) {
            mg.n3 n3Var = yVar.f8169gv;
            if (n3Var == null) {
                if (this.f8025n3 != yVar.f8174zn) {
                    return true;
                }
                return false;
            }
            long j2 = this.f8027zn;
            if (j2 == -1) {
                return false;
            }
            if (n3Var.f238gv > j2) {
                return true;
            }
            if (this.f8024gv == null) {
                return false;
            }
            int a2 = yVar.f8171n3.a(n3Var.y);
            int a3 = yVar.f8171n3.a(this.f8024gv.y);
            mg.n3 n3Var2 = yVar.f8169gv;
            if (n3Var2.f238gv < this.f8024gv.f238gv || a2 < a3) {
                return false;
            }
            if (a2 > a3) {
                return true;
            }
            if (n3Var2.n3()) {
                mg.n3 n3Var3 = yVar.f8169gv;
                int i = n3Var3.f239n3;
                int i5 = n3Var3.f241zn;
                mg.n3 n3Var4 = this.f8024gv;
                int i6 = n3Var4.f239n3;
                if (i > i6) {
                    return true;
                }
                if (i == i6 && i5 > n3Var4.f241zn) {
                    return true;
                }
                return false;
            }
            int i8 = yVar.f8169gv.f240v;
            if (i8 == -1 || i8 > this.f8024gv.f239n3) {
                return true;
            }
            return false;
        }

        public final int t(hy hyVar, hy hyVar2, int i) {
            if (i >= hyVar.z()) {
                if (i >= hyVar2.z()) {
                    return -1;
                }
                return i;
            }
            hyVar.mt(i, kp.this.y);
            for (int i5 = kp.this.y.f10808d0; i5 <= kp.this.y.f10812fh; i5++) {
                int a2 = hyVar2.a(hyVar.p(i5));
                if (a2 != -1) {
                    return hyVar2.i9(a2, kp.this.f8019n3).f10828fb;
                }
            }
            return -1;
        }

        public boolean tl(hy hyVar, hy hyVar2) {
            int t2 = t(hyVar, hyVar2, this.f8025n3);
            this.f8025n3 = t2;
            if (t2 == -1) {
                return false;
            }
            mg.n3 n3Var = this.f8024gv;
            if (n3Var != null && hyVar2.a(n3Var.y) == -1) {
                return false;
            }
            return true;
        }
    }

    public kp() {
        this(f8015s);
    }

    public static String t() {
        byte[] bArr = new byte[12];
        f8014c5.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // fj.g3
    public void a(g3.y yVar) {
        this.f8020v = yVar;
    }

    @Override // fj.g3
    public synchronized boolean fb(zn.y yVar, String str) {
        y yVar2 = this.f8021zn.get(str);
        if (yVar2 == null) {
            return false;
        }
        yVar2.f(yVar.f8174zn, yVar.f8169gv);
        return yVar2.c5(yVar.f8174zn, yVar.f8169gv);
    }

    @Override // fj.g3
    public synchronized void gv(zn.y yVar, int i) {
        boolean z2;
        boolean z3;
        try {
            v5.y.v(this.f8020v);
            if (i == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Iterator<y> it = this.f8021zn.values().iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (next.i9(yVar)) {
                    it.remove();
                    if (next.f8026v) {
                        boolean equals = next.y.equals(this.f8017fb);
                        if (z2 && equals && next.f8022a) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (equals) {
                            this.f8017fb = null;
                        }
                        this.f8020v.e(yVar, next.y, z3);
                    }
                }
            }
            wz(yVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // fj.g3
    public synchronized void n3(zn.y yVar) {
        g3.y yVar2;
        this.f8017fb = null;
        Iterator<y> it = this.f8021zn.values().iterator();
        while (it.hasNext()) {
            y next = it.next();
            it.remove();
            if (next.f8026v && (yVar2 = this.f8020v) != null) {
                yVar2.e(yVar, next.y, false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r25.f8169gv.f238gv < r2.f8027zn) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00df A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:4:0x0005, B:8:0x0014, B:11:0x0024, B:13:0x002e, B:18:0x003a, B:23:0x0048, B:25:0x0054, B:26:0x005a, B:28:0x005f, B:30:0x0065, B:32:0x007e, B:34:0x00d9, B:36:0x00df, B:38:0x00f5, B:40:0x0101, B:42:0x0107), top: B:47:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f1  */
    @Override // fj.g3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void s(fj.zn.y r25) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj.kp.s(fj.zn$y):void");
    }

    public final y tl(int i, @Nullable mg.n3 n3Var) {
        int i5;
        y yVar = null;
        long j2 = Long.MAX_VALUE;
        for (y yVar2 : this.f8021zn.values()) {
            yVar2.f(i, n3Var);
            if (yVar2.c5(i, n3Var)) {
                long j4 = yVar2.f8027zn;
                if (j4 != -1 && j4 >= j2) {
                    if (i5 == 0 && ((y) v5.j5.i9(yVar)).f8024gv != null && yVar2.f8024gv != null) {
                        yVar = yVar2;
                    }
                } else {
                    yVar = yVar2;
                    j2 = j4;
                }
            }
        }
        if (yVar == null) {
            String str = this.f8018gv.get();
            y yVar3 = new y(str, i, n3Var);
            this.f8021zn.put(str, yVar3);
            return yVar3;
        }
        return yVar;
    }

    @Override // fj.g3
    public synchronized String v(hy hyVar, mg.n3 n3Var) {
        return tl(hyVar.t(n3Var.y, this.f8019n3).f10828fb, n3Var).y;
    }

    public final void wz(zn.y yVar) {
        if (yVar.f8171n3.r()) {
            this.f8017fb = null;
            return;
        }
        y yVar2 = this.f8021zn.get(this.f8017fb);
        y tl2 = tl(yVar.f8174zn, yVar.f8169gv);
        this.f8017fb = tl2.y;
        s(yVar);
        mg.n3 n3Var = yVar.f8169gv;
        if (n3Var != null && n3Var.n3()) {
            if (yVar2 == null || yVar2.f8027zn != yVar.f8169gv.f238gv || yVar2.f8024gv == null || yVar2.f8024gv.f239n3 != yVar.f8169gv.f239n3 || yVar2.f8024gv.f241zn != yVar.f8169gv.f241zn) {
                mg.n3 n3Var2 = yVar.f8169gv;
                this.f8020v.j(yVar, tl(yVar.f8174zn, new mg.n3(n3Var2.y, n3Var2.f238gv)).y, tl2.y);
            }
        }
    }

    @Override // fj.g3
    @Nullable
    public synchronized String y() {
        return this.f8017fb;
    }

    @Override // fj.g3
    public synchronized void zn(zn.y yVar) {
        try {
            v5.y.v(this.f8020v);
            hy hyVar = this.f8016a;
            this.f8016a = yVar.f8171n3;
            Iterator<y> it = this.f8021zn.values().iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (next.tl(hyVar, this.f8016a) && !next.i9(yVar)) {
                }
                it.remove();
                if (next.f8026v) {
                    if (next.y.equals(this.f8017fb)) {
                        this.f8017fb = null;
                    }
                    this.f8020v.e(yVar, next.y, false);
                }
            }
            wz(yVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public kp(w0.z<String> zVar) {
        this.f8018gv = zVar;
        this.y = new hy.gv();
        this.f8019n3 = new hy.n3();
        this.f8021zn = new HashMap<>();
        this.f8016a = hy.y;
    }
}
