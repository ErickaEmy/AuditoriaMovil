package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Xb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1078Xb extends C6 {
    public static byte[] A05;
    public static String[] A06 = {"S6oix22WW3XrOL6PgcbxfAkEtHdPkPhf", "4OWz7hl1Zq8qyI8tM", "clV1g7mDIxTidmwZ1CuuG8s1lTi1VXAM", "4pPGx9", "ltKNubnfMHDxlo41G", "61sVTIAUswj0oFXzD6", "V6Pb0wOPN8cWCdQmqK9dHxyDUr6EkDd0", "qXRSabgl4tCI0bSRqPqCbhaUnodlSpfB"};
    public int A00;
    public int A01;
    public boolean A02;
    public final C0697Hz A03;
    public final C0697Hz A04;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{71, 120, 117, 116, 126, 49, 119, 126, 99, 124, 112, 101, 49, Byte.MAX_VALUE, 126, 101, 49, 98, 100, 97, 97, 126, 99, 101, 116, 117, 43, 49, 39, 56, 53, 52, 62, 126, 48, 39, 50};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.C6
    public final void A0B(C0697Hz c0697Hz, long j2) throws C05059v {
        int A0E = c0697Hz.A0E();
        long A09 = j2 + (c0697Hz.A09() * 1000);
        if (A0E == 0 && !this.A02) {
            C0697Hz c0697Hz2 = new C0697Hz(new byte[c0697Hz.A04()]);
            c0697Hz.A0c(c0697Hz2.A00, 0, c0697Hz.A04());
            IH A00 = IH.A00(c0697Hz2);
            this.A01 = A00.A02;
            super.A00.A5n(Format.A03(null, A00(28, 9, R.styleable.AppCompatTheme_textColorAlertDialogListItem), null, -1, -1, A00.A03, A00.A01, -1.0f, A00.A04, -1, A00.A00, null));
            this.A02 = true;
        } else if (A0E == 1 && this.A02) {
            byte[] bArr = this.A03.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.A01;
            int i5 = 0;
            while (c0697Hz.A04() > 0) {
                c0697Hz.A0c(this.A03.A00, i, this.A01);
                this.A03.A0Y(0);
                int A0H = this.A03.A0H();
                this.A04.A0Y(0);
                super.A00.AFR(this.A04, 4);
                super.A00.AFR(c0697Hz, A0H);
                i5 = i5 + 4 + A0H;
            }
            super.A00.AFS(A09, this.A00 != 1 ? 0 : 1, i5, 0, null);
        }
    }

    static {
        A01();
    }

    public C1078Xb(C4 c4) {
        super(c4);
        this.A04 = new C0697Hz(AbstractC0693Hv.A03);
        this.A03 = new C0697Hz(4);
    }

    @Override // com.facebook.ads.redexgen.X.C6
    public final boolean A0C(C0697Hz c0697Hz) throws C1079Xc {
        int frameType = c0697Hz.A0E();
        int header = frameType >> 4;
        int i = header & 15;
        int i5 = frameType & 15;
        if (i5 == 7) {
            this.A00 = i;
            if (A06[2].charAt(25) != 118) {
                A06[5] = "9goNtADcrLhK1amHV7";
                return i != 5;
            }
            throw new RuntimeException();
        }
        throw new C1079Xc(A00(0, 28, 46) + i5);
    }
}
