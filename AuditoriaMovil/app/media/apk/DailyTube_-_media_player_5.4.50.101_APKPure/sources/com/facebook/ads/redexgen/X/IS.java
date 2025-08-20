package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class IS implements Choreographer.FrameCallback, Handler.Callback {
    public static byte[] A05;
    public static final IS A06;
    public int A00;
    public Choreographer A01;
    public final Handler A02;
    public final HandlerThread A03;
    public volatile long A04 = -9223372036854775807L;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{105, 66, 69, 88, 79, 69, 77, 88, 75, 90, 66, 79, 88, 101, 93, 68, 79, 88, 16, 98, 75, 68, 78, 70, 79, 88};
    }

    static {
        A05();
        A06 = new IS();
    }

    public IS() {
        HandlerThread handlerThread = new HandlerThread(A01(0, 26, R.styleable.AppCompatTheme_toolbarStyle));
        this.A03 = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.A02 = handler;
        handler.sendEmptyMessage(0);
    }

    public static IS A00() {
        return A06;
    }

    private void A02() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 1) {
            this.A01.postFrameCallback(this);
        }
    }

    private void A03() {
        this.A01 = Choreographer.getInstance();
    }

    private void A04() {
        int i = this.A00 - 1;
        this.A00 = i;
        if (i == 0) {
            this.A01.removeFrameCallback(this);
            this.A04 = -9223372036854775807L;
        }
    }

    public final void A06() {
        this.A02.sendEmptyMessage(1);
    }

    public final void A07() {
        this.A02.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.A04 = j2;
        this.A01.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A03();
                return true;
            case 1:
                A02();
                return true;
            case 2:
                A04();
                return true;
            default:
                return false;
        }
    }
}
