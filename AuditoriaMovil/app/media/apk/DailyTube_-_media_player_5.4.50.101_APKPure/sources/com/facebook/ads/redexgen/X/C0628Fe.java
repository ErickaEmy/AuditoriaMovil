package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Fe  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0628Fe extends AbstractC1249bZ {
    public static byte[] A02;
    public static String[] A03 = {"EO73VH", "Qgz5bq7vpM6wgaeZrwJ0N", "K0RixItTLV229tIQ9volfY9Fr2yfBG4Z", "0XJd0xzB9RaoqzSBbOWrwbmO5Qd7B1Hm", "", "cDFQfUnzrKwrnb1BC8KnyL9IHyRAK9fC", "Q7Q0M0vYffDRrtcuJmKxnq", "hygqtGcON2Cep"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {14, 41, 49, 52, 45, 44, -24, 60, 55, -24, 55, 56, 45, 54, -24, 52, 49, 54, 51, -24, 61, 58, 52, 2, -24, -14, -17, -12, -15};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "z2LBMWL3UZ6mgEOfq1wT6wdWGhdUBaxY";
        strArr[2] = "LNV6u0tAGiEAXpu6l5ZCQkq7c5KJBKxy";
        A02 = bArr;
    }

    static {
        A01();
        A04 = C0628Fe.class.getSimpleName();
    }

    public C0628Fe(C1116Yn c1116Yn, J2 j2, String str, Uri uri, Map<String, String> mExtraData, C02790o c02790o, boolean z2) {
        super(c1116Yn, j2, str, c02790o, z2);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1249bZ
    public final EnumC02720g A0D() {
        EnumC02720g enumC02720g = EnumC02720g.A08;
        if (((AbstractC1249bZ) this).A02) {
            enumC02720g = A0G();
        }
        if (!AbstractC0783Lo.A0e(((AbstractC02730h) this).A00, enumC02720g, this.A01)) {
            A0E(this.A01, enumC02720g);
        }
        return enumC02720g;
    }

    public final EnumC02720g A0G() {
        if (A0F(this.A00)) {
            EnumC02720g actionOutcome = EnumC02720g.A09;
            return actionOutcome;
        }
        try {
            EnumC02720g actionOutcome2 = C0764Kv.A05(new C0764Kv(), ((AbstractC02730h) this).A00, AbstractC0767Ky.A00(this.A00.getQueryParameter(A00(25, 4, 35))), ((AbstractC02730h) this).A02, this.A01);
            return actionOutcome2;
        } catch (Exception unused) {
            String str = A00(0, 25, 101) + this.A00.toString();
            EnumC02720g actionOutcome3 = EnumC02720g.A03;
            return actionOutcome3;
        }
    }
}
