package ha;

import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import e4.d;
import e4.d0;
import e4.f3;
import e4.fh;
import e4.ta;
import ha.y;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m1.m;
import m1.ne;
import v5.c;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class f implements e4.t, fh {

    /* renamed from: n  reason: collision with root package name */
    public static final e4.mt f8764n = new e4.mt() { // from class: ha.i9
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] co2;
            co2 = f.co();
            return co2;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque<y.C0106y> f8765a;

    /* renamed from: c5  reason: collision with root package name */
    public int f8766c5;

    /* renamed from: co  reason: collision with root package name */
    public y[] f8767co;

    /* renamed from: f  reason: collision with root package name */
    public long f8768f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public MotionPhotoMetadata f8769f3;

    /* renamed from: fb  reason: collision with root package name */
    public final tl f8770fb;

    /* renamed from: gv  reason: collision with root package name */
    public final rz f8771gv;

    /* renamed from: i4  reason: collision with root package name */
    public int f8772i4;

    /* renamed from: i9  reason: collision with root package name */
    public int f8773i9;

    /* renamed from: mt  reason: collision with root package name */
    public e4.wz f8774mt;

    /* renamed from: n3  reason: collision with root package name */
    public final rz f8775n3;

    /* renamed from: p  reason: collision with root package name */
    public int f8776p;

    /* renamed from: r  reason: collision with root package name */
    public int f8777r;

    /* renamed from: s  reason: collision with root package name */
    public final List<Metadata.Entry> f8778s;

    /* renamed from: t  reason: collision with root package name */
    public int f8779t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public rz f8780tl;

    /* renamed from: v  reason: collision with root package name */
    public final rz f8781v;

    /* renamed from: w  reason: collision with root package name */
    public int f8782w;

    /* renamed from: wz  reason: collision with root package name */
    public int f8783wz;

    /* renamed from: x4  reason: collision with root package name */
    public long f8784x4;

    /* renamed from: xc  reason: collision with root package name */
    public int f8785xc;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public long[][] f8786z;

    /* renamed from: zn  reason: collision with root package name */
    public final rz f8787zn;

    /* loaded from: classes.dex */
    public static final class y {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final d f8788gv;

        /* renamed from: n3  reason: collision with root package name */
        public final mt f8789n3;

        /* renamed from: v  reason: collision with root package name */
        public int f8790v;
        public final xc y;

        /* renamed from: zn  reason: collision with root package name */
        public final ta f8791zn;

        public y(xc xcVar, mt mtVar, ta taVar) {
            d dVar;
            this.y = xcVar;
            this.f8789n3 = mtVar;
            this.f8791zn = taVar;
            if ("audio/true-hd".equals(xcVar.f8904a.f10948f3)) {
                dVar = new d();
            } else {
                dVar = null;
            }
            this.f8788gv = dVar;
        }
    }

    public f() {
        this(0);
    }

    public static /* synthetic */ e4.t[] co() {
        return new e4.t[]{new f()};
    }

    public static boolean d(int i) {
        if (i != 1835296868 && i != 1836476516 && i != 1751411826 && i != 1937011556 && i != 1937011827 && i != 1937011571 && i != 1668576371 && i != 1701606260 && i != 1937011555 && i != 1937011578 && i != 1937013298 && i != 1937007471 && i != 1668232756 && i != 1953196132 && i != 1718909296 && i != 1969517665 && i != 1801812339 && i != 1768715124) {
            return false;
        }
        return true;
    }

    public static int f3(rz rzVar) {
        rzVar.oz(8);
        int t2 = t(rzVar.p());
        if (t2 != 0) {
            return t2;
        }
        rzVar.ut(4);
        while (rzVar.y() > 0) {
            int t3 = t(rzVar.p());
            if (t3 != 0) {
                return t3;
            }
        }
        return 0;
    }

    public static int t(int i) {
        if (i != 1751476579) {
            if (i != 1903435808) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    public static boolean ta(int i) {
        if (i != 1836019574 && i != 1953653099 && i != 1835297121 && i != 1835626086 && i != 1937007212 && i != 1701082227 && i != 1835365473) {
            return false;
        }
        return true;
    }

    public static long[][] tl(y[] yVarArr) {
        long[][] jArr = new long[yVarArr.length];
        int[] iArr = new int[yVarArr.length];
        long[] jArr2 = new long[yVarArr.length];
        boolean[] zArr = new boolean[yVarArr.length];
        for (int i = 0; i < yVarArr.length; i++) {
            jArr[i] = new long[yVarArr[i].f8789n3.f8849n3];
            jArr2[i] = yVarArr[i].f8789n3.f8846a[0];
        }
        long j2 = 0;
        int i5 = 0;
        while (i5 < yVarArr.length) {
            long j4 = Long.MAX_VALUE;
            int i6 = -1;
            for (int i8 = 0; i8 < yVarArr.length; i8++) {
                if (!zArr[i8]) {
                    long j6 = jArr2[i8];
                    if (j6 <= j4) {
                        i6 = i8;
                        j4 = j6;
                    }
                }
            }
            int i10 = iArr[i6];
            long[] jArr3 = jArr[i6];
            jArr3[i10] = j2;
            mt mtVar = yVarArr[i6].f8789n3;
            j2 += mtVar.f8848gv[i10];
            int i11 = i10 + 1;
            iArr[i6] = i11;
            if (i11 < jArr3.length) {
                jArr2[i6] = mtVar.f8846a[i11];
            } else {
                zArr[i6] = true;
                i5++;
            }
        }
        return jArr;
    }

    public static int w(mt mtVar, long j2) {
        int y2 = mtVar.y(j2);
        if (y2 == -1) {
            return mtVar.n3(j2);
        }
        return y2;
    }

    public static long z(mt mtVar, long j2, long j4) {
        int w4 = w(mtVar, j2);
        if (w4 == -1) {
            return j4;
        }
        return Math.min(mtVar.f8852zn[w4], j4);
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        boolean z2;
        if ((this.y & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return wz.gv(tlVar, z2);
    }

    public final void c(long j2) {
        if (this.f8773i9 == 1836086884) {
            int i = this.f8779t;
            this.f8769f3 = new MotionPhotoMetadata(0L, j2, -9223372036854775807L, j2 + i, this.f8768f - i);
        }
    }

    @Override // e4.fh
    public long c5() {
        return this.f8784x4;
    }

    public final boolean d0(e4.tl tlVar) throws IOException {
        y.C0106y peek;
        boolean z2;
        boolean z3;
        if (this.f8779t == 0) {
            if (!tlVar.f(this.f8781v.v(), 0, 8, true)) {
                i4();
                return false;
            }
            this.f8779t = 8;
            this.f8781v.oz(0);
            this.f8768f = this.f8781v.a8();
            this.f8773i9 = this.f8781v.p();
        }
        long j2 = this.f8768f;
        if (j2 == 1) {
            tlVar.readFully(this.f8781v.v(), 8, 8);
            this.f8779t += 8;
            this.f8768f = this.f8781v.k5();
        } else if (j2 == 0) {
            long length = tlVar.getLength();
            if (length == -1 && (peek = this.f8765a.peek()) != null) {
                length = peek.f8916n3;
            }
            if (length != -1) {
                this.f8768f = (length - tlVar.getPosition()) + this.f8779t;
            }
        }
        if (this.f8768f >= this.f8779t) {
            if (ta(this.f8773i9)) {
                long position = tlVar.getPosition();
                long j4 = this.f8768f;
                int i = this.f8779t;
                long j6 = (position + j4) - i;
                if (j4 != i && this.f8773i9 == 1835365473) {
                    r(tlVar);
                }
                this.f8765a.push(new y.C0106y(this.f8773i9, j6));
                if (this.f8768f == this.f8779t) {
                    x4(j6);
                } else {
                    wz();
                }
            } else if (d(this.f8773i9)) {
                if (this.f8779t == 8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.fb(z2);
                if (this.f8768f <= 2147483647L) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v5.y.fb(z3);
                rz rzVar = new rz((int) this.f8768f);
                System.arraycopy(this.f8781v.v(), 0, rzVar.v(), 0, 8);
                this.f8780tl = rzVar;
                this.f8766c5 = 1;
            } else {
                c(tlVar.getPosition() - this.f8779t);
                this.f8780tl = null;
                this.f8766c5 = 1;
            }
            return true;
        }
        throw ne.s("Atom size less than header length (unsupported).");
    }

    public final boolean fh(e4.tl tlVar, d0 d0Var) throws IOException {
        boolean z2;
        long j2 = this.f8768f - this.f8779t;
        long position = tlVar.getPosition() + j2;
        rz rzVar = this.f8780tl;
        if (rzVar != null) {
            tlVar.readFully(rzVar.v(), this.f8779t, (int) j2);
            if (this.f8773i9 == 1718909296) {
                this.f8772i4 = f3(rzVar);
            } else if (!this.f8765a.isEmpty()) {
                this.f8765a.peek().v(new y.n3(this.f8773i9, rzVar));
            }
        } else if (j2 < 262144) {
            tlVar.p((int) j2);
        } else {
            d0Var.y = tlVar.getPosition() + j2;
            z2 = true;
            x4(position);
            if (!z2 && this.f8766c5 != 2) {
                return true;
            }
            return false;
        }
        z2 = false;
        x4(position);
        if (!z2) {
        }
        return false;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        return xc(j2, -1);
    }

    public final void i4() {
        Metadata metadata;
        if (this.f8772i4 == 2 && (this.y & 2) != 0) {
            ta a2 = this.f8774mt.a(0, 4);
            if (this.f8769f3 == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.f8769f3);
            }
            a2.v(new m.n3().en(metadata).z6());
            this.f8774mt.xc();
            this.f8774mt.t(new fh.n3(-9223372036854775807L));
        }
    }

    public final int mg(e4.tl tlVar, d0 d0Var) throws IOException {
        int zn2 = this.f8770fb.zn(tlVar, d0Var, this.f8778s);
        if (zn2 == 1 && d0Var.y == 0) {
            wz();
        }
        return zn2;
    }

    public final void n(y.C0106y c0106y) throws ne {
        boolean z2;
        Metadata metadata;
        Metadata metadata2;
        Metadata metadata3;
        boolean z3;
        List<mt> list;
        int i;
        int i5;
        Metadata metadata4;
        Metadata metadata5;
        ArrayList arrayList;
        int i6;
        int i8;
        ArrayList arrayList2 = new ArrayList();
        if (this.f8772i4 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        f3 f3Var = new f3();
        y.n3 fb2 = c0106y.fb(1969517665);
        if (fb2 != null) {
            Pair<Metadata, Metadata> fh2 = n3.fh(fb2);
            Metadata metadata6 = (Metadata) fh2.first;
            Metadata metadata7 = (Metadata) fh2.second;
            if (metadata6 != null) {
                f3Var.zn(metadata6);
            }
            metadata2 = metadata7;
            metadata = metadata6;
        } else {
            metadata = null;
            metadata2 = null;
        }
        y.C0106y a2 = c0106y.a(1835365473);
        if (a2 != null) {
            metadata3 = n3.wz(a2);
        } else {
            metadata3 = null;
        }
        if ((this.y & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Metadata metadata8 = metadata3;
        Metadata metadata9 = metadata;
        List<mt> d02 = n3.d0(c0106y, f3Var, -9223372036854775807L, null, z3, z2, new w0.fb() { // from class: ha.c5
            @Override // w0.fb
            public final Object apply(Object obj) {
                xc mt2;
                mt2 = f.mt((xc) obj);
                return mt2;
            }
        });
        int size = d02.size();
        long j2 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        int i10 = 0;
        int i11 = -1;
        while (i10 < size) {
            mt mtVar = d02.get(i10);
            if (mtVar.f8849n3 == 0) {
                list = d02;
                i5 = size;
                arrayList = arrayList2;
                metadata5 = metadata9;
                i6 = 1;
            } else {
                xc xcVar = mtVar.y;
                ArrayList arrayList3 = arrayList2;
                long j6 = xcVar.f8912v;
                if (j6 == j2) {
                    j6 = mtVar.f8850s;
                }
                j4 = Math.max(j4, j6);
                list = d02;
                y yVar = new y(xcVar, mtVar, this.f8774mt.a(i10, xcVar.f8910n3));
                if ("audio/true-hd".equals(xcVar.f8904a.f10948f3)) {
                    i = mtVar.f8851v * 16;
                } else {
                    i = mtVar.f8851v + 30;
                }
                m.n3 n32 = xcVar.f8904a.n3();
                n32.f7(i);
                i5 = size;
                if (xcVar.f8910n3 == 2 && j6 > 0 && (i8 = mtVar.f8849n3) > 1) {
                    n32.qn(i8 / (((float) j6) / 1000000.0f));
                }
                s.f(xcVar.f8910n3, f3Var, n32);
                int i12 = xcVar.f8910n3;
                if (this.f8778s.isEmpty()) {
                    metadata4 = null;
                } else {
                    metadata4 = new Metadata(this.f8778s);
                }
                Metadata[] metadataArr = {metadata2, metadata4};
                metadata5 = metadata9;
                s.t(i12, metadata5, metadata8, n32, metadataArr);
                yVar.f8791zn.v(n32.z6());
                if (xcVar.f8910n3 == 2 && i11 == -1) {
                    i11 = arrayList3.size();
                }
                arrayList = arrayList3;
                arrayList.add(yVar);
                i6 = 1;
            }
            i10 += i6;
            metadata9 = metadata5;
            arrayList2 = arrayList;
            d02 = list;
            size = i5;
            j2 = -9223372036854775807L;
        }
        this.f8777r = i11;
        this.f8784x4 = j4;
        y[] yVarArr = (y[]) arrayList2.toArray(new y[0]);
        this.f8767co = yVarArr;
        this.f8786z = tl(yVarArr);
        this.f8774mt.xc();
        this.f8774mt.t(this);
    }

    public final int p(long j2) {
        boolean z2;
        int i = -1;
        int i5 = -1;
        int i6 = 0;
        long j4 = Long.MAX_VALUE;
        boolean z3 = true;
        long j6 = Long.MAX_VALUE;
        boolean z4 = true;
        long j7 = Long.MAX_VALUE;
        while (true) {
            y[] yVarArr = this.f8767co;
            if (i6 >= yVarArr.length) {
                break;
            }
            y yVar = yVarArr[i6];
            int i8 = yVar.f8790v;
            mt mtVar = yVar.f8789n3;
            if (i8 != mtVar.f8849n3) {
                long j8 = mtVar.f8852zn[i8];
                long j9 = ((long[][]) j5.i9(this.f8786z))[i6][i8];
                long j10 = j8 - j2;
                if (j10 >= 0 && j10 < 262144) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((!z2 && z4) || (z2 == z4 && j10 < j7)) {
                    z4 = z2;
                    j7 = j10;
                    i5 = i6;
                    j6 = j9;
                }
                if (j9 < j4) {
                    z3 = z2;
                    i = i6;
                    j4 = j9;
                }
            }
            i6++;
        }
        if (j4 == Long.MAX_VALUE || !z3 || j6 < j4 + 10485760) {
            return i5;
        }
        return i;
    }

    public final void r(e4.tl tlVar) throws IOException {
        this.f8771gv.j5(8);
        tlVar.z(this.f8771gv.v(), 0, 8);
        n3.v(this.f8771gv);
        tlVar.p(this.f8771gv.a());
        tlVar.s();
    }

    public final int rz(e4.tl tlVar, d0 d0Var) throws IOException {
        int i;
        d0 d0Var2;
        long position = tlVar.getPosition();
        if (this.f8783wz == -1) {
            int p2 = p(position);
            this.f8783wz = p2;
            if (p2 == -1) {
                return -1;
            }
        }
        y yVar = this.f8767co[this.f8783wz];
        ta taVar = yVar.f8791zn;
        int i5 = yVar.f8790v;
        mt mtVar = yVar.f8789n3;
        long j2 = mtVar.f8852zn[i5];
        int i6 = mtVar.f8848gv[i5];
        d dVar = yVar.f8788gv;
        long j4 = (j2 - position) + this.f8785xc;
        if (j4 >= 0) {
            if (j4 >= 262144) {
                d0Var2 = d0Var;
                i = 1;
            } else {
                if (yVar.y.f8907fb == 1) {
                    j4 += 8;
                    i6 -= 8;
                }
                tlVar.p((int) j4);
                xc xcVar = yVar.y;
                if (xcVar.f8909i9 != 0) {
                    byte[] v2 = this.f8787zn.v();
                    v2[0] = 0;
                    v2[1] = 0;
                    v2[2] = 0;
                    int i8 = yVar.y.f8909i9;
                    int i10 = 4 - i8;
                    while (this.f8782w < i6) {
                        int i11 = this.f8776p;
                        if (i11 == 0) {
                            tlVar.readFully(v2, i10, i8);
                            this.f8785xc += i8;
                            this.f8787zn.oz(0);
                            int p3 = this.f8787zn.p();
                            if (p3 >= 0) {
                                this.f8776p = p3;
                                this.f8775n3.oz(0);
                                taVar.zn(this.f8775n3, 4);
                                this.f8782w += 4;
                                i6 += i10;
                            } else {
                                throw ne.y("Invalid NAL length", null);
                            }
                        } else {
                            int n32 = taVar.n3(tlVar, i11, false);
                            this.f8785xc += n32;
                            this.f8782w += n32;
                            this.f8776p -= n32;
                        }
                    }
                } else {
                    if ("audio/ac4".equals(xcVar.f8904a.f10948f3)) {
                        if (this.f8782w == 0) {
                            d9.zn.y(i6, this.f8771gv);
                            taVar.zn(this.f8771gv, 7);
                            this.f8782w += 7;
                        }
                        i6 += 7;
                    } else if (dVar != null) {
                        dVar.gv(tlVar);
                    }
                    while (true) {
                        int i12 = this.f8782w;
                        if (i12 >= i6) {
                            break;
                        }
                        int n33 = taVar.n3(tlVar, i6 - i12, false);
                        this.f8785xc += n33;
                        this.f8782w += n33;
                        this.f8776p -= n33;
                    }
                }
                int i13 = i6;
                mt mtVar2 = yVar.f8789n3;
                long j6 = mtVar2.f8846a[i5];
                int i14 = mtVar2.f8847fb[i5];
                if (dVar != null) {
                    dVar.zn(taVar, j6, i14, i13, 0, null);
                    if (i5 + 1 == yVar.f8789n3.f8849n3) {
                        dVar.y(taVar, null);
                    }
                } else {
                    taVar.gv(j6, i14, i13, 0, null);
                }
                yVar.f8790v++;
                this.f8783wz = -1;
                this.f8785xc = 0;
                this.f8782w = 0;
                this.f8776p = 0;
                return 0;
            }
        } else {
            i = 1;
            d0Var2 = d0Var;
        }
        d0Var2.y = j2;
        return i;
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }

    @Override // e4.t
    public int v(e4.tl tlVar, d0 d0Var) throws IOException {
        while (true) {
            int i = this.f8766c5;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return mg(tlVar, d0Var);
                        }
                        throw new IllegalStateException();
                    }
                    return rz(tlVar, d0Var);
                } else if (fh(tlVar, d0Var)) {
                    return 1;
                }
            } else if (!d0(tlVar)) {
                return -1;
            }
        }
    }

    public final void wz() {
        this.f8766c5 = 0;
        this.f8779t = 0;
    }

    public final void x4(long j2) throws ne {
        while (!this.f8765a.isEmpty() && this.f8765a.peek().f8916n3 == j2) {
            y.C0106y pop = this.f8765a.pop();
            if (pop.y == 1836019574) {
                n(pop);
                this.f8765a.clear();
                this.f8766c5 = 2;
            } else if (!this.f8765a.isEmpty()) {
                this.f8765a.peek().gv(pop);
            }
        }
        if (this.f8766c5 != 2) {
            wz();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e4.fh.y xc(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            ha.f$y[] r4 = r0.f8767co
            int r5 = r4.length
            if (r5 != 0) goto L13
            e4.fh$y r1 = new e4.fh$y
            e4.rz r2 = e4.rz.f7511zn
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.f8777r
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            ha.mt r4 = r4.f8789n3
            int r6 = w(r4, r1)
            if (r6 != r5) goto L35
            e4.fh$y r1 = new e4.fh$y
            e4.rz r2 = e4.rz.f7511zn
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f8846a
            r12 = r11[r6]
            long[] r11 = r4.f8852zn
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.f8849n3
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.n3(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f8846a
            r9 = r2[r1]
            long[] r2 = r4.f8852zn
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L80
            r3 = 0
        L63:
            ha.f$y[] r4 = r0.f8767co
            int r5 = r4.length
            if (r3 >= r5) goto L80
            int r5 = r0.f8777r
            if (r3 == r5) goto L7d
            r4 = r4[r3]
            ha.mt r4 = r4.f8789n3
            long r5 = z(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r1 = z(r4, r9, r1)
        L7c:
            r14 = r5
        L7d:
            int r3 = r3 + 1
            goto L63
        L80:
            e4.rz r3 = new e4.rz
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8f
            e4.fh$y r1 = new e4.fh$y
            r1.<init>(r3)
            return r1
        L8f:
            e4.rz r4 = new e4.rz
            r4.<init>(r9, r1)
            e4.fh$y r1 = new e4.fh$y
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.f.xc(long, int):e4.fh$y");
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        y[] yVarArr;
        this.f8765a.clear();
        this.f8779t = 0;
        this.f8783wz = -1;
        this.f8785xc = 0;
        this.f8782w = 0;
        this.f8776p = 0;
        if (j2 == 0) {
            if (this.f8766c5 != 3) {
                wz();
                return;
            }
            this.f8770fb.fb();
            this.f8778s.clear();
            return;
        }
        for (y yVar : this.f8767co) {
            z6(yVar, j4);
            d dVar = yVar.f8788gv;
            if (dVar != null) {
                dVar.n3();
            }
        }
    }

    public final void z6(y yVar, long j2) {
        mt mtVar = yVar.f8789n3;
        int y2 = mtVar.y(j2);
        if (y2 == -1) {
            y2 = mtVar.n3(j2);
        }
        yVar.f8790v = y2;
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f8774mt = wzVar;
    }

    public f(int i) {
        this.y = i;
        this.f8766c5 = (i & 4) != 0 ? 3 : 0;
        this.f8770fb = new tl();
        this.f8778s = new ArrayList();
        this.f8781v = new rz(16);
        this.f8765a = new ArrayDeque<>();
        this.f8775n3 = new rz(c.y);
        this.f8787zn = new rz(4);
        this.f8771gv = new rz();
        this.f8783wz = -1;
        this.f8774mt = e4.wz.f7522zn;
        this.f8767co = new y[0];
    }

    @Override // e4.t
    public void release() {
    }

    public static /* synthetic */ xc mt(xc xcVar) {
        return xcVar;
    }
}
