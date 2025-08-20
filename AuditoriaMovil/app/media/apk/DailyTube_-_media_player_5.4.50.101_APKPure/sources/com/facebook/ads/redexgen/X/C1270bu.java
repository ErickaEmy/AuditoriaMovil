package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1270bu {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-119, -42, -34, -36, -35, -119, -41, -40, -35, -119, -53, -50, -119, -41, -34, -43, -43, -87, -99, -19, -34, -17, -34, -22, -30, -15, -30, -17, -99, 74, -52, -35, -18, -35, -23, -31, -16, -31, -18, -100, -17, -20, -31, -33, -27, -30, -27, -31, -32, -100, -35, -17, -100, -22, -21, -22, -87, -22, -15, -24, -24, -100, -27, -17, -100, -22, -15, -24, -24, -74, -100, -23, -31, -16, -28, -21, -32, -100};
    }

    public static String A01(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = C1270bu.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        String methodName = stackTraceElement.getClassName();
        String className = stackTraceElement.getMethodName();
        return A00(30, 48, 120) + methodName + A00(29, 1, 24) + className + A00(17, 12, 121) + str;
    }

    public static <T extends Throwable> T A02(T throwable) {
        return (T) A03(throwable, C1270bu.class.getName());
    }

    public static <T extends Throwable> T A03(T throwable, String str) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int i = stackTrace.length;
        int lastIntrinsic = -1;
        for (int size = 0; size < i; size++) {
            if (str.equals(stackTrace[size].getClassName())) {
                lastIntrinsic = size;
            }
        }
        StackTraceElement[] stackTrace2 = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, lastIntrinsic + 1, i);
        throwable.setStackTrace(stackTrace2);
        return throwable;
    }

    public static void A05(Object obj, String str) {
        if (obj == null) {
            A08(str);
            throw null;
        }
    }

    public static void A06(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) A02(new NullPointerException(str + A00(0, 17, 101))));
    }

    public static void A07(Object obj, String str) {
        if (obj == null) {
            A09(str);
            throw null;
        }
    }

    public static void A08(String str) {
        throw ((NullPointerException) A02(new NullPointerException(str)));
    }

    public static void A09(String str) {
        throw ((NullPointerException) A02(new NullPointerException(A01(str))));
    }

    public static boolean A0A(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
