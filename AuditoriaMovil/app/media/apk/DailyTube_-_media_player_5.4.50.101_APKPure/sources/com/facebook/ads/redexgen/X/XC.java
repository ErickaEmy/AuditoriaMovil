package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class XC extends AbstractC0573Co {
    public static byte[] A05;
    public static String[] A06 = {"yJHQcBl4f4L", "G0ieIp3rn9VMbRQq", "FaSr", "diNTGhkPk6T4rZ0cbtlCtFUtzgnoDDOW", "ZsfK02RsUHO", "uQbwEIiYvgO", "fIpYaZEOmsgiiOCz2AK4PDqwDhI8GLBw", "t90Xt1PXy7A3GvR50K3KPdbeyD"};
    public int A00;
    public C0575Cq A01;
    public C0577Cs A02;
    public C0578Cu A03;
    public boolean A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C0575Cq A02(C0697Hz c0697Hz) throws IOException {
        if (this.A03 == null) {
            this.A03 = AbstractC0579Cv.A04(c0697Hz);
            return null;
        } else if (this.A02 == null) {
            this.A02 = AbstractC0579Cv.A03(c0697Hz);
            return null;
        } else {
            byte[] bArr = new byte[c0697Hz.A07()];
            System.arraycopy(c0697Hz.A00, 0, bArr, 0, c0697Hz.A07());
            Ct[] A0C = AbstractC0579Cv.A0C(c0697Hz, this.A03.A05);
            return new C0575Cq(this.A03, this.A02, bArr, A0C, AbstractC0579Cv.A00(A0C.length - 1));
        }
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{88, 76, 93, 80, 86, 22, 79, 86, 75, 91, 80, 74};
    }

    static {
        A04();
    }

    public static int A00(byte b2, int i, int i5) {
        return (b2 >> i5) & (255 >>> (8 - i));
    }

    public static int A01(byte b2, C0575Cq c0575Cq) {
        if (!c0575Cq.A04[A00(b2, c0575Cq.A00, 1)].A03) {
            int modeNumber = c0575Cq.A02.A03;
            return modeNumber;
        }
        int modeNumber2 = c0575Cq.A02.A04;
        return modeNumber2;
    }

    public static void A05(C0697Hz c0697Hz, long j2) {
        c0697Hz.A0X(c0697Hz.A07() + 4);
        c0697Hz.A00[c0697Hz.A07() - 4] = (byte) (j2 & 255);
        c0697Hz.A00[c0697Hz.A07() - 3] = (byte) ((j2 >>> 8) & 255);
        c0697Hz.A00[c0697Hz.A07() - 2] = (byte) ((j2 >>> 16) & 255);
        c0697Hz.A00[c0697Hz.A07() - 1] = (byte) (255 & (j2 >>> 24));
    }

    public static boolean A06(C0697Hz c0697Hz) {
        try {
            return AbstractC0579Cv.A0A(1, c0697Hz, true);
        } catch (C05059v unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final long A07(C0697Hz c0697Hz) {
        int i = 0;
        if ((c0697Hz.A00[0] & 1) == 1) {
            return -1L;
        }
        int A01 = A01(c0697Hz.A00[0], this.A01);
        if (this.A04) {
            int packetBlockSize = this.A00;
            i = (packetBlockSize + A01) / 4;
        }
        A05(c0697Hz, i);
        this.A04 = true;
        int samplesInPacket = A06[2].length();
        if (samplesInPacket != 7) {
            String[] strArr = A06;
            strArr[6] = "lV1SPFBYbG5lxAnFlWta4jj5erMHhp00";
            strArr[3] = "grWENQhpkSsLY54DCH6OLJaVWIdWM4Dq";
            this.A00 = A01;
            return i;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final void A08(long j2) {
        super.A08(j2);
        this.A04 = j2 != 0;
        C0578Cu c0578Cu = this.A03;
        this.A00 = c0578Cu != null ? c0578Cu.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final void A09(boolean z2) {
        super.A09(z2);
        if (z2) {
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final boolean A0A(C0697Hz c0697Hz, long j2, C0572Cn c0572Cn) throws IOException, InterruptedException {
        if (this.A01 == null) {
            C0575Cq A02 = A02(c0697Hz);
            this.A01 = A02;
            if (A02 == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.A01.A02.A09);
            arrayList.add(this.A01.A03);
            c0572Cn.A00 = Format.A07(null, A03(0, 12, 20), null, this.A01.A02.A02, -1, this.A01.A02.A05, (int) this.A01.A02.A06, arrayList, null, 0, null);
            return true;
        }
        return false;
    }
}
