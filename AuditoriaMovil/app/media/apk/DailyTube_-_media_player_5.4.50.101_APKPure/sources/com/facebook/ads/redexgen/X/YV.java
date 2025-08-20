package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class YV implements RI {
    public static byte[] A01;
    public final C1115Ym A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 127);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, -45, -20, -24, -45, -10, 21, 21, 18, -45, -8, 21, 27, 26, 15, 20, 13, -45, -6, 21, 17, 11, 20, 102, 100, 86, 99, 30, 82, 88, 86, 95, 101};
    }

    public YV(C1115Ym c1115Ym) {
        this.A00 = c1115Ym;
    }

    @Override // com.facebook.ads.redexgen.X.RI
    public final Map<String, String> A5o(boolean z2) {
        HashMap hashMap = new HashMap();
        if (!C6E.A00().A04()) {
            hashMap.put(A00(0, 23, 39), C04718l.A00().A01(this.A00, true).A03());
        }
        hashMap.put(A00(23, 10, R.styleable.AppCompatTheme_tooltipForegroundColor), AbstractC04748o.A06(new C8K(this.A00), this.A00, z2));
        return hashMap;
    }
}
