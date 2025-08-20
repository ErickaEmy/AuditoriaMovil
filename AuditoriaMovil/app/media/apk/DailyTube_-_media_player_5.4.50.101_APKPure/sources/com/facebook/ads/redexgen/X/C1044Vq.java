package com.facebook.ads.redexgen.X;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* renamed from: com.facebook.ads.redexgen.X.Vq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1044Vq {
    public H7<? extends H8> A00;
    public IOException A01;
    public final ExecutorService A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final <T extends H8> long A04(T t2, H6<T> h62, int i) {
        Looper myLooper = Looper.myLooper();
        AbstractC0672Ha.A04(myLooper != null);
        this.A01 = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new H7(this, myLooper, t2, h62, i, elapsedRealtime).A06(0L);
        return elapsedRealtime;
    }

    public C1044Vq(String str) {
        this.A02 = IF.A0T(str);
    }

    public final void A05() {
        this.A00.A07(false);
    }

    public final void A06(int i) throws IOException {
        IOException iOException = this.A01;
        if (iOException == null) {
            H7<? extends H8> h7 = this.A00;
            if (h7 != null) {
                if (i == Integer.MIN_VALUE) {
                    i = h7.A03;
                }
                h7.A05(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void A07(H9 h9) {
        H7<? extends H8> h7 = this.A00;
        if (h7 != null) {
            h7.A07(true);
        }
        if (h9 != null) {
            this.A02.execute(new HA(h9));
        }
        this.A02.shutdown();
    }

    public final boolean A08() {
        return this.A00 != null;
    }
}
