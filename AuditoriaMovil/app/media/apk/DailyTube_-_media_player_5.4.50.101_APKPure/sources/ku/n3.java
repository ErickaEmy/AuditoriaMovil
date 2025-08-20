package ku;

import android.net.Uri;
import e4.d0;
import e4.fh;
import e4.mt;
import e4.p;
import e4.t;
import e4.ta;
import e4.tl;
import e4.v;
import e4.wz;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import m1.m;
import m1.ne;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 implements t {

    /* renamed from: mt  reason: collision with root package name */
    public static final int[] f9994mt;

    /* renamed from: r  reason: collision with root package name */
    public static final int f9996r;

    /* renamed from: a  reason: collision with root package name */
    public int f9999a;

    /* renamed from: c5  reason: collision with root package name */
    public int f10000c5;

    /* renamed from: f  reason: collision with root package name */
    public long f10001f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f10002fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f10003gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f10004i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f10005n3;

    /* renamed from: s  reason: collision with root package name */
    public long f10006s;

    /* renamed from: t  reason: collision with root package name */
    public wz f10007t;

    /* renamed from: tl  reason: collision with root package name */
    public ta f10008tl;

    /* renamed from: v  reason: collision with root package name */
    public int f10009v;

    /* renamed from: wz  reason: collision with root package name */
    public fh f10010wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f10011xc;
    public final byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f10012zn;

    /* renamed from: w  reason: collision with root package name */
    public static final mt f9997w = new mt() { // from class: ku.y
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] tl2;
            tl2 = n3.tl();
            return tl2;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f9995p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: co  reason: collision with root package name */
    public static final byte[] f9993co = j5.ap("#!AMR\n");

    /* renamed from: z  reason: collision with root package name */
    public static final byte[] f9998z = j5.ap("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f9994mt = iArr;
        f9996r = iArr[8];
    }

    public n3() {
        this(0);
    }

    public static int fb(int i, long j2) {
        return (int) ((i * 8000000) / j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] tl() {
        return new t[]{new n3()};
    }

    public static boolean w(tl tlVar, byte[] bArr) throws IOException {
        tlVar.s();
        byte[] bArr2 = new byte[bArr.length];
        tlVar.z(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        return mt(tlVar);
    }

    public final int c5(int i) throws ne {
        String str;
        if (!f(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal AMR ");
            if (this.f10012zn) {
                str = "WB";
            } else {
                str = "NB";
            }
            sb.append(str);
            sb.append(" frame type ");
            sb.append(i);
            throw ne.y(sb.toString(), null);
        } else if (this.f10012zn) {
            return f9994mt[i];
        } else {
            return f9995p[i];
        }
    }

    public final int co(tl tlVar) throws IOException {
        if (this.f9999a == 0) {
            try {
                int p2 = p(tlVar);
                this.f10009v = p2;
                this.f9999a = p2;
                if (this.f10000c5 == -1) {
                    this.f10006s = tlVar.getPosition();
                    this.f10000c5 = this.f10009v;
                }
                if (this.f10000c5 == this.f10009v) {
                    this.f10004i9++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int n32 = this.f10008tl.n3(tlVar, this.f9999a, true);
        if (n32 == -1) {
            return -1;
        }
        int i = this.f9999a - n32;
        this.f9999a = i;
        if (i > 0) {
            return 0;
        }
        this.f10008tl.gv(this.f10001f + this.f10003gv, 1, this.f10009v, 0, null);
        this.f10003gv += 20000;
        return 0;
    }

    public final boolean f(int i) {
        if (i >= 0 && i <= 15 && (t(i) || i9(i))) {
            return true;
        }
        return false;
    }

    public final void gv() {
        v5.y.c5(this.f10008tl);
        j5.i9(this.f10007t);
    }

    public final boolean i9(int i) {
        if (!this.f10012zn && (i < 12 || i > 14)) {
            return true;
        }
        return false;
    }

    public final boolean mt(tl tlVar) throws IOException {
        byte[] bArr = f9993co;
        if (w(tlVar, bArr)) {
            this.f10012zn = false;
            tlVar.p(bArr.length);
            return true;
        }
        byte[] bArr2 = f9998z;
        if (!w(tlVar, bArr2)) {
            return false;
        }
        this.f10012zn = true;
        tlVar.p(bArr2.length);
        return true;
    }

    public final int p(tl tlVar) throws IOException {
        tlVar.s();
        tlVar.z(this.y, 0, 1);
        byte b2 = this.y[0];
        if ((b2 & 131) <= 0) {
            return c5((b2 >> 3) & 15);
        }
        throw ne.y("Invalid padding bits for frame header " + ((int) b2), null);
    }

    public final fh s(long j2, boolean z2) {
        return new v(j2, this.f10006s, fb(this.f10000c5, 20000L), this.f10000c5, z2);
    }

    public final boolean t(int i) {
        if (this.f10012zn && (i < 10 || i > 13)) {
            return true;
        }
        return false;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        gv();
        if (tlVar.getPosition() == 0 && !mt(tlVar)) {
            throw ne.y("Could not find AMR header.", null);
        }
        wz();
        int co2 = co(tlVar);
        xc(tlVar.getLength(), co2);
        return co2;
    }

    public final void wz() {
        String str;
        int i;
        if (!this.f10011xc) {
            this.f10011xc = true;
            boolean z2 = this.f10012zn;
            if (z2) {
                str = "audio/amr-wb";
            } else {
                str = "audio/3gpp";
            }
            if (z2) {
                i = 16000;
            } else {
                i = 8000;
            }
            this.f10008tl.v(new m.n3().o4(str).f7(f9996r).a8(1).rs(i).z6());
        }
    }

    public final void xc(long j2, int i) {
        int i5;
        boolean z2;
        if (this.f10002fb) {
            return;
        }
        int i6 = this.f10005n3;
        if ((i6 & 1) != 0 && j2 != -1 && ((i5 = this.f10000c5) == -1 || i5 == this.f10009v)) {
            if (this.f10004i9 >= 20 || i == -1) {
                if ((i6 & 2) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fh s2 = s(j2, z2);
                this.f10010wz = s2;
                this.f10007t.t(s2);
                this.f10002fb = true;
                return;
            }
            return;
        }
        fh.n3 n3Var = new fh.n3(-9223372036854775807L);
        this.f10010wz = n3Var;
        this.f10007t.t(n3Var);
        this.f10002fb = true;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f10003gv = 0L;
        this.f10009v = 0;
        this.f9999a = 0;
        if (j2 != 0) {
            fh fhVar = this.f10010wz;
            if (fhVar instanceof v) {
                this.f10001f = ((v) fhVar).zn(j2);
                return;
            }
        }
        this.f10001f = 0L;
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f10007t = wzVar;
        this.f10008tl = wzVar.a(0, 1);
        wzVar.xc();
    }

    public n3(int i) {
        this.f10005n3 = (i & 2) != 0 ? i | 1 : i;
        this.y = new byte[1];
        this.f10000c5 = -1;
    }

    @Override // e4.t
    public void release() {
    }
}
