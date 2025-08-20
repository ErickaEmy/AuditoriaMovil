package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
import java.util.UUID;
/* renamed from: com.facebook.ads.redexgen.X.Cb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0561Cb {
    public static byte[] A00;
    public static String[] A01 = {"vniJFRP", "oJtPNZwcQG6hLH64wW6tXvk3sbQ9WwGW", "zry57w6QfhfaFpFxdZgKHC1xYn", "fo4QeY", "i9CLNlynjhorIFu8zs9NEh7lWGRKe1E6", "M5SbcVIJ6zX6bTvbAFwxovtl6mtBjy6T", "O1VKgn8XNf4GQEXWcT9RCCs6YBao3Pp0", "jcDd8FEzgCzhSc3FOh8Nko0kxmmUpCTh"};

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-28, 7, 7, -4, -43, 8, 3, 1, -23, 8, -3, 0, -85, -60, -55, -53, -58, -58, -59, -56, -54, -69, -70, 118, -58, -55, -55, -66, 118, -52, -69, -56, -55, -65, -59, -60, -112, 118};
    }

    static {
        A03();
    }

    public static C0560Ca A00(byte[] bArr) {
        C0697Hz c0697Hz = new C0697Hz(bArr);
        if (c0697Hz.A07() < 32) {
            return null;
        }
        c0697Hz.A0Y(0);
        if (c0697Hz.A08() == c0697Hz.A04() + 4 && c0697Hz.A08() == CJ.A0s) {
            int dataSize = CJ.A01(c0697Hz.A08());
            if (dataSize > 1) {
                Log.w(A01(0, 12, 98), A01(12, 26, 36) + dataSize);
                return null;
            }
            UUID uuid = new UUID(c0697Hz.A0L(), c0697Hz.A0L());
            if (dataSize == 1) {
                int atomType = c0697Hz.A0H() * 16;
                if (A01[0].length() == 21) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[3] = "thpi9L";
                strArr[2] = "TMAT5NZ1bWTkNSNpNaLonMSfAF";
                c0697Hz.A0Z(atomType);
            }
            int atomSize = c0697Hz.A0H();
            if (atomSize != c0697Hz.A04()) {
                return null;
            }
            byte[] bArr2 = new byte[atomSize];
            c0697Hz.A0c(bArr2, 0, atomSize);
            return new C0560Ca(uuid, dataSize, bArr2);
        }
        return null;
    }

    public static UUID A02(byte[] bArr) {
        UUID uuid;
        C0560Ca parsedAtom = A00(bArr);
        if (parsedAtom != null) {
            uuid = parsedAtom.A01;
            return uuid;
        }
        return null;
    }
}
