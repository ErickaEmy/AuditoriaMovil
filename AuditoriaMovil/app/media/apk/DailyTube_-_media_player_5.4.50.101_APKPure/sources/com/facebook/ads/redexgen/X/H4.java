package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public class H4 extends IOException {
    public final int A00;
    public final C0671Gy A01;

    public H4(IOException iOException, C0671Gy c0671Gy, int i) {
        super(iOException);
        this.A01 = c0671Gy;
        this.A00 = i;
    }

    public H4(String str, C0671Gy c0671Gy, int i) {
        super(str);
        this.A01 = c0671Gy;
        this.A00 = i;
    }

    public H4(String str, IOException iOException, C0671Gy c0671Gy, int i) {
        super(str, iOException);
        this.A01 = c0671Gy;
        this.A00 = i;
    }
}
