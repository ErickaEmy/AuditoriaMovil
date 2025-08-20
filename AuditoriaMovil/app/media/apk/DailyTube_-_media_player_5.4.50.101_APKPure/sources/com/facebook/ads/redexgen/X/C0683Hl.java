package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Hl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0683Hl implements InterfaceC0940Rp {
    public static boolean A03;
    public static byte[] A04;
    public static final InterfaceC0938Rn A05;
    public static final String A06;
    public long A00 = 0;
    public final InterfaceC0939Ro A01;
    public final InterfaceC0945Ru A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{Byte.MAX_VALUE, -88, -85, -100, -94, -89, -96, 89, -89, -98, -79, -83, 89, -84, -78, -89, -100, 89, -102, -83, 89, -77, -57, -40, -47, -122, -57, -39, -122, -44, -43, -122, -39, -33, -44, -55, -50, -40, -43, -44, -49, -32, -57, -38, -49, -43, -44, -122, -39, -55, -50, -53, -54, -37, -46, -53, -54, -108, -122, -78, -57, -39, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -122, -76, -53, -34, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -51, -26, -33, -33, -22, -102, -32, -23, -20, -102, -97, -34, -102, -25, -29, -26, -26, -29, -19, -88, -14, -15, -43, -8, -15, -55, -20, -15, -20, -10, -21, -24, -25};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0940Rp
    public final synchronized void A5k(int i) {
        long A4z = this.A02.A4z() + (i * 1000000 * (A03 ? 1 : 1000));
        long j2 = this.A00;
        if (j2 == 0 || j2 > A4z) {
            this.A00 = A4z;
            notifyAll();
        }
    }

    static {
        A02();
        A06 = C0683Hl.class.getSimpleName();
        A05 = new C0686Ho();
        A03 = false;
    }

    public C0683Hl(InterfaceC0939Ro interfaceC0939Ro, InterfaceC0945Ru interfaceC0945Ru) {
        this.A01 = interfaceC0939Ro;
        this.A02 = interfaceC0945Ru;
        Thread scheduler = new Thread(new RunnableC0941Rq(this));
        scheduler.start();
    }

    private void A01() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long A4z = this.A02.A4z();
                    long j2 = this.A00;
                    if (A4z < j2) {
                        int millisToSleep = (int) ((j2 - A4z) / 1000000);
                        if (millisToSleep >= 1) {
                            String.format(Locale.US, A00(92, 20, 69), Integer.valueOf(millisToSleep));
                            try {
                                long current = millisToSleep;
                                this.A02.AGQ(this, current);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A01.AFP();
                    long A4z2 = this.A02.A4z();
                    if (0 != 0) {
                        break;
                    }
                    synchronized (this) {
                        if (this.A00 < A4z2) {
                            String.format(Locale.US, A00(21, 71, 49), Long.valueOf(A4z2), Long.valueOf(this.A00));
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
        throw new NullPointerException(A00(R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 13, 78));
    }

    public static /* synthetic */ void A03(C0683Hl c0683Hl) {
        c0683Hl.A01();
        throw null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0940Rp
    public final synchronized void A5l() {
        this.A00 = this.A02.A4z();
        String str = A00(0, 21, 4) + this.A00;
        notifyAll();
    }
}
