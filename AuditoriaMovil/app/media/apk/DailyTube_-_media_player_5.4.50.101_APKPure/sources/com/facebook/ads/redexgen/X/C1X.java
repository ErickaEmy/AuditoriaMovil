package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1X implements Serializable {
    public static byte[] A04 = null;
    public static String[] A05 = {"fMgCBjwnSPLlGmCQgsSLupdT7pqDzyp4", "yUS8gRlB2MWxUDhPAJrAYtkWaSt8qz4B", "dBasyOwTmlOZTCbIWWmvB1g7E", "RqaXhgYUvoqEq", "F0nm8JPdbdm", "Y401XUNRFDrr9SfWxNZZjZ9oz", "LA5HjnpgcUFB3", "MK9sfwjFqBk"};
    public static final long serialVersionUID = 351643298236575729L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{121, -7, -31, -13, -16, -16, -29, -20, -31, -9, -5, -23, -33, -29, -49, -36, -30, -41, -30, -25, -21};
    }

    static {
        A02();
    }

    public C1X(C1W c1w) {
        String str;
        String str2;
        String str3;
        String str4;
        str = c1w.A02;
        this.A02 = str;
        str2 = c1w.A03;
        this.A03 = str2;
        str3 = c1w.A00;
        this.A00 = str3;
        str4 = c1w.A01;
        this.A01 = str4;
    }

    public static String A01(String str, String str2, int i) {
        String replace = str.replace(A00(1, 10, 49), str2);
        String A00 = A00(0, 0, 15);
        if (i > 0) {
            StringBuilder append = new StringBuilder().append(i);
            String updatedString = A00(0, 1, 12);
            A00 = append.append(updatedString).toString();
        }
        String updatedString2 = A00(11, 10, 33);
        String replace2 = replace.replace(updatedString2, A00);
        String updatedString3 = A05[7];
        if (updatedString3.length() != 29) {
            A05[4] = "HwfJGa76I4tQ";
            return replace2;
        }
        throw new RuntimeException();
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final String A05() {
        return this.A02;
    }

    public final String A06(String str, int i) {
        return A01(this.A03, str, i);
    }
}
