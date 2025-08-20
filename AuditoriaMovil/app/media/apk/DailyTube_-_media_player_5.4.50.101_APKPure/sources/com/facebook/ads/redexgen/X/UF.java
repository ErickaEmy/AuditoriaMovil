package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class UF implements L8 {
    public static byte[] A01;
    public static String[] A02 = {"XQ6pDaA1rZEM", "XoeGOYiSv0w2M1U1qXC2kK0WxpTFbq6C", "goNPtYs5sZFfNSJyOgs171oDuCl7t69H", "IBRmsKraW8ihcuaNuynFKjmRlH", "udOMyB", "k9bLdXox5SSCuqwZoRmzAy5kJm", "rLCACxpviKCtWgunDsmekf59Ef0kXw8R", "IiDilnQTvcIperbA6lCpmy3utrrmGEhT"};
    public final /* synthetic */ UD A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-32, -8, -22, -24, -8, -30};
    }

    static {
        A01();
    }

    public UF(UD ud2) {
        this.A00 = ud2;
    }

    public /* synthetic */ UF(UD ud2, UK uk) {
        this(ud2);
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ABA() {
        boolean z2;
        boolean A0V;
        this.A00.A0W.setToolbarActionMessage(A00(0, 0, 7));
        this.A00.A0I();
        z2 = this.A00.A0U;
        if (z2) {
            A0V = this.A00.A0V();
            if (A0V) {
                this.A00.A0W.setToolbarActionMode(1);
                return;
            }
        }
        this.A00.A0W.setToolbarActionMode(0);
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ACm(float f4) {
        boolean z2;
        C02931c c02931c;
        boolean z3;
        AbstractC1219b5 abstractC1219b5;
        float A03;
        AbstractC1219b5 abstractC1219b52;
        AbstractC1219b5 abstractC1219b53;
        boolean z4;
        AbstractC1219b5 abstractC1219b54;
        boolean z5;
        AbstractC1219b5 abstractC1219b55;
        this.A00.A0O((int) f4);
        z2 = this.A00.A0V;
        if (!z2) {
            c02931c = this.A00.A0G;
            this.A00.A0W.setProgress(100.0f * (1.0f - (f4 / c02931c.A07())));
            return;
        }
        z3 = this.A00.A0B;
        if (z3) {
            abstractC1219b54 = this.A00.A0F;
            A03 = 1.0f - (f4 / abstractC1219b54.A0x().A0D().A02());
            z5 = this.A00.A0E;
            if (z5 || A03 < 1.0f) {
                this.A00.A0E = false;
                abstractC1219b55 = this.A00.A0F;
                String A022 = abstractC1219b55.A11().A02();
                String[] strArr = A02;
                if (strArr[1].charAt(20) != strArr[6].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "16sMGD3KF8iI";
                strArr2[5] = "yItCOMUcMHVXea4ql8lykvs7qx";
                this.A00.A0W.setToolbarActionMessage(A022.replace(A00(0, 6, 65), String.valueOf((int) f4)));
            } else {
                this.A00.A0E = true;
                this.A00.A0W.setToolbarActionMessage(A00(0, 0, 7));
            }
        } else {
            abstractC1219b5 = this.A00.A0F;
            A03 = 1.0f - (f4 / abstractC1219b5.A0x().A0D().A03());
        }
        this.A00.A0W.setProgress(100.0f * A03);
        abstractC1219b52 = this.A00.A0F;
        abstractC1219b53 = this.A00.A0F;
        float percentageOfReward = abstractC1219b53.A0x().A0D().A03();
        boolean z7 = ((float) abstractC1219b52.A0x().A0D().A02()) - f4 >= percentageOfReward;
        z4 = this.A00.A0E;
        if (!z4 && z7) {
            this.A00.A0W.setToolbarActionMode(1);
        }
    }
}
