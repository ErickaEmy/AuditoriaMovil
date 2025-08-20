package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public final class WX implements EK {
    public static String[] A06 = {"z6XOcFfUlZLiYF0seOLnv3ze9s0DdTB", "", "kOUqzIhQkth8unrmunVXM7OloxceXCp", "vNZflObtCpyDQVnjonlKme7G1XHf5P9t", "ltwdc1Rff3GtcYqOYiouDHeI", "qE08X0G6Jnym0xvk75ZNBZoUEwP5MAza", "Z6LnFft16t74Gtd3ASLNWwB", "zHF"};
    public final C0671Gy A00;
    public final HK A01;
    public final C1038Vk A02;
    public final I3 A04;
    public final HP A03 = new HP();
    public final AtomicBoolean A05 = new AtomicBoolean();

    public WX(Uri uri, String str, EL el) {
        this.A00 = new C0671Gy(uri, 0L, -1L, str, 0);
        this.A01 = el.A02();
        this.A02 = el.A03(false);
        this.A04 = el.A04();
    }

    @Override // com.facebook.ads.redexgen.X.EK
    public final void A5D() throws InterruptedException, IOException {
        this.A04.A00(-1000);
        try {
            HQ.A03(this.A00, this.A01, this.A02, new byte[131072], this.A04, -1000, this.A03, this.A05, true);
        } finally {
            this.A04.A03(-1000);
        }
    }

    @Override // com.facebook.ads.redexgen.X.EK
    public final float A6o() {
        long j2 = this.A03.A01;
        if (j2 == -1) {
            return -1.0f;
        }
        long contentLength = this.A03.A00();
        float f4 = ((float) contentLength) * 100.0f;
        if (A06[3].charAt(18) != 'l') {
            throw new RuntimeException();
        }
        A06[5] = "hhB6jfIM7FzfpB2Im4JpX4ZUe2epnCaG";
        return f4 / ((float) j2);
    }

    @Override // com.facebook.ads.redexgen.X.EK
    public final long A6p() {
        return this.A03.A00();
    }

    @Override // com.facebook.ads.redexgen.X.EK
    public final void cancel() {
        this.A05.set(true);
    }

    @Override // com.facebook.ads.redexgen.X.EK
    public final void remove() {
        HQ.A05(this.A01, HQ.A02(this.A00));
    }
}
