package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class ZA implements InterfaceC03151y {
    public static byte[] A03;
    public C04055m A00;
    public C1116Yn A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 87);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, Byte.MAX_VALUE, 122, Byte.MAX_VALUE, 126, 102, Byte.MAX_VALUE};
    }

    public ZA(C04055m c04055m, C1116Yn c1116Yn, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = c04055m;
        this.A01 = c1116Yn;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03151y
    public final void ABR(C0722Jb c0722Jb) {
        KK.A00(new ZD(this, c0722Jb));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03151y
    public final void ACP(List<C1234bK> list) {
        C04216c manager = new C04216c(this.A01);
        String firstRequestId = A02(6, 7, 70);
        for (C1234bK c1234bK : list) {
            if (A02(6, 7, 70).equals(firstRequestId)) {
                firstRequestId = c1234bK.A0G();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (c1234bK.A0E().A0G() != null) {
                    manager.A0b(new C04196a(c1234bK.A0E().A0G().getUrl(), c1234bK.A0E().A0G().getHeight(), c1234bK.A0E().A0G().getWidth(), c1234bK.A0G(), A02(0, 6, 2)));
                }
                if (c1234bK.A0E().A0F() != null) {
                    manager.A0b(new C04196a(c1234bK.A0E().A0F().getUrl(), c1234bK.A0E().A0F().getHeight(), c1234bK.A0E().A0F().getWidth(), c1234bK.A0G(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(c1234bK.A0E().A0d())) {
                    manager.A0a(new C6Y(c1234bK.A0E().A0d(), c1234bK.A0G(), A02(0, 6, 2), c1234bK.A0E().A0A()));
                }
            }
        }
        manager.A0W(new ZB(this, list), new C6V(firstRequestId, A02(0, 6, 2)));
    }
}
