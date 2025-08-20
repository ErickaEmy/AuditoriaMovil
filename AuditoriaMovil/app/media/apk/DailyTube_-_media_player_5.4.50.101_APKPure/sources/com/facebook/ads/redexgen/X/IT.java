package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class IT {
    public static byte[] A0C;
    public static String[] A0D = {"xjDjhxCoR5E9PaR", "vpLFoDls1yXd", "vp7lX6ix760xQFA", "plC", "mnLR5dwnrEQUmTikV", "t5Nzngx1C9ROF", "WJjUxBMWNKZwORVrQ", "T20oC"};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public boolean A08;
    public final WindowManager A09;
    public final IR A0A;
    public final IS A0B;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 91;
            if (A0D[5].length() != 13) {
                throw new RuntimeException();
            }
            A0D[2] = "fcjVOHbVEUruwwj";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{-13, -8, 2, -1, -5, -16, 8, 29, 15, 20, 10, 21, 29};
    }

    static {
        A04();
    }

    public IT() {
        this(null);
    }

    public IT(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.A09 = (WindowManager) context.getSystemService(A02(7, 6, 75));
        } else {
            this.A09 = null;
        }
        if (this.A09 != null) {
            this.A0A = IF.A02 >= 17 ? A01(context) : null;
            this.A0B = IS.A00();
        } else {
            this.A0A = null;
            this.A0B = null;
        }
        this.A06 = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
    }

    public static long A00(long j2, long j4, long j6) {
        long j7;
        long vsyncCount = j6 * ((j2 - j4) / j6);
        long j8 = j4 + vsyncCount;
        if (j2 <= j8) {
            j7 = j8 - j6;
        } else {
            j7 = j8;
            if (A0D[5].length() != 13) {
                throw new RuntimeException();
            }
            A0D[7] = "KRnDU";
            j8 += j6;
        }
        return j8 - j2 < j2 - j7 ? j8 : j7;
    }

    private IR A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 52));
        if (displayManager == null) {
            return null;
        }
        return new IR(this, displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        Display defaultDisplay = this.A09.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.A06 = refreshRate;
            this.A07 = (refreshRate * 80) / 100;
        }
    }

    private boolean A06(long j2, long j4) {
        long j6 = j2 - this.A04;
        long elapsedFrameTimeNs = this.A05;
        return Math.abs((j4 - elapsedFrameTimeNs) - j6) > 20000000;
    }

    public final long A07(long j2, long j4) {
        long j6 = 1000 * j2;
        long j7 = j6;
        long j8 = j4;
        if (this.A08) {
            if (j2 != this.A02) {
                this.A01++;
                this.A00 = this.A03;
            }
            long j9 = this.A01;
            if (j9 >= 6) {
                long j10 = this.A00 + ((j6 - this.A04) / j9);
                if (!A06(j10, j4)) {
                    j8 = (this.A05 + j10) - this.A04;
                    j7 = j10;
                } else {
                    this.A08 = false;
                }
            } else if (A06(j6, j4)) {
                this.A08 = false;
            }
        }
        if (!this.A08) {
            this.A04 = j6;
            this.A05 = j4;
            this.A01 = 0L;
            this.A08 = true;
        }
        this.A02 = j2;
        this.A03 = j7;
        IS is = this.A0B;
        if (is != null) {
            long j11 = this.A06;
            if (A0D[2].length() != 15) {
                throw new RuntimeException();
            }
            A0D[3] = "GMIC0";
            if (j11 != -9223372036854775807L) {
                long j12 = is.A04;
                if (j12 == -9223372036854775807L) {
                    return j8;
                }
                return A00(j8, j12, this.A06) - this.A07;
            }
        }
        return j8;
    }

    public final void A08() {
        if (this.A09 != null) {
            IR ir = this.A0A;
            if (ir != null) {
                ir.A01();
            }
            this.A0B.A07();
        }
    }

    public final void A09() {
        this.A08 = false;
        if (this.A09 != null) {
            this.A0B.A06();
            IR ir = this.A0A;
            if (ir != null) {
                ir.A00();
            }
            A03();
        }
    }
}
