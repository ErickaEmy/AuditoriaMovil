package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
/* renamed from: com.facebook.ads.redexgen.X.Hy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0696Hy {
    public byte[] A00;
    public int A01;
    public int A02;
    public int A03;

    public C0696Hy() {
    }

    public C0696Hy(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public C0696Hy(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A02 = i;
    }

    private void A00() {
        int i;
        int i5 = this.A03;
        AbstractC0672Ha.A04(i5 >= 0 && (i5 < (i = this.A02) || (i5 == i && this.A01 == 0)));
    }

    public final int A01() {
        return ((this.A02 - this.A03) * 8) - this.A01;
    }

    public final int A02() {
        AbstractC0672Ha.A04(this.A01 == 0);
        return this.A03;
    }

    public final int A03() {
        return (this.A03 * 8) + this.A01;
    }

    public final int A04(int i) {
        int i5;
        if (i == 0) {
            return 0;
        }
        int i6 = 0;
        this.A01 += i;
        while (true) {
            i5 = this.A01;
            if (i5 <= 8) {
                break;
            }
            int i8 = i5 - 8;
            this.A01 = i8;
            byte[] bArr = this.A00;
            int returnValue = this.A03;
            this.A03 = returnValue + 1;
            i6 |= (bArr[returnValue] & 255) << i8;
        }
        byte[] bArr2 = this.A00;
        int i10 = this.A03;
        int returnValue2 = bArr2[i10] & 255;
        int i11 = i6 | (returnValue2 >> (8 - i5));
        int returnValue3 = 32 - i;
        int i12 = i11 & ((-1) >>> returnValue3);
        if (i5 == 8) {
            this.A01 = 0;
            this.A03 = i10 + 1;
        }
        A00();
        return i12;
    }

    public final void A05() {
        if (this.A01 == 0) {
            return;
        }
        this.A01 = 0;
        this.A03++;
        A00();
    }

    public final void A06() {
        int i = this.A01 + 1;
        this.A01 = i;
        if (i == 8) {
            this.A01 = 0;
            this.A03++;
        }
        A00();
    }

    public final void A07(int i) {
        int i5 = i / 8;
        this.A03 = i5;
        this.A01 = i - (i5 * 8);
        A00();
    }

    public final void A08(int i) {
        int numBytes = i / 8;
        int i5 = this.A03 + numBytes;
        this.A03 = i5;
        int i6 = this.A01 + (i - (numBytes * 8));
        this.A01 = i6;
        if (i6 > 7) {
            this.A03 = i5 + 1;
            this.A01 = i6 - 8;
        }
        A00();
    }

    public final void A09(int i) {
        AbstractC0672Ha.A04(this.A01 == 0);
        this.A03 += i;
        A00();
    }

    public final void A0A(int firstByteInputBits, int i) {
        if (i < 32) {
            firstByteInputBits &= (1 << i) - 1;
        }
        int min = Math.min(8 - this.A01, i);
        int remainingBitsToRead = this.A01;
        int firstByteRightPaddingSize = (8 - remainingBitsToRead) - min;
        int firstByteReadSize = 65280 >> remainingBitsToRead;
        int firstByteReadSize2 = firstByteReadSize | ((1 << firstByteRightPaddingSize) - 1);
        byte[] bArr = this.A00;
        int firstByteBitmask = this.A03;
        byte b2 = (byte) (bArr[firstByteBitmask] & firstByteReadSize2);
        bArr[firstByteBitmask] = b2;
        int firstByteReadSize3 = b2 | ((firstByteInputBits >>> (i - min)) << firstByteRightPaddingSize);
        bArr[firstByteBitmask] = (byte) firstByteReadSize3;
        int firstByteRightPaddingSize2 = i - min;
        int firstByteBitmask2 = firstByteBitmask + 1;
        while (firstByteRightPaddingSize2 > 8) {
            int firstByteReadSize4 = firstByteBitmask2 + 1;
            this.A00[firstByteBitmask2] = (byte) (firstByteInputBits >>> (firstByteRightPaddingSize2 - 8));
            firstByteRightPaddingSize2 -= 8;
            firstByteBitmask2 = firstByteReadSize4;
        }
        int lastByteRightPaddingSize = 8 - firstByteRightPaddingSize2;
        byte[] bArr2 = this.A00;
        int firstByteReadSize5 = bArr2[firstByteBitmask2];
        byte b3 = (byte) (firstByteReadSize5 & ((1 << lastByteRightPaddingSize) - 1));
        bArr2[firstByteBitmask2] = b3;
        int firstByteReadSize6 = b3 | ((firstByteInputBits & ((1 << firstByteRightPaddingSize2) - 1)) << lastByteRightPaddingSize);
        bArr2[firstByteBitmask2] = (byte) firstByteReadSize6;
        A08(i);
        A00();
    }

    public final void A0B(byte[] bArr) {
        A0C(bArr, bArr.length);
    }

    public final void A0C(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A03 = 0;
        this.A01 = 0;
        this.A02 = i;
    }

    public final void A0D(byte[] bArr, int i, int i5) {
        int i6 = (i5 >> 3) + i;
        while (i < i6) {
            byte[] bArr2 = this.A00;
            int to = this.A03;
            int i8 = to + 1;
            this.A03 = i8;
            int to2 = bArr2[to];
            int i10 = this.A01;
            bArr[i] = (byte) (to2 << i10);
            int i11 = bArr[i];
            int to3 = bArr2[i8];
            bArr[i] = (byte) (((255 & to3) >> (8 - i10)) | i11);
            i++;
        }
        int i12 = i5 & 7;
        if (i12 == 0) {
            return;
        }
        int bitsLeft = bArr[i6];
        int to4 = 255 >> i12;
        bArr[i6] = (byte) (bitsLeft & to4);
        int i13 = this.A01;
        int to5 = i13 + i12;
        if (to5 > 8) {
            int i14 = bArr[i6];
            byte[] bArr3 = this.A00;
            int bitsLeft2 = this.A03;
            int to6 = bitsLeft2 + 1;
            this.A03 = to6;
            int to7 = bArr3[bitsLeft2];
            bArr[i6] = (byte) (i14 | ((to7 & 255) << i13));
            this.A01 = i13 - 8;
        }
        int i15 = this.A01 + i12;
        this.A01 = i15;
        byte[] bArr4 = this.A00;
        int lastDataByteTrailingBits = this.A03;
        int to8 = bArr4[lastDataByteTrailingBits];
        int i16 = 255 & to8;
        int to9 = 8 - i15;
        int i17 = i16 >> to9;
        int bitsLeft3 = bArr[i6];
        int to10 = 8 - i12;
        bArr[i6] = (byte) (bitsLeft3 | ((byte) (i17 << to10)));
        if (i15 == 8) {
            this.A01 = 0;
            int to11 = lastDataByteTrailingBits + 1;
            this.A03 = to11;
        }
        A00();
    }

    public final void A0E(byte[] bArr, int i, int i5) {
        AbstractC0672Ha.A04(this.A01 == 0);
        System.arraycopy(this.A00, this.A03, bArr, i, i5);
        this.A03 += i5;
        A00();
    }

    public final boolean A0F() {
        boolean returnValue = (this.A00[this.A03] & (NotificationCompat.FLAG_HIGH_PRIORITY >> this.A01)) != 0;
        A06();
        return returnValue;
    }
}
