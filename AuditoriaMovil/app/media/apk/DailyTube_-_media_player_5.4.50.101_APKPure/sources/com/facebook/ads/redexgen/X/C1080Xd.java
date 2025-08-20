package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Xd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1080Xd extends C6 {
    public static byte[] A01;
    public static String[] A02 = {"lkUmj0P9ANZweJy", "AYR", "2bCiSP20yUx8Jjv69HyX94pfkMFX1Tn5", "GuptQSCxLEDTiFK9bPX0ljmbSmBcx9xx", "QILfBos", "yeLNYaj", "n8HrTtIUehfoTgx", "xV0sp6lxPyztL8QZzt7llBh4QSI4V12v"};
    public long A00;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] - i6) - 31);
            String[] strArr = A02;
            if (strArr[3].charAt(7) != strArr[7].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "WF1W4nbxyUcfRBlDsHDD1CgmrC98ElX3";
            strArr2[7] = "aIs3tFZxis4srcfFD6vTbXobqrKXyR4d";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{-40, -23, -26, -43, -24, -35, -29, -30, 5, 4, -29, -5, 10, -9, -38, -9, 10, -9};
    }

    static {
        A0A();
    }

    public C1080Xd() {
        super(null);
        this.A00 = -9223372036854775807L;
    }

    public static int A00(C0697Hz c0697Hz) {
        return c0697Hz.A0E();
    }

    public static Boolean A01(C0697Hz c0697Hz) {
        return Boolean.valueOf(c0697Hz.A0E() == 1);
    }

    public static Double A02(C0697Hz c0697Hz) {
        return Double.valueOf(Double.longBitsToDouble(c0697Hz.A0L()));
    }

    public static Object A03(C0697Hz c0697Hz, int i) {
        switch (i) {
            case 0:
                return A02(c0697Hz);
            case 1:
                return A01(c0697Hz);
            case 2:
                return A05(c0697Hz);
            case 3:
                return A09(c0697Hz);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                String[] strArr = A02;
                if (strArr[3].charAt(7) == strArr[7].charAt(7)) {
                    A02[2] = "Zl5TZ6M60aHBYOe9FM2F5W6f579JKUNd";
                    return null;
                }
                break;
            case 8:
                HashMap<String, Object> A08 = A08(c0697Hz);
                String[] strArr2 = A02;
                if (strArr2[0].length() == strArr2[6].length()) {
                    String[] strArr3 = A02;
                    strArr3[0] = "AtnlLuJZPUjXwht";
                    strArr3[6] = "kJYayAh32s2xp3N";
                    return A08;
                }
                break;
            case 10:
                return A06(c0697Hz);
            case 11:
                return A07(c0697Hz);
        }
        throw new RuntimeException();
    }

    public static String A05(C0697Hz c0697Hz) {
        int A0I = c0697Hz.A0I();
        int A06 = c0697Hz.A06();
        c0697Hz.A0Z(A0I);
        return new String(c0697Hz.A00, A06, A0I);
    }

    public static ArrayList<Object> A06(C0697Hz c0697Hz) {
        int A0H = c0697Hz.A0H();
        ArrayList<Object> arrayList = new ArrayList<>(A0H);
        for (int i = 0; i < A0H; i++) {
            int count = A00(c0697Hz);
            arrayList.add(A03(c0697Hz, count));
        }
        return arrayList;
    }

    public static Date A07(C0697Hz c0697Hz) {
        Date date = new Date((long) A02(c0697Hz).doubleValue());
        c0697Hz.A0Z(2);
        return date;
    }

    public static HashMap<String, Object> A08(C0697Hz c0697Hz) {
        int A0H = c0697Hz.A0H();
        HashMap<String, Object> hashMap = new HashMap<>(A0H);
        for (int i = 0; i < A0H; i++) {
            String A05 = A05(c0697Hz);
            int count = A00(c0697Hz);
            hashMap.put(A05, A03(c0697Hz, count));
        }
        return hashMap;
    }

    public static HashMap<String, Object> A09(C0697Hz c0697Hz) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String A05 = A05(c0697Hz);
            int A00 = A00(c0697Hz);
            if (A00 == 9) {
                return hashMap;
            }
            hashMap.put(A05, A03(c0697Hz, A00));
        }
    }

    @Override // com.facebook.ads.redexgen.X.C6
    public final void A0B(C0697Hz c0697Hz, long j2) throws C05059v {
        if (A00(c0697Hz) == 2) {
            if (!A04(8, 10, 119).equals(A05(c0697Hz)) || A00(c0697Hz) != 8) {
                return;
            }
            Map<String, Object> metadata = A08(c0697Hz);
            String name = A04(0, 8, 85);
            if (metadata.containsKey(name)) {
                double durationSeconds = ((Double) metadata.get(name)).doubleValue();
                int nameType = (durationSeconds > 0.0d ? 1 : (durationSeconds == 0.0d ? 0 : -1));
                if (nameType > 0) {
                    this.A00 = (long) (1000000.0d * durationSeconds);
                    return;
                }
                return;
            }
            return;
        }
        throw new C05059v();
    }

    @Override // com.facebook.ads.redexgen.X.C6
    public final boolean A0C(C0697Hz c0697Hz) {
        return true;
    }

    public final long A0D() {
        return this.A00;
    }
}
