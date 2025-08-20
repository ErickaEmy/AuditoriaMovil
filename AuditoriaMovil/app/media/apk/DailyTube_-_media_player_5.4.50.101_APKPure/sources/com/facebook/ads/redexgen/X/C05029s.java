package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.9s  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05029s {
    public static byte[] A0F;
    public long A00;
    public C05029s A01;
    public C05039t A02;
    public TrackGroupArray A03;
    public C0657Gk A04;
    public boolean A05;
    public boolean A06;
    public C0657Gk A07;
    public final WP A08;
    public final Object A09;
    public final FB[] A0A;
    public final boolean[] A0B;
    public final InterfaceC0614Eq A0C;
    public final AbstractC0656Gj A0D;
    public final AA[] A0E;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{79, 103, 102, 107, 99, 82, 103, 112, 107, 109, 102, 74, 109, 110, 102, 103, 112, 81, 100, 115, 104, 110, 101, 33, 115, 100, 109, 100, 96, 114, 100, 33, 103, 96, 104, 109, 100, 101, 47};
    }

    public C05029s(AA[] aaArr, long j2, AbstractC0656Gj abstractC0656Gj, InterfaceC0659Gm interfaceC0659Gm, InterfaceC0614Eq interfaceC0614Eq, Object obj, C05039t c05039t) {
        this.A0E = aaArr;
        this.A00 = j2 - c05039t.A03;
        this.A0D = abstractC0656Gj;
        this.A0C = interfaceC0614Eq;
        this.A09 = AbstractC0672Ha.A01(obj);
        this.A02 = c05039t;
        this.A0A = new FB[aaArr.length];
        this.A0B = new boolean[aaArr.length];
        WP A4k = interfaceC0614Eq.A4k(c05039t.A04, interfaceC0659Gm);
        this.A08 = c05039t.A02 != Long.MIN_VALUE ? new CI(A4k, true, 0L, c05039t.A02) : A4k;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0003 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A02(com.facebook.ads.redexgen.X.C0657Gk r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            int r0 = r4.A00
            if (r2 >= r0) goto L19
            boolean r1 = r4.A00(r2)
            com.facebook.ads.redexgen.X.Gh r0 = r4.A01
            com.facebook.ads.redexgen.X.Gg r0 = r0.A00(r2)
            if (r1 == 0) goto L16
            if (r0 == 0) goto L16
            r0.A5U()
        L16:
            int r2 = r2 + 1
            goto L1
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C05029s.A02(com.facebook.ads.redexgen.X.Gk):void");
    }

    private void A03(C0657Gk c0657Gk) {
        C0657Gk c0657Gk2 = this.A07;
        this.A07 = c0657Gk;
        if (c0657Gk != null) {
            A02(c0657Gk);
        }
    }

    private void A04(FB[] fbArr) {
        int i = 0;
        while (true) {
            AA[] aaArr = this.A0E;
            int i5 = aaArr.length;
            if (i < i5) {
                if (aaArr[i].A8C() == 5 && this.A04.A00(i)) {
                    fbArr[i] = new WU();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void A05(FB[] fbArr) {
        int i = 0;
        while (true) {
            AA[] aaArr = this.A0E;
            int i5 = aaArr.length;
            if (i < i5) {
                if (aaArr[i].A8C() == 5) {
                    fbArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final long A06() {
        if (this.A06) {
            return this.A08.A7U();
        }
        return 0L;
    }

    public final long A07() {
        return this.A00;
    }

    public final long A08(long j2) {
        return j2 - A07();
    }

    public final long A09(long j2) {
        return A07() + j2;
    }

    public final long A0A(long j2, boolean z2) {
        return A0B(j2, z2, new boolean[this.A0E.length]);
    }

    public final long A0B(long j2, boolean z2, boolean[] zArr) {
        int i = 0;
        while (true) {
            int i5 = this.A04.A00;
            boolean z3 = false;
            if (i >= i5) {
                break;
            }
            boolean[] zArr2 = this.A0B;
            if (!z2 && this.A04.A02(this.A07, i)) {
                z3 = true;
            }
            zArr2[i] = z3;
            i++;
        }
        A05(this.A0A);
        A03(this.A04);
        C0654Gh c0654Gh = this.A04.A01;
        long AFm = this.A08.AFm(c0654Gh.A01(), this.A0B, this.A0A, zArr, j2);
        A04(this.A0A);
        this.A05 = false;
        int i6 = 0;
        while (true) {
            FB[] fbArr = this.A0A;
            if (i6 < fbArr.length) {
                if (fbArr[i6] != null) {
                    AbstractC0672Ha.A04(this.A04.A00(i6));
                    int i8 = this.A0E[i6].A8C();
                    if (i8 != 5) {
                        this.A05 = true;
                    }
                } else {
                    AbstractC0672Ha.A04(c0654Gh.A00(i6) == null);
                }
                i6++;
            } else {
                return AFm;
            }
        }
    }

    public final long A0C(boolean z2) {
        if (!this.A06) {
            return this.A02.A03;
        }
        long A6D = this.A08.A6D();
        if (A6D == Long.MIN_VALUE && z2) {
            return this.A02.A01;
        }
        return A6D;
    }

    public final void A0D() {
        A03(null);
        try {
            if (this.A02.A02 != Long.MIN_VALUE) {
                this.A0C.AEa(((CI) this.A08).A05);
            } else {
                this.A0C.AEa(this.A08);
            }
        } catch (RuntimeException e2) {
            Log.e(A00(0, 17, 28), A00(17, 22, 31), e2);
        }
    }

    public final void A0E(float f4) throws C04879c {
        this.A06 = true;
        this.A03 = this.A08.A8B();
        A0I(f4);
        long A0A = A0A(this.A02.A03, false);
        long j2 = this.A00;
        long newStartPositionUs = this.A02.A03;
        this.A00 = j2 + (newStartPositionUs - A0A);
        this.A02 = this.A02.A01(A0A);
    }

    public final void A0F(long j2) {
        this.A08.A4T(A08(j2));
    }

    public final void A0G(long j2) {
        if (this.A06) {
            this.A08.AER(A08(j2));
        }
    }

    public final boolean A0H() {
        return this.A06 && (!this.A05 || this.A08.A6D() == Long.MIN_VALUE);
    }

    public final boolean A0I(float f4) throws C04879c {
        InterfaceC0653Gg[] A01;
        C0657Gk A0T = this.A0D.A0T(this.A0E, this.A03);
        C0657Gk selectorResult = this.A07;
        if (A0T.A01(selectorResult)) {
            return false;
        }
        this.A04 = A0T;
        for (InterfaceC0653Gg interfaceC0653Gg : A0T.A01.A01()) {
            if (interfaceC0653Gg != null) {
                interfaceC0653Gg.ACc(f4);
            }
        }
        return true;
    }
}
