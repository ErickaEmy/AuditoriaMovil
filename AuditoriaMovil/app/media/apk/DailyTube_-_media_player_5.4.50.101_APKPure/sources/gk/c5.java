package gk;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.m;
import v5.b;
import v5.r;
import v5.w;
/* loaded from: classes.dex */
public final class c5 implements wn.f, y {

    /* renamed from: co  reason: collision with root package name */
    public int f8269co;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public byte[] f8273n;

    /* renamed from: z  reason: collision with root package name */
    public SurfaceTexture f8280z;
    public final AtomicBoolean y = new AtomicBoolean();

    /* renamed from: v  reason: collision with root package name */
    public final AtomicBoolean f8278v = new AtomicBoolean(true);

    /* renamed from: fb  reason: collision with root package name */
    public final fb f8272fb = new fb();

    /* renamed from: s  reason: collision with root package name */
    public final zn f8276s = new zn();

    /* renamed from: f  reason: collision with root package name */
    public final b<Long> f8270f = new b<>();

    /* renamed from: t  reason: collision with root package name */
    public final b<v> f8277t = new b<>();

    /* renamed from: w  reason: collision with root package name */
    public final float[] f8279w = new float[16];

    /* renamed from: p  reason: collision with root package name */
    public final float[] f8274p = new float[16];

    /* renamed from: r  reason: collision with root package name */
    public volatile int f8275r = 0;

    /* renamed from: f3  reason: collision with root package name */
    public int f8271f3 = -1;

    public SurfaceTexture a() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            w.n3();
            this.f8272fb.n3();
            w.n3();
            this.f8269co = w.a();
        } catch (w.y e2) {
            r.gv("SceneRenderer", "Failed to initialize the renderer", e2);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f8269co);
        this.f8280z = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: gk.s
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                c5.this.fb(surfaceTexture2);
            }
        });
        return this.f8280z;
    }

    public final void c5(@Nullable byte[] bArr, int i, long j2) {
        v vVar;
        byte[] bArr2 = this.f8273n;
        int i5 = this.f8271f3;
        this.f8273n = bArr;
        if (i == -1) {
            i = this.f8275r;
        }
        this.f8271f3 = i;
        if (i5 == i && Arrays.equals(bArr2, this.f8273n)) {
            return;
        }
        byte[] bArr3 = this.f8273n;
        if (bArr3 != null) {
            vVar = a.y(bArr3, this.f8271f3);
        } else {
            vVar = null;
        }
        if (vVar == null || !fb.zn(vVar)) {
            vVar = v.n3(this.f8271f3);
        }
        this.f8277t.y(j2, vVar);
    }

    public final /* synthetic */ void fb(SurfaceTexture surfaceTexture) {
        this.y.set(true);
    }

    public void gv(float[] fArr, boolean z2) {
        GLES20.glClear(16384);
        try {
            w.n3();
        } catch (w.y e2) {
            r.gv("SceneRenderer", "Failed to draw a frame", e2);
        }
        if (this.y.compareAndSet(true, false)) {
            ((SurfaceTexture) v5.y.v(this.f8280z)).updateTexImage();
            try {
                w.n3();
            } catch (w.y e3) {
                r.gv("SceneRenderer", "Failed to draw a frame", e3);
            }
            if (this.f8278v.compareAndSet(true, false)) {
                w.i9(this.f8279w);
            }
            long timestamp = this.f8280z.getTimestamp();
            Long fb2 = this.f8270f.fb(timestamp);
            if (fb2 != null) {
                this.f8276s.zn(this.f8279w, fb2.longValue());
            }
            v i92 = this.f8277t.i9(timestamp);
            if (i92 != null) {
                this.f8272fb.gv(i92);
            }
        }
        Matrix.multiplyMM(this.f8274p, 0, fArr, 0, this.f8279w, 0);
        this.f8272fb.y(this.f8269co, this.f8274p, z2);
    }

    @Override // gk.y
    public void n3(long j2, float[] fArr) {
        this.f8276s.v(j2, fArr);
    }

    public void s(int i) {
        this.f8275r = i;
    }

    @Override // wn.f
    public void v(long j2, long j4, m mVar, @Nullable MediaFormat mediaFormat) {
        this.f8270f.y(j4, Long.valueOf(j2));
        c5(mVar.f10961qn, mVar.f10957o, j4);
    }

    @Override // gk.y
    public void zn() {
        this.f8270f.zn();
        this.f8276s.gv();
        this.f8278v.set(true);
    }
}
