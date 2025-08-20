package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: assets/audience_network.dex */
public final class WO implements C4 {
    public static String[] A0F = {"J778k2tN1A71aNteuaiayf8W9Cwuw9", "SddvXAFvjaaaNZPS5hBFE72C4u8NAkzU", "DlS6L0Rs4yOHZbnixJzGuxf7gpgZ1", "jQlCDwUBXdtP", "ybgFHcAQFxf90xR6S9k4k72uXmSANsHZ", "TXMpPdQfareL1guTNfB0PsKfFvbJoTHv", "R2X9ywuliv1XsGmKXBlkokivcnsZ5nAf", "17XTwjN4yTPZEt52JUGlNgZMXTvW6CfX"};
    public long A00;
    public long A01;
    public Format A02;
    public Format A03;
    public F9 A04;
    public F9 A05;
    public F9 A06;
    public FA A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final F7 A0B;
    public final F8 A0C;
    public final InterfaceC0659Gm A0D;
    public final C0697Hz A0E;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A07(C1094Xr c1094Xr, F7 f72) {
        int i;
        long j2 = f72.A01;
        this.A0E.A0W(1);
        A06(j2, this.A0E.A00, 1);
        long j4 = j2 + 1;
        byte b2 = this.A0E.A00[0];
        boolean z2 = (b2 & 128) != 0;
        int i5 = b2 & Byte.MAX_VALUE;
        if (c1094Xr.A02.A04 == null) {
            c1094Xr.A02.A04 = new byte[16];
        }
        A06(j4, c1094Xr.A02.A04, i5);
        long j6 = j4 + i5;
        if (z2) {
            this.A0E.A0W(2);
            A06(j6, this.A0E.A00, 2);
            j6 += 2;
            i = this.A0E.A0I();
        } else {
            i = 1;
            if (A0F[4].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "qfwCamou4xH4TsJy70kUYaPJ1paRPrQS";
            strArr[6] = "GMGbKrn5SK4TcHFeKaSIsaM2NwTeIDah";
        }
        int[] iArr = c1094Xr.A02.A06;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = c1094Xr.A02.A07;
        if (A0F[1].charAt(27) == 'T') {
            throw new RuntimeException();
        }
        A0F[3] = "l74rmj1cvzMl";
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
            if (A0F[3].length() != 12) {
                A0F[5] = "mTjJh6O10GTQKtsNTzpZkGXCEgBidJyY";
            } else {
                String[] strArr2 = A0F;
                strArr2[2] = "gGnYbSzqov18WRGS84osGLTli7oQ4";
                strArr2[0] = "bcZjTvBd8pDqGicoFFRFmeT3NfcxuZ";
            }
        }
        if (z2) {
            int i6 = i * 6;
            this.A0E.A0W(i6);
            A06(j6, this.A0E.A00, i6);
            j6 += i6;
            this.A0E.A0Y(0);
            for (int i8 = 0; i8 < i; i8++) {
                iArr[i8] = this.A0E.A0I();
                iArr2[i8] = this.A0E.A0H();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = f72.A00 - ((int) (j6 - f72.A01));
        }
        C3 c32 = f72.A02;
        c1094Xr.A02.A03(i, iArr, iArr2, c32.A03, c1094Xr.A02.A04, c32.A01, c32.A02, c32.A00);
        int i10 = (int) (j6 - f72.A01);
        f72.A01 += i10;
        f72.A00 -= i10;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.C4
    public final void AFS(long j2, int i, int i5, int i6, C3 c32) {
        if (this.A08) {
            A5n(this.A03);
        }
        if (this.A09) {
            if ((i & 1) == 0 || !this.A0C.A0J(j2)) {
                return;
            }
            this.A09 = false;
        }
        this.A0C.A0G(j2 + this.A00, i, (this.A01 - i5) - i6, i5, c32);
    }

    public WO(InterfaceC0659Gm interfaceC0659Gm) {
        this.A0D = interfaceC0659Gm;
        int A7D = interfaceC0659Gm.A7D();
        this.A0A = A7D;
        this.A0C = new F8();
        this.A0B = new F7();
        this.A0E = new C0697Hz(32);
        F9 f9 = new F9(0L, A7D);
        this.A04 = f9;
        this.A05 = f9;
        this.A06 = f9;
    }

    private int A00(int i) {
        if (!this.A06.A02) {
            this.A06.A02(this.A0D.A3X(), new F9(this.A06.A03, this.A0A));
        }
        return Math.min(i, (int) (this.A06.A03 - this.A01));
    }

    public static Format A01(Format format, long j2) {
        if (format == null) {
            return null;
        }
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (A0F[5].charAt(18) != 'x') {
            A0F[5] = "lOB1PW6jUN1Flr4ublIocLHYYSFUXZqB";
            if (i != 0 && format.A0G != Long.MAX_VALUE) {
                return format.A0H(format.A0G + j2);
            }
            return format;
        }
        throw new RuntimeException();
    }

    private void A02(int i) {
        long j2 = this.A01 + i;
        this.A01 = j2;
        if (j2 == this.A06.A03) {
            this.A06 = this.A06.A00;
        }
    }

    private void A03(long j2) {
        while (j2 >= this.A05.A03) {
            this.A05 = this.A05.A00;
        }
    }

    private void A04(long j2) {
        if (j2 == -1) {
            return;
        }
        while (j2 >= this.A04.A03) {
            this.A0D.AEW(this.A04.A01);
            this.A04 = this.A04.A01();
        }
        if (this.A05.A04 < this.A04.A04) {
            this.A05 = this.A04;
        }
    }

    private void A05(long j2, ByteBuffer byteBuffer, int i) {
        A03(j2);
        while (i > 0) {
            int remaining = (int) (this.A05.A03 - j2);
            int min = Math.min(i, remaining);
            byte[] bArr = this.A05.A01.A01;
            int remaining2 = this.A05.A00(j2);
            byteBuffer.put(bArr, remaining2, min);
            i -= min;
            j2 += min;
            int remaining3 = (j2 > this.A05.A03 ? 1 : (j2 == this.A05.A03 ? 0 : -1));
            if (remaining3 == 0) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A06(long j2, byte[] bArr, int i) {
        A03(j2);
        int i5 = i;
        while (i5 > 0) {
            int min = Math.min(i5, (int) (this.A05.A03 - j2));
            byte[] bArr2 = this.A05.A01.A01;
            int toCopy = this.A05.A00(j2);
            int remaining = i - i5;
            System.arraycopy(bArr2, toCopy, bArr, remaining, min);
            i5 -= min;
            j2 += min;
            int remaining2 = (j2 > this.A05.A03 ? 1 : (j2 == this.A05.A03 ? 0 : -1));
            if (remaining2 == 0) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A08(F9 f9) {
        if (!f9.A02) {
            return;
        }
        int i = (this.A06.A02 ? 1 : 0) + (((int) (this.A06.A04 - f9.A04)) / this.A0A);
        if (A0F[5].charAt(18) == 'x') {
            throw new RuntimeException();
        }
        A0F[1] = "iejtrz5gn5ypfg4If5spWIciPKrb2ZMM";
        C0658Gl[] c0658GlArr = new C0658Gl[i];
        for (int i5 = 0; i5 < c0658GlArr.length; i5++) {
            c0658GlArr[i5] = f9.A01;
            f9 = f9.A01();
        }
        this.A0D.AEX(c0658GlArr);
    }

    private final void A09(boolean z2) {
        this.A0C.A0H(z2);
        A08(this.A04);
        F9 f9 = new F9(0L, this.A0A);
        this.A04 = f9;
        this.A05 = f9;
        this.A06 = f9;
        this.A01 = 0L;
        this.A0D.AGj();
    }

    public final int A0A() {
        return this.A0C.A07();
    }

    public final int A0B() {
        return this.A0C.A05();
    }

    public final int A0C() {
        return this.A0C.A06();
    }

    public final int A0D(long j2, boolean z2, boolean z3) {
        return this.A0C.A08(j2, z2, z3);
    }

    public final int A0E(C04999p c04999p, C1094Xr c1094Xr, boolean z2, boolean z3, long j2) {
        int result = this.A0C.A09(c04999p, c1094Xr, z2, z3, this.A02, this.A0B);
        switch (result) {
            case -5:
                this.A02 = c04999p.A00;
                return -5;
            case -4:
                if (!c1094Xr.A04()) {
                    int result2 = (c1094Xr.A00 > j2 ? 1 : (c1094Xr.A00 == j2 ? 0 : -1));
                    if (result2 < 0) {
                        String[] strArr = A0F;
                        String str = strArr[2];
                        String str2 = strArr[0];
                        int length = str.length();
                        int result3 = str2.length();
                        if (length == result3) {
                            throw new RuntimeException();
                        }
                        A0F[3] = "3oC8GcXqxYNt";
                        c1094Xr.A00(Integer.MIN_VALUE);
                    }
                    if (c1094Xr.A0A()) {
                        A07(c1094Xr, this.A0B);
                    }
                    int result4 = this.A0B.A00;
                    c1094Xr.A09(result4);
                    long j4 = this.A0B.A01;
                    ByteBuffer byteBuffer = c1094Xr.A01;
                    int result5 = this.A0B.A00;
                    A05(j4, byteBuffer, result5);
                    return -4;
                }
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A0F() {
        return this.A0C.A0B();
    }

    public final Format A0G() {
        return this.A0C.A0E();
    }

    public final void A0H() {
        A04(this.A0C.A0A());
    }

    public final void A0I() {
        A09(false);
    }

    public final void A0J() {
        this.A0C.A0F();
        this.A05 = this.A04;
    }

    public final void A0K(long j2, boolean z2, boolean z3) {
        A04(this.A0C.A0D(j2, z2, z3));
    }

    public final void A0L(FA fa) {
        this.A07 = fa;
    }

    public final boolean A0M() {
        return this.A0C.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final void A5n(Format format) {
        Format A01 = A01(format, this.A00);
        boolean formatChanged = this.A0C.A0K(A01);
        this.A03 = format;
        this.A08 = false;
        FA fa = this.A07;
        if (fa != null && formatChanged) {
            fa.ADS(A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final int AFQ(InterfaceC0555Bt interfaceC0555Bt, int i, boolean z2) throws IOException, InterruptedException {
        int read = interfaceC0555Bt.read(this.A06.A01.A01, this.A06.A00(this.A01), A00(i));
        if (read == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        A02(read);
        return read;
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final void AFR(C0697Hz c0697Hz, int i) {
        while (i > 0) {
            int A00 = A00(i);
            byte[] bArr = this.A06.A01.A01;
            int bytesAppended = this.A06.A00(this.A01);
            c0697Hz.A0c(bArr, bytesAppended, A00);
            i -= A00;
            A02(A00);
        }
    }
}
