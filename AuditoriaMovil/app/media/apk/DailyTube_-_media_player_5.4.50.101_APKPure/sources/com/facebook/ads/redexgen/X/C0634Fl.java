package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0634Fl extends AbstractC1252bc<EnumC02700e> {
    public static byte[] A00;
    public static String[] A01 = {"nfOmdPRKy6dJXhDeozy3bec4eprLIoSQ", "SpNSu", "KnwtHm0RppTzgOMyhwsp1PpmZykcOlps", "rm2Q4", "VxhbZsLUCIIY3eK9iwu", "VDpaDUxovSHskE3K7Rzj9CiAPD6OjiUH", "VHZOT7bXdVoDaPP", "SrW2lLCi4fFkH4TY8LZz6iOiSZQwKo1F"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A01[5] = "VLAsB6FpgF6HHUeMgZV0uCFNDiYuOANh";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 46);
            i8++;
        }
    }

    public static void A01() {
        A00 = new byte[]{19, 26, 17, 17};
    }

    static {
        A01();
    }

    public C0634Fl(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1252bc
    /* renamed from: A05 */
    public final C0Y A04(EnumC02700e enumC02700e) {
        String A02;
        if (enumC02700e != null) {
            A02 = enumC02700e.A02();
        } else if (A01[0].charAt(24) == 'c') {
            throw new RuntimeException();
        } else {
            A01[2] = "FtIMifYPiEAUkOQozBm9Vw11LGuuRK56";
            A02 = A00(0, 4, 119);
        }
        return new C0Y(this, A02);
    }
}
