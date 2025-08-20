package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Qi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0907Qi {
    A04,
    A03,
    A06,
    A05;
    
    public static byte[] A00;
    public static String[] A01 = {"DteKWBudESjDtqSUyoTC5E", "I5FSM6v9D3qkRXnarws6dVsmQqtQoJdF", "2aIeIMdS22Kqsjw8nHnHH5KV6oj1373E", "g", "GOJ9oRRABJfcwjAA770tm42MgykplS5Q", "ccCRkU4tJU1cPhlyS12s2rOBaxNg0sA2", "PEuaDw0tTVC0zIT2D0mW6", "B"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {41, 38, 33, 37, 41, 60, 45, 44, 85, 90, 93, 89, 85, 64, 93, 90, 83, 70, 81, 66, 81, 70, 71, 81, 75, 85, 90, 93, 89, 85, 64, 81, 80, 81, 70, 85, 70, 81, 80, 70, 92, 66, 77, 74, 78, 66, 87, 74, 77, 68};
        String[] strArr = A01;
        if (strArr[3].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[3] = "Z";
        strArr2[7] = "Z";
        A00 = bArr;
    }

    static {
        A01();
    }
}
