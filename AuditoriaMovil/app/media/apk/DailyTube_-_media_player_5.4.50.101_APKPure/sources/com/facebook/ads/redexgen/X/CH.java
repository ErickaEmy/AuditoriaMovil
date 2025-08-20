package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class CH {
    public static byte[] A03;
    public static String[] A04 = {"jNGyeOKibO3rZ", "Gh5JKt6GRlqFQi5f7wncYkOvXKUgvq3H", "CofAGDTz318WCwUORyk9cSrFfeh2Hkrj", "9nnBa0OOqYKGA4mW7JXlquoRY2XdVC9l", "SGv5o9U73t5KHQiabCNHP6atzf1gi70l", "Pw4XIo5raqSVixY1hwfj9nDYbuGZRESR", "ADqcQvt0hpjLC586x1ggUJbhpZ3DSlma", "N1vQLbUqrUUUOY9UOZX86MfJnRzuBUgh"};
    public static final long[] A05;
    public int A00;
    public int A01;
    public final byte[] A02 = new byte[8];

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A04;
            if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
                break;
            }
            A04[3] = "ZERhDI0eRTm5worZScrGBygyYS9gFskv";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 77);
            String[] strArr2 = A04;
            if (strArr2[4].charAt(6) != strArr2[7].charAt(6)) {
                break;
            }
            String[] strArr3 = A04;
            strArr3[6] = "5jMkCIwJgzdMCgzRGNs7rdJ4OYAUyBry";
            strArr3[2] = "xyMLmlHhB2f8Cz8kVUOrh9ZTHBCB3Rr0";
            i8++;
        }
        throw new RuntimeException();
    }

    public static void A03() {
        A03 = new byte[]{64, 97, 46, 120, 111, 98, 103, 106, 46, 120, 111, 124, 103, 96, 122, 46, 98, 107, 96, 105, 122, 102, 46, 99, 111, 125, 101, 46, 104, 97, 123, 96, 106};
    }

    static {
        A03();
        A05 = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    public static int A00(int i) {
        int i5 = 0;
        while (true) {
            long[] jArr = A05;
            int varIntLength = jArr.length;
            if (i5 >= varIntLength) {
                return -1;
            }
            int varIntLength2 = ((jArr[i5] & i) > 0L ? 1 : ((jArr[i5] & i) == 0L ? 0 : -1));
            if (varIntLength2 != 0) {
                return i5 + 1;
            }
            i5++;
        }
    }

    public static long A01(byte[] bArr, int i, boolean z2) {
        long j2 = bArr[0] & 255;
        if (z2) {
            long j4 = A05[i - 1];
            String[] strArr = A04;
            if (strArr[5].charAt(17) != strArr[1].charAt(17)) {
                throw new RuntimeException();
            }
            A04[0] = "UDmiDfZ1LL8gM";
            j2 &= j4 ^ (-1);
        }
        for (int i5 = 1; i5 < i; i5++) {
            long j6 = j2 << 8;
            byte b2 = bArr[i5];
            if (A04[3].charAt(15) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "cm8OQheSofC6CbyPg1WnuKrHLhcydwvw";
            strArr2[2] = "ayPMvBCy6e1LCFJPDiyGHhHMjUGacyfS";
            long varint = b2;
            j2 = j6 | (varint & 255);
        }
        return j2;
    }

    public final int A04() {
        return this.A00;
    }

    public final long A05(InterfaceC0555Bt interfaceC0555Bt, boolean z2, boolean z3, int i) throws IOException, InterruptedException {
        if (this.A01 == 0) {
            if (!interfaceC0555Bt.AEM(this.A02, 0, 1, z2)) {
                return -1L;
            }
            int firstByte = this.A02[0] & 255;
            int A00 = A00(firstByte);
            this.A00 = A00;
            if (A00 != -1) {
                this.A01 = 1;
            } else {
                throw new IllegalStateException(A02(0, 33, 67));
            }
        }
        int i5 = this.A00;
        if (i5 > i) {
            this.A01 = 0;
            return -2L;
        }
        if (i5 != 1) {
            interfaceC0555Bt.readFully(this.A02, 1, i5 - 1);
        }
        this.A01 = 0;
        return A01(this.A02, this.A00, z3);
    }

    public final void A06() {
        this.A01 = 0;
        this.A00 = 0;
    }
}
