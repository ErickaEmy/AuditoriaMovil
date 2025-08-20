package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class W1 implements InterfaceC0662Gp, HG<Object> {
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public final Handler A06;
    public final InterfaceC0661Go A07;
    public final InterfaceC0675Hd A08;
    public final IA A09;

    public W1() {
        this(null, null, 1000000L, 2000, InterfaceC0675Hd.A00);
    }

    public W1(Handler handler, InterfaceC0661Go interfaceC0661Go, long j2, int i, InterfaceC0675Hd interfaceC0675Hd) {
        this.A06 = handler;
        this.A07 = interfaceC0661Go;
        this.A09 = new IA(i);
        this.A08 = interfaceC0675Hd;
        this.A01 = j2;
    }

    private void A01(int i, long j2, long j4) {
        Handler handler = this.A06;
        if (handler != null && this.A07 != null) {
            handler.post(new Gz(this, i, j2, j4));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0662Gp
    public final synchronized long A67() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HG
    public final synchronized void AB1(Object obj, int i) {
        this.A02 += i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r16.A04 >= 524288) goto L13;
     */
    @Override // com.facebook.ads.redexgen.X.HG
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void ADO(java.lang.Object r17) {
        /*
            r16 = this;
            r4 = r16
            monitor-enter(r4)
            int r0 = r4.A00     // Catch: java.lang.Throwable -> L6c
            r9 = 1
            if (r0 <= 0) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            com.facebook.ads.redexgen.X.AbstractC0672Ha.A04(r0)     // Catch: java.lang.Throwable -> L6c
            com.facebook.ads.redexgen.X.Hd r0 = r4.A08     // Catch: java.lang.Throwable -> L6c
            long r2 = r0.A5T()     // Catch: java.lang.Throwable -> L6c
            long r5 = r4.A03     // Catch: java.lang.Throwable -> L6c
            long r0 = r2 - r5
            int r11 = (int) r0     // Catch: java.lang.Throwable -> L6c
            long r5 = r4.A05     // Catch: java.lang.Throwable -> L6c
            long r0 = (long) r11     // Catch: java.lang.Throwable -> L6c
            long r5 = r5 + r0
            r4.A05 = r5     // Catch: java.lang.Throwable -> L6c
            long r0 = r4.A04     // Catch: java.lang.Throwable -> L6c
            long r5 = r4.A02     // Catch: java.lang.Throwable -> L6c
            long r0 = r0 + r5
            r4.A04 = r0     // Catch: java.lang.Throwable -> L6c
            if (r11 <= 0) goto L55
            r0 = 8000(0x1f40, double:3.9525E-320)
            long r0 = r0 * r5
            long r7 = (long) r11     // Catch: java.lang.Throwable -> L6c
            long r0 = r0 / r7
            float r8 = (float) r0     // Catch: java.lang.Throwable -> L6c
            com.facebook.ads.redexgen.X.IA r7 = r4.A09     // Catch: java.lang.Throwable -> L6c
            double r0 = (double) r5     // Catch: java.lang.Throwable -> L6c
            double r5 = java.lang.Math.sqrt(r0)     // Catch: java.lang.Throwable -> L6c
            int r0 = (int) r5     // Catch: java.lang.Throwable -> L6c
            r7.A03(r0, r8)     // Catch: java.lang.Throwable -> L6c
            long r7 = r4.A05     // Catch: java.lang.Throwable -> L6c
            r5 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L4a
            long r7 = r4.A04     // Catch: java.lang.Throwable -> L6c
            r5 = 524288(0x80000, double:2.590327E-318)
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L55
        L4a:
            com.facebook.ads.redexgen.X.IA r1 = r4.A09     // Catch: java.lang.Throwable -> L6c
            r0 = 1056964608(0x3f000000, float:0.5)
            float r0 = r1.A02(r0)     // Catch: java.lang.Throwable -> L6c
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L6c
            r4.A01 = r0     // Catch: java.lang.Throwable -> L6c
        L55:
            long r12 = r4.A02     // Catch: java.lang.Throwable -> L6c
            long r14 = r4.A01     // Catch: java.lang.Throwable -> L6c
            r10 = r4
            r10.A01(r11, r12, r14)     // Catch: java.lang.Throwable -> L6c
            int r0 = r4.A00     // Catch: java.lang.Throwable -> L6c
            int r0 = r0 - r9
            r4.A00 = r0     // Catch: java.lang.Throwable -> L6c
            if (r0 <= 0) goto L66
            r4.A03 = r2     // Catch: java.lang.Throwable -> L6c
        L66:
            r0 = 0
            r4.A02 = r0     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r4)
            return
        L6c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.W1.ADO(java.lang.Object):void");
    }

    @Override // com.facebook.ads.redexgen.X.HG
    public final synchronized void ADP(Object obj, C0671Gy c0671Gy) {
        if (this.A00 == 0) {
            this.A03 = this.A08.A5T();
        }
        this.A00++;
    }
}
