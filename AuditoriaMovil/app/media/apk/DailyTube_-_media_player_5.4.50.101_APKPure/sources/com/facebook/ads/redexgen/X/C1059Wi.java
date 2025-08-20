package com.facebook.ads.redexgen.X;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1059Wi implements DQ {
    public static byte[] A02;
    public MediaCodecInfo[] A00;
    public final int A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 45);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{3, -11, -13, 5, 2, -11, -67, 0, -4, -15, 9, -14, -15, -13, -5};
    }

    public C1059Wi(boolean z2) {
        this.A01 = z2 ? 1 : 0;
    }

    private void A01() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final int A6U() {
        A01();
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final MediaCodecInfo A6V(int i) {
        A01();
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final boolean A9H(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A00(0, 15, 99));
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final boolean AFf() {
        return true;
    }
}
