package x1;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import d9.ud;
import e4.d0;
import e4.f;
import e4.f3;
import e4.mt;
import e4.n;
import e4.p;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import ho.n3;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import m1.m;
import v5.j5;
import v5.rz;
import x1.fb;
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: r  reason: collision with root package name */
    public static final mt f14882r = new mt() { // from class: x1.gv
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] xc2;
            xc2 = a.xc();
            return xc2;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: x4  reason: collision with root package name */
    public static final n3.y f14883x4 = new n3.y() { // from class: x1.v
        @Override // ho.n3.y
        public final boolean evaluate(int i, int i5, int i6, int i8, int i10) {
            boolean w4;
            w4 = a.w(i, i5, i6, i8, i10);
            return w4;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final n f14884a;

    /* renamed from: c5  reason: collision with root package name */
    public ta f14885c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f14886co;

    /* renamed from: f  reason: collision with root package name */
    public int f14887f;

    /* renamed from: fb  reason: collision with root package name */
    public final ta f14888fb;

    /* renamed from: gv  reason: collision with root package name */
    public final ud.y f14889gv;

    /* renamed from: i9  reason: collision with root package name */
    public ta f14890i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f14891mt;

    /* renamed from: n3  reason: collision with root package name */
    public final long f14892n3;

    /* renamed from: p  reason: collision with root package name */
    public fb f14893p;

    /* renamed from: s  reason: collision with root package name */
    public wz f14894s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public Metadata f14895t;

    /* renamed from: tl  reason: collision with root package name */
    public long f14896tl;

    /* renamed from: v  reason: collision with root package name */
    public final f3 f14897v;

    /* renamed from: w  reason: collision with root package name */
    public int f14898w;

    /* renamed from: wz  reason: collision with root package name */
    public long f14899wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f14900xc;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public long f14901z;

    /* renamed from: zn  reason: collision with root package name */
    public final rz f14902zn;

    public a() {
        this(0);
    }

    private void fb() {
        v5.y.c5(this.f14885c5);
        j5.i9(this.f14894s);
    }

    @Nullable
    public static zn p(@Nullable Metadata metadata, long j2) {
        if (metadata != null) {
            int v2 = metadata.v();
            for (int i = 0; i < v2; i++) {
                Metadata.Entry gv2 = metadata.gv(i);
                if (gv2 instanceof MlltFrame) {
                    return zn.y(j2, (MlltFrame) gv2, t(metadata));
                }
            }
            return null;
        }
        return null;
    }

    private int r(tl tlVar) throws IOException {
        ud.y yVar;
        if (this.f14898w == 0) {
            tlVar.s();
            if (co(tlVar)) {
                return -1;
            }
            this.f14902zn.oz(0);
            int p2 = this.f14902zn.p();
            if (wz(p2, this.f14887f) && ud.i9(p2) != -1) {
                this.f14889gv.y(p2);
                if (this.f14896tl == -9223372036854775807L) {
                    this.f14896tl = this.f14893p.n3(tlVar.getPosition());
                    if (this.f14892n3 != -9223372036854775807L) {
                        this.f14896tl += this.f14892n3 - this.f14893p.n3(0L);
                    }
                }
                this.f14898w = this.f14889gv.f7198zn;
                fb fbVar = this.f14893p;
                if (fbVar instanceof n3) {
                    n3 n3Var = (n3) fbVar;
                    n3Var.zn(c5(this.f14899wz + yVar.f7194fb), tlVar.getPosition() + this.f14889gv.f7198zn);
                    if (this.f14886co && n3Var.y(this.f14901z)) {
                        this.f14886co = false;
                        this.f14890i9 = this.f14885c5;
                    }
                }
            } else {
                tlVar.p(1);
                this.f14887f = 0;
                return 0;
            }
        }
        int n32 = this.f14890i9.n3(tlVar, this.f14898w, true);
        if (n32 == -1) {
            return -1;
        }
        int i = this.f14898w - n32;
        this.f14898w = i;
        if (i > 0) {
            return 0;
        }
        this.f14890i9.gv(c5(this.f14899wz), 1, this.f14889gv.f7198zn, 0, null);
        this.f14899wz += this.f14889gv.f7194fb;
        this.f14898w = 0;
        return 0;
    }

    public static long t(@Nullable Metadata metadata) {
        if (metadata != null) {
            int v2 = metadata.v();
            for (int i = 0; i < v2; i++) {
                Metadata.Entry gv2 = metadata.gv(i);
                if (gv2 instanceof TextInformationFrame) {
                    TextInformationFrame textInformationFrame = (TextInformationFrame) gv2;
                    if (textInformationFrame.y.equals("TLEN")) {
                        return j5.xb(Long.parseLong(textInformationFrame.f4276s.get(0)));
                    }
                }
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    public static int tl(rz rzVar, int i) {
        if (rzVar.fb() >= i + 4) {
            rzVar.oz(i);
            int p2 = rzVar.p();
            if (p2 == 1483304551 || p2 == 1231971951) {
                return p2;
            }
        }
        if (rzVar.fb() >= 40) {
            rzVar.oz(36);
            if (rzVar.p() == 1447187017) {
                return 1447187017;
            }
            return 0;
        }
        return 0;
    }

    public static /* synthetic */ boolean w(int i, int i5, int i6, int i8, int i10) {
        if ((i5 == 67 && i6 == 79 && i8 == 77 && (i10 == 77 || i == 2)) || (i5 == 77 && i6 == 76 && i8 == 76 && (i10 == 84 || i == 2))) {
            return true;
        }
        return false;
    }

    public static boolean wz(int i, long j2) {
        if ((i & (-128000)) == (j2 & (-128000))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] xc() {
        return new t[]{new a()};
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        return x4(tlVar, true);
    }

    public final long c5(long j2) {
        return this.f14896tl + ((j2 * 1000000) / this.f14889gv.f7195gv);
    }

    public final boolean co(tl tlVar) throws IOException {
        fb fbVar = this.f14893p;
        if (fbVar != null) {
            long fb2 = fbVar.fb();
            if (fb2 != -1 && tlVar.t() > fb2 - 4) {
                return true;
            }
        }
        try {
            return !tlVar.v(this.f14902zn.v(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final fb f(tl tlVar, boolean z2) throws IOException {
        tlVar.z(this.f14902zn.v(), 0, 4);
        this.f14902zn.oz(0);
        this.f14889gv.y(this.f14902zn.p());
        return new y(tlVar.getLength(), tlVar.getPosition(), this.f14889gv, z2);
    }

    public void i9() {
        this.f14891mt = true;
    }

    @Nullable
    public final fb mt(tl tlVar) throws IOException {
        int i;
        rz rzVar = new rz(this.f14889gv.f7198zn);
        tlVar.z(rzVar.v(), 0, this.f14889gv.f7198zn);
        ud.y yVar = this.f14889gv;
        if ((yVar.y & 1) != 0) {
            if (yVar.f7197v != 1) {
                i = 36;
            }
            i = 21;
        } else {
            if (yVar.f7197v == 1) {
                i = 13;
            }
            i = 21;
        }
        int tl2 = tl(rzVar, i);
        if (tl2 != 1483304551 && tl2 != 1231971951) {
            if (tl2 == 1447187017) {
                s y = s.y(tlVar.getLength(), tlVar.getPosition(), this.f14889gv, rzVar);
                tlVar.p(this.f14889gv.f7198zn);
                return y;
            }
            tlVar.s();
            return null;
        }
        c5 y2 = c5.y(tlVar.getLength(), tlVar.getPosition(), this.f14889gv, rzVar);
        if (y2 != null && !this.f14897v.y()) {
            tlVar.s();
            tlVar.wz(i + 141);
            tlVar.z(this.f14902zn.v(), 0, 3);
            this.f14902zn.oz(0);
            this.f14897v.gv(this.f14902zn.x());
        }
        tlVar.p(this.f14889gv.f7198zn);
        if (y2 != null && !y2.s() && tl2 == 1231971951) {
            return f(tlVar, false);
        }
        return y2;
    }

    public final fb s(tl tlVar) throws IOException {
        long t2;
        long j2;
        fb mt2 = mt(tlVar);
        zn p2 = p(this.f14895t, tlVar.getPosition());
        if (this.f14891mt) {
            return new fb.y();
        }
        if ((this.y & 4) != 0) {
            if (p2 != null) {
                t2 = p2.c5();
                j2 = p2.fb();
            } else if (mt2 != null) {
                t2 = mt2.c5();
                j2 = mt2.fb();
            } else {
                t2 = t(this.f14895t);
                j2 = -1;
            }
            mt2 = new n3(t2, tlVar.getPosition(), j2);
        } else if (p2 != null) {
            mt2 = p2;
        } else if (mt2 == null) {
            mt2 = null;
        }
        boolean z2 = true;
        if (mt2 == null || (!mt2.s() && (this.y & 1) != 0)) {
            if ((this.y & 2) == 0) {
                z2 = false;
            }
            return f(tlVar, z2);
        }
        return mt2;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        fb();
        int z2 = z(tlVar);
        if (z2 == -1 && (this.f14893p instanceof n3)) {
            long c52 = c5(this.f14899wz);
            if (this.f14893p.c5() != c52) {
                ((n3) this.f14893p).v(c52);
                this.f14894s.t(this.f14893p);
            }
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
        if (r13 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009c, code lost:
        r12.p(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a1, code lost:
        r12.s();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
        r11.f14887f = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x4(e4.tl r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            if (r13 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r12.s()
            long r1 = r12.getPosition()
            r3 = 0
            r5 = 0
            r6 = 0
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L3e
            int r1 = r11.y
            r1 = r1 & 8
            if (r1 != 0) goto L1f
            r1 = r5
            goto L21
        L1f:
            ho.n3$y r1 = x1.a.f14883x4
        L21:
            e4.n r2 = r11.f14884a
            com.google.android.exoplayer2.metadata.Metadata r1 = r2.y(r12, r1)
            r11.f14895t = r1
            if (r1 == 0) goto L30
            e4.f3 r2 = r11.f14897v
            r2.zn(r1)
        L30:
            long r1 = r12.t()
            int r2 = (int) r1
            if (r13 != 0) goto L3a
            r12.p(r2)
        L3a:
            r1 = 0
        L3b:
            r3 = 0
            r4 = 0
            goto L41
        L3e:
            r1 = 0
            r2 = 0
            goto L3b
        L41:
            boolean r7 = r11.co(r12)
            r8 = 1
            if (r7 == 0) goto L51
            if (r3 <= 0) goto L4b
            goto L9a
        L4b:
            java.io.EOFException r12 = new java.io.EOFException
            r12.<init>()
            throw r12
        L51:
            v5.rz r7 = r11.f14902zn
            r7.oz(r6)
            v5.rz r7 = r11.f14902zn
            int r7 = r7.p()
            if (r1 == 0) goto L65
            long r9 = (long) r1
            boolean r9 = wz(r7, r9)
            if (r9 == 0) goto L6c
        L65:
            int r9 = d9.ud.i9(r7)
            r10 = -1
            if (r9 != r10) goto L8c
        L6c:
            int r1 = r4 + 1
            if (r4 != r0) goto L7a
            if (r13 == 0) goto L73
            return r6
        L73:
            java.lang.String r12 = "Searched too many bytes."
            m1.ne r12 = m1.ne.y(r12, r5)
            throw r12
        L7a:
            if (r13 == 0) goto L85
            r12.s()
            int r3 = r2 + r1
            r12.wz(r3)
            goto L88
        L85:
            r12.p(r8)
        L88:
            r4 = r1
            r1 = 0
            r3 = 0
            goto L41
        L8c:
            int r3 = r3 + 1
            if (r3 != r8) goto L97
            d9.ud$y r1 = r11.f14889gv
            r1.y(r7)
            r1 = r7
            goto La7
        L97:
            r7 = 4
            if (r3 != r7) goto La7
        L9a:
            if (r13 == 0) goto La1
            int r2 = r2 + r4
            r12.p(r2)
            goto La4
        La1:
            r12.s()
        La4:
            r11.f14887f = r1
            return r8
        La7:
            int r9 = r9 + (-4)
            r12.wz(r9)
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.a.x4(e4.tl, boolean):boolean");
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f14887f = 0;
        this.f14896tl = -9223372036854775807L;
        this.f14899wz = 0L;
        this.f14898w = 0;
        this.f14901z = j4;
        fb fbVar = this.f14893p;
        if ((fbVar instanceof n3) && !((n3) fbVar).y(j4)) {
            this.f14886co = true;
            this.f14890i9 = this.f14888fb;
        }
    }

    public final int z(tl tlVar) throws IOException {
        Metadata metadata;
        if (this.f14887f == 0) {
            try {
                x4(tlVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f14893p == null) {
            fb s2 = s(tlVar);
            this.f14893p = s2;
            this.f14894s.t(s2);
            ta taVar = this.f14890i9;
            m.n3 j52 = new m.n3().o4(this.f14889gv.f7196n3).f7(4096).a8(this.f14889gv.f7197v).rs(this.f14889gv.f7195gv).hw(this.f14897v.y).j5(this.f14897v.f7502n3);
            if ((this.y & 8) != 0) {
                metadata = null;
            } else {
                metadata = this.f14895t;
            }
            taVar.v(j52.en(metadata).z6());
            this.f14900xc = tlVar.getPosition();
        } else if (this.f14900xc != 0) {
            long position = tlVar.getPosition();
            long j2 = this.f14900xc;
            if (position < j2) {
                tlVar.p((int) (j2 - position));
            }
        }
        return r(tlVar);
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f14894s = wzVar;
        ta a2 = wzVar.a(0, 1);
        this.f14885c5 = a2;
        this.f14890i9 = a2;
        this.f14894s.xc();
    }

    public a(int i) {
        this(i, -9223372036854775807L);
    }

    public a(int i, long j2) {
        this.y = (i & 2) != 0 ? i | 1 : i;
        this.f14892n3 = j2;
        this.f14902zn = new rz(10);
        this.f14889gv = new ud.y();
        this.f14897v = new f3();
        this.f14896tl = -9223372036854775807L;
        this.f14884a = new n();
        f fVar = new f();
        this.f14888fb = fVar;
        this.f14890i9 = fVar;
    }

    @Override // e4.t
    public void release() {
    }
}
