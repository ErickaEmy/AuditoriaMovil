package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
/* loaded from: assets/audience_network.dex */
public final class I0 {
    public static String[] A04 = {"BtHKr", "GAfuq", "1TcIbYyYGpE6Ekv4glvvfZz9bC", "q9fmd3d0ImW5Daxca", "ooOXUvpeMSptobOLnq6qd7gNdq", "VwsWXVZM3brBJlmy9", "pSziVAe", "zUHU2CyO73eexnRwL2LOOWJW4Jr0bcWv"};
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public I0(byte[] bArr, int i, int i5) {
        A08(bArr, i, i5);
    }

    private int A00() {
        int i = 0;
        while (!A0A()) {
            i++;
        }
        int i5 = (1 << i) - 1;
        int leadingZeros = i > 0 ? A05(i) : 0;
        return i5 + leadingZeros;
    }

    private void A01() {
        boolean z2;
        int i = this.A02;
        if (i >= 0) {
            int i5 = this.A01;
            if (A04[1].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "f06qvbC";
            strArr[0] = "HuIz9";
            if (i < i5 || (i == i5 && this.A00 == 0)) {
                z2 = true;
                AbstractC0672Ha.A04(z2);
            }
        }
        z2 = false;
        AbstractC0672Ha.A04(z2);
    }

    private boolean A02(int i) {
        if (2 <= i && i < this.A01) {
            byte[] bArr = this.A03;
            byte b2 = bArr[i];
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                String[] strArr2 = A04;
                strArr2[5] = "Jod3dkhqFQ8qWj2s5";
                strArr2[3] = "0zxF2BZpdiUX5xaGz";
                if (b2 == 3 && bArr[i - 2] == 0) {
                    byte b3 = bArr[i - 1];
                    String[] strArr3 = A04;
                    if (strArr3[6].length() != strArr3[0].length()) {
                        String[] strArr4 = A04;
                        strArr4[6] = "lQKXp2Z";
                        strArr4[0] = "Kosug";
                        if (b3 == 0) {
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int A03() {
        int A00 = A00();
        int codeNum = A00 % 2;
        int i = codeNum == 0 ? -1 : 1;
        int codeNum2 = A00 + 1;
        return i * (codeNum2 / 2);
    }

    public final int A04() {
        return A00();
    }

    public final int A05(int i) {
        int i5;
        int i6 = 0;
        int returnValue = this.A00;
        this.A00 = returnValue + i;
        while (true) {
            i5 = this.A00;
            if (i5 <= 8) {
                break;
            }
            int i8 = i5 - 8;
            this.A00 = i8;
            byte[] bArr = this.A03;
            int i10 = this.A02;
            int returnValue2 = bArr[i10];
            i6 |= (returnValue2 & 255) << i8;
            int returnValue3 = i10 + 1;
            if (!A02(returnValue3)) {
                r7 = 1;
            }
            this.A02 = i10 + r7;
        }
        byte[] bArr2 = this.A03;
        int i11 = this.A02;
        int returnValue4 = bArr2[i11];
        int i12 = returnValue4 & 255;
        String[] strArr = A04;
        String str = strArr[5];
        String str2 = strArr[3];
        int length = str.length();
        int returnValue5 = str2.length();
        if (length != returnValue5) {
            throw new RuntimeException();
        }
        A04[7] = "CI85ryy9UuGcWp4q0bXmx78DrLL4QG6i";
        int returnValue6 = 8 - i5;
        int returnValue7 = (-1) >>> (32 - i);
        int i13 = (i6 | (i12 >> returnValue6)) & returnValue7;
        if (i5 == 8) {
            this.A00 = 0;
            int returnValue8 = i11 + 1;
            this.A02 = i11 + (A02(returnValue8) ? 2 : 1);
        }
        A01();
        return i13;
    }

    public final void A06() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 8) {
            this.A00 = 0;
            int i5 = this.A02;
            this.A02 = i5 + (A02(i5 + 1) ? 2 : 1);
        }
        A01();
    }

    public final void A07(int i) {
        int i5 = this.A02;
        int oldByteOffset = i / 8;
        int numBytes = this.A02 + oldByteOffset;
        this.A02 = numBytes;
        int i6 = this.A00 + (i - (oldByteOffset * 8));
        this.A00 = i6;
        if (i6 > 7) {
            int i8 = numBytes + 1;
            String[] strArr = A04;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "WKnUhbHg5PXpVOXLjQbslPOixC";
            strArr2[4] = "5elOCNAU3UTje1WUqtoqjArHkZ";
            this.A02 = i8;
            this.A00 = i6 - 8;
        }
        int numBytes2 = i5 + 1;
        while (numBytes2 <= this.A02) {
            if (A02(numBytes2)) {
                this.A02++;
                numBytes2 += 2;
            }
            numBytes2++;
        }
        A01();
    }

    public final void A08(byte[] bArr, int i, int i5) {
        this.A03 = bArr;
        this.A02 = i;
        this.A01 = i5;
        this.A00 = 0;
        A01();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0009 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A09() {
        /*
            r7 = this;
            int r6 = r7.A02
            int r5 = r7.A00
            r4 = 0
        L5:
            int r1 = r7.A02
            int r0 = r7.A01
            if (r1 >= r0) goto L14
            boolean r0 = r7.A0A()
            if (r0 != 0) goto L14
            int r4 = r4 + 1
            goto L5
        L14:
            int r3 = r7.A02
            int r0 = r7.A01
            r2 = 0
            r1 = 1
            if (r3 != r0) goto L2e
            r0 = 1
        L1d:
            r7.A02 = r6
            r7.A00 = r5
            if (r0 != 0) goto L2d
            int r0 = r4 * 2
            int r0 = r0 + r1
            boolean r0 = r7.A0B(r0)
            if (r0 == 0) goto L2d
            r2 = 1
        L2d:
            return r2
        L2e:
            r0 = 0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I0.A09():boolean");
    }

    public final boolean A0A() {
        boolean returnValue = (this.A03[this.A02] & (NotificationCompat.FLAG_HIGH_PRIORITY >> this.A00)) != 0;
        A06();
        return returnValue;
    }

    public final boolean A0B(int i) {
        int numBytes = this.A02;
        int oldByteOffset = i / 8;
        int i5 = this.A02 + oldByteOffset;
        int newBitOffset = (this.A00 + i) - (oldByteOffset * 8);
        if (newBitOffset > 7) {
            i5++;
            newBitOffset -= 8;
        }
        int newByteOffset = numBytes + 1;
        while (newByteOffset <= i5 && i5 < this.A01) {
            if (A02(newByteOffset)) {
                i5++;
                newByteOffset += 2;
            }
            newByteOffset++;
        }
        int oldByteOffset2 = this.A01;
        if (i5 >= oldByteOffset2) {
            return i5 == oldByteOffset2 && newBitOffset == 0;
        }
        return true;
    }
}
