package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/* renamed from: com.facebook.ads.redexgen.X.1T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1T {
    public static int A06;
    public static byte[] A07;
    public static String[] A08 = {"Du56ltgKKs1OVAX5", "GkTmjkH3MPiTFcKSZdtZeP", "KEGdoxZZnAdDUnYCV96i9ePmYlw0nVcs", "eeVVi2jaa6aVR", "fQADRcl3z4I9sbyUvoxt9O6e4jXdGtkI", "3SSpimwT8orOGywmbz8JxKLw4xXAqR", "PizR3LI8tsUKIk44MqfkEczppTSirtIQ", "PpMlGdJ0WRh5qmood9xHloOk"};
    public int A00;
    public int A01;
    public long A03;
    public String A04;
    public int A02 = 0;
    public LinkedList<Integer> A05 = new LinkedList<>();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_textAppearancePopupMenuHeader);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{70, 27, 12, 109, 60, 8, 31, 11, 15, 31, 20, 25, 3, 90, 57, 27, 10, 10, 19, 20, 29, 90, 62, 27, 14, 27, 64, 90, 20, 21, 20, 31, 90, 51, 20, 14, 31, 29, 31, 8, 90, 21, 25, 25, 15, 8, 8, 31, 20, 25, 31, 1, 11, 9, 24, 53, 62, 51, 34, 41, 32, 36, 53, 52, 15, 57, 52, 53, 57, 32, 7, 59, 57, 40, 40, 61, 60, 7, 57, 42, 42, 57, 33, 7, 52, 61, 54, 63, 44, 48, 104, 100, 100, 114, 117, 117, 98, 105, 100, 98, 116, 49, 36, 51, 40, 46, 37, 102, 113, 107, 106, 65, 113, 125, 125, 107, 108, 108, 123, 112, 125, 123, 65, 109, 123, 125, 109, 33, 54, 44, 45, 6, 41, 60, 43, 48, 54, 61, 29, 5};
    }

    static {
        A03();
        A06 = 50;
    }

    public C1T(String str) {
        this.A04 = str;
    }

    public static int A00() {
        return A06;
    }

    private void A02() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        while (!this.A05.isEmpty() && this.A05.peekFirst() != null) {
            long currentTime = this.A05.peekFirst().intValue();
            if (currentTimeMillis - currentTime >= this.A00) {
                this.A05.removeFirst();
            } else {
                return;
            }
        }
    }

    public final void A04(int i) {
        this.A02 = i;
    }

    public final void A05(int i, int i5, long j2, int i6) {
        this.A00 = i;
        this.A01 = i5;
        this.A03 = j2;
        A06 = i6;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A06(org.json.JSONArray r4) throws org.json.JSONException {
        /*
            r3 = this;
            r2 = 0
        L1:
            int r0 = r4.length()
            if (r2 >= r0) goto L2c
            java.lang.Object r0 = r4.get(r2)
            boolean r0 = r0 instanceof java.lang.Integer
            if (r0 == 0) goto L1d
            java.util.LinkedList<java.lang.Integer> r1 = r3.A05
            java.lang.Object r0 = r4.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1.addLast(r0)
            int r2 = r2 + 1
            goto L1
        L1d:
            r2 = 4
            r1 = 47
            r0 = 16
            java.lang.String r1 = A01(r2, r1, r0)
            org.json.JSONException r0 = new org.json.JSONException
            r0.<init>(r1)
            throw r0
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1T.A06(org.json.JSONArray):void");
    }

    public final void A07(boolean z2) {
        if (z2) {
            this.A05.addLast(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
        A02();
    }

    public final boolean A08() {
        return ((long) this.A05.size()) >= this.A03;
    }

    public final boolean A09() {
        return (System.currentTimeMillis() / 1000) - ((long) this.A02) <= ((long) this.A01);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A01(138, 1, 12));
        sb.append(A01(55, 12, 58));
        String A01 = A01(1, 1, 75);
        sb.append(A01);
        sb.append(this.A04);
        String A012 = A01(0, 1, 0);
        sb.append(A012);
        sb.append(A01(101, 6, 43));
        sb.append(A01);
        sb.append(this.A00);
        sb.append(A012);
        sb.append(A01(127, 11, 51));
        sb.append(A01);
        sb.append(this.A01);
        sb.append(A012);
        sb.append(A01(52, 3, 2));
        sb.append(A01);
        sb.append(this.A03);
        sb.append(A012);
        sb.append(A01(107, 20, 116));
        sb.append(A01);
        sb.append(this.A02);
        sb.append(A012);
        sb.append(A01(67, 23, 50));
        sb.append(A01);
        sb.append(A06);
        sb.append(A012);
        sb.append(A01(90, 11, 109));
        sb.append(A01(2, 2, 92));
        Iterator<Integer> it = this.A05.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A08[1].length() != 22) {
                throw new RuntimeException();
            }
            A08[7] = "ktnl640oaPGPfDqOI7";
            if (hasNext) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(A012);
                }
            } else {
                sb.append(A01(51, 1, 54));
                sb.append(A01(139, 1, 18));
                return sb.toString();
            }
        }
    }
}
