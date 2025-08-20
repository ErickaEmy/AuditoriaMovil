package y3;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import e4.fh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m1.ne;
import v5.j5;
import v5.k5;
import y3.ud;
/* loaded from: classes.dex */
public final class ej implements e4.t {

    /* renamed from: z  reason: collision with root package name */
    public static final e4.mt f15036z = new e4.mt() { // from class: y3.z6
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] i42;
            i42 = ej.i4();
            return i42;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final ud.zn f15037a;

    /* renamed from: c5  reason: collision with root package name */
    public final SparseBooleanArray f15038c5;

    /* renamed from: co  reason: collision with root package name */
    public int f15039co;

    /* renamed from: f  reason: collision with root package name */
    public ta f15040f;

    /* renamed from: fb  reason: collision with root package name */
    public final SparseArray<ud> f15041fb;

    /* renamed from: gv  reason: collision with root package name */
    public final v5.rz f15042gv;

    /* renamed from: i9  reason: collision with root package name */
    public final d f15043i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f15044mt;

    /* renamed from: n3  reason: collision with root package name */
    public final int f15045n3;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public ud f15046p;

    /* renamed from: s  reason: collision with root package name */
    public final SparseBooleanArray f15047s;

    /* renamed from: t  reason: collision with root package name */
    public e4.wz f15048t;

    /* renamed from: tl  reason: collision with root package name */
    public int f15049tl;

    /* renamed from: v  reason: collision with root package name */
    public final SparseIntArray f15050v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f15051w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f15052wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f15053xc;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final List<k5> f15054zn;

    public ej() {
        this(0);
    }

    public static /* synthetic */ int f(ej ejVar) {
        int i = ejVar.f15049tl;
        ejVar.f15049tl = i + 1;
        return i;
    }

