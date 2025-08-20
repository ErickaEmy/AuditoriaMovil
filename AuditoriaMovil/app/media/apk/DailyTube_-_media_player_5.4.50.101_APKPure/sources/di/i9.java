package di;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public final class i9 {

    /* renamed from: a  reason: collision with root package name */
    public long f7260a;

    /* renamed from: c5  reason: collision with root package name */
    public volatile boolean f7261c5;

    /* renamed from: fb  reason: collision with root package name */
    public long f7262fb;

    /* renamed from: gv  reason: collision with root package name */
    public final String f7263gv;

    /* renamed from: n3  reason: collision with root package name */
    public final di.y f7264n3;

    /* renamed from: s  reason: collision with root package name */
    public long f7265s;

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f7266v;
    public final zn y;

    /* renamed from: zn  reason: collision with root package name */
    public final kx.p f7267zn;

    /* loaded from: classes.dex */
    public interface y {
    }

    public i9(zn znVar, kx.p pVar, @Nullable byte[] bArr, @Nullable y yVar) {
        this.y = znVar;
        this.f7264n3 = znVar.c5();
        this.f7267zn = pVar;
        this.f7266v = bArr == null ? new byte[131072] : bArr;
        this.f7263gv = znVar.mt().buildCacheKey(pVar);
        this.f7260a = pVar.f10071fb;
    }

    public final void a() throws InterruptedIOException {
        if (!this.f7261c5) {
            return;
        }
        throw new InterruptedIOException();
    }

    public final void gv(long j2) {
        if (this.f7262fb == j2) {
            return;
        }
        this.f7262fb = j2;
    }

    public void n3() {
        this.f7261c5 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: IOException -> 0x0068, TryCatch #0 {IOException -> 0x0068, blocks: (B:27:0x0064, B:33:0x006f, B:35:0x007d, B:37:0x0085), top: B:43:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #0 {IOException -> 0x0068, blocks: (B:27:0x0064, B:33:0x006f, B:35:0x007d, B:37:0x0085), top: B:43:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long v(long r10, long r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.f7262fb
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L13
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L11
            goto L13
        L11:
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L36
            kx.p r1 = r9.f7267zn
            kx.p$n3 r1 = r1.y()
            kx.p$n3 r1 = r1.s(r10)
            kx.p$n3 r12 = r1.fb(r12)
            kx.p r12 = r12.y()
            di.zn r13 = r9.y     // Catch: java.io.IOException -> L31
            long r12 = r13.y(r12)     // Catch: java.io.IOException -> L31
            goto L38
        L31:
            di.zn r12 = r9.y
            kx.w.y(r12)
        L36:
            r12 = r6
            r4 = 0
        L38:
            if (r4 != 0) goto L5d
            r9.a()
            kx.p r12 = r9.f7267zn
            kx.p$n3 r12 = r12.y()
            kx.p$n3 r12 = r12.s(r10)
            kx.p$n3 r12 = r12.fb(r6)
            kx.p r12 = r12.y()
            di.zn r13 = r9.y     // Catch: java.io.IOException -> L56
            long r12 = r13.y(r12)     // Catch: java.io.IOException -> L56
            goto L5d
        L56:
            r10 = move-exception
            di.zn r11 = r9.y
            kx.w.y(r11)
            throw r10
        L5d:
            if (r0 == 0) goto L6a
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L6a
            long r12 = r12 + r10
            r9.gv(r12)     // Catch: java.io.IOException -> L68
            goto L6a
        L68:
            r10 = move-exception
            goto L8b
        L6a:
            r12 = 0
            r13 = 0
        L6c:
            r1 = -1
            if (r12 == r1) goto L83
            r9.a()     // Catch: java.io.IOException -> L68
            di.zn r12 = r9.y     // Catch: java.io.IOException -> L68
            byte[] r2 = r9.f7266v     // Catch: java.io.IOException -> L68
            int r3 = r2.length     // Catch: java.io.IOException -> L68
            int r12 = r12.read(r2, r5, r3)     // Catch: java.io.IOException -> L68
            if (r12 == r1) goto L6c
            long r1 = (long) r12     // Catch: java.io.IOException -> L68
            r9.zn(r1)     // Catch: java.io.IOException -> L68
            int r13 = r13 + r12
            goto L6c
        L83:
            if (r0 == 0) goto L91
            long r0 = (long) r13     // Catch: java.io.IOException -> L68
            long r10 = r10 + r0
            r9.gv(r10)     // Catch: java.io.IOException -> L68
            goto L91
        L8b:
            di.zn r11 = r9.y
            kx.w.y(r11)
            throw r10
        L91:
            di.zn r10 = r9.y
            r10.close()
            long r10 = (long) r13
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: di.i9.v(long, long):long");
    }

    public void y() throws IOException {
        long j2;
        a();
        di.y yVar = this.f7264n3;
        String str = this.f7263gv;
        kx.p pVar = this.f7267zn;
        this.f7265s = yVar.gv(str, pVar.f10071fb, pVar.f10075s);
        kx.p pVar2 = this.f7267zn;
        long j4 = pVar2.f10075s;
        if (j4 != -1) {
            this.f7262fb = pVar2.f10071fb + j4;
        } else {
            long y2 = tl.y(this.f7264n3.zn(this.f7263gv));
            if (y2 == -1) {
                y2 = -1;
            }
            this.f7262fb = y2;
        }
        while (true) {
            long j6 = this.f7262fb;
            if (j6 != -1 && this.f7260a >= j6) {
                return;
            }
            a();
            long j7 = this.f7262fb;
            if (j7 == -1) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j7 - this.f7260a;
            }
            long a2 = this.f7264n3.a(this.f7263gv, this.f7260a, j2);
            if (a2 > 0) {
                this.f7260a += a2;
            } else {
                long j8 = -a2;
                if (j8 == Long.MAX_VALUE) {
                    j8 = -1;
                }
                long j9 = this.f7260a;
                this.f7260a = j9 + v(j9, j8);
            }
        }
    }

    public final void zn(long j2) {
        this.f7265s += j2;
    }
}
