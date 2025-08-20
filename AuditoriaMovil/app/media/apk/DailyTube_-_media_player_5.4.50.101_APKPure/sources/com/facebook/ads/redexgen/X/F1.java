package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: assets/audience_network.dex */
public final class F1 {
    public static String[] A04 = {"XHo", "ubtbrXFiKU0aMD9WZdFFXMvL5SNCKhBD", "k9cdhOGQS1oEdCdR21VeueSE4nGT", "BZNadIlHUT8LbNbZ8qdMYncW4fXCJJFh", "22DNreJXUwzG5I9t9ymbmjKefjfUTWMr", "OkM0GcBH5aVjMNZagw1JqhxPR8ijdnHI", "ik3Hzc9el9B7KCBCFVHKN4tCPL2D2JGF", "0FgMGgJ2UsG2ZcXwt2m5OtQLezKmVI44"};
    public final int A00;
    public final C0612Eo A01;
    public final long A02;
    public final CopyOnWriteArrayList<F0> A03;

    public F1() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public F1(CopyOnWriteArrayList<F0> copyOnWriteArrayList, int i, C0612Eo c0612Eo, long j2) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i;
        this.A01 = c0612Eo;
        this.A02 = j2;
    }

    private long A00(long j2) {
        long A01 = C9W.A01(j2);
        if (A01 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long mediaTimeMs = this.A02;
        return mediaTimeMs + A01;
    }

    private void A01(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public final F1 A02(int i, C0612Eo c0612Eo, long j2) {
        return new F1(this.A03, i, c0612Eo, j2);
    }

    public final void A03() {
        AbstractC0672Ha.A04(this.A01 != null);
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0615Er(this, listener));
        }
    }

    public final void A04() {
        AbstractC0672Ha.A04(this.A01 != null);
        String[] strArr = A04;
        if (strArr[4].charAt(4) != strArr[1].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "rYA4ryMG3XFm73cnSWA4HWNW3HUxv7KC";
        strArr2[1] = "1YJ2rSWw51hvYcz1kikUBhJeKIWd76IZ";
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 listenerAndHandler = it.next();
            A01(listenerAndHandler.A00, new RunnableC0616Es(this, listenerAndHandler.A01));
        }
    }

    public final void A05() {
        AbstractC0672Ha.A04(this.A01 != null);
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0621Ex(this, listener));
        }
    }

    public final void A06(int i, Format format, int i5, Object obj, long j2) {
        A0C(new F3(1, i, format, i5, obj, A00(j2), -9223372036854775807L));
    }

    public final void A07(Handler handler, F4 f4) {
        AbstractC0672Ha.A03((handler == null || f4 == null) ? false : true);
        this.A03.add(new F0(handler, f4));
    }

    public final void A08(F2 f22, F3 f32) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0619Ev(this, listener, f22, f32));
        }
    }

    public final void A09(F2 f22, F3 f32) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0618Eu(this, listener, f22, f32));
        }
    }

    public final void A0A(F2 f22, F3 f32) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0617Et(this, listener, f22, f32));
        }
    }

    public final void A0B(F2 f22, F3 f32, IOException iOException, boolean z2) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            A01(next.A00, new RunnableC0620Ew(this, next.A01, f22, f32, iOException, z2));
        }
    }

    public final void A0C(F3 f32) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 next = it.next();
            F4 listener = next.A01;
            A01(next.A00, new RunnableC0623Ez(this, listener, f32));
        }
    }

    public final void A0D(F4 f4) {
        Iterator<F0> it = this.A03.iterator();
        while (it.hasNext()) {
            F0 listenerAndHandler = it.next();
            if (listenerAndHandler.A01 == f4) {
                this.A03.remove(listenerAndHandler);
            }
        }
    }

    public final void A0E(C0671Gy c0671Gy, int i, int i5, Format format, int i6, Object obj, long j2, long j4, long j6) {
        A0A(new F2(c0671Gy, j6, 0L, 0L), new F3(i, i5, format, i6, obj, A00(j2), A00(j4)));
    }

    public final void A0F(C0671Gy c0671Gy, int i, int i5, Format format, int i6, Object obj, long j2, long j4, long j6, long j7, long j8) {
        A08(new F2(c0671Gy, j6, j7, j8), new F3(i, i5, format, i6, obj, A00(j2), A00(j4)));
    }

    public final void A0G(C0671Gy c0671Gy, int i, int i5, Format format, int i6, Object obj, long j2, long j4, long j6, long j7, long j8) {
        A09(new F2(c0671Gy, j6, j7, j8), new F3(i, i5, format, i6, obj, A00(j2), A00(j4)));
    }

    public final void A0H(C0671Gy c0671Gy, int i, int i5, Format format, int i6, Object obj, long j2, long j4, long j6, long j7, long j8, IOException iOException, boolean z2) {
        A0B(new F2(c0671Gy, j6, j7, j8), new F3(i, i5, format, i6, obj, A00(j2), A00(j4)), iOException, z2);
    }
}
