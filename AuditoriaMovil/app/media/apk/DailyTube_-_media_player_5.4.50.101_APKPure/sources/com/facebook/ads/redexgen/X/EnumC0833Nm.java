package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Nm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0833Nm {
    A06(0),
    A05(1),
    A04(2);
    
    public static byte[] A01;
    public static String[] A02 = {"rZGvvZMI6I", "wpdicw5jfWUP9Cs9nncu65zzvPXSjTXh", "qXEMgnv7Ct425l7In8PWxhOPFYVbEYpB", "dTodKdBY68fO6HNBSU3LN7qZJ4nOCEpk", "Hkjhu", "mY7TKQYFYXm3BBS2pDypGTbdY20sKsEk", "u0FGaDIimXxXG0l3UqPLAtx16Sc8Y059", "GEphX9PDUn8ir5euMIdeMTZrm9gVIFzw"};
    public int A00;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{46, 35, 44, 38, 49, 33, 35, 50, 39, 77, 82, 79, 73, 79, 92, 84, 73, 102, 125, 96, 99, 118, 112, 122, 117, 122, 118, 119};
    }

    static {
        A02();
    }

    EnumC0833Nm(int i) {
        this.A00 = i;
    }

    public static EnumC0833Nm A00(int i) {
        EnumC0833Nm[] valuesCustom;
        for (EnumC0833Nm enumC0833Nm : valuesCustom()) {
            if (enumC0833Nm.A00 == i) {
                return enumC0833Nm;
            }
        }
        return A05;
    }

    public final int A03() {
        return this.A00;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EnumC0833Nm[] valuesCustom() {
        Object clone = values().clone();
        if (A02[4].length() != 18) {
            A02[4] = "9YF3oPenjmVnddjujEMQmJq4m";
            return (EnumC0833Nm[]) clone;
        }
        throw new RuntimeException();
    }
}
