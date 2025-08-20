package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: assets/audience_network.dex */
public final class XH extends AbstractC0573Co {
    public static byte[] A02;
    public static String[] A03 = {"8dTWvXK8tch0WiEnFvHb8QUOTjgSOqY9", "GP5XsFGUIcP3F8wb7eo6", "CqCUMDrIKsNfOt03xA9INRdZ8", "ntm6pkiJXJn0b4vYMFRbAtYqalurqDmt", "MKNWZ4ceQqyXKZHhShlPBWdiS", "qmQfSGtBK4Bh2Swsb", "DS4", "jEA"};
    public XI A00;
    public C0684Hm A01;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 12);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-97, -77, -94, -89, -83, 109, -92, -86, -97, -95};
    }

    static {
        A03();
    }

    private int A00(C0697Hz c0697Hz) {
        int i = (c0697Hz.A00[2] & 255) >> 4;
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                int i5 = i - 2;
                String[] strArr = A03;
                String str = strArr[3];
                String str2 = strArr[0];
                int charAt = str.charAt(11);
                int blockSizeCode = str2.charAt(11);
                if (charAt == blockSizeCode) {
                    A03[1] = "m7WV3F64xJdvTLT";
                    return 576 << i5;
                }
                String[] strArr2 = A03;
                strArr2[6] = "ZGd";
                strArr2[7] = "V9k";
                return 576 << i5;
            case 6:
            case 7:
                c0697Hz.A0Z(4);
                c0697Hz.A0O();
                String[] strArr3 = A03;
                String str3 = strArr3[3];
                String str4 = strArr3[0];
                int charAt2 = str3.charAt(11);
                int blockSizeCode2 = str4.charAt(11);
                if (charAt2 != blockSizeCode2) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A03;
                strArr4[6] = "ycs";
                strArr4[7] = "AJV";
                int value = i == 6 ? c0697Hz.A0E() : c0697Hz.A0I();
                c0697Hz.A0Y(0);
                int blockSizeCode3 = value + 1;
                return blockSizeCode3;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                int blockSizeCode4 = 256 << (i - 8);
                return blockSizeCode4;
            default:
                return -1;
        }
    }

    public static boolean A04(C0697Hz c0697Hz) {
        return c0697Hz.A04() >= 5 && c0697Hz.A0E() == 127 && c0697Hz.A0M() == 1179402563;
    }

    public static boolean A05(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final long A07(C0697Hz c0697Hz) {
        if (!A05(c0697Hz.A00)) {
            return -1L;
        }
        return A00(c0697Hz);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final void A09(boolean z2) {
        super.A09(z2);
        if (z2) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final boolean A0A(C0697Hz c0697Hz, long j2, C0572Cn c0572Cn) throws IOException, InterruptedException {
        byte[] bArr = c0697Hz.A00;
        if (this.A01 == null) {
            this.A01 = new C0684Hm(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, c0697Hz.A07());
            copyOfRange[4] = Byte.MIN_VALUE;
            c0572Cn.A00 = Format.A07(null, A02(0, 10, 50), null, -1, this.A01.A00(), this.A01.A01, this.A01.A06, Collections.singletonList(copyOfRange), null, 0, null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            XI xi = new XI(this);
            this.A00 = xi;
            xi.A01(c0697Hz);
            return true;
        } else if (!A05(bArr)) {
            return true;
        } else {
            XI xi2 = this.A00;
            if (A03[5].length() != 17) {
                throw new RuntimeException();
            }
            A03[1] = "qWJSCS9yuHod5mMI2FbA5J9U";
            if (xi2 != null) {
                xi2.A00(j2);
                c0572Cn.A01 = this.A00;
            }
            return false;
        }
    }
}
