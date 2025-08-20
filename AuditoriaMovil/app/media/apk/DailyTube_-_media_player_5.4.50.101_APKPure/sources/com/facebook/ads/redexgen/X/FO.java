package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class FO extends AbstractC1200am {
    public static byte[] A00;
    public static String[] A01 = {"d7tLiGkqyLa7cKOkED7RtvmpIXZH8d0b", "LmA4T64r6T9e", "1EBtOKlPck0twYp3ElEJQmg3d", "uhXcdOUibAChEZNBNQuPqKRIQ2", "Z", "LV0o53GlcsqgEYK9Pr4EwymnJShooL9b", "NLZosIPt4DzrQXhRsvqwWEHVFOTX5bDJ", "MQasnwh7q"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 72, 12, 69, 95, 12, 66, 67, 88, 12, 94, 73, 77, 72, 85, 12, 67, 94, 12, 77, 64, 94, 73, 77, 72, 85, 12, 72, 69, 95, 92, 64, 77, 85, 73, 72, 56, 57, 48, 61, 37};
    }

    static {
        A03();
    }

    public FO(C1116Yn c1116Yn, C03111u c03111u) {
        super(c1116Yn, c03111u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(36, 5, 104), String.valueOf(System.currentTimeMillis() - j2));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> trackingUrls, Map<String, String> extraData) {
        if (trackingUrls == null || trackingUrls.isEmpty()) {
            return;
        }
        Iterator<String> it = trackingUrls.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            if (hasNext) {
                new AsyncTaskC0929Re(this.A0B, extraData).execute(it.next());
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0M() {
        C1234bK c1234bK = (C1234bK) this.A01;
        if (c1234bK.A0R()) {
            if (this.A06 != null) {
                this.A06.A0B(c1234bK);
                return;
            }
            return;
        }
        throw new IllegalStateException(A00(0, 36, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0O(InterfaceC02800p interfaceC02800p, C8S c8s, C8Q c8q, C03121v c03121v) {
        C1234bK c1234bK = (C1234bK) interfaceC02800p;
        long currentTimeMillis = System.currentTimeMillis();
        C1197aj c1197aj = new C1197aj(this, c03121v, c1234bK, currentTimeMillis, c8q);
        A0F().postDelayed(c1197aj, c8s.A05().A05());
        c1234bK.A0L(this.A0B, new C1196ai(this, c1197aj, currentTimeMillis, c8q), this.A08, c03121v, V2.A0K());
    }
}
