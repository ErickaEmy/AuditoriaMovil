package af;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zn implements vl {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public e4.t f470n3;
    public final e4.mt y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public e4.tl f471zn;

    public zn(e4.mt mtVar) {
        this.y = mtVar;
    }

    @Override // af.vl
    public void gv() {
        e4.t tVar = this.f470n3;
        if (tVar instanceof x1.a) {
            ((x1.a) tVar).i9();
        }
    }

    @Override // af.vl
    public int n3(e4.d0 d0Var) throws IOException {
        return ((e4.t) v5.y.v(this.f470n3)).v((e4.tl) v5.y.v(this.f471zn), d0Var);
    }

    @Override // af.vl
    public void release() {
        e4.t tVar = this.f470n3;
        if (tVar != null) {
            tVar.release();
            this.f470n3 = null;
        }
        this.f471zn = null;
    }

    @Override // af.vl
    public long v() {
        e4.tl tlVar = this.f471zn;
        if (tlVar != null) {
            return tlVar.getPosition();
        }
        return -1L;
    }

    @Override // af.vl
    public void y(long j2, long j4) {
        ((e4.t) v5.y.v(this.f470n3)).y(j2, j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r6.getPosition() != r11) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
        if (r6.getPosition() != r11) goto L28;
     */
    @Override // af.vl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zn(kx.c5 r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, e4.wz r15) throws java.io.IOException {
        /*
            r7 = this;
            e4.a r6 = new e4.a
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f471zn = r6
            e4.t r8 = r7.f470n3
            if (r8 == 0) goto L10
            return
        L10:
            e4.mt r8 = r7.y
            e4.t[] r8 = r8.y(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f470n3 = r8
            goto L78
        L20:
            int r10 = r8.length
            r0 = 0
        L22:
            if (r0 >= r10) goto L74
            r1 = r8[r0]
            boolean r2 = r1.a(r6)     // Catch: java.lang.Throwable -> L35 java.io.EOFException -> L37
            if (r2 == 0) goto L39
            r7.f470n3 = r1     // Catch: java.lang.Throwable -> L35 java.io.EOFException -> L37
            v5.y.fb(r14)
            r6.s()
            goto L74
        L35:
            r8 = move-exception
            goto L50
        L37:
            goto L64
        L39:
            e4.t r1 = r7.f470n3
            if (r1 != 0) goto L48
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L46
            goto L48
        L46:
            r1 = 0
            goto L49
        L48:
            r1 = 1
        L49:
            v5.y.fb(r1)
            r6.s()
            goto L71
        L50:
            e4.t r9 = r7.f470n3
            if (r9 != 0) goto L5c
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L5d
        L5c:
            r13 = 1
        L5d:
            v5.y.fb(r13)
            r6.s()
            throw r8
        L64:
            e4.t r1 = r7.f470n3
            if (r1 != 0) goto L48
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L46
            goto L48
        L71:
            int r0 = r0 + 1
            goto L22
        L74:
            e4.t r10 = r7.f470n3
            if (r10 == 0) goto L7e
        L78:
            e4.t r8 = r7.f470n3
            r8.zn(r15)
            return
        L7e:
            af.nf r10 = new af.nf
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = v5.j5.k5(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = v5.y.v(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: af.zn.zn(kx.c5, android.net.Uri, java.util.Map, long, long, e4.wz):void");
    }
}
