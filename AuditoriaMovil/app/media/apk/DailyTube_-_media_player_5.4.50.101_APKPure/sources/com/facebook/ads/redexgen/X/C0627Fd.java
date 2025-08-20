package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Fd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0627Fd extends AbstractC1249bZ {
    public static byte[] A02;
    public static final String A03;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{122, 93, 85, 80, 89, 88, 28, 72, 83, 28, 83, 76, 89, 82, 28, 80, 85, 82, 87, 28, 73, 78, 80, 6, 28, 43, 46, 41, 44};
    }

    static {
        A01();
        A03 = C0627Fd.class.getSimpleName();
    }

    public C0627Fd(C1116Yn c1116Yn, J2 j2, String str, Uri uri, Map<String, String> mExtraData, C02790o c02790o, boolean z2) {
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
        A0E(this.A01, enumC02720g);
        return enumC02720g;
    }

    public final EnumC02720g A0G() {
        EnumC02720g enumC02720g = EnumC02720g.A08;
        try {
            C0764Kv.A0C(new C0764Kv(), ((AbstractC02730h) this).A00, AbstractC0767Ky.A00(this.A00.getQueryParameter(A00(25, 4, 8))), ((AbstractC02730h) this).A02);
            return enumC02720g;
        } catch (Exception unused) {
            String str = A00(0, 25, R.styleable.AppCompatTheme_tooltipFrameBackground) + this.A00.toString();
            return EnumC02720g.A03;
        }
    }
}
