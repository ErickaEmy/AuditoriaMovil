package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1s  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC03091s {
    public static byte[] A00;
    public static String[] A01 = {"kdNZsDbIr2FjUgQ6", "G4tbE8YXKkBHtbRzjHgF1iVs8BhQX3ki", "rgsd1nh14jUfY0oEDkCzVbJlkUwrdBXO", "6d8i19T6TQ9xRiUYh6SOmARBfT83lkdi", "2FsjHYpAfMpiihTdUse", "xtyrzkpFCSmXtl0pVvZtRxgukiiALNOU", "PnjWz3Ubzat8tEiN6RTB47L4MZQANY1H", "IONaBzwOxfylvpW8Ch"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[6].charAt(12) != strArr[5].charAt(12)) {
                break;
            }
            A01[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            byte b2 = (byte) ((copyOfRange[i8] - i6) - 100);
            if (A01[0].length() == 15) {
                break;
            }
            String[] strArr2 = A01;
            strArr2[3] = "fUzr4JaNgjTtoWHz8k6HkVts9HpSP1Qi";
            strArr2[1] = "zuQx1GaumRIGoFj6MrcQJkCLkICnzrhi";
            copyOfRange[i8] = b2;
            i8++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A00 = new byte[]{-88, -30, -18, -25, -26};
    }

    static {
        A01();
    }

    public static void A02(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, boolean z2, InterfaceC03071q interfaceC03071q) {
        if (!C0705Ih.A1k(c1116Yn)) {
            C04216c c04216c = new C04216c(c1116Yn);
            C02931c A06 = abstractC1219b5.A0x().A0D().A06();
            c04216c.A0d(new JA(abstractC1219b5.A12(), c1116Yn.A09()));
            if (A06 == null) {
                interfaceC03071q.ACZ(AdError.CACHE_ERROR);
                return;
            } else if (A06.A0J()) {
                interfaceC03071q.ACa();
                if (A01[2].charAt(7) != '1') {
                    throw new RuntimeException();
                }
                A01[0] = "84TqyqDRqUmJCVM8";
                return;
            } else {
                C6Y c6y = new C6Y(A06.A0E(), abstractC1219b5.A0S(), abstractC1219b5.A0P());
                c6y.A04 = true;
                if (C0705Ih.A1Z(c1116Yn)) {
                    c6y.A03 = A00(0, 5, 22);
                }
                switch (C03061p.A00[A06.A09().ordinal()]) {
                    case 1:
                    case 2:
                        c04216c.A0X(c6y);
                        break;
                }
                c04216c.A0b(new C04196a(abstractC1219b5.A10().A01(), -1, -1, abstractC1219b5.A0S(), abstractC1219b5.A0P()));
                c04216c.A0b(new C04196a(A06.A0D(), -1, -1, abstractC1219b5.A0S(), abstractC1219b5.A0P()));
                c04216c.A0W(new C1206as(c1116Yn, interfaceC03071q, c04216c, A06, z2), new C6V(abstractC1219b5.A0S(), abstractC1219b5.A0P()));
                return;
            }
        }
        interfaceC03071q.ACa();
    }
}
