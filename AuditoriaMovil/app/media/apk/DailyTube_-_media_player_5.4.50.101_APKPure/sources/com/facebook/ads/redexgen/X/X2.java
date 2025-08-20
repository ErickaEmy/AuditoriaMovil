package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: assets/audience_network.dex */
public final class X2 implements InterfaceC0580Cy {
    public static byte[] A0D;
    public static final double[] A0E;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public C4 A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final boolean[] A0C = new boolean[4];
    public final Cz A0B = new Cz(NotificationCompat.FLAG_HIGH_PRIORITY);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Format, Long> A00(Cz cz, String str) {
        int i;
        byte[] copyOf = Arrays.copyOf(cz.A02, cz.A00);
        int i5 = copyOf[4] & 255;
        int i6 = copyOf[5] & 255;
        int i8 = (i5 << 4) | (i6 >> 4);
        int i10 = ((i6 & 15) << 8) | (copyOf[6] & 255);
        float f4 = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f4 = (i10 * 4) / (i8 * 3);
                break;
            case 3:
                f4 = (i10 * 16) / (i8 * 9);
                break;
            case 4:
                f4 = (i10 * 121) / (i8 * 100);
                break;
        }
        Format A03 = Format.A03(str, A01(0, 11, 121), null, -1, -1, i8, i10, -1.0f, Collections.singletonList(copyOf), -1, f4, null);
        long j2 = 0;
        int i11 = (copyOf[7] & 15) - 1;
        if (i11 >= 0) {
            double[] dArr = A0E;
            if (i11 < dArr.length) {
                double d2 = dArr[i11];
                int i12 = cz.A01;
                int i13 = (copyOf[i12 + 9] & 96) >> 5;
                if (i13 != (copyOf[i12 + 9] & 31)) {
                    d2 *= (i13 + 1.0d) / (i + 1);
                }
                j2 = (long) (1000000.0d / d2);
            }
        }
        return Pair.create(A03, Long.valueOf(j2));
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 8);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0D = new byte[]{7, 24, 21, 20, 30, 94, 28, 1, 20, 22, 67};
    }

    static {
        A02();
        A0E = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4R(C0697Hz c0697Hz) {
        int A06 = c0697Hz.A06();
        int startCodeValue = c0697Hz.A07();
        byte[] bArr = c0697Hz.A00;
        this.A04 += c0697Hz.A04();
        this.A05.AFR(c0697Hz, c0697Hz.A04());
        while (true) {
            int startCodeOffset = AbstractC0693Hv.A04(bArr, A06, startCodeValue, this.A0C);
            if (startCodeOffset == startCodeValue) {
                break;
            }
            int i = c0697Hz.A00[startCodeOffset + 3] & 255;
            if (!this.A07) {
                int i5 = startCodeOffset - A06;
                if (i5 > 0) {
                    this.A0B.A01(bArr, A06, startCodeOffset);
                }
                if (this.A0B.A02(i, i5 < 0 ? -i5 : 0)) {
                    Pair<Format, Long> A00 = A00(this.A0B, this.A06);
                    this.A05.A5n((Format) A00.first);
                    this.A00 = ((Long) A00.second).longValue();
                    this.A07 = true;
                }
            }
            if (i == 0 || i == 179) {
                int i6 = startCodeValue - startCodeOffset;
                if (this.A0A && this.A08 && this.A07) {
                    boolean z2 = this.A09;
                    C4 c4 = this.A05;
                    long j2 = this.A03;
                    int flags = z2 ? 1 : 0;
                    c4.AFS(j2, flags, ((int) (this.A04 - this.A02)) - i6, i6, null);
                }
                boolean z3 = this.A0A;
                if (!z3 || this.A08) {
                    this.A02 = this.A04 - i6;
                    long j4 = this.A01;
                    if (j4 == -9223372036854775807L) {
                        j4 = z3 ? this.A03 + this.A00 : 0L;
                    }
                    this.A03 = j4;
                    this.A09 = false;
                    this.A01 = -9223372036854775807L;
                    this.A0A = true;
                }
                this.A08 = i == 0;
            } else if (i == 184) {
                this.A09 = true;
            }
            A06 = startCodeOffset + 3;
        }
        if (!this.A07) {
            this.A0B.A01(bArr, A06, startCodeValue);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4p(InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        dc.A05();
        this.A06 = dc.A04();
        this.A05 = interfaceC0556Bu.AGi(dc.A03(), 2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADt(long j2, boolean z2) {
        this.A01 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void AFg() {
        AbstractC0693Hv.A0B(this.A0C);
        this.A0B.A00();
        this.A04 = 0L;
        this.A0A = false;
    }
}
