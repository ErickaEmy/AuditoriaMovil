package h3;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import v5.j5;
/* loaded from: classes.dex */
public class v {

    /* renamed from: fb  reason: collision with root package name */
    public static final ArrayDeque<n3> f8454fb = new ArrayDeque<>();

    /* renamed from: s  reason: collision with root package name */
    public static final Object f8455s = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8456a;

    /* renamed from: gv  reason: collision with root package name */
    public final AtomicReference<RuntimeException> f8457gv;

    /* renamed from: n3  reason: collision with root package name */
    public final HandlerThread f8458n3;

    /* renamed from: v  reason: collision with root package name */
    public final v5.s f8459v;
    public final MediaCodec y;

    /* renamed from: zn  reason: collision with root package name */
    public Handler f8460zn;

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f8461a;

        /* renamed from: gv  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f8462gv = new MediaCodec.CryptoInfo();

        /* renamed from: n3  reason: collision with root package name */
        public int f8463n3;

        /* renamed from: v  reason: collision with root package name */
        public long f8464v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f8465zn;

        public void y(int i, int i5, int i6, long j2, int i8) {
            this.y = i;
            this.f8463n3 = i5;
            this.f8465zn = i6;
            this.f8464v = j2;
            this.f8461a = i8;
        }
    }

    /* loaded from: classes.dex */
    public class y extends Handler {
        public y(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            v.this.a(message);
        }
    }

    public v(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new v5.s());
    }

    public static n3 f() {
        ArrayDeque<n3> arrayDeque = f8454fb;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new n3();
                }
                return arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public static byte[] gv(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 != null && bArr2.length >= bArr.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Nullable
    public static int[] v(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 != null && iArr2.length >= iArr.length) {
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public static void xc(n3 n3Var) {
        ArrayDeque<n3> arrayDeque = f8454fb;
        synchronized (arrayDeque) {
            arrayDeque.add(n3Var);
        }
    }

    public static void zn(a9.zn znVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = znVar.f87a;
        cryptoInfo.numBytesOfClearData = v(znVar.f90gv, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = v(znVar.f94v, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) v5.y.v(gv(znVar.f92n3, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) v5.y.v(gv(znVar.y, cryptoInfo.iv));
        cryptoInfo.mode = znVar.f95zn;
        if (j5.y >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(znVar.f89fb, znVar.f93s));
        }
    }

    public final void a(Message message) {
        n3 n3Var;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                n3Var = null;
                if (i != 2) {
                    y5.w.y(this.f8457gv, null, new IllegalStateException(String.valueOf(message.what)));
                } else {
                    this.f8459v.a();
                }
            } else {
                n3Var = (n3) message.obj;
                s(n3Var.y, n3Var.f8463n3, n3Var.f8462gv, n3Var.f8464v, n3Var.f8461a);
            }
        } else {
            n3Var = (n3) message.obj;
            fb(n3Var.y, n3Var.f8463n3, n3Var.f8465zn, n3Var.f8464v, n3Var.f8461a);
        }
        if (n3Var != null) {
            xc(n3Var);
        }
    }

    public void c5() {
        if (this.f8456a) {
            try {
                i9();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public final void fb(int i, int i5, int i6, long j2, int i8) {
        try {
            this.y.queueInputBuffer(i, i5, i6, j2, i8);
        } catch (RuntimeException e2) {
            y5.w.y(this.f8457gv, null, e2);
        }
    }

    public final void i9() throws InterruptedException {
        ((Handler) v5.y.v(this.f8460zn)).removeCallbacksAndMessages(null);
        n3();
    }

    public void mt() throws InterruptedException {
        n3();
    }

    public final void n3() throws InterruptedException {
        this.f8459v.gv();
        ((Handler) v5.y.v(this.f8460zn)).obtainMessage(2).sendToTarget();
        this.f8459v.y();
    }

    public void p() {
        if (!this.f8456a) {
            this.f8458n3.start();
            this.f8460zn = new y(this.f8458n3.getLooper());
            this.f8456a = true;
        }
    }

    public final void s(int i, int i5, MediaCodec.CryptoInfo cryptoInfo, long j2, int i6) {
        try {
            synchronized (f8455s) {
                this.y.queueSecureInputBuffer(i, i5, cryptoInfo, j2, i6);
            }
        } catch (RuntimeException e2) {
            y5.w.y(this.f8457gv, null, e2);
        }
    }

    public void t() {
        RuntimeException andSet = this.f8457gv.getAndSet(null);
        if (andSet == null) {
            return;
        }
        throw andSet;
    }

    public void tl(int i, int i5, int i6, long j2, int i8) {
        t();
        n3 f4 = f();
        f4.y(i, i5, i6, j2, i8);
        ((Handler) j5.i9(this.f8460zn)).obtainMessage(0, f4).sendToTarget();
    }

    public void w() {
        if (this.f8456a) {
            c5();
            this.f8458n3.quit();
        }
        this.f8456a = false;
    }

    public void wz(int i, int i5, a9.zn znVar, long j2, int i6) {
        t();
        n3 f4 = f();
        f4.y(i, i5, 0, j2, i6);
        zn(znVar, f4.f8462gv);
        ((Handler) j5.i9(this.f8460zn)).obtainMessage(1, f4).sendToTarget();
    }

    public v(MediaCodec mediaCodec, HandlerThread handlerThread, v5.s sVar) {
        this.y = mediaCodec;
        this.f8458n3 = handlerThread;
        this.f8459v = sVar;
        this.f8457gv = new AtomicReference<>();
    }
}
