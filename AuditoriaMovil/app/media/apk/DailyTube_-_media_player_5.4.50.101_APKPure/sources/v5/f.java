package v5;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import v5.w;
/* loaded from: classes.dex */
public final class f implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: w  reason: collision with root package name */
    public static final int[] f14342w = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public EGLSurface f14343f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public EGLDisplay f14344fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public EGLContext f14345s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public SurfaceTexture f14346t;

    /* renamed from: v  reason: collision with root package name */
    public final int[] f14347v;
    public final Handler y;

    /* loaded from: classes.dex */
    public interface y {
    }

    public f(Handler handler) {
        this(handler, null);
    }

    public static EGLDisplay a() throws w.y {
        boolean z2;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.zn(z2, "eglGetDisplay failed");
        int[] iArr = new int[2];
        w.zn(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eglGetDisplay;
    }

    public static EGLContext n3(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) throws w.y {
        boolean z2 = true;
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eglCreateContext == null) {
            z2 = false;
        }
        w.zn(z2, "eglCreateContext failed");
        return eglCreateContext;
    }

    public static void v(int[] iArr) throws w.y {
        GLES20.glGenTextures(1, iArr, 0);
        w.n3();
    }

    public static EGLConfig y(EGLDisplay eGLDisplay) throws w.y {
        boolean z2;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f14342w, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (eglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.zn(z2, j5.rz("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    public static EGLSurface zn(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i) throws w.y {
        EGLSurface eglCreatePbufferSurface;
        boolean z2 = true;
        if (i == 1) {
            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eglCreatePbufferSurface == null) {
                z2 = false;
            }
            w.zn(z2, "eglCreatePbufferSurface failed");
        }
        w.zn(EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eGLContext), "eglMakeCurrent failed");
        return eglCreatePbufferSurface;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, android.opengl.EGLDisplay] */
    public void c5() {
        this.y.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f14346t;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f14347v, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f14344fb;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f14344fb;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f14343f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f14344fb, this.f14343f);
            }
            EGLContext eGLContext = this.f14345s;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f14344fb, eGLContext);
            }
            if (j5.y >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f14344fb;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f14344fb);
            }
            this.f14344fb = null;
            this.f14345s = null;
            this.f14343f = null;
            this.f14346t = null;
        }
    }

    public SurfaceTexture fb() {
        return (SurfaceTexture) v5.y.v(this.f14346t);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.y.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        gv();
        SurfaceTexture surfaceTexture = this.f14346t;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public void s(int i) throws w.y {
        EGLDisplay a2 = a();
        this.f14344fb = a2;
        EGLConfig y2 = y(a2);
        EGLContext n32 = n3(this.f14344fb, y2, i);
        this.f14345s = n32;
        this.f14343f = zn(this.f14344fb, y2, n32, i);
        v(this.f14347v);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f14347v[0]);
        this.f14346t = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public f(Handler handler, @Nullable y yVar) {
        this.y = handler;
        this.f14347v = new int[1];
    }

    public final void gv() {
    }
}
