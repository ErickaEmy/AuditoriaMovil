package af;

import af.b;
import af.d0;
import af.f7;
import af.x4;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import e4.fh;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kx.mg;
import kx.p;
import kx.ta;
import m1.g;
import m1.m;
import m1.ne;
import m1.vc;
/* loaded from: classes.dex */
public final class j implements d0, e4.wz, ta.n3<y>, ta.a, f7.gv {

    /* renamed from: eb  reason: collision with root package name */
    public static final Map<String, String> f257eb = x();

    /* renamed from: lc  reason: collision with root package name */
    public static final m f258lc = new m.n3().oz("icy").o4("application/x-icy").z6();
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final String f261co;

    /* renamed from: ct  reason: collision with root package name */
    public int f262ct;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public d0.y f263d;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f265dm;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public IcyHeaders f266ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f267en;

    /* renamed from: f  reason: collision with root package name */
    public final b.y f268f;

    /* renamed from: f3  reason: collision with root package name */
    public final vl f269f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f270f7;

    /* renamed from: fb  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f271fb;

    /* renamed from: j  reason: collision with root package name */
    public v f273j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f274j5;

    /* renamed from: jz  reason: collision with root package name */
    public int f275jz;

    /* renamed from: o  reason: collision with root package name */
    public boolean f278o;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f279o4;

    /* renamed from: oz  reason: collision with root package name */
    public e4.fh f280oz;

    /* renamed from: p  reason: collision with root package name */
    public final kx.n3 f281p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f282q9;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f283qn;

    /* renamed from: rs  reason: collision with root package name */
    public boolean f285rs;

    /* renamed from: s  reason: collision with root package name */
    public final kx.mg f286s;

    /* renamed from: t  reason: collision with root package name */
    public final v.y f287t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f288u;

    /* renamed from: v  reason: collision with root package name */
    public final kx.tl f290v;

    /* renamed from: w  reason: collision with root package name */
    public final n3 f291w;
    public final Uri y;

    /* renamed from: y5  reason: collision with root package name */
    public long f294y5;

    /* renamed from: z  reason: collision with root package name */
    public final long f295z;

    /* renamed from: r  reason: collision with root package name */
    public final kx.ta f284r = new kx.ta("ProgressiveMediaPeriod");

    /* renamed from: n  reason: collision with root package name */
    public final v5.s f277n = new v5.s();

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f260c = new Runnable() { // from class: af.hw
        @Override // java.lang.Runnable
        public final void run() {
            j.this.j();
        }
    };

    /* renamed from: d0  reason: collision with root package name */
    public final Runnable f264d0 = new Runnable() { // from class: af.j5
        @Override // java.lang.Runnable
        public final void run() {
            j.this.j5();
        }
    };

    /* renamed from: fh  reason: collision with root package name */
    public final Handler f272fh = v5.j5.i4();

    /* renamed from: b  reason: collision with root package name */
    public gv[] f259b = new gv[0];

    /* renamed from: x  reason: collision with root package name */
    public f7[] f292x = new f7[0];

    /* renamed from: xg  reason: collision with root package name */
    public long f293xg = -9223372036854775807L;

    /* renamed from: ut  reason: collision with root package name */
    public long f289ut = -9223372036854775807L;

    /* renamed from: k  reason: collision with root package name */
    public int f276k = 1;

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f296n3;
        public final int y;

