package h3;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import h3.n3;
import h3.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import v5.yt;
/* loaded from: classes.dex */
public final class n3 implements t {

    /* renamed from: a  reason: collision with root package name */
    public int f8438a;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f8439gv;

    /* renamed from: n3  reason: collision with root package name */
    public final fb f8440n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f8441v;
    public final MediaCodec y;

    /* renamed from: zn  reason: collision with root package name */
    public final v f8442zn;

    /* renamed from: h3.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0103n3 implements t.n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f8443gv;

        /* renamed from: n3  reason: collision with root package name */
        public final w0.z<HandlerThread> f8444n3;

        /* renamed from: zn  reason: collision with root package name */
        public final w0.z<HandlerThread> f8445zn;

        public C0103n3(final int i, boolean z2) {
            this(new w0.z() { // from class: h3.zn
                @Override // w0.z
                public final Object get() {
                    HandlerThread v2;
                    v2 = n3.C0103n3.v(i);
                    return v2;
                }
            }, new w0.z() { // from class: h3.gv
                @Override // w0.z
                public final Object get() {
                    HandlerThread a2;
                    a2 = n3.C0103n3.a(i);
                    return a2;
                }
            }, z2);
        }

        public static /* synthetic */ HandlerThread a(int i) {
            return new HandlerThread(n3.z(i));
        }

        public static /* synthetic */ HandlerThread v(int i) {
            return new HandlerThread(n3.co(i));
        }

        @Override // h3.t.n3
        /* renamed from: gv */
        public n3 y(t.y yVar) throws IOException {
            MediaCodec mediaCodec;
            n3 n3Var;
            String str = yVar.y.y;
            n3 n3Var2 = null;
            try {
                yt.y("createCodec:" + str);
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    n3Var = new n3(mediaCodec, this.f8444n3.get(), this.f8445zn.get(), this.f8443gv);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodec = null;
            }
            try {
                yt.zn();
                n3Var.x4(yVar.f8451n3, yVar.f8450gv, yVar.f8452v, yVar.f8449a);
                return n3Var;
            } catch (Exception e5) {
                e = e5;
                n3Var2 = n3Var;
                if (n3Var2 == null) {
                    if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                } else {
                    n3Var2.release();
                }
                throw e;
            }
        }

        public C0103n3(w0.z<HandlerThread> zVar, w0.z<HandlerThread> zVar2, boolean z2) {
            this.f8444n3 = zVar;
            this.f8445zn = zVar2;
            this.f8443gv = z2;
        }
    }

    public static String co(int i) {
        return r(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String r(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    public static String z(int i) {
        return r(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    @Override // h3.t
    public void a(int i, int i5, int i6, long j2, int i8) {
        this.f8442zn.tl(i, i5, i6, j2, i8);
    }

    @Override // h3.t
    public void c5(Bundle bundle) {
        f3();
        this.y.setParameters(bundle);
    }

    @Override // h3.t
    public int f() {
        this.f8442zn.t();
        return this.f8440n3.zn();
    }

    public final void f3() {
        if (this.f8439gv) {
            try {
                this.f8442zn.mt();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    @Override // h3.t
    public void fb(int i, int i5, a9.zn znVar, long j2, int i6) {
        this.f8442zn.wz(i, i5, znVar, j2, i6);
    }

    @Override // h3.t
    public void flush() {
        this.f8442zn.c5();
        this.y.flush();
        this.f8440n3.v();
        this.y.start();
    }

    @Override // h3.t
    @Nullable
    public ByteBuffer gv(int i) {
        return this.y.getInputBuffer(i);
    }

    public final /* synthetic */ void i4(t.zn znVar, MediaCodec mediaCodec, long j2, long j4) {
        znVar.y(this, j2, j4);
    }

    @Override // h3.t
    public void i9(int i, long j2) {
        this.y.releaseOutputBuffer(i, j2);
    }

    @Override // h3.t
    public void n3(final t.zn znVar, Handler handler) {
        f3();
        this.y.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: h3.y
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j4) {
                n3.this.i4(znVar, mediaCodec, j2, j4);
            }
        }, handler);
    }

    @Override // h3.t
    public void release() {
        try {
            if (this.f8438a == 1) {
                this.f8442zn.w();
                this.f8440n3.xc();
            }
            this.f8438a = 2;
            if (!this.f8441v) {
                this.y.release();
                this.f8441v = true;
            }
        } catch (Throwable th) {
            if (!this.f8441v) {
                this.y.release();
                this.f8441v = true;
            }
            throw th;
        }
    }

    @Override // h3.t
    public boolean s() {
        return false;
    }

    @Override // h3.t
    public int t(MediaCodec.BufferInfo bufferInfo) {
        this.f8442zn.t();
        return this.f8440n3.gv(bufferInfo);
    }

    @Override // h3.t
    public void tl(int i, boolean z2) {
        this.y.releaseOutputBuffer(i, z2);
    }

    @Override // h3.t
    public void v(Surface surface) {
        f3();
        this.y.setOutputSurface(surface);
    }

    @Override // h3.t
    @Nullable
    public ByteBuffer wz(int i) {
        return this.y.getOutputBuffer(i);
    }

    public final void x4(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.f8440n3.s(this.y);
        yt.y("configureCodec");
        this.y.configure(mediaFormat, surface, mediaCrypto, i);
        yt.zn();
        this.f8442zn.p();
        yt.y("startCodec");
        this.y.start();
        yt.zn();
        this.f8438a = 1;
    }

    @Override // h3.t
    public MediaFormat y() {
        return this.f8440n3.fb();
    }

    @Override // h3.t
    public void zn(int i) {
        f3();
        this.y.setVideoScalingMode(i);
    }

    public n3(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2) {
        this.y = mediaCodec;
        this.f8440n3 = new fb(handlerThread);
        this.f8442zn = new v(mediaCodec, handlerThread2);
        this.f8439gv = z2;
        this.f8438a = 0;
    }
}
