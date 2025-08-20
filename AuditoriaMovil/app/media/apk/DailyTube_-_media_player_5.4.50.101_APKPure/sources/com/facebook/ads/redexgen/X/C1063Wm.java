package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.uv.v7.R;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1063Wm implements InterfaceC0554Bs {
    public static byte[] A05;
    public static String[] A06 = {"4UYaWsXN1cGpTlRGsO1EVWVYv3mJMVWU", "hbK8JAe0mxfaYRX1PJWZwY", "A0tXjRJ", "osk77A0r9", "0YYQ7Ec", "0ahCLR5uyRlwKx93emwBc8GJDT750HRT", "YIO", "F1mMZvBQ8EiEftVGCLgPL0zcj9avMacR"};
    public static final InterfaceC0557Bv A07;
    public int A00;
    public int A01;
    public InterfaceC0556Bu A02;
    public C4 A03;
    public C1062Wl A04;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{53, 78, 83, 85, 80, 80, 79, 82, 84, 69, 68, 0, 79, 82, 0, 85, 78, 82, 69, 67, 79, 71, 78, 73, 90, 69, 68, 0, 87, 65, 86, 0, 72, 69, 65, 68, 69, 82, 14, 52, 72, 55, 60, 66, 2, 69, 52, 74};
    }

    static {
        A01();
        A07 = new C1064Wn();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A02 = interfaceC0556Bu;
        this.A03 = interfaceC0556Bu.AGi(0, 1);
        this.A04 = null;
        interfaceC0556Bu.A5Y();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        if (this.A04 == null) {
            C1062Wl A00 = DF.A00(interfaceC0555Bt);
            this.A04 = A00;
            if (A00 != null) {
                this.A03.A5n(Format.A06(null, A00(39, 9, R.styleable.AppCompatTheme_toolbarStyle), null, A00.A00(), 32768, this.A04.A03(), this.A04.A04(), this.A04.A02(), null, null, 0, null));
                this.A00 = this.A04.A01();
            } else {
                throw new C05059v(A00(0, 39, 126));
            }
        }
        C1062Wl c1062Wl = this.A04;
        if (A06[0].charAt(24) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[6] = "XBd";
        strArr[3] = "hS3DTCCH9";
        if (!c1062Wl.A07()) {
            DF.A03(interfaceC0555Bt, this.A04);
            this.A02.AFi(this.A04);
        }
        int AFQ = this.A03.AFQ(interfaceC0555Bt, 32768 - this.A01, true);
        if (AFQ != -1) {
            this.A01 += AFQ;
        }
        int i = this.A01 / this.A00;
        if (i > 0) {
            long A052 = this.A04.A05(interfaceC0555Bt.A7i() - this.A01);
            int i5 = this.A00 * i;
            int i6 = this.A01 - i5;
            this.A01 = i6;
            this.A03.AFS(A052, 1, i5, i6, null);
        }
        return AFQ == -1 ? -1 : 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        return DF.A00(interfaceC0555Bt) != null;
    }
}
