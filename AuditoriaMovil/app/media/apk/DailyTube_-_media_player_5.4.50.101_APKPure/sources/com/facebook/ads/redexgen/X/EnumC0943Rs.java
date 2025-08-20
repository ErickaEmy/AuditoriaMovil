package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0943Rs {
    A05(A00(27, 7, 82)),
    A04(A00(17, 10, 36));
    
    public static byte[] A01;
    public static String[] A02 = {"eivXn7WqkaVyJ2amCalRVsu1nM81zzOL", "IY1PhTJan2YjTy3m27KNizUeB7qtWqJm", "bXOqwPMBCrH3s0bMCsL", "ZrI87R5JnQfkseZsVS85jpDDhrZappEb", "OQXnNqOlJnUzzklcWSYX2hAjXl5kV5w8", "Z35xfMoNmr9cRx2xWokc9BX7TfFFuzqW", "OPmwzWKlqSIpSWAXYRalqZxxZOaDZn32", "DtHbWGOE2Bmy5zeMr4BSgc5m3XVIvhqE"};
    public String A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{90, 91, 75, 87, 92, 85, 90, 83, 81, 71, 19, 17, 12, 21, 10, 7, 6, 86, 87, 21, 91, 80, 89, 86, 95, 93, 75, 62, 60, 33, 56, 39, 42, 43};
    }

    static {
        A01();
    }

    EnumC0943Rs(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EnumC0943Rs[] valuesCustom() {
        Object clone = values().clone();
        if (A02[0].charAt(13) != 'T') {
            A02[5] = "jZZ0FxASmyF6MQQ2nA29dubjFSBlMvOs";
            return (EnumC0943Rs[]) clone;
        }
        throw new RuntimeException();
    }
}
