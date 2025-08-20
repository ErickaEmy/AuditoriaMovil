package sc;

import e4.tl;
import java.io.IOException;
import java.util.ArrayDeque;
import m1.ne;
/* loaded from: classes.dex */
public final class y implements zn {

    /* renamed from: a  reason: collision with root package name */
    public int f13638a;

    /* renamed from: fb  reason: collision with root package name */
    public long f13639fb;

    /* renamed from: gv  reason: collision with root package name */
    public sc.n3 f13640gv;

    /* renamed from: v  reason: collision with root package name */
    public int f13642v;
    public final byte[] y = new byte[8];

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayDeque<n3> f13641n3 = new ArrayDeque<>();

    /* renamed from: zn  reason: collision with root package name */
    public final fb f13643zn = new fb();

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final long f13644n3;
        public final int y;

        public n3(int i, long j2) {
            this.y = i;
            this.f13644n3 = j2;
        }
    }

    public static String fb(tl tlVar, int i) throws IOException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        tlVar.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    public final long a(tl tlVar, int i) throws IOException {
        tlVar.readFully(this.y, 0, i);
        long j2 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            j2 = (j2 << 8) | (this.y[i5] & 255);
        }
        return j2;
    }

    public final long gv(tl tlVar) throws IOException {
        tlVar.s();
        while (true) {
            tlVar.z(this.y, 0, 4);
            int zn2 = fb.zn(this.y[0]);
            if (zn2 != -1 && zn2 <= 4) {
                int y = (int) fb.y(this.y, zn2, false);
                if (this.f13640gv.a(y)) {
                    tlVar.p(zn2);
                    return y;
                }
            }
            tlVar.p(1);
        }
    }

    @Override // sc.zn
    public boolean n3(tl tlVar) throws IOException {
        v5.y.c5(this.f13640gv);
        while (true) {
            n3 peek = this.f13641n3.peek();
            if (peek != null && tlVar.getPosition() >= peek.f13644n3) {
                this.f13640gv.y(this.f13641n3.pop().y);
                return true;
            }
            if (this.f13642v == 0) {
                long gv2 = this.f13643zn.gv(tlVar, true, false, 4);
                if (gv2 == -2) {
                    gv2 = gv(tlVar);
                }
                if (gv2 == -1) {
                    return false;
                }
                this.f13638a = (int) gv2;
                this.f13642v = 1;
            }
            if (this.f13642v == 1) {
                this.f13639fb = this.f13643zn.gv(tlVar, false, true, 8);
                this.f13642v = 2;
            }
            int v2 = this.f13640gv.v(this.f13638a);
            if (v2 != 0) {
                if (v2 != 1) {
                    if (v2 != 2) {
                        if (v2 != 3) {
                            if (v2 != 4) {
                                if (v2 == 5) {
                                    long j2 = this.f13639fb;
                                    if (j2 != 4 && j2 != 8) {
                                        throw ne.y("Invalid float size: " + this.f13639fb, null);
                                    }
                                    this.f13640gv.n3(this.f13638a, v(tlVar, (int) j2));
                                    this.f13642v = 0;
                                    return true;
                                }
                                throw ne.y("Invalid element type " + v2, null);
                            }
                            this.f13640gv.zn(this.f13638a, (int) this.f13639fb, tlVar);
                            this.f13642v = 0;
                            return true;
                        }
                        long j4 = this.f13639fb;
                        if (j4 <= 2147483647L) {
                            this.f13640gv.fb(this.f13638a, fb(tlVar, (int) j4));
                            this.f13642v = 0;
                            return true;
                        }
                        throw ne.y("String element size: " + this.f13639fb, null);
                    }
                    long j6 = this.f13639fb;
                    if (j6 <= 8) {
                        this.f13640gv.gv(this.f13638a, a(tlVar, (int) j6));
                        this.f13642v = 0;
                        return true;
                    }
                    throw ne.y("Invalid integer size: " + this.f13639fb, null);
                }
                long position = tlVar.getPosition();
                this.f13641n3.push(new n3(this.f13638a, this.f13639fb + position));
                this.f13640gv.s(this.f13638a, position, this.f13639fb);
                this.f13642v = 0;
                return true;
            }
            tlVar.p((int) this.f13639fb);
            this.f13642v = 0;
        }
    }

    public final double v(tl tlVar, int i) throws IOException {
        long a2 = a(tlVar, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) a2);
        }
        return Double.longBitsToDouble(a2);
    }

    @Override // sc.zn
    public void y() {
        this.f13642v = 0;
        this.f13641n3.clear();
        this.f13643zn.v();
    }

    @Override // sc.zn
    public void zn(sc.n3 n3Var) {
        this.f13640gv = n3Var;
    }
}
