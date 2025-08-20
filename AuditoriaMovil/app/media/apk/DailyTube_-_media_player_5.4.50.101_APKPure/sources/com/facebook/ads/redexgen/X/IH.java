package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class IH {
    public static byte[] A05;
    public static String[] A06 = {"BmLXPPjgF3W3yl6sHxYVjODx4Gc4ZSvN", "I4b0P0MoHEzHAP7yyYIBBQ151YdBHOwS", "TnUUZ2ELhZytD28RyaEX2mWW0X", "N95", "x88QxZ2XVEltUSPssGjwLeARzs7qYdf0", "T8gtGJunXdUSumjdX3X9mxIBVL", "lBAIpAErMYY7sFwVqjboSux", "Abd"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final List<byte[]> A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static IH A00(C0697Hz c0697Hz) throws C05059v {
        try {
            c0697Hz.A0Z(4);
            int A0E = (c0697Hz.A0E() & 3) + 1;
            if (A0E != 3) {
                ArrayList arrayList = new ArrayList();
                int A0E2 = c0697Hz.A0E() & 31;
                for (int i = 0; i < A0E2; i++) {
                    arrayList.add(A03(c0697Hz));
                }
                int A0E3 = c0697Hz.A0E();
                for (int i5 = 0; i5 < A0E3; i5++) {
                    arrayList.add(A03(c0697Hz));
                }
                int i6 = -1;
                int i8 = -1;
                float f4 = 1.0f;
                if (A0E2 > 0) {
                    C0692Hu A062 = AbstractC0693Hv.A06((byte[]) arrayList.get(0), A0E, ((byte[]) arrayList.get(0)).length);
                    i6 = A062.A06;
                    i8 = A062.A02;
                    f4 = A062.A00;
                } else {
                    String[] strArr = A06;
                    if (strArr[3].length() != strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A06;
                    strArr2[2] = "uBIRbiuvHYy0oHv2RJvgJqXQ4A";
                    strArr2[5] = "sPpQgCzWXqIb9lVIC566YsDxxs";
                }
                return new IH(arrayList, A0E, i6, i8, f4);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new C05059v(A01(0, 24, 65), e2);
        }
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-14, 31, 31, 28, 31, -51, 29, 14, 31, 32, 22, 27, 20, -51, -18, 3, -16, -51, 16, 28, 27, 19, 22, 20};
    }

    static {
        A02();
    }

    public IH(List<byte[]> initializationData, int i, int i5, int i6, float f4) {
        this.A04 = initializationData;
        this.A02 = i;
        this.A03 = i5;
        this.A01 = i6;
        this.A00 = f4;
    }

    public static byte[] A03(C0697Hz c0697Hz) {
        int A0I = c0697Hz.A0I();
        int offset = c0697Hz.A06();
        c0697Hz.A0Z(A0I);
        return AbstractC0676He.A08(c0697Hz.A00, offset, A0I);
    }
}