    private void f3(long j2) {
        if (!this.f15053xc) {
            this.f15053xc = true;
            if (this.f15043i9.n3() != -9223372036854775807L) {
                ta taVar = new ta(this.f15043i9.zn(), this.f15043i9.n3(), j2, this.f15039co, this.f15045n3);
                this.f15040f = taVar;
                this.f15048t.t(taVar.n3());
                return;
            }
            this.f15048t.t(new fh.n3(this.f15043i9.n3()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e4.t[] i4() {
        return new e4.t[]{new ej()};
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r1 = r1 + 1;
     */
    @Override // e4.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(e4.tl r7) throws java.io.IOException {
        /*
            r6 = this;
            v5.rz r0 = r6.f15042gv
            byte[] r0 = r0.v()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.z(r0, r2, r1)
            r1 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.p(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.ej.a(e4.tl):boolean");
    }

    public final boolean c(int i) {
        if (this.y != 2 && !this.f15052wz && this.f15038c5.get(i, false)) {
            return false;
        }
        return true;
    }

    public final void n() {
        this.f15047s.clear();
        this.f15041fb.clear();
        SparseArray<ud> y2 = this.f15037a.y();
        int size = y2.size();
        for (int i = 0; i < size; i++) {
            this.f15041fb.put(y2.keyAt(i), y2.valueAt(i));
        }
        this.f15041fb.put(0, new rz(new y()));
        this.f15046p = null;
    }

    public final boolean r(e4.tl tlVar) throws IOException {
        byte[] v2 = this.f15042gv.v();
        if (9400 - this.f15042gv.a() < 188) {
            int y2 = this.f15042gv.y();
            if (y2 > 0) {
                System.arraycopy(v2, this.f15042gv.a(), v2, 0, y2);
            }
            this.f15042gv.o(v2, y2);
        }
        while (this.f15042gv.y() < 188) {
            int fb2 = this.f15042gv.fb();
            int read = tlVar.read(v2, fb2, 9400 - fb2);
            if (read == -1) {
                return false;
            }
            this.f15042gv.j(fb2 + read);
        }
        return true;
    }

    @Override // e4.t
    public int v(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        int i;
        boolean z2;
        ud udVar;
        int i5;
        long length = tlVar.getLength();
        if (this.f15052wz) {
            if (length != -1 && this.y != 2 && !this.f15043i9.gv()) {
                return this.f15043i9.v(tlVar, d0Var, this.f15039co);
            }
            f3(length);
            if (this.f15051w) {
                this.f15051w = false;
                y(0L, 0L);
                if (tlVar.getPosition() != 0) {
                    d0Var.y = 0L;
                    return 1;
                }
            }
            ta taVar = this.f15040f;
            if (taVar != null && taVar.gv()) {
                return this.f15040f.zn(tlVar, d0Var);
            }
        }
        if (!r(tlVar)) {
            return -1;
        }
        int x42 = x4();
        int fb2 = this.f15042gv.fb();
        if (x42 > fb2) {
            return 0;
        }
        int p2 = this.f15042gv.p();
        if ((8388608 & p2) != 0) {
            this.f15042gv.oz(x42);
            return 0;
        }
        if ((4194304 & p2) != 0) {
            i = 1;
        } else {
            i = 0;
        }
        int i6 = (2096896 & p2) >> 8;
        if ((p2 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((p2 & 16) != 0) {
            udVar = this.f15041fb.get(i6);
        } else {
            udVar = null;
        }
        if (udVar == null) {
            this.f15042gv.oz(x42);
            return 0;
        }
        if (this.y != 2) {
            int i8 = p2 & 15;
            int i10 = this.f15050v.get(i6, i8 - 1);
            this.f15050v.put(i6, i8);
            if (i10 == i8) {
                this.f15042gv.oz(x42);
                return 0;
            } else if (i8 != ((i10 + 1) & 15)) {
                udVar.zn();
            }
        }
        if (z2) {
            int ej2 = this.f15042gv.ej();
            if ((this.f15042gv.ej() & 64) != 0) {
                i5 = 2;
            } else {
                i5 = 0;
            }
            i |= i5;
            this.f15042gv.ut(ej2 - 1);
        }
        boolean z3 = this.f15052wz;
        if (c(i6)) {
            this.f15042gv.j(x42);
            udVar.n3(this.f15042gv, i);
            this.f15042gv.j(fb2);
        }
        if (this.y != 2 && !z3 && this.f15052wz && length != -1) {
            this.f15051w = true;
        }
        this.f15042gv.oz(x42);
        return 0;
    }

    public final int x4() throws ne {
        int a2 = this.f15042gv.a();
        int fb2 = this.f15042gv.fb();
        int y2 = a8.y(this.f15042gv.v(), a2, fb2);
        this.f15042gv.oz(y2);
        int i = y2 + 188;
        if (i > fb2) {
            int i5 = this.f15044mt + (y2 - a2);
            this.f15044mt = i5;
            if (this.y == 2 && i5 > 376) {
                throw ne.y("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f15044mt = 0;
        }
        return i;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        boolean z2;
        ta taVar;
        boolean z3;
        if (this.y != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        int size = this.f15054zn.size();
        for (int i = 0; i < size; i++) {
            k5 k5Var = this.f15054zn.get(i);
            if (k5Var.v() == -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                long zn2 = k5Var.zn();
                if (zn2 != -9223372036854775807L && zn2 != 0 && zn2 != j4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                k5Var.fb(j4);
            }
        }
        if (j4 != 0 && (taVar = this.f15040f) != null) {
            taVar.s(j4);
        }
        this.f15042gv.j5(0);
        this.f15050v.clear();
        for (int i5 = 0; i5 < this.f15041fb.size(); i5++) {
            this.f15041fb.valueAt(i5).zn();
        }
        this.f15044mt = 0;
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f15048t = wzVar;
    }

    public ej(int i) {
        this(1, i, 112800);
    }

    public ej(int i, int i5, int i6) {
        this(i, new k5(0L), new i9(i5), i6);
    }

    public ej(int i, k5 k5Var, ud.zn znVar) {
        this(i, k5Var, znVar, 112800);
    }

    public ej(int i, k5 k5Var, ud.zn znVar, int i5) {
        this.f15037a = (ud.zn) v5.y.v(znVar);
        this.f15045n3 = i5;
        this.y = i;
        if (i != 1 && i != 2) {
            ArrayList arrayList = new ArrayList();
            this.f15054zn = arrayList;
            arrayList.add(k5Var);
        } else {
            this.f15054zn = Collections.singletonList(k5Var);
        }
        this.f15042gv = new v5.rz(new byte[9400], 0);
        this.f15047s = new SparseBooleanArray();
        this.f15038c5 = new SparseBooleanArray();
        this.f15041fb = new SparseArray<>();
        this.f15050v = new SparseIntArray();
        this.f15043i9 = new d(i5);
        this.f15048t = e4.wz.f7522zn;
        this.f15039co = -1;
        n();
    }

    @Override // e4.t
    public void release() {
    }

    /* loaded from: classes.dex */
    public class n3 implements fh {

        /* renamed from: gv  reason: collision with root package name */
        public final int f15055gv;
        public final v5.fh y = new v5.fh(new byte[5]);

        /* renamed from: n3  reason: collision with root package name */
        public final SparseArray<ud> f15056n3 = new SparseArray<>();

        /* renamed from: zn  reason: collision with root package name */
        public final SparseIntArray f15058zn = new SparseIntArray();

        public n3(int i) {
            this.f15055gv = i;
        }

        @Override // y3.fh
        public void n3(v5.rz rzVar) {
            k5 k5Var;
            int i;
            ud n32;
            if (rzVar.ej() != 2) {
                return;
            }
            if (ej.this.y != 1 && ej.this.y != 2 && ej.this.f15049tl != 1) {
                k5Var = new k5(((k5) ej.this.f15054zn.get(0)).zn());
                ej.this.f15054zn.add(k5Var);
            } else {
                k5Var = (k5) ej.this.f15054zn.get(0);
            }
            if ((rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return;
            }
            rzVar.ut(1);
            int yt2 = rzVar.yt();
            int i5 = 3;
            rzVar.ut(3);
            rzVar.f(this.y, 2);
            this.y.mt(3);
            int i6 = 13;
            ej.this.f15039co = this.y.s(13);
            rzVar.f(this.y, 2);
            int i8 = 4;
            this.y.mt(4);
            rzVar.ut(this.y.s(12));
            if (ej.this.y == 2 && ej.this.f15046p == null) {
                ud.n3 n3Var = new ud.n3(21, null, null, j5.f14357a);
                ej ejVar = ej.this;
                ejVar.f15046p = ejVar.f15037a.n3(21, n3Var);
                if (ej.this.f15046p != null) {
                    ej.this.f15046p.y(k5Var, ej.this.f15048t, new ud.gv(yt2, 21, 8192));
                }
            }
            this.f15056n3.clear();
            this.f15058zn.clear();
            int y = rzVar.y();
            while (y > 0) {
                rzVar.f(this.y, 5);
                int s2 = this.y.s(8);
                this.y.mt(i5);
                int s3 = this.y.s(i6);
                this.y.mt(i8);
                int s4 = this.y.s(12);
                ud.n3 zn2 = zn(rzVar, s4);
                if (s2 == 6 || s2 == 5) {
                    s2 = zn2.y;
                }
                y -= s4 + 5;
                if (ej.this.y == 2) {
                    i = s2;
                } else {
                    i = s3;
                }
                if (!ej.this.f15047s.get(i)) {
                    if (ej.this.y == 2 && s2 == 21) {
                        n32 = ej.this.f15046p;
                    } else {
                        n32 = ej.this.f15037a.n3(s2, zn2);
                    }
                    if (ej.this.y != 2 || s3 < this.f15058zn.get(i, 8192)) {
                        this.f15058zn.put(i, s3);
                        this.f15056n3.put(i, n32);
                    }
                }
                i5 = 3;
                i8 = 4;
                i6 = 13;
            }
            int size = this.f15058zn.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.f15058zn.keyAt(i10);
                int valueAt = this.f15058zn.valueAt(i10);
                ej.this.f15047s.put(keyAt, true);
                ej.this.f15038c5.put(valueAt, true);
                ud valueAt2 = this.f15056n3.valueAt(i10);
                if (valueAt2 != null) {
                    if (valueAt2 != ej.this.f15046p) {
                        valueAt2.y(k5Var, ej.this.f15048t, new ud.gv(yt2, keyAt, 8192));
                    }
                    ej.this.f15041fb.put(valueAt, valueAt2);
                }
            }
            if (ej.this.y == 2) {
                if (!ej.this.f15052wz) {
                    ej.this.f15048t.xc();
                    ej.this.f15049tl = 0;
                    ej.this.f15052wz = true;
                    return;
                }
                return;
            }
            ej.this.f15041fb.remove(this.f15055gv);
            ej ejVar2 = ej.this;
            ejVar2.f15049tl = ejVar2.y == 1 ? 0 : ej.this.f15049tl - 1;
            if (ej.this.f15049tl == 0) {
                ej.this.f15048t.xc();
                ej.this.f15052wz = true;
            }
        }

        public final ud.n3 zn(v5.rz rzVar, int i) {
            int a2 = rzVar.a();
            int i5 = i + a2;
            int i6 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (rzVar.a() < i5) {
                int ej2 = rzVar.ej();
                int a3 = rzVar.a() + rzVar.ej();
                if (a3 > i5) {
                    break;
                }
                if (ej2 == 5) {
                    long a82 = rzVar.a8();
                    if (a82 != 1094921523) {
                        if (a82 != 1161904947) {
                            if (a82 != 1094921524) {
                                if (a82 == 1212503619) {
                                    i6 = 36;
                                }
                            }
                            i6 = 172;
                        }
                        i6 = 135;
                    }
                    i6 = 129;
                } else {
                    if (ej2 != 106) {
                        if (ej2 != 122) {
                            if (ej2 == 127) {
                                if (rzVar.ej() != 21) {
                                }
                                i6 = 172;
                            } else if (ej2 == 123) {
                                i6 = 138;
                            } else if (ej2 == 10) {
                                str = rzVar.ta(3).trim();
                            } else if (ej2 == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (rzVar.a() < a3) {
                                    String trim = rzVar.ta(3).trim();
                                    int ej3 = rzVar.ej();
                                    byte[] bArr = new byte[4];
                                    rzVar.t(bArr, 0, 4);
                                    arrayList2.add(new ud.y(trim, ej3, bArr));
                                }
                                arrayList = arrayList2;
                                i6 = 89;
                            } else if (ej2 == 111) {
                                i6 = 257;
                            }
                        }
                        i6 = 135;
                    }
                    i6 = 129;
                }
                rzVar.ut(a3 - rzVar.a());
            }
            rzVar.oz(i5);
            return new ud.n3(i6, str, arrayList, Arrays.copyOfRange(rzVar.v(), a2, i5));
        }

        @Override // y3.fh
        public void y(k5 k5Var, e4.wz wzVar, ud.gv gvVar) {
        }
    }

    /* loaded from: classes.dex */
    public class y implements fh {
        public final v5.fh y = new v5.fh(new byte[4]);

        public y() {
        }

        @Override // y3.fh
        public void n3(v5.rz rzVar) {
            if (rzVar.ej() != 0 || (rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return;
            }
            rzVar.ut(6);
            int y = rzVar.y() / 4;
            for (int i = 0; i < y; i++) {
                rzVar.f(this.y, 4);
                int s2 = this.y.s(16);
                this.y.mt(3);
                if (s2 == 0) {
                    this.y.mt(13);
                } else {
                    int s3 = this.y.s(13);
                    if (ej.this.f15041fb.get(s3) == null) {
                        ej.this.f15041fb.put(s3, new rz(new n3(s3)));
                        ej.f(ej.this);
                    }
                }
            }
            if (ej.this.y != 2) {
                ej.this.f15041fb.remove(0);
            }
        }

        @Override // y3.fh
        public void y(k5 k5Var, e4.wz wzVar, ud.gv gvVar) {
        }
    }
}
