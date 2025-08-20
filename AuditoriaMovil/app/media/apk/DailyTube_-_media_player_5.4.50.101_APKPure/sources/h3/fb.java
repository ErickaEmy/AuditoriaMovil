package h3;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import v5.j5;
/* loaded from: classes.dex */
public final class fb extends MediaCodec.Callback {
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public MediaFormat f8424c5;

    /* renamed from: f  reason: collision with root package name */
    public long f8425f;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public MediaCodec.CodecException f8428i9;

    /* renamed from: n3  reason: collision with root package name */
    public final HandlerThread f8429n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public MediaFormat f8430s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f8431t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public IllegalStateException f8432tl;

    /* renamed from: zn  reason: collision with root package name */
    public Handler f8434zn;
    public final Object y = new Object();

    /* renamed from: gv  reason: collision with root package name */
    public final f f8427gv = new f();

    /* renamed from: v  reason: collision with root package name */
    public final f f8433v = new f();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque<MediaCodec.BufferInfo> f8423a = new ArrayDeque<>();

    /* renamed from: fb  reason: collision with root package name */
    public final ArrayDeque<MediaFormat> f8426fb = new ArrayDeque<>();

    public fb(HandlerThread handlerThread) {
        this.f8429n3 = handlerThread;
    }

    public final void a() {
        if (!this.f8426fb.isEmpty()) {
            this.f8424c5 = this.f8426fb.getLast();
        }
        this.f8427gv.n3();
        this.f8433v.n3();
        this.f8423a.clear();
        this.f8426fb.clear();
    }

    public final boolean c5() {
        if (this.f8425f <= 0 && !this.f8431t) {
            return false;
        }
        return true;
    }

    public final void f() {
        IllegalStateException illegalStateException = this.f8432tl;
        if (illegalStateException == null) {
            return;
        }
        this.f8432tl = null;
        throw illegalStateException;
    }

    public MediaFormat fb() {
        MediaFormat mediaFormat;
        synchronized (this.y) {
            try {
                mediaFormat = this.f8430s;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public int gv(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.y) {
            try {
                if (c5()) {
                    return -1;
                }
                i9();
                if (this.f8433v.gv()) {
                    return -1;
                }
                int v2 = this.f8433v.v();
                if (v2 >= 0) {
                    v5.y.c5(this.f8430s);
                    MediaCodec.BufferInfo remove = this.f8423a.remove();
                    bufferInfo.set(remove.offset, remove.size, remove.presentationTimeUs, remove.flags);
                } else if (v2 == -2) {
                    this.f8430s = this.f8426fb.remove();
                }
                return v2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i9() {
        f();
        t();
    }

    public final void n3(MediaFormat mediaFormat) {
        this.f8433v.y(-2);
        this.f8426fb.add(mediaFormat);
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.y) {
            this.f8428i9 = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.y) {
            this.f8427gv.y(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.y) {
            try {
                MediaFormat mediaFormat = this.f8424c5;
                if (mediaFormat != null) {
                    n3(mediaFormat);
                    this.f8424c5 = null;
                }
                this.f8433v.y(i);
                this.f8423a.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.y) {
            n3(mediaFormat);
            this.f8424c5 = null;
        }
    }

    public void s(MediaCodec mediaCodec) {
        boolean z2;
        if (this.f8434zn == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f8429n3.start();
        Handler handler = new Handler(this.f8429n3.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f8434zn = handler;
    }

    public final void t() {
        MediaCodec.CodecException codecException = this.f8428i9;
        if (codecException == null) {
            return;
        }
        this.f8428i9 = null;
        throw codecException;
    }

    public final void tl() {
        synchronized (this.y) {
            try {
                if (this.f8431t) {
                    return;
                }
                long j2 = this.f8425f - 1;
                this.f8425f = j2;
                if (j2 > 0) {
                    return;
                }
                if (j2 < 0) {
                    wz(new IllegalStateException());
                } else {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v() {
        synchronized (this.y) {
            this.f8425f++;
            ((Handler) j5.i9(this.f8434zn)).post(new Runnable() { // from class: h3.a
                @Override // java.lang.Runnable
                public final void run() {
                    fb.this.tl();
                }
            });
        }
    }

    public final void wz(IllegalStateException illegalStateException) {
        synchronized (this.y) {
            this.f8432tl = illegalStateException;
        }
    }

    public void xc() {
        synchronized (this.y) {
            this.f8431t = true;
            this.f8429n3.quit();
            a();
        }
    }

    public int zn() {
        synchronized (this.y) {
            try {
                int i = -1;
                if (c5()) {
                    return -1;
                }
                i9();
                if (!this.f8427gv.gv()) {
                    i = this.f8427gv.v();
                }
                return i;
            } finally {
            }
        }
    }
}