        public gv(int i, boolean z2) {
            this.y = i;
            this.f296n3 = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gv.class != obj.getClass()) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (this.y == gvVar.y && this.f296n3 == gvVar.f296n3) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.y * 31) + (this.f296n3 ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void y(long j2, boolean z2, boolean z3);
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean[] f297gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean[] f298n3;
        public final lc y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean[] f299zn;

        public v(lc lcVar, boolean[] zArr) {
            this.y = lcVar;
            this.f298n3 = zArr;
            int i = lcVar.y;
            this.f299zn = new boolean[i];
            this.f297gv = new boolean[i];
        }
    }

    /* loaded from: classes.dex */
    public final class y implements ta.v, x4.y {

        /* renamed from: a  reason: collision with root package name */
        public final v5.s f300a;

        /* renamed from: gv  reason: collision with root package name */
        public final vl f304gv;

        /* renamed from: i9  reason: collision with root package name */
        public long f305i9;

        /* renamed from: n3  reason: collision with root package name */
        public final Uri f306n3;

        /* renamed from: s  reason: collision with root package name */
        public volatile boolean f307s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public e4.ta f308t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f309tl;

        /* renamed from: v  reason: collision with root package name */
        public final e4.wz f310v;

        /* renamed from: zn  reason: collision with root package name */
        public final kx.j5 f312zn;

        /* renamed from: fb  reason: collision with root package name */
        public final e4.d0 f303fb = new e4.d0();

        /* renamed from: c5  reason: collision with root package name */
        public boolean f301c5 = true;
        public final long y = i4.y();

        /* renamed from: f  reason: collision with root package name */
        public kx.p f302f = s(0);

        public y(Uri uri, kx.tl tlVar, vl vlVar, e4.wz wzVar, v5.s sVar) {
            this.f306n3 = uri;
            this.f312zn = new kx.j5(tlVar);
            this.f304gv = vlVar;
            this.f310v = wzVar;
            this.f300a = sVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c5(long j2, long j4) {
            this.f303fb.y = j2;
            this.f305i9 = j4;
            this.f301c5 = true;
            this.f309tl = false;
        }

        private kx.p s(long j2) {
            return new p.n3().c5(this.f306n3).s(j2).a(j.this.f261co).n3(6).v(j.f257eb).y();
        }

        @Override // kx.ta.v
        public void load() throws IOException {
            int i = 0;
            while (i == 0 && !this.f307s) {
                try {
                    long j2 = this.f303fb.y;
                    kx.p s2 = s(j2);
                    this.f302f = s2;
                    long y = this.f312zn.y(s2);
                    if (y != -1) {
                        y += j2;
                        j.this.en();
                    }
                    long j4 = y;
                    j.this.f266ej = IcyHeaders.y(this.f312zn.fb());
                    kx.c5 c5Var = this.f312zn;
                    if (j.this.f266ej != null && j.this.f266ej.f4238t != -1) {
                        c5Var = new x4(this.f312zn, j.this.f266ej.f4238t, this);
                        e4.ta yt2 = j.this.yt();
                        this.f308t = yt2;
                        yt2.v(j.f258lc);
                    }
                    long j6 = j2;
                    this.f304gv.zn(c5Var, this.f306n3, this.f312zn.fb(), j2, j4, this.f310v);
                    if (j.this.f266ej != null) {
                        this.f304gv.gv();
                    }
                    if (this.f301c5) {
                        this.f304gv.y(j6, this.f305i9);
                        this.f301c5 = false;
                    }
                    while (true) {
                        long j7 = j6;
                        while (i == 0 && !this.f307s) {
                            try {
                                this.f300a.y();
                                i = this.f304gv.n3(this.f303fb);
                                j6 = this.f304gv.v();
                                if (j6 > j.this.f295z + j7) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f300a.gv();
                        j.this.f272fh.post(j.this.f264d0);
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.f304gv.v() != -1) {
                        this.f303fb.y = this.f304gv.v();
                    }
                    kx.w.y(this.f312zn);
                } catch (Throwable th) {
                    if (i != 1 && this.f304gv.v() != -1) {
                        this.f303fb.y = this.f304gv.v();
                    }
                    kx.w.y(this.f312zn);
                    throw th;
                }
            }
        }

        @Override // kx.ta.v
        public void n3() {
            this.f307s = true;
        }

        @Override // af.x4.y
        public void y(v5.rz rzVar) {
            long max;
            if (!this.f309tl) {
                max = this.f305i9;
            } else {
                max = Math.max(j.this.k5(true), this.f305i9);
            }
            long j2 = max;
            int y = rzVar.y();
            e4.ta taVar = (e4.ta) v5.y.v(this.f308t);
            taVar.zn(rzVar, y);
            taVar.gv(j2, 1, y, 0, null);
            this.f309tl = true;
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements en {
        public final int y;

        public zn(int i) {
            this.y = i;
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            return j.this.dm(this.y, gVar, fbVar, i);
        }

        @Override // af.en
        public boolean isReady() {
            return j.this.hw(this.y);
        }

        @Override // af.en
        public void n3() throws IOException {
            j.this.f7(this.y);
        }

        @Override // af.en
        public int t(long j2) {
            return j.this.eb(this.y, j2);
        }
    }

    public j(Uri uri, kx.tl tlVar, vl vlVar, com.google.android.exoplayer2.drm.a aVar, v.y yVar, kx.mg mgVar, b.y yVar2, n3 n3Var, kx.n3 n3Var2, @Nullable String str, int i) {
        this.y = uri;
        this.f290v = tlVar;
        this.f271fb = aVar;
        this.f287t = yVar;
        this.f286s = mgVar;
        this.f268f = yVar2;
        this.f291w = n3Var;
        this.f281p = n3Var2;
        this.f261co = str;
        this.f295z = i;
        this.f269f3 = vlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j5() {
        if (!this.f285rs) {
            ((d0.y) v5.y.v(this.f263d)).t(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long k5(boolean z2) {
        long j2 = Long.MIN_VALUE;
        for (int i = 0; i < this.f292x.length; i++) {
            if (z2 || ((v) v5.y.v(this.f273j)).f299zn[i]) {
                j2 = Math.max(j2, this.f292x[i].c());
            }
        }
        return j2;
    }

    private void lc() {
        y yVar = new y(this.y, this.f290v, this.f269f3, this, this.f277n);
        if (this.f283qn) {
            v5.y.fb(vl());
            long j2 = this.f289ut;
            if (j2 == -9223372036854775807L || this.f293xg <= j2) {
                yVar.c5(((e4.fh) v5.y.v(this.f280oz)).gv(this.f293xg).y.f7512n3, this.f293xg);
                for (f7 f7Var : this.f292x) {
                    f7Var.u(this.f293xg);
                }
                this.f293xg = -9223372036854775807L;
            } else {
                this.f279o4 = true;
                this.f293xg = -9223372036854775807L;
                return;
            }
        }
        this.f262ct = b();
        this.f268f.d0(new i4(yVar.y, yVar.f302f, this.f284r.wz(yVar, this, this.f286s.y(this.f276k))), 1, -1, null, 0, null, yVar.f305i9, this.f289ut);
    }

    private boolean nf() {
        if (!this.f267en && !vl()) {
            return false;
        }
        return true;
    }

    private boolean o4(boolean[] zArr, long j2) {
        int length = this.f292x.length;
        for (int i = 0; i < length; i++) {
            if (!this.f292x[i].en(j2, false) && (zArr[i] || !this.f278o)) {
                return false;
            }
        }
        return true;
    }

    private void q9(int i) {
        ej();
        boolean[] zArr = this.f273j.f298n3;
        if (this.f265dm && zArr[i]) {
            if (!this.f292x[i].x(false)) {
                this.f293xg = 0L;
                this.f265dm = false;
                this.f267en = true;
                this.f294y5 = 0L;
                this.f262ct = 0;
                for (f7 f7Var : this.f292x) {
                    f7Var.ut();
                }
                ((d0.y) v5.y.v(this.f263d)).t(this);
            }
        }
    }

    private void ut(int i) {
        ej();
        v vVar = this.f273j;
        boolean[] zArr = vVar.f297gv;
        if (!zArr[i]) {
            m zn2 = vVar.y.n3(i).zn(0);
            this.f268f.c5(v5.n.f(zn2.f10948f3), zn2, 0, null, this.f294y5);
            zArr[i] = true;
        }
    }

    private boolean vl() {
        if (this.f293xg != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public static Map<String, String> x() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // e4.wz
    public e4.ta a(int i, int i5) {
        return xg(new gv(i, false));
    }

    public final boolean a8(y yVar, int i) {
        e4.fh fhVar;
        if (!this.f288u && ((fhVar = this.f280oz) == null || fhVar.c5() == -9223372036854775807L)) {
            if (this.f283qn && !nf()) {
                this.f265dm = true;
                return false;
            }
            this.f267en = this.f283qn;
            this.f294y5 = 0L;
            this.f262ct = 0;
            for (f7 f7Var : this.f292x) {
                f7Var.ut();
            }
            yVar.c5(0L, 0L);
            return true;
        }
        this.f262ct = i;
        return true;
    }

    public final int b() {
        int i = 0;
        for (f7 f7Var : this.f292x) {
            i += f7Var.z6();
        }
        return i;
    }

    @Override // af.d0
    public long c5(long j2) {
        ej();
        boolean[] zArr = this.f273j.f298n3;
        if (!this.f280oz.s()) {
            j2 = 0;
        }
        int i = 0;
        this.f267en = false;
        this.f294y5 = j2;
        if (vl()) {
            this.f293xg = j2;
            return j2;
        } else if (this.f276k != 7 && o4(zArr, j2)) {
            return j2;
        } else {
            this.f265dm = false;
            this.f293xg = j2;
            this.f279o4 = false;
            if (this.f284r.i9()) {
                f7[] f7VarArr = this.f292x;
                int length = f7VarArr.length;
                while (i < length) {
                    f7VarArr[i].mt();
                    i++;
                }
                this.f284r.a();
            } else {
                this.f284r.fb();
                f7[] f7VarArr2 = this.f292x;
                int length2 = f7VarArr2.length;
                while (i < length2) {
                    f7VarArr2[i].ut();
                    i++;
                }
            }
            return j2;
        }
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f263d = yVar;
        this.f277n.a();
        lc();
    }

    public void ct() {
        if (this.f283qn) {
            for (f7 f7Var : this.f292x) {
                f7Var.qn();
            }
        }
        this.f284r.tl(this);
        this.f272fh.removeCallbacksAndMessages(null);
        this.f263d = null;
        this.f285rs = true;
    }

    public int dm(int i, g gVar, a9.fb fbVar, int i5) {
        if (nf()) {
            return -3;
        }
        ut(i);
        int o2 = this.f292x[i].o(gVar, fbVar, i5, this.f279o4);
        if (o2 == -3) {
            q9(i);
        }
        return o2;
    }

    public int eb(int i, long j2) {
        if (nf()) {
            return 0;
        }
        ut(i);
        f7 f7Var = this.f292x[i];
        int ta2 = f7Var.ta(j2, this.f279o4);
        f7Var.dm(ta2);
        if (ta2 == 0) {
            q9(i);
        }
        return ta2;
    }

    public final void ej() {
        v5.y.fb(this.f283qn);
        v5.y.v(this.f273j);
        v5.y.v(this.f280oz);
    }

    public final void en() {
        this.f272fh.post(new Runnable() { // from class: af.qn
            @Override // java.lang.Runnable
            public final void run() {
                j.this.qn();
            }
        });
    }

    @Override // af.d0
    public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        boolean z2;
        zo.co coVar;
        boolean z3;
        boolean z4;
        ej();
        v vVar = this.f273j;
        lc lcVar = vVar.y;
        boolean[] zArr3 = vVar.f299zn;
        int i = this.f275jz;
        int i5 = 0;
        for (int i6 = 0; i6 < coVarArr.length; i6++) {
            en enVar = enVarArr[i6];
            if (enVar != null && (coVarArr[i6] == null || !zArr[i6])) {
                int i8 = ((zn) enVar).y;
                v5.y.fb(zArr3[i8]);
                this.f275jz--;
                zArr3[i8] = false;
                enVarArr[i6] = null;
            }
        }
        if (!this.f270f7 ? j2 != 0 : i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        for (int i10 = 0; i10 < coVarArr.length; i10++) {
            if (enVarArr[i10] == null && (coVar = coVarArr[i10]) != null) {
                if (coVar.length() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v5.y.fb(z3);
                if (coVar.s(0) == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                v5.y.fb(z4);
                int zn2 = lcVar.zn(coVar.xc());
                v5.y.fb(!zArr3[zn2]);
                this.f275jz++;
                zArr3[zn2] = true;
                enVarArr[i10] = new zn(zn2);
                zArr2[i10] = true;
                if (!z2) {
                    f7 f7Var = this.f292x[zn2];
                    if (!f7Var.en(j2, true) && f7Var.rz() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
        }
        if (this.f275jz == 0) {
            this.f265dm = false;
            this.f267en = false;
            if (this.f284r.i9()) {
                f7[] f7VarArr = this.f292x;
                int length = f7VarArr.length;
                while (i5 < length) {
                    f7VarArr[i5].mt();
                    i5++;
                }
                this.f284r.a();
            } else {
                f7[] f7VarArr2 = this.f292x;
                int length2 = f7VarArr2.length;
                while (i5 < length2) {
                    f7VarArr2[i5].ut();
                    i5++;
                }
            }
        } else if (z2) {
            j2 = c5(j2);
            while (i5 < enVarArr.length) {
                if (enVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
                i5++;
            }
        }
        this.f270f7 = true;
        return j2;
    }

    public void f7(int i) throws IOException {
        this.f292x[i].yt();
        k();
    }

    @Override // af.d0, af.jz
    public long fb() {
        long j2;
        ej();
        if (this.f279o4 || this.f275jz == 0) {
            return Long.MIN_VALUE;
        }
        if (vl()) {
            return this.f293xg;
        }
        if (this.f278o) {
            int length = this.f292x.length;
            j2 = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                v vVar = this.f273j;
                if (vVar.f298n3[i] && vVar.f299zn[i] && !this.f292x[i].a8()) {
                    j2 = Math.min(j2, this.f292x[i].c());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = k5(false);
        }
        if (j2 == Long.MIN_VALUE) {
            return this.f294y5;
        }
        return j2;
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        ej();
        if (!this.f280oz.s()) {
            return 0L;
        }
        fh.y gv2 = this.f280oz.gv(j2);
        return vcVar.y(j2, gv2.y.y, gv2.f7504n3.y);
    }

    public boolean hw(int i) {
        if (!nf() && this.f292x[i].x(this.f279o4)) {
            return true;
        }
        return false;
    }

    @Override // af.d0
    public long i9() {
        if (this.f267en) {
            if (this.f279o4 || b() > this.f262ct) {
                this.f267en = false;
                return this.f294y5;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    public final void j() {
        boolean z2;
        Metadata y2;
        if (!this.f285rs && !this.f283qn && this.f274j5 && this.f280oz != null) {
            for (f7 f7Var : this.f292x) {
                if (f7Var.d() == null) {
                    return;
                }
            }
            this.f277n.gv();
            int length = this.f292x.length;
            rs[] rsVarArr = new rs[length];
            boolean[] zArr = new boolean[length];
            for (int i = 0; i < length; i++) {
                m mVar = (m) v5.y.v(this.f292x[i].d());
                String str = mVar.f10948f3;
                boolean xc2 = v5.n.xc(str);
                if (!xc2 && !v5.n.co(str)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                zArr[i] = z2;
                this.f278o = z2 | this.f278o;
                IcyHeaders icyHeaders = this.f266ej;
                if (icyHeaders != null) {
                    if (xc2 || this.f259b[i].f296n3) {
                        Metadata metadata = mVar.f10972z;
                        if (metadata == null) {
                            y2 = new Metadata(icyHeaders);
                        } else {
                            y2 = metadata.y(icyHeaders);
                        }
                        mVar = mVar.n3().en(y2).z6();
                    }
                    if (xc2 && mVar.f10964t == -1 && mVar.f10968w == -1 && icyHeaders.y != -1) {
                        mVar = mVar.n3().ud(icyHeaders.y).z6();
                    }
                }
                rsVarArr[i] = new rs(Integer.toString(i), mVar.zn(this.f271fb.n3(mVar)));
            }
            this.f273j = new v(new lc(rsVarArr), zArr);
            this.f283qn = true;
            ((d0.y) v5.y.v(this.f263d)).n3(this);
        }
    }

    @Override // kx.ta.n3
    /* renamed from: jz */
    public void ud(y yVar, long j2, long j4, boolean z2) {
        kx.j5 j5Var = yVar.f312zn;
        i4 i4Var = new i4(yVar.y, yVar.f302f, j5Var.c5(), j5Var.mt(), j2, j4, j5Var.a());
        this.f286s.zn(yVar.y);
        this.f268f.mt(i4Var, 1, -1, null, 0, null, yVar.f305i9, this.f289ut);
        if (!z2) {
            for (f7 f7Var : this.f292x) {
                f7Var.ut();
            }
            if (this.f275jz > 0) {
                ((d0.y) v5.y.v(this.f263d)).t(this);
            }
        }
    }

    public void k() throws IOException {
        this.f284r.f(this.f286s.y(this.f276k));
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        ej();
        if (vl()) {
            return;
        }
        boolean[] zArr = this.f273j.f299zn;
        int length = this.f292x.length;
        for (int i = 0; i < length; i++) {
            this.f292x[i].p(j2, z2, zArr[i]);
        }
    }

    @Override // af.d0
    public lc p() {
        ej();
        return this.f273j.y;
    }

    public final /* synthetic */ void qn() {
        this.f288u = true;
    }

    /* renamed from: rs */
    public final void o(e4.fh fhVar) {
        e4.fh n3Var;
        boolean z2;
        if (this.f266ej == null) {
            n3Var = fhVar;
        } else {
            n3Var = new fh.n3(-9223372036854775807L);
        }
        this.f280oz = n3Var;
        this.f289ut = fhVar.c5();
        int i = 1;
        if (!this.f288u && fhVar.c5() == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f282q9 = z2;
        if (z2) {
            i = 7;
        }
        this.f276k = i;
        this.f291w.y(this.f289ut, fhVar.s(), this.f282q9);
        if (!this.f283qn) {
            j();
        }
    }

    @Override // e4.wz
    public void t(final e4.fh fhVar) {
        this.f272fh.post(new Runnable() { // from class: af.o
            @Override // java.lang.Runnable
            public final void run() {
                j.this.o(fhVar);
            }
        });
    }

    @Override // kx.ta.a
    public void tl() {
        for (f7 f7Var : this.f292x) {
            f7Var.j();
        }
        this.f269f3.release();
    }

    @Override // kx.ta.n3
    /* renamed from: u */
    public void ta(y yVar, long j2, long j4) {
        e4.fh fhVar;
        long j6;
        if (this.f289ut == -9223372036854775807L && (fhVar = this.f280oz) != null) {
            boolean s2 = fhVar.s();
            long k52 = k5(true);
            if (k52 == Long.MIN_VALUE) {
                j6 = 0;
            } else {
                j6 = k52 + 10000;
            }
            this.f289ut = j6;
            this.f291w.y(j6, s2, this.f282q9);
        }
        kx.j5 j5Var = yVar.f312zn;
        i4 i4Var = new i4(yVar.y, yVar.f302f, j5Var.c5(), j5Var.mt(), j2, j4, j5Var.a());
        this.f286s.zn(yVar.y);
        this.f268f.r(i4Var, 1, -1, null, 0, null, yVar.f305i9, this.f289ut);
        this.f279o4 = true;
        ((d0.y) v5.y.v(this.f263d)).t(this);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        if (!this.f279o4 && !this.f284r.c5() && !this.f265dm) {
            if (!this.f283qn || this.f275jz != 0) {
                boolean a2 = this.f277n.a();
                if (!this.f284r.i9()) {
                    lc();
                    return true;
                }
                return a2;
            }
            return false;
        }
        return false;
    }

    @Override // af.f7.gv
    public void w(m mVar) {
        this.f272fh.post(this.f260c);
    }

    @Override // af.d0
    public void wz() throws IOException {
        k();
        if (this.f279o4 && !this.f283qn) {
            throw ne.y("Loading finished before preparation is complete.", null);
        }
    }

    @Override // e4.wz
    public void xc() {
        this.f274j5 = true;
        this.f272fh.post(this.f260c);
    }

    public final e4.ta xg(gv gvVar) {
        int length = this.f292x.length;
        for (int i = 0; i < length; i++) {
            if (gvVar.equals(this.f259b[i])) {
                return this.f292x[i];
            }
        }
        f7 f4 = f7.f(this.f281p, this.f271fb, this.f287t);
        f4.xg(this);
        int i5 = length + 1;
        gv[] gvVarArr = (gv[]) Arrays.copyOf(this.f259b, i5);
        gvVarArr[length] = gvVar;
        this.f259b = (gv[]) v5.j5.f(gvVarArr);
        f7[] f7VarArr = (f7[]) Arrays.copyOf(this.f292x, i5);
        f7VarArr[length] = f4;
        this.f292x = (f7[]) v5.j5.f(f7VarArr);
        return f4;
    }

    @Override // af.d0, af.jz
    public boolean y() {
        if (this.f284r.i9() && this.f277n.v()) {
            return true;
        }
        return false;
    }

    @Override // kx.ta.n3
    /* renamed from: y5 */
    public ta.zn oz(y yVar, long j2, long j4, IOException iOException, int i) {
        boolean z2;
        ta.zn znVar;
        kx.j5 j5Var = yVar.f312zn;
        i4 i4Var = new i4(yVar.y, yVar.f302f, j5Var.c5(), j5Var.mt(), j2, j4, j5Var.a());
        long gv2 = this.f286s.gv(new mg.zn(i4Var, new c(1, -1, null, 0, null, v5.j5.gf(yVar.f305i9), v5.j5.gf(this.f289ut)), iOException, i));
        if (gv2 == -9223372036854775807L) {
            znVar = kx.ta.f10109fb;
        } else {
            int b2 = b();
            if (b2 > this.f262ct) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (a8(yVar, b2)) {
                znVar = kx.ta.s(z2, gv2);
            } else {
                znVar = kx.ta.f10108a;
            }
        }
        boolean zn2 = znVar.zn();
        this.f268f.i4(i4Var, 1, -1, null, 0, null, yVar.f305i9, this.f289ut, iOException, !zn2);
        if (!zn2) {
            this.f286s.zn(yVar.y);
        }
        return znVar;
    }

    public e4.ta yt() {
        return xg(new gv(0, true));
    }

    @Override // af.d0, af.jz
    public long zn() {
        return fb();
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
    }
}
