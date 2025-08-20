package y3;

import android.net.Uri;
import e4.fh;
import java.io.IOException;
import java.util.Map;
import y3.ud;
/* loaded from: classes.dex */
public final class n3 implements e4.t {

    /* renamed from: gv  reason: collision with root package name */
    public static final e4.mt f15096gv = new e4.mt() { // from class: y3.y
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] gv2;
            gv2 = n3.gv();
            return gv2;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15098zn;
    public final zn y = new zn();

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f15097n3 = new v5.rz(2786);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e4.t[] gv() {
        return new e4.t[]{new n3()};
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        r8.s();
        r4 = r4 + 1;
     */
    @Override // e4.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(e4.tl r8) throws java.io.IOException {
        /*
            r7 = this;
            v5.rz r0 = new v5.rz
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.v()
            r8.z(r4, r2, r1)
            r0.oz(r2)
            int r4 = r0.x()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.s()
            r8.wz(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.v()
            r6 = 6
            r8.z(r5, r2, r6)
            r0.oz(r2)
            int r5 = r0.yt()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.s()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.wz(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.v()
            int r5 = d9.n3.fb(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.wz(r5)
            goto L24
        L5f:
            r4 = 3
            r0.ut(r4)
            int r4 = r0.z6()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.wz(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.n3.a(e4.tl):boolean");
    }

    @Override // e4.t
    public int v(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        int read = tlVar.read(this.f15097n3.v(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f15097n3.oz(0);
        this.f15097n3.j(read);
        if (!this.f15098zn) {
            this.y.a(0L, 4);
            this.f15098zn = true;
        }
        this.y.n3(this.f15097n3);
        return 0;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f15098zn = false;
        this.y.zn();
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.y.v(wzVar, new ud.gv(0, 1));
        wzVar.xc();
        wzVar.t(new fh.n3(-9223372036854775807L));
    }

    @Override // e4.t
    public void release() {
    }
}
