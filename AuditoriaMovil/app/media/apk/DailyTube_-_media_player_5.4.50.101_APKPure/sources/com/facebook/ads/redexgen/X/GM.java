package com.facebook.ads.redexgen.X;

import android.text.Layout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class GM {
    public static byte[] A0G;
    public static String[] A0H = {"a0j0pjJovXsqGpLV", "nOyRGrgn0RrQrx8RLh1IVysMIGGZ9zSU", "HhM8cHVoe7oP095HvM3MDl3FTOytY8Nt", "qV96UZYP0XVtF", "KdjCZLvvBrBGDDTWJomEgtFOXhZQvXq0q", "EURW7oGImTlyr4LdZ1NjIT6oNREHOO5j", "RHBOYojiC1ffUGCaEMtUODJeCNdosg3N", "TICGsHQsoGjdDQAevjnKsbeUNwnFU3hV"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public Layout.Alignment A08;
    public String A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public List<String> A0D;
    public boolean A0E;
    public boolean A0F;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 20);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{117, -108, -106, -98, -102, -91, -94, -88, -95, -105, 83, -106, -94, -97, -94, -91, 83, -95, -94, -89, 83, -105, -104, -103, -100, -95, -104, -105, 97, -126, -85, -86, -80, 92, -97, -85, -88, -85, -82, 92, -86, -85, -80, 92, -96, -95, -94, -91, -86, -95, -96};
    }

    static {
        A02();
    }

    public GM() {
        A03();
    }

    public static int A00(int i, String str, String str2, int i5) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i5;
        }
        return -1;
    }

    private final void A03() {
        String A01 = A01(0, 0, 41);
        this.A0A = A01;
        this.A0B = A01;
        this.A0D = Collections.emptyList();
        this.A0C = A01;
        this.A09 = null;
        this.A0F = false;
        this.A0E = false;
        this.A06 = -1;
        this.A07 = -1;
        this.A02 = -1;
        this.A05 = -1;
        this.A04 = -1;
        this.A08 = null;
    }

    public final float A04() {
        return this.A00;
    }

    public final int A05() {
        if (this.A0E) {
            return this.A01;
        }
        throw new IllegalStateException(A01(0, 29, 31));
    }

    public final int A06() {
        if (this.A0F) {
            return this.A03;
        }
        throw new IllegalStateException(A01(29, 22, 40));
    }

    public final int A07() {
        return this.A04;
    }

    public final int A08() {
        int i = this.A02;
        if (i == -1 && this.A05 == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.A05 == 1 ? 2 : 0);
    }

    public final int A09(String str, String str2, String[] strArr, String str3) {
        if (this.A0A.isEmpty()) {
            String str4 = this.A0B;
            String[] strArr2 = A0H;
            if (strArr2[5].charAt(7) == strArr2[1].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0H;
            strArr3[0] = "uGADXBaYz1rV8w4N";
            strArr3[3] = "04kRdzF0lWsSB";
            if (str4.isEmpty() && this.A0D.isEmpty() && this.A0C.isEmpty()) {
                return str2.isEmpty() ? 1 : 0;
            }
        }
        int A00 = A00(A00(A00(0, this.A0A, str, 1073741824), this.A0B, str2, 2), this.A0C, str3, 4);
        if (A00 == -1 || !Arrays.asList(strArr).containsAll(this.A0D)) {
            return 0;
        }
        int score = this.A0D.size();
        return A00 + (score * 4);
    }

    public final Layout.Alignment A0A() {
        return this.A08;
    }

    public final GM A0B(int i) {
        this.A01 = i;
        this.A0E = true;
        return this;
    }

    public final GM A0C(int i) {
        this.A03 = i;
        this.A0F = true;
        return this;
    }

    public final GM A0D(String str) {
        this.A09 = IF.A0M(str);
        return this;
    }

    public final GM A0E(boolean z2) {
        this.A02 = z2 ? 1 : 0;
        return this;
    }

    public final GM A0F(boolean z2) {
        this.A05 = z2 ? 1 : 0;
        return this;
    }

    public final GM A0G(boolean z2) {
        this.A07 = z2 ? 1 : 0;
        return this;
    }

    public final String A0H() {
        return this.A09;
    }

    public final void A0I(String str) {
        this.A0A = str;
    }

    public final void A0J(String str) {
        this.A0B = str;
    }

    public final void A0K(String str) {
        this.A0C = str;
    }

    public final void A0L(String[] strArr) {
        this.A0D = Arrays.asList(strArr);
    }

    public final boolean A0M() {
        return this.A0E;
    }

    public final boolean A0N() {
        return this.A0F;
    }

    public final boolean A0O() {
        return this.A06 == 1;
    }

    public final boolean A0P() {
        return this.A07 == 1;
    }
}
