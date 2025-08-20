package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.8Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8Q {
    public static byte[] A04;
    public static String[] A05 = {"MRuBx", "tnrUNtkj", "pjyIxrC6Yt5E7Bc8e3CsDS5x0xMg", "2xISKY0hJDtdJSu4Q6JXzE3xpGdbyGij", "ditV1dZQcpc", "LaRPF5Qegj7e827D6k5bX2o3j9w5", "b", "ieJW9hY3GIu"};
    public final String A00;
    public final String A01;
    public final Map<C8U, List<String>> A02 = new HashMap();
    public final JSONObject A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23, -18, -27, -38, -69, -72, -78};
        String[] strArr = A05;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[4] = "sekG1ort6wl";
        strArr2[7] = "5zf1LSqUL7z";
        A04 = bArr;
    }

    static {
        A01();
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0035 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C8Q(java.lang.String r7, java.lang.String r8, org.json.JSONObject r9, org.json.JSONArray r10) {
        /*
            r6 = this;
            r6.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r6.A02 = r0
            r6.A00 = r7
            r6.A01 = r8
            r6.A03 = r9
            if (r10 == 0) goto L18
            int r0 = r10.length()
            if (r0 != 0) goto L19
        L18:
            return
        L19:
            com.facebook.ads.redexgen.X.8U[] r5 = com.facebook.ads.redexgen.X.C8U.values()
            int r4 = r5.length
            r3 = 0
        L1f:
            if (r3 >= r4) goto L30
            r2 = r5[r3]
            java.util.Map<com.facebook.ads.redexgen.X.8U, java.util.List<java.lang.String>> r1 = r6.A02
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r1.put(r2, r0)
            int r3 = r3 + 1
            goto L1f
        L30:
            r4 = 0
        L31:
            int r0 = r10.length()
            if (r4 >= r0) goto L73
            org.json.JSONObject r5 = r10.getJSONObject(r4)     // Catch: java.lang.Exception -> L70
            r2 = 0
            r1 = 4
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> L70
            java.lang.String r3 = r5.getString(r0)     // Catch: java.lang.Exception -> L70
            r2 = 4
            r1 = 3
            r0 = 61
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> L70
            java.lang.String r2 = r5.getString(r0)     // Catch: java.lang.Exception -> L70
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Exception -> L70
            java.lang.String r0 = r3.toUpperCase(r0)     // Catch: java.lang.Exception -> L70
            com.facebook.ads.redexgen.X.8U r1 = com.facebook.ads.redexgen.X.C8U.valueOf(r0)     // Catch: java.lang.Exception -> L70
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L70
            if (r0 != 0) goto L70
            java.util.Map<com.facebook.ads.redexgen.X.8U, java.util.List<java.lang.String>> r0 = r6.A02     // Catch: java.lang.Exception -> L70
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L70
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L70
            if (r0 == 0) goto L70
            r0.add(r2)     // Catch: java.lang.Exception -> L70
        L70:
            int r4 = r4 + 1
            goto L31
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8Q.<init>(java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONArray):void");
    }

    public final String A02() {
        return this.A00;
    }

    public final List<String> A03(C8U c8u) {
        return this.A02.get(c8u);
    }

    public final JSONObject A04() {
        return this.A03;
    }
}
