package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class W2 implements InterfaceC0659Gm {
    public static byte[] A08;
    public int A00;
    public int A01;
    public int A02;
    public C0658Gl[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final C0658Gl[] A07;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{100, 104, 40, 19, 24, 5, 13, 24, 30, 9, 24, 25, 93, 28, 17, 17, 18, 30, 28, 9, 20, 18, 19, 71, 93};
    }

    public W2(boolean z2, int i) {
        this(z2, i, 0);
    }

    public W2(boolean z2, int i, int i5) {
        AbstractC0672Ha.A03(i > 0);
        AbstractC0672Ha.A03(i5 >= 0);
        this.A05 = z2;
        this.A04 = i;
        this.A01 = i5;
        this.A03 = new C0658Gl[i5 + 100];
        if (i5 > 0) {
            this.A06 = new byte[i5 * i];
            for (int i6 = 0; i6 < i5; i6++) {
                this.A03[i6] = new C0658Gl(this.A06, i6 * i);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new C0658Gl[1];
    }

    public final synchronized int A02() {
        return this.A00 * this.A04;
    }

    public final synchronized void A03() {
        if (this.A05) {
            A04(0);
        }
    }

    public final synchronized void A04(int i) {
        boolean targetBufferSizeReduced = i < this.A02;
        this.A02 = i;
        if (targetBufferSizeReduced) {
            AGj();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0659Gm
    public final synchronized C0658Gl A3X() {
        C0658Gl c0658Gl;
        this.A00++;
        int i = this.A01;
        if (i > 0) {
            C0658Gl[] c0658GlArr = this.A03;
            int i5 = i - 1;
            this.A01 = i5;
            c0658Gl = c0658GlArr[i5];
            c0658GlArr[i5] = null;
        } else {
            c0658Gl = new C0658Gl(new byte[this.A04], 0);
        }
        return c0658Gl;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0659Gm
    public final int A7D() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0659Gm
    public final synchronized void AEW(C0658Gl c0658Gl) {
        C0658Gl[] c0658GlArr = this.A07;
        c0658GlArr[0] = c0658Gl;
        AEX(c0658GlArr);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0659Gm
    public final synchronized void AEX(C0658Gl[] c0658GlArr) {
        int i = this.A01;
        int length = c0658GlArr.length + i;
        C0658Gl[] c0658GlArr2 = this.A03;
        if (length >= c0658GlArr2.length) {
            this.A03 = (C0658Gl[]) Arrays.copyOf(c0658GlArr2, Math.max(c0658GlArr2.length * 2, i + c0658GlArr.length));
        }
        for (C0658Gl c0658Gl : c0658GlArr) {
            if (c0658Gl.A01 == this.A06 || c0658Gl.A01.length == this.A04) {
                C0658Gl[] c0658GlArr3 = this.A03;
                int i5 = this.A01;
                this.A01 = i5 + 1;
                c0658GlArr3[i5] = c0658Gl;
            } else {
                throw new IllegalArgumentException(A00(2, 23, R.styleable.AppCompatTheme_textColorAlertDialogListItem) + System.identityHashCode(c0658Gl.A01) + A00(0, 2, 91) + System.identityHashCode(this.A06) + A00(0, 2, 91) + c0658Gl.A01.length + A00(0, 2, 91) + this.A04);
            }
        }
        this.A00 -= c0658GlArr.length;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0659Gm
    public final synchronized void AGj() {
        int A04 = IF.A04(this.A02, this.A04);
        int targetAllocationCount = this.A00;
        int highIndex = Math.max(0, A04 - targetAllocationCount);
        int targetAvailableCount = this.A01;
        if (highIndex >= targetAvailableCount) {
            return;
        }
        if (this.A06 != null) {
            int lowIndex = 0;
            int i = targetAvailableCount - 1;
            while (lowIndex <= i) {
                C0658Gl highAllocation = this.A03[lowIndex];
                if (highAllocation.A01 == this.A06) {
                    lowIndex++;
                } else {
                    C0658Gl lowAllocation = this.A03[i];
                    if (lowAllocation.A01 != this.A06) {
                        i--;
                    } else {
                        C0658Gl[] c0658GlArr = this.A03;
                        c0658GlArr[lowIndex] = lowAllocation;
                        int targetAllocationCount2 = i - 1;
                        c0658GlArr[i] = highAllocation;
                        i = targetAllocationCount2;
                        lowIndex++;
                    }
                }
            }
            highIndex = Math.max(highIndex, lowIndex);
            int targetAllocationCount3 = this.A01;
            if (highIndex >= targetAllocationCount3) {
                return;
            }
        }
        Arrays.fill(this.A03, highIndex, this.A01, (Object) null);
        this.A01 = highIndex;
    }
}
