package com.facebook.ads.redexgen.X;

import org.json.JSONArray;
/* renamed from: com.facebook.ads.redexgen.X.Ri */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0933Ri {
    /* JADX WARN: Incorrect condition in loop: B:27:0x0011 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A00(org.json.JSONArray r4, org.json.JSONArray r5) {
        /*
            int r1 = r4.length()
            int r0 = r5.length()
            r3 = 0
            if (r1 == r0) goto Lc
            return r3
        Lc:
            r2 = 0
        Ld:
            int r0 = r4.length()
            if (r2 >= r0) goto L28
            com.facebook.ads.redexgen.X.Rh r1 = com.facebook.ads.redexgen.X.EnumC0932Rh.A00(r4, r2)
            com.facebook.ads.redexgen.X.Rh r0 = com.facebook.ads.redexgen.X.EnumC0932Rh.A00(r5, r2)
            if (r1 == r0) goto L1e
            return r3
        L1e:
            boolean r0 = r1.A05(r4, r5, r2)
            if (r0 != 0) goto L25
            return r3
        L25:
            int r2 = r2 + 1
            goto Ld
        L28:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0933Ri.A00(org.json.JSONArray, org.json.JSONArray):boolean");
    }

    public static /* synthetic */ boolean A01(JSONArray jSONArray, JSONArray jSONArray2) {
        return A00(jSONArray, jSONArray2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A02(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            int r1 = r5.length()
            int r0 = r6.length()
            r4 = 0
            if (r1 == r0) goto Lc
            return r4
        Lc:
            java.util.Iterator r3 = r5.keys()
        L10:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L35
            java.lang.Object r2 = r3.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = r6.has(r2)
            if (r0 != 0) goto L23
            return r4
        L23:
            com.facebook.ads.redexgen.X.Rh r1 = com.facebook.ads.redexgen.X.EnumC0932Rh.A01(r5, r2)
            com.facebook.ads.redexgen.X.Rh r0 = com.facebook.ads.redexgen.X.EnumC0932Rh.A01(r6, r2)
            if (r1 == r0) goto L2e
            return r4
        L2e:
            boolean r0 = r1.A07(r5, r6, r2)
            if (r0 != 0) goto L10
            return r4
        L35:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0933Ri.A02(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
