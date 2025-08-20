package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Nr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0838Nr {
    public static long A0C;
    public static byte[] A0D;
    public static String[] A0E = {"Dlx9HUQ", "3SJpPR4POSYtfyo20zogCoACzZ0TFz6K", "kjKhSI2oz7rhTngoHOUaCo24OHJZbpIQ", "a4Zk7jMDxn", "WU0c1Yk7xIFA3rTFxMg", "", "SjppttcIPjZ3F", "aZkh9z8pdJw1o0Uivju"};
    public AbstractC1219b5 A00;
    public InterfaceC0837Nq A01;
    public OG A02;
    public boolean A03;
    public boolean A04;
    public final C1U A05;
    public final C1116Yn A06;
    public final J2 A07;
    public final C0775Lg A08;
    public final MC A09;
    public final RE A0A;
    public final String A0B;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 104);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{31, 8, 29, 30, 41, 40, 40, 51, 50, 31, 48, 53, 63, 55, 16, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, 23, 82, 79, 82, 84, 66, 67, 94, 89, 80, 23, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    static {
        A01();
        A0C = 0L;
    }

    public C0838Nr(C1116Yn c1116Yn, String str, RE re, C0775Lg c0775Lg, J2 j2, C1U c1u) {
        this(c1116Yn, str, re, c0775Lg, j2, c1u, new C0989Tm());
    }

    public C0838Nr(C1116Yn c1116Yn, String str, RE re, C0775Lg c0775Lg, J2 j2, C1U c1u, MC mc2) {
        this.A03 = true;
        this.A06 = c1116Yn;
        this.A0B = str;
        this.A0A = re;
        this.A08 = c0775Lg;
        this.A07 = j2;
        this.A05 = c1u;
        this.A09 = mc2;
    }

    private void A02(String str, String str2, Map<String, String> map) {
        String A00 = A00(0, 22, 52);
        try {
            AbstractC0783Lo.A0Z(map, this.A00);
            AbstractC02730h A01 = C02740i.A01(this.A06, this.A07, str, AbstractC0767Ky.A00(str2), new C0829Ni(map).A03(this.A0A).A02(this.A08).A05(), this.A03, this.A04, this.A05);
            if (A01 instanceof C0630Fg) {
                ((C0630Fg) A01).A0H(this.A02);
            }
            EnumC02720g actionOutcome = EnumC02720g.A08;
            if (A01 != null) {
                actionOutcome = A01.A0C();
            }
            if (!(((A01 instanceof C0628Fe) || (A01 instanceof C0630Fg)) && AbstractC0783Lo.A0e(this.A06, actionOutcome, map)) && actionOutcome != EnumC02720g.A05) {
                InterfaceC0837Nq interfaceC0837Nq = this.A01;
                if (interfaceC0837Nq != null) {
                    interfaceC0837Nq.ABE();
                }
                this.A09.A43(this.A0B);
            }
        } catch (ActivityNotFoundException e2) {
            Log.e(A00, A00(44, 20, 100) + str2, e2);
        } catch (Exception e3) {
            Log.e(A00, A00(22, 22, 95), e3);
        }
    }

    public static boolean A03(C1116Yn c1116Yn) {
        boolean isIABBottomSheetEnabled = C0705Ih.A2N(c1116Yn);
        int A06 = C0705Ih.A06(c1116Yn);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = A0C;
        long j4 = currentTimeMillis - j2;
        if (isIABBottomSheetEnabled) {
            String[] strArr = A0E;
            String str = strArr[0];
            String str2 = strArr[6];
            int clickguardTime = str.length();
            if (clickguardTime == str2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "iHhMWVvnkjnFrqYtRUL";
            strArr2[4] = "26cGs68neeVahMKc5kl";
            if (j2 > 0 && j4 < A06) {
                return true;
            }
        }
        A0C = System.currentTimeMillis();
        return false;
    }

    public final void A04(AbstractC1219b5 abstractC1219b5) {
        this.A00 = abstractC1219b5;
    }

    public final void A05(InterfaceC0837Nq interfaceC0837Nq) {
        this.A01 = interfaceC0837Nq;
    }

    public final void A06(OG og) {
        this.A02 = og;
    }

    public final void A07(String str, String str2, Map<String, String> extraData) {
        new JA(str, this.A07).A04(J9.A0J, extraData);
        if (this.A08.A09(this.A06)) {
            this.A07.A9W(str, extraData);
        } else {
            A02(str, str2, extraData);
        }
    }

    public final void A08(boolean z2) {
        this.A04 = z2;
    }
}
