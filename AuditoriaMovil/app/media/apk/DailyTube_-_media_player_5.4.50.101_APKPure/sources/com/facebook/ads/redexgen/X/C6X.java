package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
/* renamed from: com.facebook.ads.redexgen.X.6X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6X implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C04216c A01;

    public C6X(C04216c c04216c, C6Y c6y) {
        this.A01 = c04216c;
        new Handler(Looper.getMainLooper()).post(new C1119Yq(this, c04216c, c6y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00 */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C6Y c6y) {
        C04447f c04447f;
        C04447f c04447f2;
        long currentTimeMillis = System.currentTimeMillis();
        c04447f = this.A01.A04;
        R0 A05 = R0.A05(c04447f.A01());
        Uri A00 = AbstractC0767Ky.A00(c6y.A08);
        long j2 = c6y.A00;
        if (j2 == -1) {
            c04447f2 = this.A01.A04;
            j2 = C0705Ih.A0O(c04447f2);
        }
        A05.A0G(A00, new C1118Yp(this, c6y, j2, currentTimeMillis), j2);
    }
}
