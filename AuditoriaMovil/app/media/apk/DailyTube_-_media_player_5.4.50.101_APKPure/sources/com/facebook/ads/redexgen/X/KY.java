package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class KY {
    public static String[] A01 = {"vWOWhJ9TqiA1ty478f", "MWb8A3Nd6tPLcAimCp0hVAmYX6QHiaZm", "Xd3YBUkiMhOleC4V056rVyOXhinwtSii", "tT8mJINbcEXXPPmKiWyTepfA0JHaFg93", "WoudJsrKOqRuVhNYSdRTZjqc00A0B3WY", "YTheXaZSxrm1KPF5Yd", "huHeChgRkwF7QVPgKoMeW6tLhEc13T9K", "ASVM8zHOtJrSOKsDwpZwweqDqvgS8KFW"};
    public static final ThreadLocal<KY> A02 = new ThreadLocal<>();
    public final KH A00 = new KH();

    public static KH A00() {
        return A02().A00;
    }

    public static KH A01(KX kx2) {
        KH currentStackTraces = new KH(A00());
        currentStackTraces.add(kx2);
        return currentStackTraces;
    }

    public static KY A02() {
        ThreadLocal<KY> threadLocal = A02;
        KY ky = threadLocal.get();
        String[] strArr = A01;
        if (strArr[6].charAt(1) != strArr[2].charAt(1)) {
            String[] strArr2 = A01;
            strArr2[7] = "JnfSkSuIf6osqUQGv4Nkh0Vi2QZsQFPV";
            strArr2[4] = "e9u3CRl6fKpCeCDR9nRPR0cml03xK1Bs";
            if (ky == null) {
                KY ky2 = new KY();
                threadLocal.set(ky2);
                return ky2;
            }
            return ky;
        }
        throw new RuntimeException();
    }

    public static void A03(KT kt) {
        KH A05 = kt.A05();
        if (A05 != null) {
            KH createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(A05);
        }
    }

    public static void A04(KT kt) {
        KH A05 = kt.A05();
        if (A05 != null) {
            KH createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.removeAll(A05);
        }
    }
}
