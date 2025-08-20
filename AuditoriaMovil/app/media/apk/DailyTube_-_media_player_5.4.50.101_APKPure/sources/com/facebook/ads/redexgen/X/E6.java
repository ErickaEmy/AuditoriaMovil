package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
/* loaded from: assets/audience_network.dex */
public class E6 implements Runnable {
    public final /* synthetic */ E7 A00;
    public final /* synthetic */ DownloadAction[] A01;

    public E6(E7 e72, DownloadAction[] downloadActionArr) {
        this.A00 = e72;
        this.A01 = downloadActionArr;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x0091 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            boolean r0 = com.facebook.ads.redexgen.X.KL.A02(r7)
            if (r0 == 0) goto L7
            return
        L7:
            r3 = r7
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            boolean r0 = com.facebook.ads.redexgen.X.EG.A0L(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r0 == 0) goto L13
            return
        L13:
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r1 = com.facebook.ads.redexgen.X.EG.A06(r0)     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb2
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r1 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r1 = com.facebook.ads.redexgen.X.EG.A06(r1)     // Catch: java.lang.Throwable -> Lb2
            r1.clear()     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction[] r6 = r3.A01     // Catch: java.lang.Throwable -> Lb2
            int r5 = r6.length     // Catch: java.lang.Throwable -> Lb2
            r4 = 0
        L2f:
            if (r4 >= r5) goto L3d
            r2 = r6[r4]     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r1 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG.A03(r1, r2)     // Catch: java.lang.Throwable -> Lb2
            int r4 = r4 + 1
            goto L2f
        L3d:
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r2 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            r1 = 1
            com.facebook.ads.redexgen.X.EG.A0M(r2, r1)     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r1 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.concurrent.CopyOnWriteArraySet r1 = com.facebook.ads.redexgen.X.EG.A07(r1)     // Catch: java.lang.Throwable -> Lb2
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> Lb2
        L51:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto L65
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E9 r2 = (com.facebook.ads.redexgen.X.E9) r2     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r1 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            r2.ABk(r1)     // Catch: java.lang.Throwable -> Lb2
            goto L51
        L65:
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb2
            if (r1 != 0) goto L7d
            com.facebook.ads.redexgen.X.E7 r1 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r1 = r1.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r1 = com.facebook.ads.redexgen.X.EG.A06(r1)     // Catch: java.lang.Throwable -> Lb2
            r1.addAll(r0)     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG.A0F(r0)     // Catch: java.lang.Throwable -> Lb2
        L7d:
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG.A0G(r0)     // Catch: java.lang.Throwable -> Lb2
            r2 = 0
        L85:
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r0 = com.facebook.ads.redexgen.X.EG.A06(r0)     // Catch: java.lang.Throwable -> Lb2
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lb2
            if (r2 >= r0) goto Lb1
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            java.util.ArrayList r0 = com.facebook.ads.redexgen.X.EG.A06(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Object r1 = r0.get(r2)     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.ED r1 = (com.facebook.ads.redexgen.X.ED) r1     // Catch: java.lang.Throwable -> Lb2
            int r0 = com.facebook.ads.redexgen.X.ED.A03(r1)     // Catch: java.lang.Throwable -> Lb2
            if (r0 != 0) goto Lae
            com.facebook.ads.redexgen.X.E7 r0 = r3.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG r0 = r0.A00     // Catch: java.lang.Throwable -> Lb2
            com.facebook.ads.redexgen.X.EG.A0H(r0, r1)     // Catch: java.lang.Throwable -> Lb2
        Lae:
            int r2 = r2 + 1
            goto L85
        Lb1:
            return
        Lb2:
            r0 = move-exception
            com.facebook.ads.redexgen.X.KL.A00(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E6.run():void");
    }
}
