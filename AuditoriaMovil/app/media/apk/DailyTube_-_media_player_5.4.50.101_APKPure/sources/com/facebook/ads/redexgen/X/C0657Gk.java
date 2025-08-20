package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Gk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0657Gk {
    public static String[] A04 = {"1e59kXQlLqMkYu", "73uDxCsdQKWLV7ukq8JJdZs18UKd6swo", "mCuMZDHsEtXcrT2f0", "82", "pR5c7vVXcuaoTTpQp", "OeCOW4uYvzA4LVqnaAabDbQ1U", "2mUnq0j6yY0W6wQrn1U3Lg5rNBUJPBqf", "6oWLaazoE5vpCSBDL9uHOzoNvgEAVE9"};
    public final int A00;
    public final C0654Gh A01;
    public final Object A02;
    public final AB[] A03;

    public C0657Gk(AB[] abArr, InterfaceC0653Gg[] interfaceC0653GgArr, Object obj) {
        this.A03 = abArr;
        this.A01 = new C0654Gh(interfaceC0653GgArr);
        this.A02 = obj;
        this.A00 = abArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(C0657Gk c0657Gk) {
        if (c0657Gk == null || c0657Gk.A01.A01 != this.A01.A01) {
            return false;
        }
        for (int i = 0; i < this.A01.A01; i++) {
            if (!A02(c0657Gk, i)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A02(C0657Gk c0657Gk, int i) {
        if (c0657Gk == null) {
            return false;
        }
        AB[] abArr = this.A03;
        String[] strArr = A04;
        if (strArr[0].length() != strArr[3].length()) {
            String[] strArr2 = A04;
            strArr2[0] = "XY11p18RHVDFci";
            strArr2[3] = "x2";
            return IF.A0g(abArr[i], c0657Gk.A03[i]) && IF.A0g(this.A01.A00(i), c0657Gk.A01.A00(i));
        }
        throw new RuntimeException();
    }
}
