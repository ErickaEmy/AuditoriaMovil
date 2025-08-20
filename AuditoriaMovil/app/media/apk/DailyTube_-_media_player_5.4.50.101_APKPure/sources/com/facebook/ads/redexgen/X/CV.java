package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
/* loaded from: assets/audience_network.dex */
public final class CV {
    public static String[] A0A = {"VV6EzFzDFGyxh7278LhkWh1nAnO", "a", "RIeoUtwh2k0Lp", "KiUc8yTTjWF6Y9v", "6tIA8m5WM2YSgVpCAFtgKZOFEkm", "A00z45", "ej2X1eDppCFfwh6aI5B812e88v7VHLnd", "obdd9bh"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public CP A04;
    public C0563Ce A05;
    public final C4 A06;
    public final C0565Cg A07 = new C0565Cg();
    public final C0697Hz A09 = new C0697Hz(1);
    public final C0697Hz A08 = new C0697Hz();

    public CV(C4 c4) {
        this.A06 = c4;
    }

    private C0564Cf A00() {
        int i = this.A07.A07.A02;
        if (this.A07.A08 != null) {
            C0565Cg c0565Cg = this.A07;
            if (A0A[2].length() != 16) {
                A0A[2] = "yH";
                return c0565Cg.A08;
            }
            throw new RuntimeException();
        }
        return this.A05.A00(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (!this.A07.A0A) {
            return;
        }
        C0697Hz c0697Hz = this.A07.A09;
        C0564Cf encryptionBox = A00();
        if (encryptionBox.A00 != 0) {
            c0697Hz.A0Z(encryptionBox.A00);
        }
        if (this.A07.A0H[this.A01]) {
            c0697Hz.A0Z(c0697Hz.A0I() * 6);
        }
    }

    public final int A03() {
        C0697Hz c0697Hz;
        int vectorSize;
        if (this.A07.A0A) {
            C0564Cf A00 = A00();
            if (A0A[5].length() != 6) {
                throw new RuntimeException();
            }
            A0A[1] = "c";
            if (A00.A00 != 0) {
                c0697Hz = this.A07.A09;
                vectorSize = A00.A00;
            } else {
                byte[] initVectorData = A00.A04;
                this.A08.A0b(initVectorData, initVectorData.length);
                c0697Hz = this.A08;
                vectorSize = initVectorData.length;
            }
            boolean z2 = this.A07.A0H[this.A01];
            this.A09.A00[0] = (byte) ((z2 ? NotificationCompat.FLAG_HIGH_PRIORITY : 0) | vectorSize);
            this.A09.A0Y(0);
            C4 c4 = this.A06;
            C0697Hz initializationVectorData = this.A09;
            c4.AFR(initializationVectorData, 1);
            this.A06.AFR(c0697Hz, vectorSize);
            if (!z2) {
                return vectorSize + 1;
            }
            C0697Hz c0697Hz2 = this.A07.A09;
            int A0I = c0697Hz2.A0I();
            c0697Hz2.A0Z(-2);
            int i = (A0I * 6) + 2;
            this.A06.AFR(c0697Hz2, i);
            return vectorSize + 1 + i;
        }
        return 0;
    }

    public final void A04() {
        this.A07.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A05(long j2) {
        long A01 = C9W.A01(j2);
        for (int i = this.A01; i < this.A07.A00 && this.A07.A00(i) < A01; i++) {
            if (this.A07.A0I[i]) {
                this.A03 = i;
            }
        }
    }

    public final void A06(DrmInitData drmInitData) {
        C0564Cf encryptionBox = this.A05.A00(this.A07.A07.A02);
        this.A06.A5n(this.A05.A07.A0I(drmInitData.A02(encryptionBox != null ? encryptionBox.A02 : null)));
    }

    public final void A07(C0563Ce c0563Ce, CP cp) {
        this.A05 = (C0563Ce) AbstractC0672Ha.A01(c0563Ce);
        this.A04 = (CP) AbstractC0672Ha.A01(cp);
        this.A06.A5n(c0563Ce.A07);
        A04();
    }

    public final boolean A08() {
        this.A01++;
        int i = this.A00 + 1;
        this.A00 = i;
        int[] iArr = this.A07.A0E;
        int i5 = this.A02;
        if (i == iArr[i5]) {
            this.A02 = i5 + 1;
            this.A00 = 0;
            return false;
        }
        return true;
    }
}
