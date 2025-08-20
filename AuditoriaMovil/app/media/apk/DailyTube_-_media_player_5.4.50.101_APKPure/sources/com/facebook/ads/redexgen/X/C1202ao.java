package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.ao  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1202ao extends KT {
    public static byte[] A03;
    public InterfaceC02800p A00;
    public String A01;
    public final /* synthetic */ FR A02;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 2);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{105, -116, -119, -104, -100, -115, -102, 72, -100, -111, -107, -115, -105, -99, -100, 86};
    }

    public C1202ao(FR fr, InterfaceC02800p interfaceC02800p, String str) {
        this.A02 = fr;
        this.A00 = interfaceC02800p;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        this.A02.A0S(this.A01);
        this.A02.A0N(this.A00);
        this.A02.ABR(new C0722Jb(AdErrorType.NETWORK_ERROR, A00(0, 16, 38)));
    }
}
