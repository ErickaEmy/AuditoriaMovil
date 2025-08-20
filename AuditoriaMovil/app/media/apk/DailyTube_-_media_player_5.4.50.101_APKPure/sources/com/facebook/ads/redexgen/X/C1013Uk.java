package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Uk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1013Uk extends KT {
    public static byte[] A01;
    public static String[] A02 = {"562InPUOhACtlwCEtN", "R5lwX4z8RDFVh5E8umVQyGbxSoVGO", "CYUCoKvLVtAS439EMb", "ChKnavF9Nqo0oetaNymcfBGaHAWTYXo2", "g5ZzVDftJQYE4wszTnHA7JY3RdMW3", "1hyLjyvULyVtl4OO", "Eld6CqAd7cnvJnvbiWS", "Re88eRXq7VTIVsZrXxwUq3yVYBRsOkYZ"};
    public final /* synthetic */ Context A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 11);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{86, -123, -123, 98, 126, -125, 104, 121, Byte.MIN_VALUE, 107, 122, -121, -120, 126, -124, -125};
    }

    static {
        A02();
    }

    public C1013Uk(Context context) {
        this.A00 = context;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        int returnMinSdkVersion;
        if (L6.A04 == L5.A02) {
            return;
        }
        SharedPreferences A00 = KE.A00(this.A00);
        String A002 = A00(0, 16, 10);
        int i = A00.getInt(A002, -1);
        if (i != -1) {
            int unused = L6.A00 = i;
            L6.A04 = L5.A02;
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            returnMinSdkVersion = L6.A03(this.A00);
        } else {
            returnMinSdkVersion = L6.A02(this.A00);
        }
        int unused2 = L6.A00 = returnMinSdkVersion;
        if (A02[7].charAt(31) == 'G') {
            throw new RuntimeException();
        }
        A02[3] = "Y4NBnL2AiN9ppE2ANDhRNdYoO8WQhPKC";
        A00.edit().putInt(A002, returnMinSdkVersion).commit();
        L6.A04 = L5.A02;
    }
}
