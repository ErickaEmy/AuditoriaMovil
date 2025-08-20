package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.0r  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC02820r {
    public static byte[] A04;
    public static String[] A05 = {"OqcLT37Xtir4oyEfNmT1h4Rk4YkQZZDY", "Uwe5RI", "pL0dXLjcEL0YvPTfwlaTsWSX1DbaAkE5", "xtw7OOYBvYdKgcW8WzcZrKA0PDZy4bwg", "f918FI", "0rYE8aKdqB5alUcDRGHr7byWf0zxjLED", "HJdrWZ0hD1uhwEG", "W2AWehjS6wPr2mpVEIqcODXDVwSDQEbA"};
    public boolean A00;
    public final C1116Yn A01;
    public final AbstractC02830s A02;
    public final RE A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 37);
            String[] strArr = A05;
            if (strArr[7].charAt(19) == strArr[3].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "ralyQsFIfJjHchT6ijaCYOn7xcrh9SYP";
            strArr2[0] = "lf1tsTh5P7IODA8hmkOKCVUdKtrYifbk";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-126, -90, -87, -85, -98, -84, -84, -94, -88, -89, 89, -91, -88, -96, -96, -98, -99};
    }

    public abstract void A06(Map<String, String> map);

    static {
        A01();
    }

    public AbstractC02820r(C1116Yn c1116Yn, AbstractC02830s abstractC02830s, RE re) {
        this.A01 = c1116Yn;
        this.A02 = abstractC02830s;
        this.A03 = re;
    }

    public final void A02() {
        if (this.A00) {
            return;
        }
        AbstractC02830s abstractC02830s = this.A02;
        if (abstractC02830s != null) {
            abstractC02830s.A00();
        }
        Map<String, String> extraData = new C0829Ni().A03(this.A03).A05();
        A06(extraData);
        this.A00 = true;
        L4.A02(this.A01, A00(0, 17, 20));
        AbstractC02830s abstractC02830s2 = this.A02;
    }
}
