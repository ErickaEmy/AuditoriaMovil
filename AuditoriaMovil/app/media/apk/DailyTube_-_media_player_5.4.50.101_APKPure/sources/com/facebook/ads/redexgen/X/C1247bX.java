package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bX  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1247bX extends AbstractC02730h {
    public static byte[] A01;
    public static final String A02;
    public final Uri A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 1);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{88, 115, 123, 126, 119, 118, 50, -122, -127, 50, -127, -126, 119, Byte.MIN_VALUE, 50, 126, 123, Byte.MIN_VALUE, 125, 50, -121, -124, 126, 76, 50};
    }

    static {
        A01();
        A02 = C1247bX.class.getSimpleName();
    }

    public C1247bX(C1116Yn c1116Yn, J2 j2, String str, Uri uri) {
        super(c1116Yn, j2, str);
        this.A00 = uri;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02730h
    public final EnumC02720g A0C() {
        try {
            C0764Kv.A0D(new C0764Kv(), super.A00, this.A00, this.A02);
        } catch (Exception unused) {
            String str = A00(0, 25, 17) + this.A00.toString();
        }
        return EnumC02720g.A08;
    }
}
