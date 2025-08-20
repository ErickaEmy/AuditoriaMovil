package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Yx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1126Yx implements AnonymousClass69 {
    public static byte[] A02;
    public static String[] A03 = {"TFthAsyh9DXeOXmOSrI", "6fWFj2GuIp8edYChPrJEmZ0EGdAH52zr", "1W8BLXCecsGswLg5J6ItB4TJ0IeP92", "LJOYl73w1qtKK7uJcnV", "z6IkqPokH6efARGWKazebLzdy8d5mCY", "2wZEZTk79zqBVt75gMVieTbdYLiT7Zir", "bDoQVkMDKn3JHFmlXSVDRiBYbpx4sGCA", "L28Z4g4sdLlGf5SKMowSfgQKz11TtxJ4"};
    public final C6A A00;
    public final String A01;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{5, 10, 1, -10, 78, 75, 69};
    }

    static {
        A02();
    }

    public C1126Yx(C6A c6a, String str) {
        this.A00 = c6a;
        this.A01 = str;
    }

    public static C1126Yx A00(JSONObject jSONObject) {
        C6A A00 = C6A.A00(jSONObject.optString(A01(0, 4, 21)));
        String url = jSONObject.optString(A01(4, 3, 93));
        if (A00 == null || url == null) {
            String[] strArr = A03;
            if (strArr[7].charAt(27) != strArr[5].charAt(27)) {
                throw new RuntimeException();
            }
            A03[2] = "YX1kth4";
            return null;
        }
        return new C1126Yx(A00, url);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass69
    public final C6A A8D() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        if (r4 != r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
        if (r4 != r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        r7 = (com.facebook.ads.redexgen.X.C1126Yx) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r6.A00 == r7.A00) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        return r6.A01.equals(r7.A01);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            if (r6 != r7) goto L23
            r3 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1126Yx.A03
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L16
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L16:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1126Yx.A03
            java.lang.String r1 = "7vOCIJjJCX9CoY0eg8O"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "3BsZIpiI9Segj8T9GPE"
            r0 = 3
            r2[r0] = r1
            return r3
        L23:
            r5 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1126Yx.A03
            r0 = 7
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L3e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1126Yx.A03
            java.lang.String r1 = "CUYUmjEQroJXgi3huLe"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "AnYHMDp1ebtK81SsggF"
            r0 = 3
            r2[r0] = r1
            if (r7 == 0) goto L6a
            java.lang.Class r4 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1126Yx.A03
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L6b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1126Yx.A03
            java.lang.String r1 = "McBoxOwAJvKvGI9HKqBnGpNAZAcduNL"
            r0 = 4
            r2[r0] = r1
            if (r4 == r3) goto L6e
        L6a:
            return r5
        L6b:
            if (r4 == r3) goto L6e
            goto L6a
        L6e:
            com.facebook.ads.redexgen.X.Yx r7 = (com.facebook.ads.redexgen.X.C1126Yx) r7
            com.facebook.ads.redexgen.X.6A r1 = r6.A00
            com.facebook.ads.redexgen.X.6A r0 = r7.A00
            if (r1 == r0) goto L77
            return r5
        L77:
            java.lang.String r1 = r6.A01
            java.lang.String r0 = r7.A01
            boolean r0 = r1.equals(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1126Yx.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass69
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        int result = this.A00.hashCode();
        int i = result * 31;
        int result2 = this.A01.hashCode();
        return i + result2;
    }
}
