package h4;

import af.b;
import af.c;
import af.en;
import af.f7;
import af.i4;
import af.jz;
import af.lc;
import af.rs;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import e4.fh;
import e4.ta;
import h4.a;
import h4.p;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kx.d0;
import kx.mg;
import kx.ta;
import m1.g;
import m1.m;
import m1.ne;
import m1.vc;
import v5.j5;
import v5.n;
import v5.r;
import v5.rz;
import z0.d0;
import z0.x4;
/* loaded from: classes.dex */
public final class p implements ta.n3<p7.a>, ta.a, jz, e4.wz, f7.gv {

    /* renamed from: m  reason: collision with root package name */
    public static final Set<Integer> f8619m = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));

    /* renamed from: ap  reason: collision with root package name */
    public boolean f8620ap;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DrmInitData> f8621b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<i9> f8622c;

    /* renamed from: co  reason: collision with root package name */
    public final mg f8623co;

    /* renamed from: ct  reason: collision with root package name */
    public Set<rs> f8624ct;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f8625d;

    /* renamed from: d0  reason: collision with root package name */
    public final List<i9> f8626d0;

    /* renamed from: dm  reason: collision with root package name */
    public lc f8627dm;

    /* renamed from: e  reason: collision with root package name */
    public long f8628e;

    /* renamed from: eb  reason: collision with root package name */
    public boolean f8629eb;

    /* renamed from: ej  reason: collision with root package name */
    public final Handler f8630ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f8631en;

    /* renamed from: f  reason: collision with root package name */
    public final kx.n3 f8632f;

    /* renamed from: f3  reason: collision with root package name */
    public final int f8633f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f8634f7;

    /* renamed from: fb  reason: collision with root package name */
    public final n3 f8635fb;

    /* renamed from: fh  reason: collision with root package name */
    public final Runnable f8636fh;
    @Nullable

    /* renamed from: g3  reason: collision with root package name */
    public i9 f8637g3;

    /* renamed from: j  reason: collision with root package name */
    public Set<Integer> f8638j;
    @Nullable

    /* renamed from: j5  reason: collision with root package name */
    public p7.a f8639j5;

    /* renamed from: jz  reason: collision with root package name */
    public int f8640jz;

    /* renamed from: k  reason: collision with root package name */
    public int f8641k;

    /* renamed from: kp  reason: collision with root package name */
    public long f8642kp;

    /* renamed from: lc  reason: collision with root package name */
    public boolean[] f8643lc;

    /* renamed from: nf  reason: collision with root package name */
    public boolean[] f8645nf;

    /* renamed from: o4  reason: collision with root package name */
    public int[] f8647o4;

    /* renamed from: oz  reason: collision with root package name */
    public SparseIntArray f8648oz;

    /* renamed from: p  reason: collision with root package name */
    public final v.y f8649p;

    /* renamed from: q9  reason: collision with root package name */
    public int f8650q9;

    /* renamed from: qn  reason: collision with root package name */
    public gv[] f8651qn;

    /* renamed from: r  reason: collision with root package name */
    public final b.y f8652r;

    /* renamed from: ra  reason: collision with root package name */
    public long f8653ra;
    @Nullable

    /* renamed from: rb  reason: collision with root package name */
    public DrmInitData f8654rb;

    /* renamed from: rs  reason: collision with root package name */
    public int f8655rs;

    /* renamed from: s  reason: collision with root package name */
    public final a f8656s;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f8657s8;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final m f8658t;

    /* renamed from: u  reason: collision with root package name */
    public m f8659u;

    /* renamed from: ut  reason: collision with root package name */
    public e4.ta f8660ut;

    /* renamed from: v  reason: collision with root package name */
    public final int f8661v;

    /* renamed from: w  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f8662w;

    /* renamed from: x  reason: collision with root package name */
    public final ArrayList<tl> f8663x;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f8664xg;
    public final String y;
    @Nullable

    /* renamed from: y5  reason: collision with root package name */
    public m f8665y5;

    /* renamed from: yc  reason: collision with root package name */
    public boolean f8666yc;

    /* renamed from: yg  reason: collision with root package name */
    public boolean f8667yg;

    /* renamed from: z  reason: collision with root package name */
    public final ta f8668z = new ta("Loader:HlsSampleStreamWrapper");

    /* renamed from: n  reason: collision with root package name */
    public final a.n3 f8644n = new a.n3();

    /* renamed from: o  reason: collision with root package name */
    public int[] f8646o = new int[0];

    /* loaded from: classes.dex */
    public static final class gv extends f7 {

        /* renamed from: ej  reason: collision with root package name */
        public final Map<String, DrmInitData> f8669ej;
        @Nullable

        /* renamed from: ud  reason: collision with root package name */
        public DrmInitData f8670ud;

        public void eb(@Nullable DrmInitData drmInitData) {
            this.f8670ud = drmInitData;
            ud();
        }

        @Override // af.f7, e4.ta
        public void gv(long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
            super.gv(j2, i, i5, i6, yVar);
        }

        @Override // af.f7
        public m i4(m mVar) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.f8670ud;
            if (drmInitData2 == null) {
                drmInitData2 = mVar.f10944d0;
            }
            if (drmInitData2 != null && (drmInitData = this.f8669ej.get(drmInitData2.f4114fb)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata rs2 = rs(mVar.f10972z);
            if (drmInitData2 != mVar.f10944d0 || rs2 != mVar.f10972z) {
                mVar = mVar.n3().vl(drmInitData2).en(rs2).z6();
            }
            return super.i4(mVar);
        }

        public void lc(i9 i9Var) {
            ct(i9Var.f8595f);
        }

        @Nullable
        public final Metadata rs(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int v2 = metadata.v();
            int i = 0;
            while (true) {
                if (i < v2) {
                    Metadata.Entry gv2 = metadata.gv(i);
                    if ((gv2 instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) gv2).f4274v)) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                return metadata;
            }
            if (v2 == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[v2 - 1];
            for (int i5 = 0; i5 < v2; i5++) {
                if (i5 != i) {
                    entryArr[i5 < i ? i5 : i5 - 1] = metadata.gv(i5);
                }
            }
            return new Metadata(entryArr);
        }

        public gv(kx.n3 n3Var, com.google.android.exoplayer2.drm.a aVar, v.y yVar, Map<String, DrmInitData> map) {
            super(n3Var, aVar, yVar);
            this.f8669ej = map;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 extends jz.y<p> {
        void onPrepared();

        void tl(Uri uri);
    }

    /* loaded from: classes.dex */
    public static class zn implements e4.ta {

        /* renamed from: fb  reason: collision with root package name */
        public static final m f8671fb = new m.n3().o4("application/id3").z6();

        /* renamed from: s  reason: collision with root package name */
        public static final m f8672s = new m.n3().o4("application/x-emsg").z6();

        /* renamed from: a  reason: collision with root package name */
        public int f8673a;

        /* renamed from: gv  reason: collision with root package name */
        public m f8674gv;

        /* renamed from: n3  reason: collision with root package name */
        public final e4.ta f8675n3;

        /* renamed from: v  reason: collision with root package name */
        public byte[] f8676v;
        public final f5.y y = new f5.y();

        /* renamed from: zn  reason: collision with root package name */
        public final m f8677zn;

        public zn(e4.ta taVar, int i) {
            this.f8675n3 = taVar;
            if (i != 1) {
                if (i == 3) {
                    this.f8677zn = f8672s;
                } else {
                    throw new IllegalArgumentException("Unknown metadataType: " + i);
                }
            } else {
                this.f8677zn = f8671fb;
            }
            this.f8676v = new byte[0];
            this.f8673a = 0;
        }

        @Override // e4.ta
        public void a(rz rzVar, int i, int i5) {
            s(this.f8673a + i);
            rzVar.t(this.f8676v, this.f8673a, i);
            this.f8673a += i;
        }

        public final rz c5(int i, int i5) {
            int i6 = this.f8673a - i5;
            rz rzVar = new rz(Arrays.copyOfRange(this.f8676v, i6 - i, i6));
            byte[] bArr = this.f8676v;
            System.arraycopy(bArr, i6, bArr, 0, i5);
            this.f8673a = i5;
            return rzVar;
        }

        public final boolean fb(EventMessage eventMessage) {
            m co2 = eventMessage.co();
            if (co2 != null && j5.zn(this.f8677zn.f10948f3, co2.f10948f3)) {
                return true;
            }
            return false;
        }

        @Override // e4.ta
        public void gv(long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
            v5.y.v(this.f8674gv);
            rz c52 = c5(i5, i6);
            if (!j5.zn(this.f8674gv.f10948f3, this.f8677zn.f10948f3)) {
                if ("application/x-emsg".equals(this.f8674gv.f10948f3)) {
                    EventMessage zn2 = this.y.zn(c52);
                    if (!fb(zn2)) {
                        r.c5("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f8677zn.f10948f3, zn2.co()));
                        return;
                    }
                    c52 = new rz((byte[]) v5.y.v(zn2.w2()));
                } else {
                    r.c5("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f8674gv.f10948f3);
                    return;
                }
            }
            int y = c52.y();
            this.f8675n3.zn(c52, y);
            this.f8675n3.gv(j2, i, y, i6, yVar);
        }

        @Override // e4.ta
        public /* synthetic */ int n3(kx.c5 c5Var, int i, boolean z2) {
            return e4.mg.y(this, c5Var, i, z2);
        }

        public final void s(int i) {
            byte[] bArr = this.f8676v;
            if (bArr.length < i) {
                this.f8676v = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        @Override // e4.ta
        public void v(m mVar) {
            this.f8674gv = mVar;
            this.f8675n3.v(this.f8677zn);
        }

        @Override // e4.ta
        public int y(kx.c5 c5Var, int i, boolean z2, int i5) throws IOException {
            s(this.f8673a + i);
            int read = c5Var.read(this.f8676v, this.f8673a, i);
            if (read == -1) {
                if (z2) {
                    return -1;
                }
                throw new EOFException();
            }
            this.f8673a += read;
            return read;
        }

        @Override // e4.ta
        public /* synthetic */ void zn(rz rzVar, int i) {
            e4.mg.n3(this, rzVar, i);
        }
    }

    public p(String str, int i, n3 n3Var, a aVar, Map<String, DrmInitData> map, kx.n3 n3Var2, long j2, @Nullable m mVar, com.google.android.exoplayer2.drm.a aVar2, v.y yVar, mg mgVar, b.y yVar2, int i5) {
        this.y = str;
        this.f8661v = i;
        this.f8635fb = n3Var;
        this.f8656s = aVar;
        this.f8621b = map;
        this.f8632f = n3Var2;
        this.f8658t = mVar;
        this.f8662w = aVar2;
        this.f8649p = yVar;
        this.f8623co = mgVar;
        this.f8652r = yVar2;
        this.f8633f3 = i5;
        Set<Integer> set = f8619m;
        this.f8638j = new HashSet(set.size());
        this.f8648oz = new SparseIntArray(set.size());
        this.f8651qn = new gv[0];
        this.f8645nf = new boolean[0];
        this.f8643lc = new boolean[0];
        ArrayList<i9> arrayList = new ArrayList<>();
        this.f8622c = arrayList;
        this.f8626d0 = Collections.unmodifiableList(arrayList);
        this.f8663x = new ArrayList<>();
        this.f8636fh = new Runnable() { // from class: h4.xc
            @Override // java.lang.Runnable
            public final void run() {
                p.this.o();
            }
        };
        this.f8625d = new Runnable() { // from class: h4.w
            @Override // java.lang.Runnable
            public final void run() {
                p.this.y5();
            }
        };
        this.f8630ej = j5.i4();
        this.f8653ra = j2;
        this.f8628e = j2;
    }

    public static int b(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 1;
        }
        return 0;
    }

    public static e4.f c(int i, int i5) {
        r.c5("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i5);
        return new e4.f();
    }

    public static boolean ej(m mVar, m mVar2) {
        String str = mVar.f10948f3;
        String str2 = mVar2.f10948f3;
        int f4 = n.f(str);
        if (f4 != 3) {
            if (f4 != n.f(str2)) {
                return false;
            }
            return true;
        } else if (!j5.zn(str, str2)) {
            return false;
        } else {
            if (("application/cea-608".equals(str) || "application/cea-708".equals(str)) && mVar.f10946en != mVar2.f10946en) {
                return false;
            }
            return true;
        }
    }

    private void mg(int i) {
        v5.y.fb(!this.f8668z.i9());
        while (true) {
            if (i < this.f8622c.size()) {
                if (f3(i)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return;
        }
        long j2 = a8().f12446s;
        i9 d2 = d(i);
        if (this.f8622c.isEmpty()) {
            this.f8628e = this.f8653ra;
        } else {
            ((i9) d0.v(this.f8622c)).wz();
        }
        this.f8667yg = false;
        this.f8652r.mg(this.f8650q9, d2.f12443fb, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.f8664xg && this.f8647o4 == null && this.f8634f7) {
            for (gv gvVar : this.f8651qn) {
                if (gvVar.d() == null) {
                    return;
                }
            }
            if (this.f8627dm != null) {
                qn();
                return;
            }
            i4();
            ra();
            this.f8635fb.onPrepared();
        }
    }

    private void o4() {
        for (gv gvVar : this.f8651qn) {
            gvVar.q9(this.f8657s8);
        }
        this.f8657s8 = false;
    }

    public static m rz(@Nullable m mVar, m mVar2, boolean z2) {
        String gv2;
        String str;
        int i;
        int i5;
        if (mVar == null) {
            return mVar2;
        }
        int f4 = n.f(mVar2.f10948f3);
        if (j5.x(mVar.f10942co, f4) == 1) {
            gv2 = j5.b(mVar.f10942co, f4);
            str = n.fb(gv2);
        } else {
            gv2 = n.gv(mVar.f10942co, mVar2.f10948f3);
            str = mVar2.f10948f3;
        }
        m.n3 dm2 = mVar2.n3().oz(mVar.y).q9(mVar.f10967v).k(mVar.f10950fb).eb(mVar.f10963s).dm(mVar.f10947f);
        if (z2) {
            i = mVar.f10964t;
        } else {
            i = -1;
        }
        m.n3 ud2 = dm2.ud(i);
        if (z2) {
            i5 = mVar.f10968w;
        } else {
            i5 = -1;
        }
        m.n3 x2 = ud2.u(i5).x(gv2);
        if (f4 == 2) {
            x2.s8(mVar.f10943d).o(mVar.f10945ej).qn(mVar.f10969x);
        }
        if (str != null) {
            x2.o4(str);
        }
        int i6 = mVar.f10958oz;
        if (i6 != -1 && f4 == 1) {
            x2.a8(i6);
        }
        Metadata metadata = mVar.f10972z;
        if (metadata != null) {
            Metadata metadata2 = mVar2.f10972z;
            if (metadata2 != null) {
                metadata = metadata2.n3(metadata);
            }
            x2.en(metadata);
        }
        return x2.z6();
    }

    private boolean vl() {
        if (this.f8628e != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    private static boolean yt(p7.a aVar) {
        return aVar instanceof i9;
    }

    @Override // e4.wz
    public e4.ta a(int i, int i5) {
        e4.ta taVar;
        if (f8619m.contains(Integer.valueOf(i5))) {
            taVar = x(i, i5);
        } else {
            int i6 = 0;
            while (true) {
                e4.ta[] taVarArr = this.f8651qn;
                if (i6 < taVarArr.length) {
                    if (this.f8646o[i6] == i) {
                        taVar = taVarArr[i6];
                        break;
                    }
                    i6++;
                } else {
                    taVar = null;
                    break;
                }
            }
        }
        if (taVar == null) {
            if (this.f8666yc) {
                return c(i, i5);
            }
            taVar = d0(i, i5);
        }
        if (i5 == 5) {
            if (this.f8660ut == null) {
                this.f8660ut = new zn(taVar, this.f8633f3);
            }
            return this.f8660ut;
        }
        return taVar;
    }

    public final i9 a8() {
        ArrayList<i9> arrayList = this.f8622c;
        return arrayList.get(arrayList.size() - 1);
    }

    public int ap(int i, long j2) {
        if (vl()) {
            return 0;
        }
        gv gvVar = this.f8651qn[i];
        int ta2 = gvVar.ta(j2, this.f8667yg);
        i9 i9Var = (i9) d0.a(this.f8622c, null);
        if (i9Var != null && !i9Var.w()) {
            ta2 = Math.min(ta2, i9Var.t(i) - gvVar.rz());
        }
        gvVar.dm(ta2);
        return ta2;
    }

    public void ct() {
        if (this.f8631en) {
            for (gv gvVar : this.f8651qn) {
                gvVar.qn();
            }
        }
        this.f8668z.tl(this);
        this.f8630ej.removeCallbacksAndMessages(null);
        this.f8664xg = true;
        this.f8663x.clear();
    }

    public final i9 d(int i) {
        i9 i9Var = this.f8622c.get(i);
        ArrayList<i9> arrayList = this.f8622c;
        j5.w2(arrayList, i, arrayList.size());
        for (int i5 = 0; i5 < this.f8651qn.length; i5++) {
            this.f8651qn[i5].r(i9Var.t(i5));
        }
        return i9Var;
    }

    public final f7 d0(int i, int i5) {
        int length = this.f8651qn.length;
        boolean z2 = true;
        if (i5 != 1 && i5 != 2) {
            z2 = false;
        }
        gv gvVar = new gv(this.f8632f, this.f8662w, this.f8649p, this.f8621b);
        gvVar.u(this.f8653ra);
        if (z2) {
            gvVar.eb(this.f8654rb);
        }
        gvVar.jz(this.f8642kp);
        i9 i9Var = this.f8637g3;
        if (i9Var != null) {
            gvVar.lc(i9Var);
        }
        gvVar.xg(this);
        int i6 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f8646o, i6);
        this.f8646o = copyOf;
        copyOf[length] = i;
        this.f8651qn = (gv[]) j5.cy(this.f8651qn, gvVar);
        boolean[] copyOf2 = Arrays.copyOf(this.f8645nf, i6);
        this.f8645nf = copyOf2;
        copyOf2[length] = z2;
        this.f8629eb |= z2;
        this.f8638j.add(Integer.valueOf(i5));
        this.f8648oz.append(i5, length);
        if (b(i5) > b(this.f8650q9)) {
            this.f8641k = length;
            this.f8650q9 = i5;
        }
        this.f8643lc = Arrays.copyOf(this.f8643lc, i6);
        return gvVar;
    }

    public int dm(int i, g gVar, a9.fb fbVar, int i5) {
        m mVar;
        if (vl()) {
            return -3;
        }
        int i6 = 0;
        if (!this.f8622c.isEmpty()) {
            int i8 = 0;
            while (i8 < this.f8622c.size() - 1 && z6(this.f8622c.get(i8))) {
                i8++;
            }
            j5.w2(this.f8622c, 0, i8);
            i9 i9Var = this.f8622c.get(0);
            m mVar2 = i9Var.f12444gv;
            if (!mVar2.equals(this.f8665y5)) {
                this.f8652r.c5(this.f8661v, mVar2, i9Var.f12447v, i9Var.f12441a, i9Var.f12443fb);
            }
            this.f8665y5 = mVar2;
        }
        if (!this.f8622c.isEmpty() && !this.f8622c.get(0).w()) {
            return -3;
        }
        int o2 = this.f8651qn[i].o(gVar, fbVar, i5, this.f8667yg);
        if (o2 == -5) {
            m mVar3 = (m) v5.y.v(gVar.f10757n3);
            if (i == this.f8641k) {
                int j52 = this.f8651qn[i].j5();
                while (i6 < this.f8622c.size() && this.f8622c.get(i6).f8595f != j52) {
                    i6++;
                }
                if (i6 < this.f8622c.size()) {
                    mVar = this.f8622c.get(i6).f12444gv;
                } else {
                    mVar = (m) v5.y.v(this.f8659u);
                }
                mVar3 = mVar3.f(mVar);
            }
            gVar.f10757n3 = mVar3;
        }
        return o2;
    }

    public void e(boolean z2) {
        this.f8656s.z(z2);
    }

    public boolean eb(long j2, boolean z2) {
        this.f8653ra = j2;
        if (vl()) {
            this.f8628e = j2;
            return true;
        }
        if (this.f8634f7 && !z2 && rs(j2)) {
            return false;
        }
        this.f8628e = j2;
        this.f8667yg = false;
        this.f8622c.clear();
        if (this.f8668z.i9()) {
            if (this.f8634f7) {
                for (gv gvVar : this.f8651qn) {
                    gvVar.mt();
                }
            }
            this.f8668z.a();
        } else {
            this.f8668z.fb();
            o4();
        }
        return true;
    }

    public void en() {
        this.f8638j.clear();
    }

    public final boolean f3(int i) {
        for (int i5 = i; i5 < this.f8622c.size(); i5++) {
            if (this.f8622c.get(i5).f8610wz) {
                return false;
            }
        }
        i9 i9Var = this.f8622c.get(i);
        for (int i6 = 0; i6 < this.f8651qn.length; i6++) {
            if (this.f8651qn[i6].rz() > i9Var.t(i6)) {
                return false;
            }
        }
        return true;
    }

    @Override // kx.ta.n3
    /* renamed from: f7 */
    public ta.zn oz(p7.a aVar, long j2, long j4, IOException iOException, int i) {
        boolean z2;
        ta.zn znVar;
        int i5;
        boolean yt2 = yt(aVar);
        if (yt2 && !((i9) aVar).w() && (iOException instanceof d0.v) && ((i5 = ((d0.v) iOException).responseCode) == 410 || i5 == 404)) {
            return kx.ta.f10110gv;
        }
        long y2 = aVar.y();
        i4 i4Var = new i4(aVar.y, aVar.f12445n3, aVar.v(), aVar.gv(), j2, j4, y2);
        mg.zn znVar2 = new mg.zn(i4Var, new c(aVar.f12448zn, this.f8661v, aVar.f12444gv, aVar.f12447v, aVar.f12441a, j5.gf(aVar.f12443fb), j5.gf(aVar.f12446s)), iOException, i);
        mg.n3 n32 = this.f8623co.n3(zo.d0.zn(this.f8656s.f()), znVar2);
        boolean z3 = false;
        if (n32 != null && n32.y == 2) {
            z2 = this.f8656s.tl(aVar, n32.f10055n3);
        } else {
            z2 = false;
        }
        if (z2) {
            if (yt2 && y2 == 0) {
                ArrayList<i9> arrayList = this.f8622c;
                if (arrayList.remove(arrayList.size() - 1) == aVar) {
                    z3 = true;
                }
                v5.y.fb(z3);
                if (this.f8622c.isEmpty()) {
                    this.f8628e = this.f8653ra;
                } else {
                    ((i9) z0.d0.v(this.f8622c)).wz();
                }
            }
            znVar = kx.ta.f10108a;
        } else {
            long gv2 = this.f8623co.gv(znVar2);
            if (gv2 != -9223372036854775807L) {
                znVar = kx.ta.s(false, gv2);
            } else {
                znVar = kx.ta.f10109fb;
            }
        }
        ta.zn znVar3 = znVar;
        boolean zn2 = znVar3.zn();
        this.f8652r.i4(i4Var, aVar.f12448zn, this.f8661v, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s, iOException, !zn2);
        if (!zn2) {
            this.f8639j5 = null;
            this.f8623co.zn(aVar.y);
        }
        if (z2) {
            if (!this.f8631en) {
                v(this.f8653ra);
            } else {
                this.f8635fb.t(this);
            }
        }
        return znVar3;
    }

    @Override // af.jz
    public long fb() {
        ArrayList<i9> arrayList;
        if (this.f8667yg) {
            return Long.MIN_VALUE;
        }
        if (vl()) {
            return this.f8628e;
        }
        long j2 = this.f8653ra;
        i9 a82 = a8();
        if (!a82.fb()) {
            if (this.f8622c.size() > 1) {
                a82 = this.f8622c.get(arrayList.size() - 2);
            } else {
                a82 = null;
            }
        }
        if (a82 != null) {
            j2 = Math.max(j2, a82.f12446s);
        }
        if (this.f8634f7) {
            for (gv gvVar : this.f8651qn) {
                j2 = Math.max(j2, gvVar.c());
            }
        }
        return j2;
    }

    public final lc fh(rs[] rsVarArr) {
        for (int i = 0; i < rsVarArr.length; i++) {
            rs rsVar = rsVarArr[i];
            m[] mVarArr = new m[rsVar.y];
            for (int i5 = 0; i5 < rsVar.y; i5++) {
                m zn2 = rsVar.zn(i5);
                mVarArr[i5] = zn2.zn(this.f8662w.n3(zn2));
            }
            rsVarArr[i] = new rs(rsVar.f381v, mVarArr);
        }
        return new lc(rsVarArr);
    }

    public long gv(long j2, vc vcVar) {
        return this.f8656s.n3(j2, vcVar);
    }

    public boolean hw(int i) {
        if (!vl() && this.f8651qn[i].x(this.f8667yg)) {
            return true;
        }
        return false;
    }

    public final void i4() {
        m mVar;
        m rz2;
        m mVar2;
        boolean z2 = true;
        int length = this.f8651qn.length;
        int i = 0;
        int i5 = -2;
        int i6 = -1;
        while (true) {
            int i8 = 2;
            if (i >= length) {
                break;
            }
            String str = ((m) v5.y.c5(this.f8651qn[i].d())).f10948f3;
            if (!n.co(str)) {
                if (n.xc(str)) {
                    i8 = 1;
                } else if (n.mt(str)) {
                    i8 = 3;
                } else {
                    i8 = -2;
                }
            }
            if (b(i8) > b(i5)) {
                i6 = i;
                i5 = i8;
            } else if (i8 == i5 && i6 != -1) {
                i6 = -1;
            }
            i++;
        }
        rs i92 = this.f8656s.i9();
        int i10 = i92.y;
        this.f8655rs = -1;
        this.f8647o4 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            this.f8647o4[i11] = i11;
        }
        rs[] rsVarArr = new rs[length];
        for (int i12 = 0; i12 < length; i12++) {
            m mVar3 = (m) v5.y.c5(this.f8651qn[i12].d());
            if (i12 == i6) {
                m[] mVarArr = new m[i10];
                for (int i13 = 0; i13 < i10; i13++) {
                    m zn2 = i92.zn(i13);
                    if (i5 == 1 && (mVar2 = this.f8658t) != null) {
                        zn2 = zn2.f(mVar2);
                    }
                    if (i10 == 1) {
                        rz2 = mVar3.f(zn2);
                    } else {
                        rz2 = rz(zn2, mVar3, true);
                    }
                    mVarArr[i13] = rz2;
                }
                rsVarArr[i12] = new rs(this.y, mVarArr);
                this.f8655rs = i12;
            } else {
                if (i5 == 2 && n.xc(mVar3.f10948f3)) {
                    mVar = this.f8658t;
                } else {
                    mVar = null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.y);
                sb.append(":muxed:");
                sb.append(i12 < i6 ? i12 : i12 - 1);
                rsVarArr[i12] = new rs(sb.toString(), rz(mVar, mVar3, false));
            }
        }
        this.f8627dm = fh(rsVarArr);
        if (this.f8624ct != null) {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f8624ct = Collections.emptySet();
    }

    public void j() throws IOException {
        this.f8668z.n3();
        this.f8656s.wz();
    }

    public boolean j5() {
        if (this.f8650q9 == 2) {
            return true;
        }
        return false;
    }

    public boolean jz(Uri uri, mg.zn znVar, boolean z2) {
        long j2;
        mg.n3 n32;
        if (!this.f8656s.xc(uri)) {
            return true;
        }
        if (!z2 && (n32 = this.f8623co.n3(zo.d0.zn(this.f8656s.f()), znVar)) != null && n32.y == 2) {
            j2 = n32.f10055n3;
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f8656s.p(uri, j2) && j2 != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // kx.ta.n3
    /* renamed from: k */
    public void ta(p7.a aVar, long j2, long j4) {
        this.f8639j5 = null;
        this.f8656s.w(aVar);
        i4 i4Var = new i4(aVar.y, aVar.f12445n3, aVar.v(), aVar.gv(), j2, j4, aVar.y());
        this.f8623co.zn(aVar.y);
        this.f8652r.r(i4Var, aVar.f12448zn, this.f8661v, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s);
        if (!this.f8631en) {
            v(this.f8653ra);
        } else {
            this.f8635fb.t(this);
        }
    }

    public final void k5(i9 i9Var) {
        gv[] gvVarArr;
        this.f8637g3 = i9Var;
        this.f8659u = i9Var.f12444gv;
        this.f8628e = -9223372036854775807L;
        this.f8622c.add(i9Var);
        x4.y x42 = x4.x4();
        for (gv gvVar : this.f8651qn) {
            x42.y(Integer.valueOf(gvVar.z6()));
        }
        i9Var.tl(this, x42.s());
        for (gv gvVar2 : this.f8651qn) {
            gvVar2.lc(i9Var);
            if (i9Var.f8610wz) {
                gvVar2.o4();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0119, code lost:
        if (r11.mt() != r19.f8656s.i9().gv(r1.f12444gv)) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean lc(zo.co[] r20, boolean[] r21, af.en[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.p.lc(zo.co[], boolean[], af.en[], boolean[], long, boolean):boolean");
    }

    public void mt(long j2, boolean z2) {
        if (this.f8634f7 && !vl()) {
            int length = this.f8651qn.length;
            for (int i = 0; i < length; i++) {
                this.f8651qn[i].p(j2, z2, this.f8643lc[i]);
            }
        }
    }

    public void n() {
        if (!this.f8631en) {
            v(this.f8653ra);
        }
    }

    public void nf(@Nullable DrmInitData drmInitData) {
        if (!j5.zn(this.f8654rb, drmInitData)) {
            this.f8654rb = drmInitData;
            int i = 0;
            while (true) {
                gv[] gvVarArr = this.f8651qn;
                if (i < gvVarArr.length) {
                    if (this.f8645nf[i]) {
                        gvVarArr[i].eb(drmInitData);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public lc p() {
        r();
        return this.f8627dm;
    }

    @Override // kx.ta.n3
    /* renamed from: q9 */
    public void ud(p7.a aVar, long j2, long j4, boolean z2) {
        this.f8639j5 = null;
        i4 i4Var = new i4(aVar.y, aVar.f12445n3, aVar.v(), aVar.gv(), j2, j4, aVar.y());
        this.f8623co.zn(aVar.y);
        this.f8652r.mt(i4Var, aVar.f12448zn, this.f8661v, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s);
        if (!z2) {
            if (vl() || this.f8640jz == 0) {
                o4();
            }
            if (this.f8640jz > 0) {
                this.f8635fb.t(this);
            }
        }
    }

    public final void qn() {
        int i = this.f8627dm.y;
        int[] iArr = new int[i];
        this.f8647o4 = iArr;
        Arrays.fill(iArr, -1);
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = 0;
            while (true) {
                gv[] gvVarArr = this.f8651qn;
                if (i6 >= gvVarArr.length) {
                    break;
                } else if (ej((m) v5.y.c5(gvVarArr[i6].d()), this.f8627dm.n3(i5).zn(0))) {
                    this.f8647o4[i5] = i6;
                    break;
                } else {
                    i6++;
                }
            }
        }
        Iterator<tl> it = this.f8663x.iterator();
        while (it.hasNext()) {
            it.next().y();
        }
    }

    public final void r() {
        v5.y.fb(this.f8631en);
        v5.y.v(this.f8627dm);
        v5.y.v(this.f8624ct);
    }

    public final void ra() {
        this.f8631en = true;
    }

    public final boolean rs(long j2) {
        int length = this.f8651qn.length;
        for (int i = 0; i < length; i++) {
            if (!this.f8651qn[i].en(j2, false) && (this.f8645nf[i] || !this.f8629eb)) {
                return false;
            }
        }
        return true;
    }

    @Override // af.jz
    public void s(long j2) {
        if (!this.f8668z.c5() && !vl()) {
            if (this.f8668z.i9()) {
                v5.y.v(this.f8639j5);
                if (this.f8656s.x4(j2, this.f8639j5, this.f8626d0)) {
                    this.f8668z.a();
                    return;
                }
                return;
            }
            int size = this.f8626d0.size();
            while (size > 0 && this.f8656s.zn(this.f8626d0.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.f8626d0.size()) {
                mg(size);
            }
            int s2 = this.f8656s.s(j2, this.f8626d0);
            if (s2 < this.f8622c.size()) {
                mg(s2);
            }
        }
    }

    public void s8(long j2) {
        if (this.f8642kp != j2) {
            this.f8642kp = j2;
            for (gv gvVar : this.f8651qn) {
                gvVar.jz(j2);
            }
        }
    }

    @Override // kx.ta.a
    public void tl() {
        for (gv gvVar : this.f8651qn) {
            gvVar.j();
        }
    }

    public void u() {
        if (this.f8622c.isEmpty()) {
            return;
        }
        i9 i9Var = (i9) z0.d0.v(this.f8622c);
        int zn2 = this.f8656s.zn(i9Var);
        if (zn2 == 1) {
            i9Var.r();
        } else if (zn2 == 2 && !this.f8667yg && this.f8668z.i9()) {
            this.f8668z.a();
        }
    }

    public void ut(int i) throws IOException {
        j();
        this.f8651qn[i].yt();
    }

    @Override // af.jz
    public boolean v(long j2) {
        List<i9> list;
        long max;
        boolean z2;
        if (this.f8667yg || this.f8668z.i9() || this.f8668z.c5()) {
            return false;
        }
        if (vl()) {
            list = Collections.emptyList();
            max = this.f8628e;
            for (gv gvVar : this.f8651qn) {
                gvVar.u(this.f8628e);
            }
        } else {
            list = this.f8626d0;
            i9 a82 = a8();
            if (a82.fb()) {
                max = a82.f12446s;
            } else {
                max = Math.max(this.f8653ra, a82.f12443fb);
            }
        }
        List<i9> list2 = list;
        long j4 = max;
        this.f8644n.y();
        a aVar = this.f8656s;
        if (!this.f8631en && list2.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        aVar.v(j2, j4, list2, z2, this.f8644n);
        a.n3 n3Var = this.f8644n;
        boolean z3 = n3Var.f8573n3;
        p7.a aVar2 = n3Var.y;
        Uri uri = n3Var.f8574zn;
        if (z3) {
            this.f8628e = -9223372036854775807L;
            this.f8667yg = true;
            return true;
        } else if (aVar2 == null) {
            if (uri != null) {
                this.f8635fb.tl(uri);
            }
            return false;
        } else {
            if (yt(aVar2)) {
                k5((i9) aVar2);
            }
            this.f8639j5 = aVar2;
            this.f8652r.d0(new i4(aVar2.y, aVar2.f12445n3, this.f8668z.wz(aVar2, this, this.f8623co.y(aVar2.f12448zn))), aVar2.f12448zn, this.f8661v, aVar2.f12444gv, aVar2.f12447v, aVar2.f12441a, aVar2.f12443fb, aVar2.f12446s);
            return true;
        }
    }

    @Override // af.f7.gv
    public void w(m mVar) {
        this.f8630ej.post(this.f8636fh);
    }

    public void wz() throws IOException {
        j();
        if (this.f8667yg && !this.f8631en) {
            throw ne.y("Loading finished before preparation is complete.", null);
        }
    }

    @Nullable
    public final e4.ta x(int i, int i5) {
        v5.y.y(f8619m.contains(Integer.valueOf(i5)));
        int i6 = this.f8648oz.get(i5, -1);
        if (i6 == -1) {
            return null;
        }
        if (this.f8638j.add(Integer.valueOf(i5))) {
            this.f8646o[i6] = i;
        }
        if (this.f8646o[i6] == i) {
            return this.f8651qn[i6];
        }
        return c(i, i5);
    }

    public int x4(int i) {
        r();
        v5.y.v(this.f8647o4);
        int i5 = this.f8647o4[i];
        if (i5 == -1) {
            if (!this.f8624ct.contains(this.f8627dm.n3(i))) {
                return -2;
            }
            return -3;
        }
        boolean[] zArr = this.f8643lc;
        if (zArr[i5]) {
            return -2;
        }
        zArr[i5] = true;
        return i5;
    }

    @Override // e4.wz
    public void xc() {
        this.f8666yc = true;
        this.f8630ej.post(this.f8625d);
    }

    public void xg(rs[] rsVarArr, int i, int... iArr) {
        this.f8627dm = fh(rsVarArr);
        this.f8624ct = new HashSet();
        for (int i5 : iArr) {
            this.f8624ct.add(this.f8627dm.n3(i5));
        }
        this.f8655rs = i;
        Handler handler = this.f8630ej;
        final n3 n3Var = this.f8635fb;
        Objects.requireNonNull(n3Var);
        handler.post(new Runnable() { // from class: h4.wz
            @Override // java.lang.Runnable
            public final void run() {
                p.n3.this.onPrepared();
            }
        });
        ra();
    }

    @Override // af.jz
    public boolean y() {
        return this.f8668z.i9();
    }

    public final void y5() {
        this.f8634f7 = true;
        o();
    }

    public final void yc(en[] enVarArr) {
        this.f8663x.clear();
        for (en enVar : enVarArr) {
            if (enVar != null) {
                this.f8663x.add((tl) enVar);
            }
        }
    }

    public void yg(int i) {
        r();
        v5.y.v(this.f8647o4);
        int i5 = this.f8647o4[i];
        v5.y.fb(this.f8643lc[i5]);
        this.f8643lc[i5] = false;
    }

    public final boolean z6(i9 i9Var) {
        int i = i9Var.f8595f;
        int length = this.f8651qn.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (this.f8643lc[i5] && this.f8651qn[i5].j5() == i) {
                return false;
            }
        }
        return true;
    }

    @Override // af.jz
    public long zn() {
        if (vl()) {
            return this.f8628e;
        }
        if (this.f8667yg) {
            return Long.MIN_VALUE;
        }
        return a8().f12446s;
    }

    @Override // e4.wz
    public void t(fh fhVar) {
    }
}
