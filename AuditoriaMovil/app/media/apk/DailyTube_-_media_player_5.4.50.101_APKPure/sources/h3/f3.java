package h3;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import h3.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import v5.j5;
import v5.yt;
/* loaded from: classes.dex */
public final class f3 implements t {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public ByteBuffer[] f8421n3;
    public final MediaCodec y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public ByteBuffer[] f8422zn;

    /* loaded from: classes.dex */
    public static class n3 implements t.n3 {
        public MediaCodec n3(t.y yVar) throws IOException {
            v5.y.v(yVar.y);
            String str = yVar.y.y;
            yt.y("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            yt.zn();
            return createByCodecName;
        }

        @Override // h3.t.n3
        public t y(t.y yVar) throws IOException {
            MediaCodec n32;
            MediaCodec mediaCodec = null;
            try {
                n32 = n3(yVar);
            } catch (IOException e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            }
            try {
                yt.y("configureCodec");
                n32.configure(yVar.f8451n3, yVar.f8450gv, yVar.f8452v, yVar.f8449a);
                yt.zn();
                yt.y("startCodec");
                n32.start();
                yt.zn();
                return new f3(n32);
            } catch (IOException | RuntimeException e5) {
                e = e5;
                mediaCodec = n32;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(t.zn znVar, MediaCodec mediaCodec, long j2, long j4) {
        znVar.y(this, j2, j4);
    }

    @Override // h3.t
    public void a(int i, int i5, int i6, long j2, int i8) {
        this.y.queueInputBuffer(i, i5, i6, j2, i8);
    }

    @Override // h3.t
    public void c5(Bundle bundle) {
        this.y.setParameters(bundle);
    }

    @Override // h3.t
    public int f() {
        return this.y.dequeueInputBuffer(0L);
    }

    @Override // h3.t
    public void fb(int i, int i5, a9.zn znVar, long j2, int i6) {
        this.y.queueSecureInputBuffer(i, i5, znVar.y(), j2, i6);
    }

    @Override // h3.t
    public void flush() {
        this.y.flush();
    }

    @Override // h3.t
    @Nullable
    public ByteBuffer gv(int i) {
        if (j5.y >= 21) {
            return this.y.getInputBuffer(i);
        }
        return ((ByteBuffer[]) j5.i9(this.f8421n3))[i];
    }

    @Override // h3.t
    public void i9(int i, long j2) {
        this.y.releaseOutputBuffer(i, j2);
    }

    @Override // h3.t
    public void n3(final t.zn znVar, Handler handler) {
        this.y.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: h3.i4
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j4) {
                f3.this.w(znVar, mediaCodec, j2, j4);
            }
        }, handler);
    }

    @Override // h3.t
    public void release() {
        this.f8421n3 = null;
        this.f8422zn = null;
        this.y.release();
    }

    @Override // h3.t
    public boolean s() {
        return false;
    }

    @Override // h3.t
    public int t(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.y.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && j5.y < 21) {
                this.f8422zn = this.y.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // h3.t
    public void tl(int i, boolean z2) {
        this.y.releaseOutputBuffer(i, z2);
    }

    @Override // h3.t
    public void v(Surface surface) {
        this.y.setOutputSurface(surface);
    }

    @Override // h3.t
    @Nullable
    public ByteBuffer wz(int i) {
        if (j5.y >= 21) {
            return this.y.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) j5.i9(this.f8422zn))[i];
    }

    @Override // h3.t
    public MediaFormat y() {
        return this.y.getOutputFormat();
    }

    @Override // h3.t
    public void zn(int i) {
        this.y.setVideoScalingMode(i);
    }

    public f3(MediaCodec mediaCodec) {
        this.y = mediaCodec;
        if (j5.y < 21) {
            this.f8421n3 = mediaCodec.getInputBuffers();
            this.f8422zn = mediaCodec.getOutputBuffers();
        }
    }
}
