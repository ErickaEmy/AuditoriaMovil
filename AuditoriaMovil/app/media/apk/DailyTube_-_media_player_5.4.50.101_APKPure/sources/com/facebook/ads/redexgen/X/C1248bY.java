package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.bY  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1248bY extends AbstractC02730h {
    public static byte[] A02;
    public static String[] A03 = {"jy5CHS8ciK95qvgyZPKNzTZ", "EsJYGwS5VmRo2OpDKfhEPxAAyWa", "TXamSNcIJ7UnME9", "aAqXHcETEDrJIQ0", "iKc7fPJ", "AeuUMR7bsIhvkygvb", "MOi5LCZvXht1yXQHfTxaoFALkw", "2sehTzR2RD89PLQKMZ0CUhyomJdrMDfZ"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {42, 40, 51, 53, 40, 51, 46, 35, 75, 70, 79, 90};
        String[] strArr = A03;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A03[5] = "wR51MZdRiuTx9tajcMEJR1ABXy";
        A02 = bArr;
    }

    static {
        A01();
        A04 = C1248bY.class.getSimpleName();
    }

    public C1248bY(C1116Yn c1116Yn, J2 j2, String str, Uri uri, Map<String, String> mExtraData) {
        super(c1116Yn, j2, str);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02730h
    public final EnumC02720g A0C() {
        J4 j4 = J4.A05;
        String queryParameter = this.A00.getQueryParameter(A00(0, 8, 58));
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                j4 = J4.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception unused) {
            }
        }
        J2 j2 = super.A01;
        String str = this.A02;
        String[] strArr = A03;
        String priorityString = strArr[4];
        if (priorityString.length() != strArr[1].length()) {
            A03[7] = "bcTdT52UhpG9HF3JMoKdCwsgb4e7WHJf";
            j2.A9v(str, this.A01, this.A00.getQueryParameter(A00(8, 4, 95)), j4);
            return EnumC02720g.A08;
        }
        throw new RuntimeException();
    }
}
