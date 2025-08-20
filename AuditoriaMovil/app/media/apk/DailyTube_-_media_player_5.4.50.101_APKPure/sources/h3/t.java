package h3;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import m1.m;
/* loaded from: classes.dex */
public interface t {

    /* loaded from: classes.dex */
    public interface n3 {
        public static final n3 y = new i9();

        t y(y yVar) throws IOException;
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final int f8449a;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final Surface f8450gv;

        /* renamed from: n3  reason: collision with root package name */
        public final MediaFormat f8451n3;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final MediaCrypto f8452v;
        public final wz y;

        /* renamed from: zn  reason: collision with root package name */
        public final m f8453zn;

        public y(wz wzVar, MediaFormat mediaFormat, m mVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
            this.y = wzVar;
            this.f8451n3 = mediaFormat;
            this.f8453zn = mVar;
            this.f8450gv = surface;
            this.f8452v = mediaCrypto;
            this.f8449a = i;
        }

        public static y n3(wz wzVar, MediaFormat mediaFormat, m mVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new y(wzVar, mediaFormat, mVar, surface, mediaCrypto, 0);
        }

        public static y y(wz wzVar, MediaFormat mediaFormat, m mVar, @Nullable MediaCrypto mediaCrypto) {
            return new y(wzVar, mediaFormat, mVar, null, mediaCrypto, 0);
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void y(t tVar, long j2, long j4);
    }

    void a(int i, int i5, int i6, long j2, int i8);

    void c5(Bundle bundle);

    int f();

    void fb(int i, int i5, a9.zn znVar, long j2, int i6);

    void flush();

    @Nullable
    ByteBuffer gv(int i);

    void i9(int i, long j2);

    void n3(zn znVar, Handler handler);

    void release();

    boolean s();

    int t(MediaCodec.BufferInfo bufferInfo);

    void tl(int i, boolean z2);

    void v(Surface surface);

    @Nullable
    ByteBuffer wz(int i);

    MediaFormat y();

    void zn(int i);
}
