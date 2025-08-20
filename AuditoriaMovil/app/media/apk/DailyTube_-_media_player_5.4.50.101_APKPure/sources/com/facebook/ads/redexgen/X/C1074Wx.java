package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
/* renamed from: com.facebook.ads.redexgen.X.Wx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1074Wx implements InterfaceC0580Cy {
    public static String[] A0C = {"M8nxhoQeDkjHEk3tjnypaUsJeky9pUPe", "22wDV1USJ2tZABUEWkFG7fElxPqoDepQ", "WSXmuBny7XXEQ4s813c9BSbsqOjqSskJ", "KVrLQEQFGtTXAXMopyF5dj", "jUO9kFQXOuNF5MkzWpfFf35Wzr3tp3jj", "UgJN", "fATsZHYNQKGGAXuN", "X77CUtb4yEwh8nH4MH"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C4 A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final By A09;
    public final C0697Hz A0A;
    public final String A0B;

    public C1074Wx() {
        this(null);
    }

    public C1074Wx(String str) {
        this.A02 = 0;
        C0697Hz c0697Hz = new C0697Hz(4);
        this.A0A = c0697Hz;
        c0697Hz.A00[0] = -1;
        this.A09 = new By();
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[LOOP:0: B:3:0x000a->B:16:0x003b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0026 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A00(com.facebook.ads.redexgen.X.C0697Hz r9) {
        /*
            r8 = this;
            byte[] r6 = r9.A00
            int r5 = r9.A06()
            int r7 = r9.A07()
        La:
            if (r5 >= r7) goto L42
            r1 = r6[r5]
            r0 = 255(0xff, float:3.57E-43)
            r1 = r1 & r0
            r4 = 0
            r3 = 1
            if (r1 != r0) goto L40
            r2 = 1
        L16:
            boolean r0 = r8.A08
            if (r0 == 0) goto L3e
            r1 = r6[r5]
            r0 = 224(0xe0, float:3.14E-43)
            r1 = r1 & r0
            if (r1 != r0) goto L3e
            r0 = 1
        L22:
            r8.A08 = r2
            if (r0 == 0) goto L3b
            int r0 = r5 + 1
            r9.A0Y(r0)
            r8.A08 = r4
            com.facebook.ads.redexgen.X.Hz r0 = r8.A0A
            byte[] r1 = r0.A00
            r0 = r6[r5]
            r1[r3] = r0
            r0 = 2
            r8.A00 = r0
            r8.A02 = r3
            return
        L3b:
            int r5 = r5 + 1
            goto La
        L3e:
            r0 = 0
            goto L22
        L40:
            r2 = 0
            goto L16
        L42:
            r9.A0Y(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1074Wx.A00(com.facebook.ads.redexgen.X.Hz):void");
    }

    private void A01(C0697Hz c0697Hz) {
        int min = Math.min(c0697Hz.A04(), this.A01 - this.A00);
        this.A05.AFR(c0697Hz, min);
        int bytesToRead = this.A00 + min;
        this.A00 = bytesToRead;
        int i = this.A01;
        if (bytesToRead < i) {
            return;
        }
        C4 c4 = this.A05;
        if (A0C[2].charAt(7) == 'H') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "Ix3a1KSHqy7cK1t6WtGmlZzK6PY1tVDv";
        strArr[1] = "TW6fubs4zpuEa3cAWqrpZRXJHWdUZhrV";
        c4.AFS(this.A04, 1, i, 0, null);
        this.A04 += this.A03;
        this.A00 = 0;
        this.A02 = 0;
    }

    private void A02(C0697Hz c0697Hz) {
        int min = Math.min(c0697Hz.A04(), 4 - this.A00);
        c0697Hz.A0c(this.A0A.A00, this.A00, min);
        int i = this.A00 + min;
        this.A00 = i;
        if (i < 4) {
            return;
        }
        this.A0A.A0Y(0);
        if (By.A04(this.A0A.A08(), this.A09)) {
            this.A01 = this.A09.A02;
            if (!this.A07) {
                this.A03 = (this.A09.A04 * 1000000) / this.A09.A03;
                this.A05.A5n(Format.A07(this.A06, this.A09.A06, null, -1, 4096, this.A09.A01, this.A09.A03, null, null, 0, this.A0B));
                this.A07 = true;
            }
            this.A0A.A0Y(0);
            this.A05.AFR(this.A0A, 4);
            this.A02 = 2;
            return;
        }
        this.A00 = 0;
        this.A02 = 1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4R(C0697Hz c0697Hz) {
        while (c0697Hz.A04() > 0) {
            switch (this.A02) {
                case 0:
                    A00(c0697Hz);
                    break;
                case 1:
                    A02(c0697Hz);
                    break;
                case 2:
                    A01(c0697Hz);
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4p(InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        dc.A05();
        this.A06 = dc.A04();
        this.A05 = interfaceC0556Bu.AGi(dc.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADt(long j2, boolean z2) {
        this.A04 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void AFg() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
