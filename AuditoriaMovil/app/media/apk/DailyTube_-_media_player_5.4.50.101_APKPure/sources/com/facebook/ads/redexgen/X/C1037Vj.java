package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1037Vj implements InterfaceC0666Gt {
    public static byte[] A06;
    public final int A00;
    public final InterfaceC0664Gr A01;
    public final InterfaceC0666Gt A02;
    public final InterfaceC0666Gt A03;
    public final HK A04;
    public final HM A05;

    static {
        A02();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 44);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{106, 123, 108, 104, 125, 108, 77, 104, 125, 104, 90, 96, 103, 98};
    }

    public C1037Vj(HK hk, InterfaceC0666Gt interfaceC0666Gt, InterfaceC0666Gt interfaceC0666Gt2, InterfaceC0664Gr interfaceC0664Gr, int i, HM hm) {
        this.A04 = hk;
        this.A03 = interfaceC0666Gt;
        this.A02 = interfaceC0666Gt2;
        this.A01 = interfaceC0664Gr;
        this.A00 = i;
        this.A05 = hm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0666Gt
    /* renamed from: A00 */
    public final C1038Vk A4X() {
        HK hk = this.A04;
        InterfaceC0667Gu A4X = this.A03.A4X();
        InterfaceC0667Gu A4X2 = this.A02.A4X();
        if (0 != 0) {
            throw new NullPointerException(A01(0, 14, 37));
        }
        return new C1038Vk(hk, A4X, A4X2, null, this.A00, null);
    }
}
