package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class G8 {
    public static String[] A09 = {"Ae51WtdtbsQ7oHVSUK2kH2lkhYtCD", "qx7lDBYo1odo5Y55vJBjPuPd0SCIUsyA", "8Fm6CMM7j8ObWzEih", "Wlrw6QUG7RBgeIlzL5kKGv4h4BsSo73q", "KMN6ZJtdLdMqvcVUA0dmI7c1fz02SP9b", "8oEfNfnBPUmBxW5HI", "jCL3JtrXJCo63I6Hw50xrAvVkRQtnXEj", "6zRYHFDNSsaLRa7ASpeJIQcC6Xopjreo"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final C0697Hz A07 = new C0697Hz();
    public final int[] A08 = new int[256];

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C0697Hz c0697Hz, int i) {
        int totalLength;
        if (i < 4) {
            return;
        }
        c0697Hz.A0Z(3);
        int i5 = i - 4;
        if (((c0697Hz.A0E() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 ? 1 : 0) != 0) {
            String[] strArr = A09;
            if (strArr[4].charAt(22) == strArr[7].charAt(22)) {
                String[] strArr2 = A09;
                strArr2[2] = "m4TsyqBzkyxUuct48";
                strArr2[5] = "zfIYrv7wq9TBAE9Jz";
                if (i5 < 7 || (totalLength = c0697Hz.A0G()) < 4) {
                    return;
                }
                this.A01 = c0697Hz.A0I();
                this.A00 = c0697Hz.A0I();
                this.A07.A0W(totalLength - 4);
                i5 -= 7;
            }
            throw new RuntimeException();
        }
        int A06 = this.A07.A06();
        int position = this.A07.A07();
        if (A06 < position && i5 > 0) {
            int bytesToRead = Math.min(i5, position - A06);
            C0697Hz c0697Hz2 = this.A07;
            String[] strArr3 = A09;
            if (strArr3[4].charAt(22) == strArr3[7].charAt(22)) {
                A09[6] = "1YWr3OwQ0jPjYWbciqj9BosGRiIvHZyi";
                c0697Hz.A0c(c0697Hz2.A00, A06, bytesToRead);
                this.A07.A0Y(A06 + bytesToRead);
                return;
            }
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(C0697Hz c0697Hz, int i) {
        if (i < 19) {
            return;
        }
        this.A05 = c0697Hz.A0I();
        this.A04 = c0697Hz.A0I();
        c0697Hz.A0Z(11);
        this.A02 = c0697Hz.A0I();
        this.A03 = c0697Hz.A0I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(C0697Hz c0697Hz, int i) {
        if (i % 5 != 2) {
            return;
        }
        c0697Hz.A0Z(2);
        Arrays.fill(this.A08, 0);
        int i5 = i / 5;
        for (int index = 0; index < i5; index++) {
            int A0E = c0697Hz.A0E();
            int a2 = c0697Hz.A0E();
            int A0E2 = c0697Hz.A0E();
            int A0E3 = c0697Hz.A0E();
            int entryCount = A0E2 - 128;
            int i6 = (int) (a2 + (entryCount * 1.402d));
            int g2 = (int) ((a2 - ((A0E3 - 128) * 0.34414d)) - ((A0E2 - 128) * 0.71414d));
            int entryCount2 = c0697Hz.A0E() << 24;
            this.A08[A0E] = entryCount2 | (IF.A06(i6, 0, 255) << 16) | (IF.A06(g2, 0, 255) << 8) | IF.A06((int) (a2 + ((A0E3 - 128) * 1.772d)), 0, 255);
        }
        this.A06 = true;
    }

    public final C0635Fn A06() {
        int A0E;
        if (this.A05 == 0 || this.A04 == 0 || this.A01 == 0 || this.A00 == 0 || this.A07.A07() == 0 || this.A07.A06() != this.A07.A07()) {
            return null;
        }
        boolean z2 = this.A06;
        if (A09[6].charAt(24) != 'V') {
            A09[1] = "nq70zeHujM7cnH9A4IhpB5iOObfNW5He";
            if (!z2) {
                return null;
            }
            this.A07.A0Y(0);
            int[] iArr = new int[this.A01 * this.A00];
            int switchBits = 0;
            while (switchBits < iArr.length) {
                int argbBitmapDataIndex = this.A07.A0E();
                if (argbBitmapDataIndex != 0) {
                    int[] argbBitmapData = this.A08;
                    iArr[switchBits] = argbBitmapData[argbBitmapDataIndex];
                    switchBits++;
                } else {
                    int argbBitmapDataIndex2 = this.A07.A0E();
                    if (argbBitmapDataIndex2 != 0) {
                        if ((argbBitmapDataIndex2 & 64) == 0) {
                            A0E = argbBitmapDataIndex2 & 63;
                        } else {
                            A0E = ((argbBitmapDataIndex2 & 63) << 8) | this.A07.A0E();
                        }
                        Arrays.fill(iArr, switchBits, switchBits + A0E, (argbBitmapDataIndex2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0 ? 0 : this.A08[this.A07.A0E()]);
                        switchBits += A0E;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.A01, this.A00, Bitmap.Config.ARGB_8888);
            int argbBitmapDataIndex3 = this.A05;
            int i = this.A04;
            return new C0635Fn(createBitmap, this.A02 / argbBitmapDataIndex3, 0, this.A03 / i, 0, this.A01 / argbBitmapDataIndex3, this.A00 / i);
        }
        throw new RuntimeException();
    }

    public final void A07() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0W(0);
        this.A06 = false;
    }
}
