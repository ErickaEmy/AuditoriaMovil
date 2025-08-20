package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Pa  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0873Pa implements Runnable {
    public static byte[] A01;
    public static String[] A02 = {"uduF7y1C8f4BfvOCO4Bbq6znZfD289wY", "LfQQ99tGpIYoqROwWovpCF40OXz0xcCP", "pe2RdaJtvVEZmLt4Dkt9DCEmAABN", "zCkDdi8MMPMgBKhzCwwd8Y", "gpXsz89N0H7wm", "U57X7XmLFZehOxidvs2iHeLBOkC7", "VomEcvnoa3iVV8u", "uRkqt"};
    public final /* synthetic */ C04859a A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-28, -9, -14, -13, -3, -34, -6, -17, 7, -16, -17, -15, -7, -45, 0, 0, -3, 0};
        String[] strArr = A02;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[2] = "IRUmVXxJ3xpLtoKGmKUObZK1jjqw";
        strArr2[5] = "FvpPsD11YfGqSvfesnropeXaLbJS";
        A01 = bArr;
    }

    static {
        A01();
    }

    public RunnableC0873Pa(C04859a c04859a) {
        this.A00 = c04859a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0876Pd interfaceC0876Pd;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0876Pd = this.A00.A00.A0X;
            interfaceC0876Pd.ADX(A00(0, 18, 98));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
