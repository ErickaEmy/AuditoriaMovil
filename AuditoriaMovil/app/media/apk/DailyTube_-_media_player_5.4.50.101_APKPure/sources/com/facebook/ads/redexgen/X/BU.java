package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class BU extends O7 {
    public static byte[] A01;
    public static String[] A02 = {"AyjpfVMH4abbuU", "C4f54F5689i8nguXYuZVyawidNrV99tP", "", "kvcj7JPhLleA0fC5", "qT9ER7mxQyIS", "DVCseFxiIzNfwa", "yADVvB6XdmuuqrvB", "b9AAn0hyeOBCYK5qzyR18"};
    public final /* synthetic */ UA A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[1].charAt(16) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "MNhPeHQbaIIJpJ20hNozP";
            strArr[2] = "";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 60);
            i8++;
        }
    }

    public static void A01() {
        A01 = new byte[]{35, 22, 17, 18, 28, -10, 27, 33, 18, 31, 32, 33, 22, 33, 14, 25, -14, 35, 18, 27, 33};
    }

    static {
        A01();
    }

    public BU(UA ua2) {
        this.A00 = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A02 */
    public final void A03(O8 o8) {
        MC mc2;
        mc2 = this.A00.A06;
        mc2.A44(A00(0, 21, R.styleable.AppCompatTheme_toolbarStyle), o8);
    }
}
