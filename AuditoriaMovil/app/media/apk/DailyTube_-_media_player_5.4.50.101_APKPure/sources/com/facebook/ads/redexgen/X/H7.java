package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.redexgen.X.H8;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
/* loaded from: assets/audience_network.dex */
public final class H7<T extends H8> extends Handler implements Runnable {
    public static byte[] A0A;
    public int A00;
    public H6<T> A01;
    public IOException A02;
    public final int A03;
    public final long A04;
    public final T A05;
    public volatile Thread A06;
    public volatile boolean A07;
    public volatile boolean A08;
    public final /* synthetic */ C1044Vq A09;

    static {
        A04();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0A = new byte[]{-124, 119, -85, -76, -69, -122, -70, -35, -49, -46, -62, -49, -31, -39, -80, -42, -43, -80, -57, -82, -58, -50, -48, -45, -38, -127, -58, -45, -45, -48, -45, -127, -51, -48, -62, -59, -54, -49, -56, -127, -44, -43, -45, -58, -62, -50, -29, -4, -13, 6, -2, -13, -15, 2, -13, -14, -82, -13, 0, 0, -3, 0, -82, -6, -3, -17, -14, -9, -4, -11, -82, 1, 2, 0, -13, -17, -5, 118, -113, -122, -103, -111, -122, -124, -107, -122, -123, 65, -122, -103, -124, -122, -111, -107, -118, -112, -113, 65, -119, -126, -113, -123, -115, -118, -113, -120, 65, -115, -112, -126, -123, 65, -124, -112, -114, -111, -115, -122, -107, -122, -123, 120, -111, -120, -101, -109, -120, -122, -105, -120, -121, 67, -120, -101, -122, -120, -109, -105, -116, -110, -111, 67, -113, -110, -124, -121, -116, -111, -118, 67, -106, -105, -107, -120, -124, -112, -4, -1, -15, -12, -54, -52, -13, -4, 3, -50};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A08) {
                return;
            }
            if (message.what == 0) {
                A02();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                A03();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.A04;
                if (this.A07) {
                    this.A01.ABz(this.A05, elapsedRealtime, j2, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.A01.ABz(this.A05, elapsedRealtime, j2, false);
                        return;
                    case 2:
                        try {
                            this.A01.AC1(this.A05, elapsedRealtime, j2);
                            return;
                        } catch (RuntimeException e2) {
                            Log.e(A01(6, 8, 85), A01(77, 44, 8), e2);
                            this.A09.A01 = new HC(e2);
                            return;
                        }
                    case 3:
                        IOException iOException = (IOException) message.obj;
                        this.A02 = iOException;
                        int AC2 = this.A01.AC2(this.A05, elapsedRealtime, j2, iOException);
                        if (AC2 == 3) {
                            this.A09.A01 = this.A02;
                            return;
                        } else if (AC2 != 2) {
                            int i = 1;
                            if (AC2 != 1) {
                                i = 1 + this.A00;
                            }
                            this.A00 = i;
                            A06(A00());
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H6 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.H8> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    public H7(C1044Vq c1044Vq, Looper looper, T loadable, H6<T> h62, int i, long j2) {
        super(looper);
        this.A09 = c1044Vq;
        this.A05 = loadable;
        this.A01 = h62;
        this.A03 = i;
        this.A04 = j2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    private long A00() {
        return Math.min((this.A00 - 1) * 1000, 5000);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    private void A02() {
        ExecutorService executorService;
        H7 h7;
        this.A02 = null;
        executorService = this.A09.A02;
        h7 = this.A09.A00;
        executorService.execute(h7);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    private void A03() {
        this.A09.A00 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    public final void A05(int i) throws IOException {
        IOException iOException = this.A02;
        if (iOException == null || this.A00 <= i) {
            return;
        }
        throw iOException;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    public final void A06(long j2) {
        H7 h7;
        h7 = this.A09.A00;
        AbstractC0672Ha.A04(h7 == null);
        this.A09.A00 = this;
        if (j2 > 0) {
            sendEmptyMessageDelayed(0, j2);
        } else {
            A02();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    public final void A07(boolean z2) {
        this.A08 = z2;
        this.A02 = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z2) {
                sendEmptyMessage(1);
            }
        } else {
            this.A07 = true;
            this.A05.A4A();
            if (this.A06 != null) {
                this.A06.interrupt();
            }
        }
        if (z2) {
            A03();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.A01.ABz(this.A05, elapsedRealtime, elapsedRealtime - this.A04, true);
            this.A01 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.H7 != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.H8> */
    @Override // java.lang.Runnable
    public final void run() {
        String A01 = A01(6, 8, 85);
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            this.A06 = Thread.currentThread();
                            if (!this.A07) {
                                IC.A02(A01(156, 10, 119) + this.A05.getClass().getSimpleName() + A01(0, 6, 47));
                                try {
                                    this.A05.A9P();
                                } finally {
                                    IC.A00();
                                }
                            }
                            if (!this.A08) {
                                sendEmptyMessage(2);
                            }
                        } catch (IOException e2) {
                            if (!this.A08) {
                                obtainMessage(3, e2).sendToTarget();
                            }
                        }
                    } catch (OutOfMemoryError e3) {
                        Log.e(A01, A01(14, 32, 72), e3);
                        if (!this.A08) {
                            obtainMessage(3, new HC(e3)).sendToTarget();
                        }
                    }
                } catch (Exception e5) {
                    Log.e(A01, A01(121, 35, 10), e5);
                    if (!this.A08) {
                        obtainMessage(3, new HC(e5)).sendToTarget();
                    }
                }
            } catch (Error e6) {
                Log.e(A01, A01(46, 31, 117), e6);
                if (!this.A08) {
                    obtainMessage(4, e6).sendToTarget();
                }
                throw e6;
            } catch (InterruptedException unused) {
                AbstractC0672Ha.A04(this.A07);
                if (!this.A08) {
                    sendEmptyMessage(2);
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
