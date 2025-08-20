package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class WT implements H8 {
    public static String[] A0C = {"G7jWD6ulf4YNSZyKFTHtDKYEexnehBFD", "eAcypqsPfTTSG9tYkNPVa4Ur1OSgM6nM", "x", "tNQG44GENbPBCr6MlCIr3t4n4NF0MmxZ", "OwErIGDXAeY1H11Nt9UmuNZTMubue4sT", "f", "eBkibdjxFKT4WmP6H51EPZ9055c0bCkp", "0Ce9TygyYiJS1KV85oyrWWiGz76nCu"};
    public long A00;
    public long A02;
    public C0671Gy A03;
    public final Uri A05;
    public final C0608Ek A07;
    public final InterfaceC0667Gu A08;
    public final C0678Hg A09;
    public volatile boolean A0A;
    public final /* synthetic */ CD A0B;
    public final C0559Bz A06 = new C0559Bz();
    public boolean A04 = true;
    public long A01 = -1;

    public WT(CD cd, Uri uri, InterfaceC0667Gu interfaceC0667Gu, C0608Ek c0608Ek, C0678Hg c0678Hg) {
        this.A0B = cd;
        this.A05 = (Uri) AbstractC0672Ha.A01(uri);
        this.A08 = (InterfaceC0667Gu) AbstractC0672Ha.A01(interfaceC0667Gu);
        this.A07 = (C0608Ek) AbstractC0672Ha.A01(c0608Ek);
        this.A09 = c0678Hg;
    }

    public final void A04(long j2, long j4) {
        this.A06.A00 = j2;
        this.A02 = j4;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final void A4A() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final void A9P() throws IOException, InterruptedException {
        char charAt;
        char charAt2;
        C1090Xn c1090Xn;
        int result = 0;
        while (result == 0 && !this.A0A) {
            try {
                long j2 = this.A06.A00;
                C0671Gy c0671Gy = new C0671Gy(this.A05, j2, -1L, CD.A08(this.A0B));
                this.A03 = c0671Gy;
                long ADl = this.A08.ADl(c0671Gy);
                this.A01 = ADl;
                if (ADl != -1) {
                    this.A01 = ADl + j2;
                }
                c1090Xn = new C1090Xn(this.A08, j2, this.A01);
                InterfaceC0554Bs extractor = this.A07.A02(c1090Xn, this.A08.A8E());
                if (this.A04) {
                    extractor.AFh(j2, this.A02);
                    this.A04 = false;
                }
                while (result == 0 && !this.A0A) {
                    this.A09.A00();
                    result = extractor.AEH(c1090Xn, this.A06);
                    if (c1090Xn.A7i() > CD.A03(this.A0B) + j2) {
                        j2 = c1090Xn.A7i();
                        this.A09.A01();
                        CD.A04(this.A0B).post(CD.A06(this.A0B));
                    }
                }
            } finally {
                if (charAt != charAt2) {
                }
                throw new RuntimeException();
            }
            if (result == 1) {
                result = 0;
            } else {
                C0559Bz c0559Bz = this.A06;
                if (A0C[7].length() == 32) {
                    throw new RuntimeException();
                }
                A0C[7] = "RP5F3MQdpmYGlMxTR22UmyqYUd";
                c0559Bz.A00 = c1090Xn.A7i();
                this.A00 = this.A06.A00 - this.A03.A01;
            }
            IF.A0W(this.A08);
        }
    }
}
